import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class BarnRepair {
    public static int solve(int M, int[] occupied) {
        if (M == 1) return M;
        int blockedStalls = occupied.length;        //minimum number of stalls blocked
        Map<ArrayList<Integer>, Integer> gaps = new HashMap<ArrayList<Integer>, Integer>();     //ACTUALLYYYYYYYY may not be necessary to track location of gap, just size, because you're only returning number of blocked stalls

        for (int stallIndex = 1; stallIndex <= occupied.length; stallIndex++) {   //beware may cause an off by 1 error

            if (occupied[stallIndex] + 1 != occupied[stallIndex+1]) {   //if the stall next to an occupied stall isn't occupied

                ArrayList<Integer> gapLocation = new ArrayList<>();
                gapLocation.add(occupied[stallIndex]);
                gapLocation.add(occupied[stallIndex+1]);      //might be able to add these things in the initialization line?

                int gapSize = occupied[stallIndex+1] - occupied[stallIndex];

                gaps.put(gapLocation, gapSize);   //add the gap to the map
            }
        }
//        System.out.println(gaps);     //test print function

        for (gap : gaps) {
            while (M != 0) {
                //add smallest gaps to blockedStalls / cover smallest gaps without using another board
                M--;
            }
        }
        return blockedStalls;
    }
}