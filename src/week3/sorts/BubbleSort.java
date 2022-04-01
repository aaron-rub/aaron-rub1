package src.week3.sorts;

import src.week3.Sorting;
import src.week3.Times;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public class BubbleSort {
  
  public static void main(String[] args) {

    int sum=0, time=0, TIMES=12, SIZE=5000;
  
    for(int a=0; a< TIMES; a++) {
        Times s = new Times(SIZE);
        for(int j = 0; j<s.getData().size(); j++) {
            sum += s.getData().get(j);
        
      
      
      int arr[] ={3,60,35,2,45,320,5};  
       
      System.out.println("Array Before Bubble Sort");  
      for(int i=0; i < arr.length; i++){  
              System.out.print(arr[i] + " ");  
      }  
      System.out.println();  
        
      Sorting.bubbleSort(arr);//sorting array elements using bubble sort  
       
      System.out.println("Array After Bubble Sort");  
      for(int i=0; i < arr.length; i++){  
              System.out.print(arr[i] + " ");
        }
      System.out.println(" \n");
          }
      }
    }
}