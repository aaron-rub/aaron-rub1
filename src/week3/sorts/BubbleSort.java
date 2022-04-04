package src.week3.sorts;

import src.week3.Times;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class BubbleSort extends Times {
    private static final ArrayList<Integer> inputArray = new ArrayList<Integer>();

    public BubbleSort(int size) {
        super(size);
    }


    @Override
    protected void bs(){
        super.name = "BubbleSort";
        System.out.println("Bubble Sort");

        int temp;
        if (inputArray.size()>1) // check if the number of orders is larger than 1
        {
            for (int x=0; x<inputArray.size(); x++) // bubble sort outer loop
            {
                for (int i=0; i < inputArray.size()-i; i++) {
                    if (inputArray.get(i).compareTo(inputArray.get(i+1)) > 0)
                    {
                        temp = inputArray.get(i);
                        inputArray.set(i,inputArray.get(i+1) );
                        inputArray.set(i+1, temp);
                    }
                }
            }
        }
    }
}