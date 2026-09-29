/*
Problem Statement: 
Given a linked list that stores integer values, remove the duplicate values and return a list containing unique values. 
Implement the logic inside removeDuplicates() method. Test the functionalities using the main() method of the Tester class.

Sample Input:
- 10 -> 15 -> 21 -> 15 -> 10

Expected Output:
- 10 -> 15 -> 21
*/

import java.util.LinkedList;
import java.util.List;

class Tester {
    
    public static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> uniqueList = new LinkedList<>();
        for (Integer value : list) {
            if (!uniqueList.contains(value)) {
                uniqueList.add(value);
            }
        }
        return uniqueList;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(15);
        list.add(21);
        list.add(15);
        list.add(10);

        List<Integer> updatedList = removeDuplicates(list);

        System.out.println("Linked list without duplicates");
        for (Integer value : updatedList) {
            System.out.print(value+" ");
        }
    }
}
