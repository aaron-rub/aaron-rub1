## FRQ Question 1

Write a static method arraySum that calculates and returns the sum of the entries in a specified one-dimensional array. The following example shows an array arr1 and the value returned by a call to arraySum.

```java
public static int arraySum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    return sum;
}

public class ArraySumTest {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 3};
        int sum = arraySum(arr);
        System.out.println(sum);
    }
}
ArraySumTest.main(null);
```

(b) Write a static method rowSums that calculates the sums of each of the rows in a given two-dimensional array and returns these sums in a one-dimensional array. The method has one parameter, a two-dimensional array arr2D of int values. The array is in row-major order: arr2D [ r ] [ c ] is the entry at row r and column c. The method returns a one-dimensional array with one entry for each row of arr2D such that each entry is the sum of the corresponding row in arr2D. As a reminder, each row of a two-dimensional array is a one-dimensional array.

```java
public static int[] rowSums(int[][] arr2D) {
    int rowsAmount = arr2D.length;
    int[] sums = new int[rowsAmount];
    for (int i = 0; i < arr2D.length; i++) {
        sums[i] = arraySum(arr2D[i]);
    }
    return sums;
}

public class RowSumsTest {
    public static void main(String[] args) {
        int[][] arr2D = {
            {1, 3, 2, 7, 3},
            {10, 10, 4, 6, 2},
            {5, 3, 5, 9, 6},
            {7, 6, 4, 2, 1}
        };
        int[] sums = rowSums(arr2D);
        for (int i = 0; i < sums.length; i++) {
            System.out.println("Row " + i + " Sum: " + sums[i]);
        }
    }
}
RowSumsTest.main(null);
```


This question covers Arrays/ArrayLists and 2D Arrays. Part a tests array knowledge by summing array elements. Part b involves 2D arrays, summing each row's elements. These parts highlight skills in navigating and manipulating 1D and 2D arrays, focusing on element summation and array traversal.

