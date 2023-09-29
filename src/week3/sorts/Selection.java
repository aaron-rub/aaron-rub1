package src.week3.sorts;

import src.week3.Times;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Selection extends Times {
    private final ArrayList<Integer> inputArray = new ArrayList<Integer>();

    public Selection(int size) {
        super(size);
    }


    @Override
    protected void sel1(int sourceIndex,int destIndex){
        super.name = "Selection Sort";
        System.out.println("Selection Sort");

        int smallInt = 0;
        int j=0;
        int smallIntIndex = 0;

        for(int i=1;i<inputArray.size();i++){

            smallInt = inputArray.get(i-1);
            smallIntIndex = i-1;

            for(j=i;j<inputArray.size();j++){
                if(inputArray.get(j)<smallInt){
                    smallInt = inputArray.get(j);
                    smallIntIndex = j;
                }
            }

            //Swap the smallest element with the first element of unsorted subarray
            sel1(i-1, smallIntIndex);
        }

        int temp = inputArray.get(destIndex);
        inputArray.set(destIndex, inputArray.get(sourceIndex));
        inputArray.set(sourceIndex, temp);
    }
}