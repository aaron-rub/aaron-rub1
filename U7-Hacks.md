## 7.1 Popcorn Hack

Create an ArrayList that stores the integers 5, 8, 14, 18, 24, 39, and 56 and only print the numbers that are divisible by 3.
```java
import java.util.ArrayList;

public class DivisibleBy3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 8, 14, 18, 24 ,39, 56));

        for (int number : numbers) {
            if (number % 3 == 0) {
                System.out.println(number);
            }
        }
    }
}
DivisibleBy3.main(null);
```


## 7.2 Popcorn Hack

Finish the code below so that all duplicates in the ArrayList are removed.

```java
import java.util.Arraylist;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(); // creating new arraylist of integers
        
        // adding integers to the arraylist
        arr.add(1);
        arr.add(7);
        arr.add(9);
        arr.add(13);
        arr.add(3);
        arr.add(7);
        arr.add(9);
        arr.add(2);

        // add your code here
        for(int i = 0: i < arr.size(): i++) {
            for (int j = i + 1; j < arr.size(): j++) {
                if(arr.get(i).equals(arr.get(j))) {
                    arr.remove(j);
                    j--;
                }
            }
        }
        System.out.println(arr);
    }
}
RemoveDuplicates.main(null);
```

## Popcorn Hack
Traverse the following ArrayList using a loop. Remove each element that is a multiple of 4.

```java
public static void main(String[] args)
{
    ArrayList<Integer> arr = new ArrayList<>();        
    arr.add(1);
    arr.add(7);
    arr.add(9);
    arr.add(80);
    arr.add(13);
    arr.add(3);
    arr.add(7);
    arr.add(8);
    arr.add(2);
    arr.add(16);

    for(int i = 0; i < arr.size(); i++) {
        if(arr.get(i) % 4 == 0) {
            arr.remove(i);
        }
    }
}
main(null);
```

## Popcorn Hacks
Find the maximum, minimum, and sum of an ArrayList.

```java
public static void main(String[] args)
{
    ArrayList<Integer> arr = new ArrayList<>();        
    arr.add(1);
    arr.add(7);
    arr.add(9);
    arr.add(80);
    arr.add(13);
    arr.add(3);
    arr.add(7);
    arr.add(8);
    arr.add(2);
    arr.add(16);

    int max = Integer.MIN_VALUE; // initialize max 
    int min = Integer.MAX_VALUE; // initialize min 
    int sum = 0; // initialize sum

    for (int num : arr) {
        if (num > max) {
            max = num; // update max if current number is greater
        }
        if (num < min) {
            min = num; // update min if current number is smaller
        }
        sum += num; // add current number to sum
    }

    System.out.println("Max: " + max);
    System.out.println("Min: " + min);
    System.out.println("Sum: " + sum);
}
```


## Popcorn Hack

- Finish the code below, write code that checks if favoriteFlavor is in chipsBag
- Using a loop, print a message saying if favoriteFlavor is in the bag

```java
import java.util.ArrayList;
import java.util.Scanner;

public class FavoriteChip {
    public static void main(String[] args) {
        ArrayList<String> chipsBag = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        chipsBag.add("BBQ");
        chipsBag.add("Cheddar");
        chipsBag.add("Salt and Pepper");

        System.out.print("Enter your favorite chip flavor: ");
        String favoriteFlavor = scanner.nextLine();

        // implement your own search logic here
        boolean found = false; // track 

        // Traverse the arraylist
        for(int i = 0; i < chipsBag.size(); i++) {
            // element is equal to favoriteFlavor
            if(chipsBag.get(i).equals(favoriteFlavor)) {
                found = true; // break the loop
                break;
            }
        }

        if(found) {
            System.out.println(favoriteFlavor + " is in the bag!");
        } else {
            System.out.println(favoriteFlavor + " is not in the bag.");
        }
    }
}

FavoriteChip.main(null);
```


## 7.6 Popcorn Hack

Given an ArrayList of String objects, sort the following ArrayLists on ascending order of word length.

```java
import java.util.ArrayList;

public class SortByLength {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(); // creating new arraylist
        
        words.add("theater");
        words.add("connection");
        words.add("seasonal");
        words.add("feast");
        words.add("meeting");

        // sort the list by length 
        for (int i = 1; i < words.size(); i++) {
            String key = words.get(i);
            int j = i - 1;


            // moving elements of array 
            while (j >= 0 && words.get(j).length() > key.length()) {
                words.set(j + 1, words.get(j));
                j = j - 1;
            }
            words.set(j + 1, key);
        }

        System.out.println(words); // print sorted list
    }
}

SortByLength.main(null);
```


## Hacks for Unit 7
- Complete all questions and popcorn hacks
- Write a Java program that creates an ArrayList of integers. Create methods for adding, removing, setting, getting, etc numbers and also sort the list. Then, utilize user input to determine which methods will actually be run and enable the user to also determine the specific index that a number will be added, removed.

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);

        System.out.println("Original list: " + list);

        // Add an element
        list.add(20);
        System.out.println("After adding an element: " + list);

        // Remove an element
        list.remove(new Integer(10));
        System.out.println("After removing an element: " + list);

        // Set an element
        list.set(1, 100);
        System.out.println("After setting an element: " + list);

        // Get an element
        int element = list.get(0);
        System.out.println("Got element: " + element);

        // Sort the list
        Collections.sort(list);
        System.out.println("After sorting: " + list);
    }
}
```

### Challenge
You are given an ArrayList of `Student` objects. Each `Student` has a name (String) and a GPA (double). Create a program that sorts the `Student` objects in descending order of GPA.

```java
import java.util.*;

class Student {
    String name;
    double gpa;

    // constructor
    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    // for pretty printing
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.8));
        students.add(new Student("Bob", 3.5));
        students.add(new Student("Charlie", 3.9));

        System.out.println("Before sorting: " + students);

        // sort in descending order of GPA
        students.sort((s1, s2) -> Double.compare(s2.gpa, s1.gpa));

        System.out.println("After sorting: " + students);
    }
}
```