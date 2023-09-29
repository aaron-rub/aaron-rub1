package src.week3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

import src.week3.sorts.BubbleSort;
import src.week3.sorts.Insertion;
import src.week3.sorts.MergeSort;
import src.week3.sorts.Selection;

public abstract class Times {
    private final static ArrayList<Integer> data = new ArrayList<>();
    private final Duration timeElapsed;
    protected String name;

    private static final ArrayList<Integer> inputArray = new ArrayList<Integer>();

    public Times(int size) {
        Instant start = Instant.now();  // time capture -- start
        // build an array
        for (int i = 0; i < size; i++) {
            data.add((int) (Math.random() * (size + 1)));
        }

        this.bs();
        this.is();
        this.sel1(1,1);
        this.sortGivenArray();
        this.divide(1,7);
        this.merger(1, 4, 7);

        // use Inheritance and Polymorphism to replace data.sort with your own algorithm
        data.sort(Comparator.naturalOrder());
        // BubbleSort.sort(data);
        // Insertion.sort(data);
        // MergeSort.sort(data);
        //Selection.sort(data);

        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }

    public Times() {
        this(5000);
    }

    // Bubble Sort
    protected abstract void bs();

    // Insertion Sort
    protected abstract void is();

    // Selection Sort First Method
    protected abstract void sel1(int sourceIndex, int destIndex);

    // Merge Sort First Method with no parameters
    protected abstract void sortGivenArray();

    // Merge Sort Second Method with parameters
    protected abstract void divide(int startIndex, int endIndex);

    // Merge Sort Third Method with parameters
    protected abstract void merger(int startIndex, int midIndex, int endIndex);



    public ArrayList<Integer> getData() {
        return data;
    }

    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }



    public static void main(String[] args) {
        int sum = 0, time = 0, TIMES = 12, SIZE = 5000;

        for (int i = 0; i < TIMES; i++) {
            Times s = new Times(SIZE) {
                @Override
                protected void bs() {
                    System.out.println("Bubble Sort");
                    super.name = "BubbleSort";

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
                    System.out.println(" ");
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
                    System.out.println(" ");
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

                @Override
                protected void sortGivenArray() {
                    divide(0, inputArray.size()-1);
                }

                @Override
                protected void divide(int startIndex, int endIndex) {
                    super.name = "Merge Sort";
                    System.out.println("Merge Sort");

                    //Divide till you breakdown your list to single element
                    if(startIndex<endIndex && (endIndex-startIndex)>=1){
                        int mid = (endIndex + startIndex)/2;
                        divide(startIndex, mid);
                        divide(mid+1, endIndex);

                        //merging Sorted array produce above into one sorted array
                        merger(startIndex,mid,endIndex);
                    }
                }

                @Override
                protected void merger(int startIndex, int midIndex, int endIndex) {
                    super.name = "Method 2";

                    //Below is the merged array that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
                    ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();

                    int leftIndex = startIndex;
                    int rightIndex = midIndex+1;

                    while(leftIndex<=midIndex && rightIndex<=endIndex){
                        if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
                            mergedSortedArray.add(inputArray.get(leftIndex));
                            leftIndex++;
                        }else{
                            mergedSortedArray.add(inputArray.get(rightIndex));
                            rightIndex++;
                        }
                    }

                    //Either of below while loop will execute
                    while(leftIndex<=midIndex){
                        mergedSortedArray.add(inputArray.get(leftIndex));
                        leftIndex++;
                    }

                    while(rightIndex<=endIndex){
                        mergedSortedArray.add(inputArray.get(rightIndex));
                        rightIndex++;
                    }

                    int i = 0;
                    int j = startIndex;
                    //Setting sorted array to original one
                    while(i<mergedSortedArray.size()){
                        inputArray.set(j, mergedSortedArray.get(i++));
                        j++;
                    }
                }
            };

            for (int j = 0; j < s.getData().size(); j++) {
                // To see data, uncomment next line
                // System.out.println(s.getData());
                sum += s.getData().get(j);
            }
            System.out.println("Average random: " + sum / ((i + 1) * SIZE));
            System.out.println("Nanoseconds: " + s.getTimeElapsed());
            time += s.getTimeElapsed();
        }
        System.out.println("Average random: " + sum / (TIMES * SIZE));
        System.out.println("Total Nanoseconds: " + time);
        System.out.println("Total Seconds: " + time / 1000000000.0);

        System.out.println(" ");
    }
}