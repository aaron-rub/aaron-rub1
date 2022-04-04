package src.week3.sorts;

import src.week3.Times;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Insertion extends Times {
    private static final ArrayList<Integer> inputArray = new ArrayList<Integer>();

    public Insertion(int size) {
        super(size);
    }


    @Override
    protected void is() {
        super.name = "Insertion Sort";
        System.out.println("Insertion Sort");

        for(int i=1;i<inputArray.size();i++){

            int key = inputArray.get(i);

            for(int j= i-1;j>=0;j--){
                if(key<inputArray.get(j)){
                    // Shifting Each Element to its right as key is less than the existing element at current index
                    inputArray.set(j+1,inputArray.get(j));

                    // Special case scenario when all elements are less than key, so placing key value at 0th Position
                    if(j==0){
                        inputArray.set(0, key);
                    }
                }else{
                    // Putting Key value after element at current index as Key value is no more less than the existing element at current index
                    inputArray.set(j+1,key);
                    break; // You need to break the loop to save un necessary iteration
                }
            }
        }
    }
}