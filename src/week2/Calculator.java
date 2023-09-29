package src.week2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import src.week2.Stack;

public class Calculator {
    // Key instance variables
    private final String expression;
    private ArrayList<String> tokens;
    private ArrayList<String> reverse_polish;
    private Double result = 0.0;
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

    // Helper definition for supported operators
    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence>
        OPERATORS.put("^", 3);
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
    }

    // Helper definition for supported operators
    private final Map<String, Integer> SEPARATORS = new HashMap<>();
    {
        // Map<"separator", not_used>
        SEPARATORS.put(" ", 0);
        SEPARATORS.put("(", 0);
        SEPARATORS.put(")", 0);
    }

    // Create a 1 argument constructor expecting a mathematical expression
    public Calculator(String expression) {
        // original input
        this.expression = expression;

        // parse expression into terms
        this.termTokenizer();

        // place terms into reverse polish notation
        this.tokensToReversePolishNotation();

        // calculate reverse polish notation
        this.rpnToResult();
    }

    // Test if token is an operator
    private boolean isOperator(String token) {
        // find the token in the hash map
        return OPERATORS.containsKey(token);
    }

    // Test if token is an seperator
    private boolean isSeperator(String token) {
        // find the token in the hash map
        return SEPARATORS.containsKey(token);
    }

    // Compare precedence of operators.
    private Boolean isPrecedent(String token1, String token2) {
        // token 1 is precedent if it is greater than token 2
        return (OPERATORS.get(token1) - OPERATORS.get(token2) >= 0) ;
    }

    // Term Tokenizer takes original expression and converts it to ArrayList of tokens
    private void termTokenizer() {
        // contains final list of tokens
        this.tokens = new ArrayList<>();

        int start = 0;  // term split starting index
        StringBuilder multiCharTerm = new StringBuilder();    // term holder
        for (int i = 0; i < this.expression.length(); i++) {
            Character c = this.expression.charAt(i);
            if ( isOperator(c.toString() ) || isSeperator(c.toString())  ) {
                // 1st check for working term and add if it exists
                if (multiCharTerm.length() > 0) {
                    tokens.add(this.expression.substring(start, i));
                }
                // Add operator or parenthesis term to list
                if (c != ' ') {
                    tokens.add(c.toString());
                }
                // Get ready for next term
                start = i + 1;
                multiCharTerm = new StringBuilder();
            } else {
                // multi character terms: numbers, functions, perhaps non-supported elements
                // Add next character to working term
                multiCharTerm.append(c);
            }

        }
        // Add last term
        if (multiCharTerm.length() > 0) {
            tokens.add(this.expression.substring(start));
        }
    }

    // Takes tokens and converts to Reverse Polish Notation (RPN), this is one where the operator follows its operands.
    private void tokensToReversePolishNotation () {
        // contains final list of tokens in RPN
        this.reverse_polish = new ArrayList<>();

        // stack is used to reorder for appropriate grouping and precedence
        Stack tokenStack = new Stack();
        for (String token : tokens) {
            switch (token) {
                // If left bracket push token on to stack
                case "(":
                    tokenStack.push(token);
                    break;
                case ")":
                    while (tokenStack.peek() != null && !tokenStack.peek().equals("("))
                    {
                        reverse_polish.add((String)tokenStack.pop() );
                    }
                    tokenStack.pop();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                case "^":
                    // While stack
                    // not empty AND stack top element
                    // and is an operator
                    while (tokenStack.peek() != null && isOperator((String) tokenStack.peek()))
                    {
                        if ( isPrecedent(token, (String) tokenStack.peek() )) {
                            reverse_polish.add((String)tokenStack.pop());
                            continue;
                        }
                        break;
                    }
                    // Push the new operator on the stack
                    tokenStack.push(token);
                    break;
                default:    // Default should be a number, there could be test here
                    this.reverse_polish.add(token);
            }
        }
        // Empty remaining tokens
        while (tokenStack.peek() != null) {
            reverse_polish.add((String)tokenStack.pop());
        }

    }

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
  
    // Print the expression, terms, and result
    public String toString() {
        return ("Original expression: " + this.expression + "\n" +
                "Tokenized expression: " + this.tokens.toString() + "\n" +
                "Reverse Polish Notation: " +this.reverse_polish.toString() + "\n" +
                "Final result: " + String.format("%.2f", this.result));
    }

    // Tester method
    public static void main(String[] args) {
        // Random set of test cases
      
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
        
        // PYTHAGORAS EXPRESSION
      
        Calculator pythag1Math = new Calculator("(" + r + " ^ " + q + ")" + " + " + "(" + s + " ^ " + q + ")");
        System.out.println("Pythagoras Expression 1\n" + pythag1Math + "\n");


        Calculator pythag2Math = new Calculator("(" + u + " ^ " + q + ")" + " + " + "(" + t + " ^ " + q + ")");
        System.out.println("Pythagoras Expression 2\n" + pythag2Math + "\n" + "\n" + "\n");

        // SQUARE ROOT
      
        roots sqrt1Math = new roots("√"+ a);
        System.out.println("Square Root Math 1\n" + sqrt1Math + "\n");


        roots sqrt2Math = new roots("√" + e);
        System.out.println("Square Root Math 2\n" + sqrt2Math + "\n" + "\n" + "\n");

        // CUBE ROOT

        roots cbrt1Math = new roots("∛" + a);
        System.out.println("Cube Root Math 1\n" + cbrt1Math + "\n");


        roots cbrt2Math = new roots("∛" + c);
        System.out.println("Cube Root Math 2\n" + cbrt2Math + "\n" + "\n" + "\n");

        // FOURTH ROOT
      
        roots tessrt1Math = new roots("∜" + b);
        System.out.println("Fourth Root Math 1\n" + tessrt1Math + "\n");

      
        roots tessrt2Math = new roots("∜" + d);
        System.out.println("Fourth Root Math 1\n" + tessrt2Math + "\n");

    }
}