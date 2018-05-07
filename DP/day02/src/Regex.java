public class Regex {

    /*
    Subproblem Definition: isMatch(s[0:i],p[0:j])
    Guess:
    Recurrence Relation: DP[i] =
    */

    public static boolean isMatch(String s, String p) {
        // Base Cases
        if (p == ".*") return true;
        if (s.length() == 0 || p.length() == 0) return (s.length() == p.length());   //if one is empty return false, but if both are empty return true

        boolean[][] DP = new boolean[s.length()][p.length()];    //DP stores isMatch(s[:i],p[:j])
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                DP[i][j] = false;                                //just initializing them as all false
            }
        }

        char[] string = s.toCharArray();
        char[] regex = p.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {

                if (DP[i-1][j-1]) {
                    if (regex[j] == '*') {
                        DP[i][j] = DP[i-1][j-1];
                    }
                    if (regex[j] == '.' || string[i] == regex[j]) {
                        DP[i][j] = DP[i-1][j-1];
                    }
                }
            }
        }

        return false;
    }
}