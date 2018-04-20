import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BarnRepair {
    public static int solve(int M, int[] occupied) {
        if (M == 1) return M;
        Arrays.sort(occupied);
        int blockedStalls = occupied.length;        //minimum number of stalls blocked
        ArrayList<Integer> gaps = new ArrayList<>();

        for (int stallIndex = 0; stallIndex < occupied.length-1; stallIndex++) {
            if (occupied[stallIndex] + 1 != occupied[stallIndex+1]) {                //if the stall next to an occupied stall isn't occupied
                gaps.add(occupied[stallIndex+1] - occupied[stallIndex]);             //add the # of stalls in the gap to the gaps arraylist
            }
        }
        Collections.sort(gaps);
        System.out.println(gaps);     //test print function
        int overBudget = gaps.size() + 1 - M; //number of boards over budget M
        while (overBudget > 0) {
            blockedStalls += gaps.get(overBudget);                        //add gap to blockedStalls
            overBudget--;                                                 //cause you didn't use an extra board
        }
        System.out.println(blockedStalls);
        return blockedStalls;
    }
}