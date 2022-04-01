package src.week1;

import src.week1.Queue;

import java.util.*;

public class OrderQ {
  public static void main(String[] args) {
      ArrayQmerge q1 = new ArrayQmerge();
      q1.enqueue(1);
      q1.enqueue(4);
      q1.enqueue(5);
      q1.enqueue(8);
      q1.enqueue(0);
      ArrayQmerge q2 = new ArrayQmerge();
      q2.enqueue(2);
      q2.enqueue(3);
      q2.enqueue(6);
      q2.enqueue(7);
      System.out.println("Queue 1" + q1);
      System.out.println("Queue 2" + q2);
      q1.mergeQs(q2);
      System.out.println("Queue 1 + Queue2 Merged: " + q1);
      System.out.println("");
  }
  
  static class ArrayQmerge{
      private List<Integer> queue = new ArrayList<Integer>();
  
      public void enqueue(int val){
          queue.add(val);
      }
  
      public String toString(){
          return queue.toString();
      }
  
      public void mergeQs(ArrayQmerge q){
          List<Integer> mergedQ = new ArrayList<Integer>(this.queue.size() + q.queue.size());
          for (int i = 0, j = 0; i < this.queue.size() || j < q.queue.size();){
              if (i < this.queue.size())
                  mergedQ.add(this.queue.get(i++));
              if (j < q.queue.size())
                  mergedQ.add(q.queue.get(j++));
          }
          this.queue = mergedQ;
     }
  }
}