package src.week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stack {
    private static void reverseQueue(Queue<Integer> queue) {
        int n = queue.size();
        Stack<Integer> stack = new Stack<>();
        // Remove all the elements from queue and push them to stack
        for (int i = 0; i < n; i++) {
            int curr = queue.poll();
            stack.push(curr);
        }
        // Pop out elements from the stack and push them back to queue
        for (int i = 0; i < n; i++) {
            int curr = stack.pop();
            queue.add(curr);
        }
        // Print the reversed queue
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Example 1
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        System.out.print("Before reverse order of queue: " + q1 + "\nAfter reverse order of queue: ");
        reverseQueue(q1);
        System.out.print("\n");
    }
}