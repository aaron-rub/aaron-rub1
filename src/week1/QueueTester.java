package src.week1;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// import src.week1.Queue;


/**
 * Driver Class
 * Tests queue with string, integers, and mixes of Classes and types
 */
public class QueueTester {
    private static int count = 1; // number of objects in queue
    public static void main(String[] args) {
        // Create iterable Queue of Words
        Object[] words = new String[] { "seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
      //   QueueManager qWords = new QueueManager("Words", words);
      //   qWords.printQueue();
      //   System.out.println("");

      //   // Create iterable Queue of Integers
      //   Object[] numbers = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      //   QueueManager qNums = new QueueManager("Integers", numbers );
      //   qNums.printQueue();
      //   System.out.println("");

      // // Create iterable Queue of Mixed types of data
      //   QueueManager qMix = new QueueManager("Mixed");
      //   qMix.queue.add("Start");
        
      //   qMix.addList(
      //           words,
      //           numbers
      //   );
      //   qMix.queue.add("\n\nEnd");
      //   qMix.printQueue();
      //   System.out.println("");
      // }

  
      // Queue Data
      Queue<String> data = new LinkedList<String>();
      for (Object x : words) {
        System.out.println("\nEnqueued Data: " + x);
        System.out.print("Words Count: " + count++);
        data.add(x.toString());
        System.out.println(", Data: " + data.toString().replaceAll("\\[|\\]", ""));
      }
            
      // Dequeue Data
      int index = 6;
      // for (int i = data.size() - 1; i >= 0; i--) {
      //   Object s = data.get(i);
      //   System.out.println("\nDequeued Data: " + s);
      // }
      for (Object x : words) {
        System.out.println("\nDequeued Data: " + x);
        System.out.print("Words Count: " + index--);
        data.poll();
        System.out.println(", Data: " + data
                           .toString()
                           .replaceAll("\\[|\\]", ""));
      }
      
      System.out.println("\n");
      }
}