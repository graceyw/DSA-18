
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyHashMapTest {

    private Map<String, Integer> map;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        map = new MyHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("null", null);
    }

    @Test
    public void testClear() {
        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    public void testContainsKey() {
        assertEquals(true, map.containsKey("One"));
        assertEquals(true, map.containsKey("Two"));
        assertEquals(true, map.containsKey("Three"));
        assertEquals(true, map.containsKey("null"));
        assertEquals(false, map.containsKey("Four"));
    }

    @Test
    public void testContainsValue() {
        assertEquals(true, map.containsValue(3));
        assertEquals(true, map.containsValue(null));
        assertEquals(false, map.containsValue(4));
    }

    @Test
    public void testGet() {
        assertEquals((int) map.get("One"), 1);
        assertEquals((int) map.get("Two"), 2);
        assertEquals((int) map.get("Three"), 3);
        assertEquals(null, map.get("null"));
    }

    @Test
    public void testIsEmpty() {
        assertEquals(false, map.isEmpty());
        map.clear();
        assertEquals(true, map.isEmpty());
    }

    @Test
    public void testKeySet() {
        Set<String> keySet = map.keySet();
        assertEquals(4, keySet.size());
        assertEquals(true, keySet.contains("Three"));
        assertEquals(true, keySet.contains("null"));
        assertEquals(false, keySet.contains("Four"));
    }

    @Test
    public void testPut() {
        assertEquals(1, (int) map.put("One", 11));
        assertEquals(4, map.size());
        assertEquals(11, (int) map.get("One"));

        assertEquals(null, map.put("Five", 5));
        assertEquals(5, map.size());
        assertEquals(5, (int) map.get("Five"));
    }

    @Test
    public void testResize() {
        for (int i = 0; i < 10000; i++)
            map.put(Integer.toString(i), i);
        assertEquals(9999, (int) map.get("9999"));
        assertEquals(1, (int) map.get("One"));
        MyHashMap temp = (MyHashMap) map;
        assertEquals(16384, temp.buckets.length);
        assertEquals(10004, map.size());
        for (int i = 0; i < 6000; i++)
            map.remove(Integer.toString(i));
        assertEquals(8192, temp.buckets.length);
        for (int i = 6000; i < 9960; i++)
            map.remove(Integer.toString(i));
        assertEquals(128, temp.buckets.length);
        for (int i = 9960; i < 9990; i++)
            map.remove(Integer.toString(i));
        assertEquals(32, temp.buckets.length);
        for (int i = 9990; i < 9998; i++)
            map.remove(Integer.toString(i));
        assertEquals(16, temp.buckets.length);
    }

    @Test
    public void testPutAll() {
        Map<String, Integer> m = new HashMap<>();
        m.put("Six", 6);
        m.put("Seven", 7);
        m.put("Eight", 8);
        map.putAll(m);
        assertEquals(7, map.size());
    }

    @Test
    public void testRemove() {
        assertEquals(1, (int) map.remove("One"));
        assertEquals(3, map.size());
        assertEquals(null, map.get("One"));
        assertEquals(2, (int) map.remove("Two"));
        assertEquals(2, map.size());
        assertEquals(3, (int) map.remove("Three"));
        assertEquals(1, map.size());
        assertEquals(null, map.remove("null"));
        assertEquals(0, map.size());
    }

    @Test
    public void testSize() {
        assertEquals(4, map.size());
    }


    @Test
    public void testValues() {
        Collection<Integer> keySet = map.values();
        assertEquals(4, keySet.size());
        assertEquals(true, keySet.contains(3));
        assertEquals(true, keySet.contains(null));
        assertEquals(false, keySet.contains(4));
    }
}