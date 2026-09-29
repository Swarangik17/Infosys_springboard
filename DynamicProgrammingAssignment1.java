import java.util.ArrayList;
import java.util.List;
/*
Problem Statement: 
Given a string and a list of words, find out the number of possible word segments that can be used to form the given string using the words present in wordsList. 
Count the number of possible word segments with the help of 'count' static variable. Implement the logic in findWordSegments() method. 
Test the functionalities using the main() method of the Tester class.

Sample Input: 
- wordsList = ["I", "like", "pizza", "li", "ke", "pi", "zza"]
- inputString = "ilikepizza"

Expected Output: 
- 4
*/

class Tester {
    static int count = 0;

    public static void findWordSegments(List<String> wordsList, String inputString) {
        count = helper(wordsList, inputString, "");
    }

    private static int helper(List<String> wordsList, String target, String current) {
        if (current.equals(target)) {
            return 1;
        }
        if (current.length() >= target.length() || !target.startsWith(current)) {
            return 0;
        }

        int ways = 0;
        for (String word : wordsList) {
            ways += helper(wordsList, target, current + word);
        }
        return ways;
    }
    
    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<String>();
        wordsList.add("I");
        wordsList.add("like");
        wordsList.add("pizza");
        wordsList.add("li");
        wordsList.add("ke");
        wordsList.add("pi");
        wordsList.add("zza");

        String inputString = "ilikepizza";
        findWordSegments(wordsList, inputString);
        System.out.println("Number of segments: " + count);
    }
}
