package src.week3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import src.week3.nsorts.BubbleSorts;
import src.week3.nsorts.Insertions;
import src.week3.nsorts.MergeSorts;
import src.week3.nsorts.Selections;

public class Sorting {
    private final ArrayList<Integer> data = new ArrayList<>();
    private final Duration timeElapsed;

    public Sorting(int size, String method) {
        Instant start = Instant.now();  // time capture -- start
        // build an array
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }
        // use Inheritance and Polymorphism to replace data.sort with your own algorithm
        //BubbleSort.sort(data);

        switch(method) {
            case "Selection Sort":
                Selections.sort(data);
                System.out.println();
                break;
            case "Bubble Sort":
                BubbleSorts.sort(data);
                System.out.println();
                break;
            case "Insertion Sort":
                Insertions.sort(data);
                break;
            case "Merge Sort":
                MergeSorts.sort(data);
                break;
            default:
                System.out.println("This is an invalid Sort Selection");
        }

        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);

    }
    public ArrayList<Integer> getData() {
        return data;
    }

    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }
}