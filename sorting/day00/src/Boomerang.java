import java.util.HashMap;

public class Boomerang {
    /**
     * Runtime: O(N^2)
     * Space: O(N)
     */
    public static int numberOfBoomerangs(int[][] points) {
        if (points.length <= 1) {
            return 0;
        }
        int totalBooms = 0;
        for (int index=0; index < points.length; index++) {
            HashMap booms = new HashMap<>();                    //will be overwritten at each loop

            for (int next = 0; next < points.length; next++) {
                if (next == index) continue;
                double distance = Math.pow(points[next][0] - points[index][0], 2) + Math.pow(points[next][1] - points[index][1], 2);   //no sqrt necessary because they just need to be the same
                System.out.println(distance);
                if (booms.containsKey(distance)) {
                    int V = (int) booms.get(distance);
                    booms.replace(distance, V + 1);
                } else {
                    booms.put(distance, 1);
                }
            }
            for (Object key : booms.keySet()) {     // for keys in the map booms
                int V = (int) booms.get(key);       // returns corresponding val
                totalBooms += V*(V-1);              // add the real # of booms from this to running total
            }
        }
        return totalBooms;
    }
}