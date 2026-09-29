/*
Problem Statement: 
A Sales company is conducting its month-end reviews. The Sales department head decides to meet the employees based on the order of their sales. 
The person with maximum sales will have the meeting first followed by the person having second highest sales and so on. 
Implement the logic in sortSales() method to sort a HashMap containing the names of the employees and their corresponding sales 
and return a List<String> containing the names of the employees based on the decreasing order of their sales.

Sample Input:
- sales = {"Mathew"=50, "Lisa"=76, "Courtney"=45, "David"=49, "Paul"=49}

Expected Output:
- ["Lisa", "Mathew", "David", "Paul", "Courtney"]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tester {
    
	public static List<String> sortSales(Map<String, Integer> sales) {
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(sales.entrySet());
		
		entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
		
		List<String> sortedEmployees = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : entryList) {
			sortedEmployees.add(entry.getKey());
		}
		
		return sortedEmployees;
	}

	public static void main(String args[]) {
	    Map<String, Integer> sales = new HashMap<String, Integer>();
		sales.put("Mathew", 50);
		sales.put("Lisa", 76);
		sales.put("Courtney", 45);
		sales.put("David", 49);
		sales.put("Paul", 49);
		
		List<String> employees = sortSales(sales);
		
		System.out.println("Employees in the decreasing order of their sales\n=====================================");
		for (String employeeName : employees) {
			System.out.println(employeeName);
		}
	}
}
