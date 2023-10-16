<h4> POPCORN HACK: Run the code.. what happened? How can we fix it?</h4>

Tell us below!

There were two problems that could essentialy fix the code, first it never exits the loop. And second you need to subtract sub.length from word.length

<br>
<br>

<h4> Another issue:</h4>

<h3> I T E R A T E </h3>
What if our substring was the word "RATE"? Note that RATE is at the end of the whole string

<br>
<br>

<h3> HACKS </h3>

**Create a algorithm similar to the one above. Except this time, use iteration to count the number of vowels within the main string.**

HINT: Use the boolean expressions we have learned in previous lessons. Which would you use when comparing your "window" with multiple options of substrings?

------

### Popcorn HACK

When the targetNumber is found, you can print a message and use the break statement to exit the loop. When it's not found, you can print a message indicating that the number was not found.
```java
public class BreakHack {
    public static void main(String[] args) {
        int targetNumber = 42; //numb we want
        int[] numbers = {10, 20, 30, 40, 50, 60, 70}; //numb array
        boolean found = false; // A boolean to keep track of whether the target number is found

        for (int number : numbers) {
            if (number == targetNumber) {
                found = true;
                // Print a message if the number is found
                System.out.println("Number " + targetNumber + " is found!");
                // Break out of the loop
                break;
            }
        }

        // Check if the number isn't found and print a message if it's not found
        if (!found) {
            System.out.println("Number " + targetNumber + " wasn't found.");
        }
    }
}
BreakHack.main(null);
```
-----------
```java
import java.util.Scanner;

public class InteractivePyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the symbol you want to use: ");
        char symbol = scanner.next().charAt(0);

        System.out.print("Enter the number of rows for the pyramid: ");
        int numRows = scanner.nextInt();

        for (int i = 1; i <= numRows; i++) {
            //print space before the symbol
            for (int j = 1; j <= numRows - i; j++) {
                System.out.print(" ");
            }

            //print
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(symbol);
            }

            System.out.println(); //next line
        }
        scanner.close();
    }
}
InteractivePyramid.main(null)
```
## Hacks

1. **Modify pyramid code:**

- Create different patterns (other then pyramid) by modifying nested loop structure

2. **Questions**

- What is a nested iteration, continue statement, and break statement (in your own words)?
- Create a simple example of a continue statement **or** break statement

# 4.5 Informal Code Analysis

<b>Learning objective</b>: Compute statement execution counts & informal run-time comparison of iterative statements

<b>Essential Knowledge</b>: A statement execution count indicates the number of times a statement is executed by the program

<h3> What IS informal code analysis? </h3>

Answer:

```java
// CODE EXAMPLE #1 (for loop)
public class InformalCodeAnalysis {
    public static void main(String[] args) {
        int count = 0;
        for (int k = 0; k < 30; k++)
        {
            if (k % 3 == 0) // statement 1
            {
                count++; // statement 2
            }
        }
    }
}
```
<b>How many times will statement 1 execute? </b>

Answer:
<b>How many times will statement 2 execute?</b>

Answer:

```java
// CODE EXAMPLE #2 (for loop)
public class InformalCodeAnalysis {
    public static void main(String[] args) {
        int count = 0;
        for (int k = 4; k < 30; k+=3)
        {
            count++; // statement 3
        }
    }
}
```
<b>How many times will statement 3 execute?</b>

Answer:

```java
// Rewrite the code segment below to have a faster run-time based on statement execution counts
for (int k = 0; k < 135; k++)
{
    if (k % 5 == 0)
    {
        System.out.println(k);
    }
}
```
------------
```java
// CODE EXAMPLE #3 (while loop)

int num = (int)(Math.random() * 10);
while (num % 2 != 0)
{
    num = (int)(Math.random() * 10); // statement 4
}
```
<b>What is the min/max number of times statement 4 will execute?</b>

Answer:

```java
// CODE EXAMPLE #4 (nested loop)

for (int outer = 0; outer < 3; outer++)
{
    for (int inner = 0; inner < 4; inner++)
    {
        // statement #5
    }
}
```
<b>How many times will statement #5 execute?</b>

Answer:

```java
// CODE EXAMPLE #5 (nested loop)

int k = 0;
while (k < 5)
{
    int x = (int)(Math.random() * 6) + 1;
    while (x != 6)
    {
        // statement #6
        x = (int)(Math.random() * 6) + 1;
    }
    k++;
}
```
<b>How many times will statement #6 execute?</b>

Answer: We don't knowf  

# 4.5 Hacks


<b>#1 How many times will statement #1 and statement #2 execute in the code segments below? </b>

```java
for (int k = 0; k < 1000; k++)
{
    // statement #1
}
```

```java
for (int k = 6; k < 50; k++)
{
    // statement #2
}
```

<b>#2 How many times will statement #3 execute for the code segment below?</b>

```java
int k = 1;
while (k <=7)
{
    for (int z = 0; z < 4; z++)
    {
        // statement #3
    }
    k++;
}
```

<b>#3 Create 3 seperate code segments that execute a statement 10 times using: </b>

(a) a for loop

(b) a while loop

(c) a nested loop

```java
// 3a code
```

```

```java
// 3b code
```

```java
// 3c code
```

<style>
    pre {
        background-color: lavenderblush;
    }

</style>