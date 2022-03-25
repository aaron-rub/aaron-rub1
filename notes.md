{% include navigation.html %}

# CSA

<Details>
<summary>Week 1</summary>

<h1> Week 1 - [Ticket](https://github.com/Chris-Ru/Chris-Ru.github.io/issues/2) </h1>

<h3> (TPT) Study Group Challenge 1 </h3>

Challenges:
    0. Sub-menu separates assignments into weeks.
    1. Add and delete elements in a queue.
    2. Merge 2 queues into an ordered fashion.
    3. Reverse a queue using a stack.

<h3> [Tri 3: Tech Talk 1: Linked Lists Part 2](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-1:-Linked-Lists-Part-2) </h3>

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


</Details>









<Details>
<summary>Week 2</summary>

<h2> Week 2 - [Ticket](https://github.com/Chris-Ru/Chris-Ru.github.io/issues/3) </h2>

<h3> (TPT) Study Group Challenge 2 </h3>

Assignment:
1. Build a calculator to process expressions and ultimately change RPN to a calculation.
   1. Build in Power of operator ^: 2 ^ 1 = 2, 2 ^ 2 = 4, 2 ^ 3 = 8
   2. Extra credit. Build variable assignment and evaluation into your expressions (a = 2; a + 1).
   3. Extra credit. Investigate Wikipedia article and pseudo code and try adding a SQRT(). Try building Pythagoras expression.

<h3> [Tri 3: Tech Talk 2: Calculator](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-2:-Calculator) </h3>

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


<h3> Challenge #1 + #2 + #4: RPN To Result, Power, Square Root </h3>
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

</Details>