import java.util.Arrays;

public class Regex {

    /*
    Subproblem Definition: isMatch(s[0:i],p[0:j])
    Guess: true or false? (guess usually makes more sense when doing top down (recursion))
    Recurrence Relation: kinda complicated. Basically a bunch of cases that check what's going on:
                  - If s[i] == p[j] or p[j] is "." AND words are "true" up to this point: , then DP[i][j] = true;
                  - If

    Runtime: s*p
    Space Complexity: s*p (size of DP)
    */

    public static boolean isMatch(String s, String p) {
        // Base Cases
        if (p == ".*") return true;
        if (s.length() == 0 || p.length() == 0) return (s.length() == p.length());   //if one is empty return false, but if both are empty return true
        char[] string = s.toCharArray();
        char[] regex = p.toCharArray();

        boolean[][] DP = new boolean[s.length()+1][p.length()+1];    //DP stores isMatch(s[:i],p[:j])
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                DP[i][j] = false;                                //just initializing them as all false
            }
        }
        DP[0][0] = true;

        for (int j = 0; j < regex.length; j++) {                 //
             if (regex[j] == '*' && string[0] != regex[j-1]) {
                 DP[0][j+1] = DP[0][j-1];
             }
        }

        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {

                // IF CHAR IS A "*"
                if (regex[j-1] == '*') {
                    if ((string[i-1] == regex[j-2] || regex[j-2] == '.')) {  //if the char in regex is "*" and (s[i]=p[j-1] or it COULD be (i.e. it's a ".")
                        if (DP[i-1][j] || DP[i][j-1]) {
                            DP[i][j] = true;
                        }
                    }
                    if (DP[i][j-2]) DP[i][j] = true;
                }

                // IF CHAR IS A "." or other letter
                if (DP[i-1][j-1]) {
                    if (regex[j-1] == '.' || string[i-1] == regex[j-1]) {
                        DP[i][j] = true;
                    }
                }
            }
        }
        return DP[s.length()][p.length()];
    }
}