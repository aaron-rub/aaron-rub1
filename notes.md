{% include notesnav.html %}

## Week 3 - [Ticket](https://github.com/Chris-Ru/Chris-Ru.github.io/issues/5)

Assignment:

Objective 1: Perform analysis on all of these sorts using 5,000 random pieces of data.
- Build custom Bubble Sort, Selection Sort, Insertion Sort and Merge Sort.
- Build a GitHub page that describes Sort implementations and the Big O complexity of these Sorts.
- Establish analytics including: time, comparisons and swaps.
- Average the results for each each Sort, run each at least 12 times and 5000 elements. You should throw out High and Low when doing analysis.
- Make your final/judgement on best sort considering Data Structure loading, Comparisons, Swaps, Big O complexity, and Time.

### Time
Sorting.java
```java
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
```

Getting the time of the sort (directly):
```java
        Instant start = Instant.now();  // time capture -- start
        // build an array
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }
        ...
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
```

### Bubble Sort Objective 1
BubbleSorts.java
- Analysis:
  - Average Speed (in seconds):
    - ~0.000 ( on personal computer)
  - Big O Complexity(same speed as Insertion and Selection Sort)
    - O(n^2)
```java
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
```

### Insertion Sort Objective 1
Insertions.java
- Analysis:
    - Average Speed (in seconds):
        - ~0.000 ( on personal computer)
    - Big O Complexity(same speed as Selection and Bubble Sort)
        - O(n^2)

```java
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
```

### Selection Sort Objective 1
Selections.java
- Analysis:
    - Average Speed (in seconds):
        - ~0.000 ( on personal computer)
  - Big O Complexity(same speed as Insertion and Bubble Sort)
      - O(n^2)

```java
    public void sortGivenArray(){

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
            swap(i-1, smallIntIndex);
        }
    }

    public void swap(int sourceIndex,int destIndex){
        int temp = inputArray.get(destIndex);
        inputArray.set(destIndex, inputArray.get(sourceIndex));
        inputArray.set(sourceIndex, temp);
    }
```


### Merge Sort Objective 1
MergeSorts.java
- Analysis:
    - Average Speed (in seconds):
        - ~0.000 ( on personal computer)
  - Big O Complexity(fastest with the most data compared with other sorts - therefore best sort)
      - O(n*log(n))

```java
    public void sortGivenArray(){
        divide(0, this.inputArray.size()-1);
        }

    public void divide(int startIndex,int endIndex){

        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
        int mid = (endIndex + startIndex)/2;
        divide(startIndex, mid);
        divide(mid+1, endIndex);

        //merging Sorted array produce above into one sorted array
        merger(startIndex,mid,endIndex);
        }
        }

    public void merger(int startIndex,int midIndex,int endIndex){

        //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
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
    }
```



## Week 2 - [Ticket](https://github.com/Chris-Ru/Chris-Ru.github.io/issues/3)

### (TPT) Study Group Challenge 2

Assignment:
1. Build a calculator to process expressions and ultimately change RPN to a calculation.
    1. Build in Power of operator ^: 2 ^ 1 = 2, 2 ^ 2 = 4, 2 ^ 3 = 8
    2. Extra credit. Build variable assignment and evaluation into your expressions (a = 2; a + 1).
    3. Extra credit. Investigate Wikipedia article and pseudo code and try adding a SQRT(). Try building Pythagoras expression.

### [Tri 3: Tech Talk 2: Calculator](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-2:-Calculator)

Math Symbols:
* PEMDAS, each operator has its own precedence (priority)
    * Add exponent ^ operator with priority 3

```Java
// Helper definition for supported operators
    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence> 
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
    }
```

Math Original Expression (String):
```Java
2 + 2
4 * 6 + 3
5 + 1 * 8
(7 + 5) * 9
```

Tokenization (Array):
```Java
[2, +, 2]
[4, *, 6, +, 3]
[5, +, 1, *, 8]
[(, 7, +, 5, ), *, 9]
```

Reverse Polish Notation (Array, works well with Stack):
```Java
[2, 2, +]
[4, 6, *, 3, +]
[5, 1, 8, *, +]
[7, 5, +, 9, *]
```

