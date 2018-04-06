import java.util.ArrayList;
import java.util.List;

public class RadioTowers {
    static class Tower {
        double x, y;
        Tower(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static double getDist(Tower t1, Tower t2) {
        double xDiff = t1.x - t2.x;
        double yDiff = t1.y - t2.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    private static boolean isWithin(Tower t1, Tower t2, int dist) {
        return getDist(t1, t2) <= dist;
    }

    // Strip contains a list of Towers sorted by x-coordinate, whose y-coordinates all fall in a 2-mile strip
    // Return true if no two towers are within 1 mile
    public static boolean checkStrip(List<Tower> strip) {
        for (int i=0; i<strip.size(); i++) {
            for (int j=i+1; j<Math.min(strip.size(), i+8); j++) {
                if (j < strip.size() && isWithin(strip.get(i),strip.get(j), 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Return true if no two towers are within distance 1 of each other
    public static boolean validTowers(List<Tower> Lx, List<Tower> Ly) {
        assert Lx.size() == Ly.size();
        int s = Lx.size();
        if (s < 2) return true;
        if (s==2) return !isWithin(Lx.get(0), Lx.get(1),1);

        List<Tower> bottomLx = new ArrayList<>();
        List<Tower> topLx = new ArrayList<>();
        List<Tower> bottomLy = new ArrayList<>();
        List<Tower> topLy = new ArrayList<>();
        double midY = Ly.get(Ly.size()/2).y;

        for (Tower tow :Lx) {
            if (tow.y <= midY) bottomLx.add(tow);
            else topLx.add(tow);
        }
        for (Tower tow :Ly) {
            if (tow.y <= midY) bottomLy.add(tow);
            else topLy.add(tow);
        }

        //checking as we combine
        if (!validTowers(topLx, topLy)) return false;
        if (!validTowers(bottomLx, bottomLy)) return false;
        List<Tower> strip = new ArrayList<>();
        for (Tower tow : Lx) {
            if (tow.y >= midY - 1 && tow.y <= midY + 1) {   //if this is the middle tower
                strip.add(tow);
            }
        }
        return checkStrip(strip);
    }
}
