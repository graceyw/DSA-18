import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Globals {
    public static HashMap<Integer, int[]> indexLocMap = new HashMap<Integer, int[]>() {{
        // Color 0 indices
        put(0, new int[]{0,0,1});
        put(1, new int[]{0,0,1});
        put(2, new int[]{0,0,1});
        put(3, new int[]{0,0,1});
        put(4, new int[]{1,0,0});
        put(5, new int[]{1,0,0});
        put(6, new int[]{1,0,0});
        put(7, new int[]{1,0,0});
        put(8, new int[]{0,1,0});
        put(9, new int[]{0,1,0});
        put(10, new int[]{0,1,0});
        put(11, new int[]{0,1,0});
        put(12, new int[]{0,0,-1});
        put(13, new int[]{0,0,-1});
        put(14, new int[]{0,0,-1});
        put(15, new int[]{0,0,-1});
        put(16, new int[]{-1,0,0});
        put(17, new int[]{-1,0,0});
        put(18, new int[]{-1,0,0});
        put(19, new int[]{-1,0,0});
        put(20, new int[]{0,-1,0});
        put(21, new int[]{0,-1,0});
        put(22, new int[]{0,-1,0});
        put(23, new int[]{0,-1,0});
    }};

    /*public static HashMap<Integer, Integer[]> sideMap = new HashMap<Integer, Integer[]>() {{
        // Color 0 indices
        put(0, );
        put(1, );
        put(2, );
    }};*/

    public static HashMap<Integer, Set<Integer>> sideMap = new HashMap<Integer, Set<Integer>>() {{
        // Color 0 indices
        put(0, new HashSet<>() {{
            add(0);
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(8);
            add(9);
            add(16);
            add(17);
            add(20);
            add(21);
        }});

        // Color 1 indices
        put(1, new HashSet<>() {{
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(11);
            add(3);
            add(2);
            add(15);
            add(14);
            add(20);
            add(23);
        }});
        put(2, new HashSet<>() {{
            add(8);
            add(9);
            add(10);
            add(11);
            add(5);
            add(6);
            add(1);
            add(2);
            add(17);
            add(18);
            add(13);
            add(14);
        }});
    }};
}