import static java.lang.Math.*;

public class DungeonGame {

    //Bottom up dungeon game
    public static int minInitialHealthBottomUp(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) return 0;

        int m = map.length;
        int n = map[0].length;

        int[][] health = new int[m][n];

        health[m - 1][n - 1] = Math.max(1 - map[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - map[i][n - 1], 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - map[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - map[i][j], 1);
                int right = Math.max(health[i][j + 1] - map[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }

        return health[0][0];
    }

    //Top down dungeon game
    public static int minInitialHealth(int[][] map) {
        //Create memo
        int memo[][] = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                memo[i][j] = -1;
            }
        }

        return minInitialHealthRecurse(map, 0, 0, memo);
    }

    private static int minInitialHealthRecurse(int[][] map, int i, int j, int[][] memo) {
        int health = 0;

        //Base
        if ((i == map.length-1) && (j == map[0].length-1)) {
            return max(-map[i][j]+1, 1);
        }

        //Memo
        else if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        //Ran out of board
        if (i == map.length-1) {
            health = max(-map[i][j] + minInitialHealthRecurse(map, i, j+1, memo), 1);
        }
        else if (j == map[0].length-1) {
            health = max(-map[i][j] + minInitialHealthRecurse(map, i+1, j, memo), 1);
        }

        //Guess
        else {
            int right = minInitialHealthRecurse(map, i + 1, j, memo);
            int down = minInitialHealthRecurse(map, i, j + 1, memo);
            int choice = Math.min(right, down);
            health = max(-map[i][j] + choice,1);
        }

        memo[i][j] = health;
        return health;

    }
}
