import java.util.*;

// Runtime: O(N) because you iterate over N twice but that means 2N, so really N
// Space Complexity: O(N) because same deal

public class FrequencyPrint {

    static String frequencyPrint(String s) {
        String[] array = s.split(" ");         // split s by spaces and turn into an array of strings

        Map<String,Integer> wordsFirst = new HashMap<>();

        for (String elem : array) {
            if (wordsFirst.containsKey(elem)) {
                int V = (int) wordsFirst.get(elem);
                wordsFirst.replace(elem, V+1); //add one to value
            }
            else {
                wordsFirst.put(elem, 1);
            }
        }

        Map<Integer,ArrayList<String>> countsFirst = new HashMap<>();
        for (Map.Entry<String,Integer> entry : wordsFirst.entrySet()) {
            String K = entry.getKey();
            Integer V = entry.getValue();
            ArrayList<String> words;                //just initializing a pointer

            if (countsFirst.containsKey(V)) {       //if the count is already a key in the new map
                words = countsFirst.get(V);         //now actually defining it
                words.add(K);
            }
            else {
                words = new ArrayList<>();
                words.add(K);
            }
            countsFirst.put(V, words);
        }

        ArrayList<String> listofStrings = new ArrayList<>();                           //can maybe do in-house space-wise? try to fix later
        for (Map.Entry<Integer,ArrayList<String>> entry : countsFirst.entrySet()) {    //for entries in countsFirst
            for (String word: entry.getValue()) {
                for (int i=entry.getKey(); i>0; i--) {                                 //for each count
                    listofStrings.add(word);                                           //add the value
                }
            }
        }
        return String.join(" ",listofStrings);
    }
}
