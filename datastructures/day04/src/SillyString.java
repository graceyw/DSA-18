import java.util.HashMap;
import java.util.Map;

public class SillyString {
    private final String innerString;

    public SillyString(String innerString) {
        this.innerString = innerString;
    }

    public String toString() {
        return innerString;
    }

    @Override
    public boolean equals(Object other) {
        return this.toString().equals(other.toString());
    }

    @Override
    public int hashCode() {
        // This is a bad hash function because it hashes different inputs
        // to the same hashcodes (collisions will happen commonly).
        // 'bad' == 'dab' or anything else that adds up to the values of b+a+d

        int total = 0;
        for (int i=0; i<innerString.length(); i++) {
            total += innerString.charAt(i);        //in java, integers and chars are same deal
        }
        return total;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SillyString first = new SillyString("Hello");
        SillyString second = new SillyString("World");

        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
    }
}
