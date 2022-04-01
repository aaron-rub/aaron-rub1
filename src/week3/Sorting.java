package src.week3;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Sorting {  
    // Selection Sort
    public static void selectionSort (Comparable[] list) {
        int min;
        Comparable temp;
        for (int index = 0; index < list.length-1; index++) {
            min = index;
            for (int scan = index+1; scan < list.length; scan++)
                if (list[scan].compareTo(list[min]) < 0)
                    min = scan;

        // Swap the values
            temp = list[min];

            list[min] = list[index];
            list[index] = temp;
        }
    }


    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                            }
                          
                   } 
           }
      }
}

