package src.week3.sorts;

import src.week3.Times;
// creating imports that enable Duration. Instant, arraylist, comparator
// no user input import
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

// creating abstract class called bubble sort that inherits attributes from 'Times'
public abstract class BubbleSort extends Times {
   // creating an array list
    // declares an output variable
    private static final ArrayList<Integer> inputArray = new ArrayList<Integer>();

    /// constructor that initializes the size as an integer
    public BubbleSort(int size) {
        super(size);
    }

// this right here is a function that is required by the abstract class
    @Override
    
    protected void bs(){
        super.name = "BubbleSort";
        // this printing out the name bubble sort
        System.out.println("Bubble Sort");

        // check if the number of orders is larger than 1
        int temp;
        if (inputArray.size()>1) 
        {
            // bubble sort outer loop
            for (int x=0; x<inputArray.size(); x++) 
            {
                // for loop that iterates over the array
                for (int i=0; i < inputArray.size()-i; i++) {
                    // if statement
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