/*
Problem Statement: 
Given two sorted linked lists containing integers, return a single linked list containing all the integers of both the lists in a sorted order. 
Implement the logic inside mergeLists() method. Test the functionalities using the main() method of the Tester class.

Sample Input:
- listOne = 10 -> 13 -> 21 -> 42 -> 56
- listTwo = 15 -> 20 -> 21 -> 85 -> 92

Expected Output:
- 10 -> 13 -> 15 -> 20 -> 21 -> 21 -> 42 -> 56 -> 85 -> 92
*/

import java.util.LinkedList;
import java.util.List;

class Tester {
    
	public static List<Integer> mergeLists(List<Integer> listOne, List<Integer> listTwo) {
		List<Integer> mergedList = new LinkedList<>();
		int i = 0, j = 0;
		
		while (i < listOne.size() && j < listTwo.size()) {
			if (listOne.get(i) <= listTwo.get(j)) {
				mergedList.add(listOne.get(i));
				i++;
			} else {
				mergedList.add(listTwo.get(j));
				j++;
			}
		}
		
		while (i < listOne.size()) {
			mergedList.add(listOne.get(i));
			i++;
		}
		
		while (j < listTwo.size()) {
			mergedList.add(listTwo.get(j));
			j++;
		}
		
		return mergedList;
	}

	public static void main(String args[]) {
		List<Integer> listOne = new LinkedList<Integer>();
		listOne.add(10);
		listOne.add(13);
		listOne.add(21);
		listOne.add(42);
		listOne.add(56);
		
		List<Integer> listTwo = new LinkedList<Integer>();
		listTwo.add(15);
		listTwo.add(20);
		listTwo.add(21);
		listTwo.add(85);
		listTwo.add(92);
		
		List<Integer> mergedList = mergeLists(listOne, listTwo);
		System.out.println(mergedList);
	}
}
