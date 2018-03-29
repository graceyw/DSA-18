package divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    public static class Point {
        public int x;
        public int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Building {
        private int l, r, h;
        public Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Merge 2 given skylines, return 1
    public static List<Point> merge(List<Point> s1, List<Point> s2) {
        int prevHt1 = 0;
        int prevHt2 = 0;
        List<Point> skyline = new ArrayList<>();

        while (prevHt1 < s1.size() || prevHt2 < s2.size()) {

            // If points have the same x, add point using max-y among both
            if ((prevHt1 < s1.size()) && (prevHt2 < s2.size()) && (s1.get(prevHt1).x == s2.get(prevHt2).x)) {
                int newX = s1.get(prevHt1).x;
                int newY = Math.max(s1.get(prevHt1).y, s2.get(prevHt2).y);
                skyline.add(new Point(newX,newY));
                prevHt1++;
                prevHt2++;
            }

            // If prevHt2 exceeds end of s2 or s1's next pt has smaller x, use point from s1
            else if (prevHt2 == s2.size() || (prevHt1 < s1.size() && s1.get(prevHt1).x < s2.get(prevHt2).x)) {
                int newX = s1.get(prevHt1).x;
                int newY = Math.max(s1.get(prevHt1).y, prevHt2 > 0 ? s2.get(prevHt2-1).y : s1.get(prevHt1).y);
                skyline.add(new Point(newX,newY));
                prevHt1++;
            }

            // Else use point from s2
            else {
                int newX = s2.get(prevHt2).x;
                int newY = Math.max(s2.get(prevHt2).y, prevHt1 > 0 ? s1.get(prevHt1-1).y : s2.get(prevHt2).y);
                skyline.add(new Point(newX,newY));
                prevHt2++;
            }
            int L = skyline.size();

            //if last 2 pts have same y value, rm last pt
            if (skyline.size() > 1 && skyline.get(L-1).y == skyline.get(L-2).y) {
                skyline.remove(L - 1);
            }
        }
        return skyline;
    }

    private static List<Point> recurs(Building[] B, int lo, int hi) {
        if (lo == hi) return new ArrayList<>();  // no building
        if (hi-lo == 1) return Arrays.asList(new Point(B[lo].l, B[lo].h), new Point(B[lo].r, 0));  // 1 building
        int mid = (hi+lo)/2;
        List<Point> leftSky = recurs(B, lo, mid);
        List<Point> rightSky = recurs(B, mid, hi);
        return merge(leftSky, rightSky);
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        return recurs(B, 0, B.length);
    }
}
