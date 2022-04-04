package src.week3;

import src.week3.Sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class NTimes {
    public static void main(String[] args) {
        System.out.println(" SELECTION SORT ");
        analyze("Selection Sort");
        System.out.println();

        System.out.println(" BUBBLE SORT ");
        analyze("Bubble Sort");
        System.out.println();

        System.out.println(" INSERTION SORT ");
        analyze("Insertion Sort");
        System.out.println();

        System.out.println(" MERGE SORT ");
        analyze("Merge Sort");
        System.out.println();
    }
    public static void analyze(String method) {
        ArrayList<Integer> Twelve = new ArrayList<Integer>();
        int TIMES = 12; int SIZE = 5000; int sum = 0; int time = 0;
        for(int i=0; i< TIMES; i++) {
            Sorting s = new Sorting(SIZE, method);
            for(int j = 0; j<s.getData().size(); j++) {
                sum += s.getData().get(j);
            }
            System.out.println("Average random: " + sum / ((i+1)*SIZE));
            System.out.println("Nanoseconds: " + s.getTimeElapsed()+"\n");
            time += s.getTimeElapsed();
            Twelve.add(s.getTimeElapsed());
        }

        Collections.sort(Twelve);

        System.out.println("Analysis for "+ method);
        System.out.println("Total Nanoseconds: " + time );
        System.out.println("Total Seconds: " + time /1000000000.0);
        System.out.println("ALL times in Nanoseconds: " + Twelve);
        System.out.println("Average time in seconds " + "(with high and low): " + time/12/1000000000.0);


        Integer Ten = 0;
        System.out.println("LOW (in nano): "+Twelve.remove(0)); // remove smallest
        System.out.println("HIGH (in nano): "+Twelve.remove(Twelve.size()-1)); //remove largest
        for(Integer d : Twelve) {
            Ten += d;
        }

        System.out.println("Average time in seconds " + "(high low OMITTED): " + Ten/10/1000000000.0);

        System.out.println(" ");
    }
}
