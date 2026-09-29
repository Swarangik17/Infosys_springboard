/*
Problem Statement: 
Given a stack of integers, calculate the sum of all the integers present in the stack. 
Modify the stack such that the sum is present in the bottom of the stack and all the other integers are present in the stack in the same order. 
Implement the logic inside calculateSum() method of the Tester class.
Sample Input:
- stack (top to bottom) = 40, 30, 20, 15

Expected Output:
Updated stack
Displaying stack elements
40
30
20
15
105
*/

import java.util.ArrayList;
import java.util.List;

class Stack {
    
    private int top; 
    private int maxSize; 
    private int[] arr;

    Stack(int maxSize) {
        this.top = -1; 
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        if (top >= (maxSize - 1)) {
            return true;
        }
        return false;
    }

    public boolean push(int data) {
        if (isFull()) {
            return false;
        }
        else {
            arr[++top] = data;
            return true;
        }
    }

    public int peek() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[top];
    }

    public void display() {
        if (isEmpty())
            System.out.println("Stack is empty!");
        else {
            System.out.println("Displaying stack elements");
            for (int index = top; index >= 0; index--) {
                System.out.println(arr[index]);
            }
        }
    }

    public boolean isEmpty() {
        if (top < 0) {
            return true;
        }
        return false;
    }

    public int pop() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[top--];
    }
}

class Tester {
      
    public static void main(String args[]) {
            
        Stack stack = new Stack(10);
        stack.push(15);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        calculateSum(stack);
            
        System.out.println("Updated stack");
        stack.display();
    }

    public static void calculateSum(Stack stack) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        
        while (!stack.isEmpty()) {
            int val = stack.pop();
            sum += val;
            list.add(val);
        }
        
        stack.push(sum);
        
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }
}
