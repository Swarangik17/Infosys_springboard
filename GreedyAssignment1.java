/*
Problem Statement: 
Given a string which consists of '(' and ')', find out and return the total number of swaps required for the string to be balanced using greedy approach. 
Implement the logic in findSwapCount() method. Test the functionalities using the main() method of the Tester class.

Sample Input: 
- inputString = "())(("
- inputString = "()"

Expected Output: 
- 2
- 0
*/
class Tester {
    public static int findSwapCount(String inputString) {
        char[] chars = inputString.toCharArray();
        int open = 0, close = 0, swaps = 0, imbalance = 0;
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                open++;
                if (imbalance > 0) {
                    swaps += imbalance;
                    imbalance--;
                }
            } else if (chars[i] == ')') {
                close++;
                imbalance = (close - open);
            }
        }
        return swaps;
    }
    
    public static void main(String[] args) {
        String inputString = "())((";
        System.out.println("Number of swaps: "+findSwapCount(inputString));
    }
}
