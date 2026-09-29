/*
Problem Statement: 
Given a queue of whole numbers, find the numbers in the queue that are evenly divisible by all the numbers from 1 to 10 and return a new queue with all the evenly divisible numbers. 
Implement the logic inside findEvenlyDivisibleNumbers() method of the Tester class.

Sample Input:
- queue(front to rear) = 13983, 10080, 7113, 2520, 2500

Expected Output:
Evenly divisible numbers
10080
2520
*/

class Queue {
      
    private int front;
    private int rear;
    private int maxSize;
    private int arr[];
      
    Queue(int maxSize) {
        this.front = 0;
        this.rear = -1;
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
    }
      
    public boolean isFull() {
        if (rear == maxSize - 1) {
            return true;
        }
        return false;
    }
            
    public boolean enqueue(int data) {
        if (isFull()) {
            return false;
        } else {
            arr[++rear] = data;
            return true;
        }
    }

    public void display() {
        if(isEmpty())
            System.out.println("Queue is empty!");
        else {
            for (int index = front; index <= rear; index++) {
                System.out.println(arr[index]);
            }
        }
    }
            
    public boolean isEmpty() {
        if (front > rear)
            return true;
        return false;
    }
            
    public int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            int data = arr[this.front];
            arr[front++] = Integer.MIN_VALUE;
            return data;
        }
    }

    public int getMaxSize() {
        return maxSize;
    }
}

class Tester {

    public static void main(String[] args) {
            
        Queue queue = new Queue(7);
        queue.enqueue(13983);
        queue.enqueue(10080);
        queue.enqueue(7113);
        queue.enqueue(2520);
        queue.enqueue(2500);

        Queue outputQueue = findEvenlyDivisibleNumbers(queue);
            
        System.out.println("Evenly divisible numbers");
        outputQueue.display();

    }
      
    public static Queue findEvenlyDivisibleNumbers(Queue queue) {
        Queue resultQueue = new Queue(queue.getMaxSize());
        Queue tempQueue = new Queue(queue.getMaxSize());
        
        while (!queue.isEmpty()) {
            int data = queue.dequeue();
            tempQueue.enqueue(data);
            
            boolean isDivisible = true;
            for (int i = 1; i <= 10; i++) {
                if (data % i != 0) {
                    isDivisible = false;
                    break;
                }
            }
            
            if (isDivisible) {
                resultQueue.enqueue(data);
            }
        }
        
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }
        
        return resultQueue;
    }
}
