package src.week3.sorts;

import src.week3.Sorting;

import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public class Selection {

  private final ArrayList<Integer> data = new ArrayList<>();
  private final Duration timeElapsed;

  public Selection(int size) {
      Instant start = Instant.now();  // time capture -- start
      // build an array
      for (int i = 0; i < size; i++) {
          data.add((int)(Math.random() * (size+1)));
      }
      // use Inheritance and Polymorphism to replace data.sort with your own algorithm
      data.sort(Comparator.naturalOrder());
      Instant end = Instant.now();    // time capture -- end
      this.timeElapsed = Duration.between(start, end);
  }

  public ArrayList<Integer> getData() {
      return data;
  }

  public int getTimeElapsed() {
      return timeElapsed.getNano();
  }
 
    // Reads in an array of integers, sorts them,
    // then prints them in sorted order.
  public static void main(String[] args){    
    int sum=0, time=0, TIMES=12, SIZE=5000;
  
    for(int n=0; n< TIMES; n++) {
        Times s = new Times(SIZE);
        for(int j = 0; j<s.getData().size(); j++) {
            // To see data, uncomment next line
            // System.out.println(s.getData());
            sum += s.getData().get(j);

        System.out.println("\nAverage random: " + sum / ((n+1)*SIZE));
        System.out.println("\nNanoseconds: " + s.getTimeElapsed());
        time += s.getTimeElapsed();



    Integer[] intList;
    
    System.out.println("\nSelection Sort");
        
    intList = new Integer[TIMES];
  
    for (int i = 0; i < TIMES; i++)
          intList[i] = sum;
      Sorting.selectionSort(intList);
  
      System.out.println("\nYour numbers in sorted order...");
  
      for (int i = 0; i < TIMES; i++)
        System.out.print(intList[i] + " ");
          System.out.println();
          }
      }
    }
}