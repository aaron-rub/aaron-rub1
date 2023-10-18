# U3 Hacks

## boolean Expressions:

1. What is the result of !(true)&&(false) in terms of boolean values?

!(true)&&(false) equals false.

2. Simplify the expression not ((((true and not (false)) ^ false) ^ true) && false) using PEMDAS (Parentheses, Exponents, Multiplication and Division, Addition and Subtraction, NOT, AND, OR):

not ((((true and not (false)) ^ false) ^ true) && false)
not ((((true and true) ^ false) ^ true) && false)
not (((true ^ false) ^ true) && false)
not ((true ^ true) && false)
not (false && false)
not (false)
true

3. Prove the following: !A * !(B + !C) = !A * (!B * !C) using De Morgan's Law.

Left-hand side: !A * !(B + !C)
Applying De Morgan's Law: !A * (!B * C) (since !C is equivalent to C)
Right-hand side: !A * (!B * !C)
The left-hand side is equal to the right-hand side, and the equation is proven.

Binary Operations:

4. Calculate 420 && 66 after converting to binary and performing the operation.

420 in binary is 110100100.
66 in binary is 1000010.
Performing the && operation: 110100100 && 1000010 equals false.
Calculate 89 OR 42 after converting to binary and performing the operation.

89 in binary is 1011001.
42 in binary is 101010.
Performing the OR operation: 1011001 OR 101010 equals false.





BONUS: Create a program that checks if a year is a leap year or not.

Here is how the method should work: 

(1) Prompt the user to input any year that they would like <br>
(2) Determine if the year is a leap year or not <br>
(3) Print the necessary dialogue (ex. [year] is/is not a leap year) AND return the value of any boolean(s) used
```java
public class PhysicsStudent implements Comparable<PhysicsStudent> {
    private String name;
    private double physicsGrade;

    public PhysicsStudent(String name, double physicsGrade) {
        this.name = name;
        this.physicsGrade = physicsGrade;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPhysicsGrade() {
        return physicsGrade;
    }

    // Override the compareTo
    public int compareTo(PhysicsStudent other) {
        if (this.physicsGrade < other.physicsGrade) {
            return -1;
        } else if (this.physicsGrade > other.physicsGrade) {
            return 1;
        } else {
            return 0;
        }
    }
}
```

Print
```java
public class Main {
    public static void main(String[] args) {
        PhysicsStudent fred = new PhysicsStudent("Fred", 3.8);
        PhysicsStudent bob = new PhysicsStudent("Bob", 3.6);

        int result = fred.compareTo(bob);

        if (result < 0) {
            System.out.println("Fred has a lower physics grade than Bob");
        } else if (result > 0) {
            System.out.println("Fred has a higher physics grade than Bob");
        } else {
            System.out.println("Fred and Bob have the same physics grade");
        }
    }
}
Main.main(null);
```


## Extra

```java
import java.util.Scanner;

public class EvenOddChecker {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        boolean result = isEven(number);

        if (result) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }

        sc.close();
    }
}

```

<style>
    pre {
        background-color: lavenderblush;
    }

</style>