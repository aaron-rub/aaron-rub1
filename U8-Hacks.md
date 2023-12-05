### Popcorn Hack: Create a 2D Array with random values

```java
public class Main {
    public static void main(String[] args) {
        int[][] myArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
    }
}

Main.main(null)
```

### Popcorn Hack: Print all the values on this 2D Array and update the last value to be 12.

```java
public class Main {
    public static void main(String[] args) {
        int[][] myArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }

        
        myArray[myArray.length - 1][myArray[myArray.length - 1].length - 1] = 12;

        System.out.println("value update to 12:");

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}

Main.main(null);
```

### Popcorn Hack: Traverse the following array and only print the values divisible by 7

```java
public class Main {
    public static void main(String[] args) {
        int[][] myArray = {
            {1, 2, 11},
            {14, 5, 21},
            {25, 28, 70}
        };

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (myArray[i][j] % 7 == 0) {
                    System.out.println(myArray[i][j]);
                }
            }
        }
    }
}

Main.main(null);
```

### 1
Initialize a 5 x 5 2D array that is populated by random values.

```java
public class Array2D {
    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        // Print the array
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

### 2)
- a) Print the values 47, 51, and 20 by accessing them in the the given two-dimensional array.
- b) Find the values from part a) using row major and column major order and print the values in each respective order.

```java
public class Problem2
{
    public static void main(String[] args)
    {
        int[][] arr = { {47,3,12},{51,74,20} };

        System.out.println("Values: " + arr[0][0] + ", " + arr[1][0] + ", " + arr[1][2]);

        System.out.print("Row-major order: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();

        System.out.print("Column-major order: ");
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j][i] + " ");
            }
        }
        System.out.println();
    }
}
Problem2.main(null);

```

### 3) 
The following 2d array `myArray` is populated with integers 1-9. Write an algorithm thath sorts the 2D array by column and returnst the values of the array in increaing order.

The expected output is:
`1 4 7`<br>
`2 5 8`<br>
`3 6 9`<br>

```java
import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) { 
        int[][] myArray = { 
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // matrix
        for (int i = 0; i < myArray.length; i++) {
            for (int j = i + 1; j < myArray[0].length; j++) {
                int temp = myArray[i][j];
                myArray[i][j] = myArray[j][i];
                myArray[j][i] = temp;
            }
        }

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                System.out.print(myArray[j][i] + " ");
            }
            System.out.println();
        }
    }
}
Problem3.main(null);
```

### 4
Replace the “ADD CODE HERE” below with the code to declare and create a 3 by 3 two-dimensional int array named table. The finished code will print the values 0 to 8.

```java
Here is the Java code to declare and create a 3 by 3 two-dimensional int array named table:

```java
public class Test1
{

    public static void main(String[] args)
    {
        // Declare and create a 3 by 3 two-dimensional int array named table
        int[][] table = new int[3][3];

        // Should print the values in table
        int count = 0;
        for (int row = 0; row < table.length; row++)
        {
            for (int col = 0; col < table[row].length; col++)
            {
                table[row][col] = count;
                count++;
                System.out.print(table[row][col] + " ");
            }
            System.out.println();
        }
    }
}
```

### 5
Replace the “ADD CODE HERE” below with the code to declare and initialize a two-dimensional String array called students with the names “Brice, Marvin, Anna” in the first row and “Kamal, Maria, Elissa” in the second. The finished code will print all the names in the array starting with all in the first row followed by all in the second row.

```java

public class Test1
{
    public static void main(String[] args)
    {
        // Declare and initialize a two-dimensional String array named students
        String[][] students = { 
            {"Brice", "Marvin", "Anna"},
            {"Kamal", "Maria", "Elissa"}
        };

        // Should print the values in students in order
        for (int row = 0; row < students.length; row++)
        {
            for (int col = 0; col < students[row].length; col++)
            {
                System.out.print(students[row][col] + " ");
            }
            System.out.println();
        }
    }
}
```