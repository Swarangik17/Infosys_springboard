/*
Problem Statement: 
Implement the functionalities of a queue by using a LinkedList. 
The class diagram specifies fields (queue: LinkedList<String>, maxSize: int) and methods 
(Queue(maxSize), getQueue(), isFull(), isEmpty(), enqueue(data), dequeue()).

Sample Input:
- Queue of maxSize 5
- Enqueue: "Emily", "Lily", "Rachel", "Rose"
- Dequeue twice ("Emily", "Lily" removed)

Expected Output:
- [Rachel, Rose]
*/

import java.util.LinkedList;

class Queue {
    private LinkedList<String> queue;
    private int maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new LinkedList<String>();
    }

    public LinkedList<String> getQueue() {
        return queue;
    }

    public boolean isFull() {
        if (queue.size() == maxSize) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (queue.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean enqueue(String data) {
        if (isFull()) {
            return false;
        }
        queue.add(data);
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        queue.remove(0);
        return true;
    }
}

class Tester {

    public static void main(String arga[]){
        Queue queue= new Queue(5);
        
        queue.enqueue("Emily");
        queue.enqueue("Lily");
        queue.enqueue("Rachel");
        queue.enqueue("Rose");
        
        queue.dequeue();
        queue.dequeue();
    
        System.out.println(queue.getQueue());
    }
}