[Youtube Video](https://www.youtube.com/watch?v=Wz85Hiwi5MY)
* Sorting the values within the Reverse Polish Notation arrayList
    * Is it an operator (+ - * / %)?
        * Is the existing operator of greater precedence?
            * Push to Stack
        * Else
            * Pop out operator underneath
            * Push to Stack
            * Push the popped operator back to Stack
    * Is it a seperator (" ")?
        * Skip it
    * Is it a number (1 2 3 4 5)?
        * Put it in a Queue

Result (Double):
```Java
4.0
27.0
13.0
108.0
```


### Challenge #1 + #2 + #4: RPN To Result, Power, Square Root
Calculator.java
```Java
public class Calculator {

    ...

    // Helper definition for supported operators
    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence>
        OPERATORS.put("∜", 2);
        OPERATORS.put("∛", 2);
        OPERATORS.put("√", 2);
        OPERATORS.put("^", 2);
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
    }
    
    ...
    
    // Takes RPN and produces a final result
    private void rpnToResult()
    {
        // stack is used to hold calculation while using RPN rules for calculation
        Stack stack = new Stack();

        // reverse_polish is processed and ultimately used to produce final result
        for (String token : this.reverse_polish)
        {
            // If the token is a number push it onto the stack
            if (!isOperator(token))
            {
                stack.push(token);
            }
            else
            {
                // Pop the two top entries
                Double operand1 = Double.valueOf( (String)stack.pop() );
                Double operand0 = Double.valueOf( (String)stack.pop() );

                // Calculate intermediate results
                Double result;
                switch (token) {    // token is the operator
                    case "+":
                        result = operand0 + operand1;
                        break;
                    case "-":
                        result = operand0 - operand1;
                        break;
                    case "*":
                        result = operand0 * operand1;
                        break;
                    case "/":
                        result = operand0 / operand1;
                        break;
                    case "%":
                        result = operand0 % operand1;
                        break;
                    case "^":
                        result = Math.pow(operand0, operand1);
                        break;
                    
                    default:    //  replace this code with errors
                        result = 0.0;
                }

                // Push intermediate result back onto the stack
                stack.push( String.valueOf( result ));
            }
        }
        // Pop final result and set as final result for expression
        this.result = Double.valueOf((String)stack.pop());
    }
    
    ...
}
```

Called Variables initialized at beginning of file
```Java
    private static int a = 64;
    private static int b = 256;
    private static int c = 729;
    private static int d = 6561;
    private static int e = 8281;
    private static int p = 1;
    private static int q = 2;
    private static int r = 3;
    private static int s = 4;
    private static int t = 5;
    private static int u = 8;
    private static int v = 100;
    private static int w = 200;
    private static int x = 300;
    private static double y = 100.2;
    private static double z = 99.3;
```

CalculatorTester.java
```Java
        // GIVEN
        Calculator simpleMath = new Calculator(v + " + " + w + " * " + r);
        System.out.println("Simple Math\n" + simpleMath + "\n");

        Calculator parenthesisMath = new Calculator("(" + v + " + " + w + ")" + " * " + r);
        System.out.println("Parenthesis Math\n" + parenthesisMath + "\n");


        Calculator fractionMath = new Calculator(y + " - " +  z);
        System.out.println("Fraction Math\n" + fractionMath + "\n");


        Calculator moduloMath = new Calculator(x + " % " + w);
        System.out.println("Modulo Math\n" + moduloMath + "\n");


        Calculator divisionMath = new Calculator(x + " / " + w);
        System.out.println("Division Math\n" + divisionMath + "\n");


        Calculator multiplicationMath = new Calculator(x + " * " + w);
        System.out.println("Multiplication Math\n" + multiplicationMath + "\n");


        Calculator allMath = new Calculator(w + " % " + x + " + " + t + " + " + x + " / " + w + " + " + p + " * " + v);
        System.out.println("All Math\n" + allMath + "\n");

        
        Calculator allMath2 = new Calculator(w + " % " + "(" + x + " + " + t + " + " + x + ") " + "/ " + w + " + " + p + " * " + v);
        System.out.println("All Math2\n" + allMath2 + "\n");


        Calculator allMath3 = new Calculator(w + " % " + "(" + x + " + " + t + " + " + x + ")" + " / " + w + " + " + p + " * " + v);
        System.out.println("All Math3\n" + allMath3 + "\n" + "\n" + "\n");


        // EXPONENTIALS

        Calculator exp1Math = new Calculator(q + " ^ " +  p);
        System.out.println("Exponential Math\n" + exp1Math + "\n");
        

        Calculator exp2Math = new Calculator(q + " ^ " +  q);
        System.out.println("Exponential Math\n" + exp2Math + "\n");
        

        Calculator exp3Math = new Calculator(q + " ^ " +  r);
        System.out.println("Exponential Math\n" + exp3Math + "\n");
        

        Calculator exp4Math = new Calculator(u + " ^ " +  s);
        System.out.println("Exponential Math\n" + exp4Math + "\n" + "\n" + "\n");
```

\
\

## Week 1 - [Ticket](https://github.com/Chris-Ru/Chris-Ru.github.io/issues/2)

### (TPT) Study Group Challenge 1

Challenges:
    0. Sub-menu separates assignments into weeks.
    1. Add and delete elements in a queue.
    2. Merge 2 queues into an ordered fashion.
    3. Reverse a queue using a stack.

### [Tri 3: Tech Talk 1: Linked Lists Part 2](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-1:-Linked-Lists-Part-2)

Linked List - Connects Objects to each other

```Java
import java.util.LinkedList;

LinkedList<String> myLinkedList = new LinkedList<String>();
myLinkedList.add("Above");
myLinkedList.add("Blob");
System.out.println(myLinkedList);
```



Generic T - Putting a Class inside an Array? {}

Iterable Interface - For each loop through... a Linked List?

Queue - Built on top of a List (FIRST IN FIRST OUT)
* (processes this one ->) above -> blob -> cup -> drip -> john -> leek -> nay -> ro -> wee -> null (<- add stuff here)
  * To add elements, add to head (queuing)
  * To delete elements, remove from tail (dequeue)

Stack - Also built on top of a List (LAST IN FIRST OUT)
* above (<- processes this one, new elements are also added here, like a stack of plates)
  * blob
  * cup
  * drip
  * john
  * leek
  * nay
  * ro
  * wee

Challenge 2 Hint: dequeue and requeue

nil - null


implements vs. extends
* 'implements' has no definition? usually from interface
  * extends

Generic T - You can put whatever data type you wish into the LinkedList. Once a data type is put in, the entire LinkedList becomes (uses) that data type.
```Java
public class Queue<T> implements Iterable<T> {
    LinkedList<T> head, tail;
    // Rest of implementation not shown...
}
```

Double sided Linked List
* Previous Node
  * and Next Node
  * null <- above <-> blob <-> cup -> null






## Week 0 - [Ticket](https://github.com/Chris-Ru/Chris-Ru.github.io/issues/1)

### (TPT) Study Group Challenges

Assignment:
- Java Menu that is not hard coded (Use object array?)
- Number Swap option that sorts two numbers from least to greatest
- Matrix Format option that prints a numpad

Final Result:
* Link to code + runtime: [CS-AP-2 Java Replit](https://replit.com/@ChristopherRub3/T3-Individual-with-Menu)
* Ticket: [Ticket](https://github.com/Chris-Ru/Chris-Ru.github.io/issues/1)

### [Tri 3: Tech Talk 0 Data Structures](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-0---Data-Structures)

- Imperative Paradigm: Procedural Programming like Python
- Object-Oriented Programming: Java, uses Objects and Classes, Inheritance, Abstraction, and Polymorphism
- Big Tech Companies Stock: Google, Microsoft, Apple, Amazon
- Assignment: Make a menu based off of a data structure, Challenge 1 and Challenge 2 and Matrix

### Challenge: Menu


Menu.java
```java
package src.week0;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu0 {
    Map<Integer, MenuRow> menu = new HashMap<>();

    public Menu0(MenuRow[] rows) {
        int i = 0;
        for (MenuRow row : rows) {
            menu.put(i++, new MenuRow(row.getTitle(), row.getAction()));
        }
    }
  
    public MenuRow get(int i) {
        return menu.get(i);
    }

    public void print() {
        for (Map.Entry<Integer, MenuRow> pair : menu.entrySet()) {
            System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
        }
    }

    public static void main(String[] args) {
        Driver.main(args);
    }

}

class MenuRow {
    String title;
    Runnable action;

    public MenuRow(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return this.title;
    }
    public Runnable getAction() {
        return this.action;
    }

    public void run() {
        action.run();
    }
}

class Driver {
    public static void main(String[] args) {
        MenuRow[] rows = new MenuRow[]{
                new MenuRow("Exit", () -> main(null)),
                new MenuRow("Swap", () -> Swapper.main(null)),
                new MenuRow("Matrix", () -> Matrix.main(null)),
        };

        Menu0 menu = new Menu0(rows);

        while (true) {
            System.out.println("Week 0 Menu:");
            menu.print();

            try {
                Scanner sc = new Scanner(System.in);
              
                int selection = sc.nextInt();

                try {
                    MenuRow row = menu.get(selection);
                    if (row.getTitle().equals("Exit"))
                        return;
                    row.run();
                } catch (Exception e) {
                    System.out.printf("\nInvalid selection: %d \n\n", selection);
                }
            } catch (Exception e) {
                System.out.println("\nInput is not a number\n");
            }
        }
    }
}


```

### Challenge: Numpad Swapper
Swapper.java
```java
package src.week0;

public class Swapper {
    private int value;

    public Swapper(Integer value) {
        this.value = value;
    }

    public String toString() {
        return (String.format("%d", this.value));
    }

    public void swapToLowHighOrder(Swapper i) {
        if (this.value > i.value) {
            int tmp = this.value;
            this.value = i.value;
            i.value = tmp;
        }
    }

    public static void swapper(int n0, int n1) {
        Swapper a = new Swapper(n0);
        Swapper b = new Swapper(n1);
        System.out.println("Before: " + a + " " + b);
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a + " " + b);
        System.out.println();
    }

    public static void main(String[] ags) {
        Swapper.swapper(21, 16);
        Swapper.swapper(16, 21);
        Swapper.swapper(16, -1);
    }

}

```

### Challenge: Matrix
Matrix.java
```java
package src.week0;

// matrix class is used to store and format the output of a matrix
public class Matrix {
    private final int[][] matrix;

    // store matrix
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    // nest for loops to format output of a matrix
    public String toString() {
        // construct output of matrix using for loops
        // outer loop for row
        StringBuilder output = new StringBuilder();
        for (int[] row : matrix) {
            // inner loop for column
            for (int cell : row) {
                output.append((cell==-1) ? " " : String.format("%x",cell)).append(" ");
            }
            output.append("\n"); // new line
        }
        return output.toString();
    }

    // print it backwards matrix
    public String reverse() {
        // outer loop starting at end row
        StringBuilder output = new StringBuilder();
        for (int i = matrix.length;  0 < i; i--) {
            // inner loop for column
            for (int j =  matrix[i-1].length; 0 < j; j--) {
                output.append((matrix[i-1][j-1]==-1) ? " " : String.format("%x",matrix[i-1][j-1])).append(" ");
            }
            output.append("\n"); // new line
        }
        return output.toString();
    }

    // declare and initialize a matrix for a keypad
    static int[][] keypad() {
        return new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {-1, 0, -1} };
    }

    // declare and initialize a random length arrays
    static int[][] numbers() {
        return new int[][]{ { 0, 1 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
    }

    // tester method for matrix formatting
    public static void main(String[] args) {
        Matrix m0 = new Matrix(keypad());
        System.out.println("Keypad:");
        System.out.println(m0);
        System.out.println(m0.reverse());


        Matrix m1 = new Matrix(numbers());
        System.out.println("Numbers Systems:");
        System.out.println(m1);
        System.out.println(m1.reverse());

    }

}
```