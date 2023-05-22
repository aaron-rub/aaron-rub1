# Purpose of our project for visitors

### Casting, specifically for Division
If an integer is divided and the end result is a float or double, the decimal value will be truncated (rounded down, but not technically).
```
int a = 5;
int b = 2;
System.out.println(a/b);
// Prints 2

System.out.println( (double)a/b );
// Prints 2.5

double c = 2.0;
System.out.println(a/c);
// Prints 2.5
```

### Casting, specifically for Truncating or Rounding
By default without casting, the value is truncated. You'll need to use the Math.round() function in order to round an integer value.
```
double a = 2.7;

System.out.println(a);
// Prints 2.7

System.out.println( (int)a );
// Prints 2

System.out.println( Math.round(a) );
// Prints 3
```

### Wrapper Classes, why wrap int, double
Wrapper Classes is the reference type version of the primitive type. So int's wrapper class is Integer, and double's wrapper class is Double.
```
String one = "1";
System.out.println(one + 2);
// Prints 12, this value gets concat'd instead of added.

int one = Integer.parseInt("1");
System.out.println(one + 2);
// Prints 3
```

### Concatenation, rules on mixed type Concatenation
```
String a = "con";
c = a.concat("cat");
System.out.println(c);
// Prints "concat", uncommonly used.

String a = "con";
String c = "cat";
System.out.println(a + c);
// Prints "concat"
```
Either code segments will print out "concat" because "con" and "cat" were concatenated together.

### Math class, specifically Random usage
Math.random() chooses a random value between 0 and 1 (including decimals!). So, truncating it by casting it to an int will always give the value 0. If we multiply the truncated statement, it'll give us a random value between 0 and whatever value we multiplied it by. So in the end, (int)Math.random() * 8 will choose a random value between 0 and 8.
```
// If we wish to print out a random value between 8 and 12:
Math.random()
// will print out a double between 0 and 0.999999
(int) Math.random()
// will print out an int between 0 and 0 (truncated from 1).
(int) Math.random() * 5
// will print out an int between 0 and 4 (truncated from 5).
(int) Math.random() * 5 + 8
// will print out an int between 8 and 12 (truncated from 13).
```

### Compound Boolean Expression
```
if ((myFaceLooksGood == true) && (myIQ >= 100)) {
    System.out.println("Bill Gates");
}
```
The && is an AND operator, and the if statement will only execute if both conditions are true. There is also an || OR operator.

### Truth Tables
![](https://www.researchgate.net/profile/Sarah-N-Chowdhury/publication/299612565/figure/tbl1/AS:668948068593682@1536501056879/Basic-Quaternary-Multi-Input-Operators-Truth-Table.png)

### De Morgan's Law

        if (oversixfoot && looksfit){
            System.out.println("You are like Allen (100% chance)");
        }
        else if (!(oversixfoot || !looksfit)){
            System.out.println("You are Charlie (0% chance)");
        }
        else if (oversixfoot || looksfit){
            System.out.println("You have a 50% chance");
        }

### Comparing Numbers
==
```
if (4 == 4) {
  System.out.println("4 is indeed 4.");
}
```

### Comparing Strings
.toString() or .compare()
```
int a = 4;
a.toString();
System.out.println(a + 5);
// Prints out 45
```

### Comparing Objects
.equals()
It also applies to other reference types like String.
```
if ("4".equals("4")) {
  System.out.println("'4' is indeed '4'.");
}
```

### for loop, enhanced for loop
```
    int index=0;
    for (String word : words) {

      // checks to see if suffix of word contains "ing"
        if (word.endsWith("ing")){
          // if word contains "ing" then prints that word
          System.out.println(String.valueOf(index++)+": "+word);
        }
    }
```

### while loop versus do while loop
A while loop runs something as long as its condition is true, and doesn't run once the condition becomes false. A do while loop runs its code first, then checks the condition to see if it should run again. Basically, while loop runs if condition is true - do while loop runs once first, then keeps running if condition is true.
```
        while (i < j) {

            // If there is a mismatch
            if (word.charAt(i) != word.charAt(j))
                super.setData("False");
            else super.setData("True");

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }
```

### Big O notation (Hash map, Binary Search, Single loop, Nested Loop)
* 1 is extremely good. No matter how much data there is, the runtime never increases. A HashMap has efficiency O(1) upon a successful run.
* sqrt(n) is very good. Runtime increases at the start, but more data doesn't affect the runtime that much (only increases a little). A Binary Search has efficiency sqrt(n).
* n is linear. The amount of data processed corresponds to runtime. It's like a single loop.
* n^2 is exponential. The amount of data causes the runtime to increase exponentially. It's like a nested loop.
* 2n^2 is complete garbage. Sometimes it's the only way though...

### Creating a Class, describe Naming Conventions
- Lowercase is where all the letters in a word are written without any capitalization (e.g., while, if, mypackage).
- Uppercase is where all the letters in a word are written in capitals. When there are more than two words in the name use underscores to separate them (e.g., MAX_HOURS, FIRST_DAY_OF_WEEK).
- CamelCase (also known as Upper CamelCase) is where each new word begins with a capital letter (e.g., CamelCase, CustomerAccount, PlayingCard).
- Mixed case (also known as Lower CamelCase) is the same as CamelCase except the first letter of the name is in lowercase (e.g., hasChildren, customerFirstName, customerLastName).
```
public class NameOfClass {
    // variables and functions go here.
}
```

### Constructor, describe why there is no return
```
public void NameOfClass(a, b) {
    this.a = a
    this.b = b
}
```
There is no return because the constructor is used to initialize the objects, providing the necessary variable values from outside the class.

### Accessor methods, relationship to getter
Accessor methods are getters, allowing an outside class to receive/read the value of a variable within the class. Since we intend to send data to a different class, the accessor method should have a return type of whatever data type we are returning, for example String, int, boolean, etc.
```
private String arch = "huang";

public String getArch() {
  return arch;
}
```

### Mutator methods, relationship to setter, describe void return type
Mutator methods are setters, receiving an argument from an outside class and sets one of its own variables to the parameter received. Since the outside class isn't intended to receive any data back, the method should be of the void return type.
```
private String arch = "huang";

public void setArch(String input) {
  arch = input;
}
```

### Static variables, Class variables
Static variables is a synonym with Class variable. They are the same as any other variable, except for the fact that Objects that use the variable don't get their own separate copy. In other words, static variables only have one instance of themselves, changing it using one object and then changing it with another will modify the only existing one. This is best shown in the PasswordGenerator.java FRQ.
```
class Arch {
  private static String arch = "huang";

  public void setArch(String input) {
    arch = input;
  }

  public String getArch() {
    return arch;
  }
}

class Main {
  private static void main(String args[]) {
    Arch objectOne = new Arch();
    Arch objectTwo = new Arch();
    objectOne.setArch("e");
    objectTwo.setArch("h");
    System.out.println(objectOne.getArch);
    // Also Prints "h" even though objectOne setArch to be "e" earlier. It would print "e" if the variable wasn't static.
    System.out.println(objectTwo.getArch);
    // Prints "h"
  }
}
```

### Static methods, Class methods
Static methods is a synonym with Class methods. They can't be called by Objects, instead requiring the class to call them. An example would be:
```
MainClass.staticMethod();
```
instead of what you'd normally do, which is:
```
NotMainClass myObj = new NotMainClass();
myObj.regularMethod();
```

### this Keyword
The "this" keyword can be put at the front of the variable to signify that it is not a local variable, but a variable that already belongs to the class. This can allow for an easier to read constructor, setting the parameters received to the "this" class variable. So instead of:
```
int x;
public Main(int y) {
    x = y;
}
```
we can use:
```
int x; // this variable is referred to as "this.x" in the constructor
public Main(int x) {
    this.x = x;
}
```

### main method, tester methods
The main method is where code starts running.
```
public static void main(String[] args) {
    // code goes here :)
}
```
The tester method is used to test the class individually, purpose being to test the individual classes for functionality or errors. It normally works by creating an object and then using the object to call the methods inside of the Class. I believe it also uses the syntax of a normal main class?

### Inheritance, extends
Class inheritance is used when desiring to use code from a different class.
```
class Cat extends Animal {

}
```

### Subclass constructor, super Keyword
This keyword is often used to... not be confused by methods of the same name. Let's suppose you've got a Class called uh... cat. And it inherits things from a parent class called Animal. If they both have a method with the name of makeNoise(), and for some reason you wanted to use the Animal class' makeNoise() function, you'd use the super keyword.
```
public class Book {
  private String title;
  private String author;

  public Book(String t, String a) {
    title = t;
    author = a;
  }

  public void printBookInfo() {
    System.out.println(title + ", written by " + author);
  }
}
```
```
public class PictureBook extends Book {
  private String illustrator;

  public PictureBook(String t, String a, String illustrator) {
    title = t;
    author = a;
    this.illustrator = illustrator;
  }

  public void super printBookInfo() {
    System.out.println(title + ", written by " + author + " and illustrated by " + illustrator);
  }
}
```

### Overloading a method, same name different parameters
Two methods with the same name but different parameters. You'll call whichever method matches the arguments you've provided. Example:
```
public void overMethod(a, b) {
    c = a + b
    System.out.println(c)
}
public void overMethod(a) {
    c = a
    System.out.println(c)
}
```
Providing two parameters will call the first function while only providing one parameter will call the second function.

### Overriding a method, same signature of a method
Going back to the Cat/Animal class methods, if Animal has a method called makeNoise() and we don't want to use that function, we can create our own makeNoise() method in the Cat class in order to use that one instead.

Overrides the parent class of _Pal and uses the method listed to return the whether a word is a palindrome with boolean outputs(true or false)
```
public class Pal_String_Reverse extends _Pal {
    public Pal_String_Reverse(String word) {
        super(word);
    }

    @Override
    protected void init() {
        super.name = "String Reverse Loop";
        // creates empty builder, capacity 16
        StringBuilder sb = new StringBuilder(word);
        // reverse it
        sb.reverse();
        // return string representation of the word
        String rev = sb.toString();

        // if the word is a palindrome then return true, otherwise don't
        if (word.equals(rev)) {
            super.setData("True");
        }
        else {
            super.setData("False");
        }
    }
```


### Abstract Class, Abstract Method
Abstract Class, a class that can't be called to run on its own. It is instead used as kind of a blueprint for other classes, with classes inheriting from it if they wish to use it as a template.
```
public abstract class _Pal {
    String word;
    private String TOrF;
    String name;
    ArrayList<String> list;

    public _Pal(String word) {
        this.word = word;
        this.list = new ArrayList<>();
    }

    public _Pal() {
        this("level");
    }


    protected abstract void init();


    public void setData(String results) {
        list.add(results);
        TOrF = results;
    }

    public static void main(String[] args) {
        PalFor.main(null);
        PalRecurse.main(null);
        PalWhile.main(null);
        Pal_String_Reverse.main(null);
    }
}
```

### Object superclass methods: toString(), compare(), clone()
These are methods that exist in the default Java Library that can be used to modify reference types instead of the default ==, =, +=, <= signs that are used to modify primitive types.
```
int a = 4;
a.toString();
System.out.println(a + 5);
// Prints out 45
```

### Late binding of object, referencing superclass object, ie Animal a = new Chicken(); Animal b = new Goat();
Apparently late binding is when the compiler doesn't have access to a superclass object, and thus can't compile it before running the code. Therefore, when the code needs to run, it gets "late binded" by the superclass object? Yeah not too sure on this one...
```
Animal a = new Chicken();
Animal b = new Goat();
```

### Polymorphism: any of overloading, overriding, late binding
Polymorphism - Using overloading and overriding through the inheritance of classes.
![picture](https://techvidvan.com/tutorials/wp-content/uploads/sites/2/2020/02/example-of-polymorphism-in-java.jpg)

### Web API, REST, FETCH, Async, Request, Response
* Web API - Application Programming Interface, a framework or concept that provides REST functionalities across the web, supported by many programming languages.
* REST - Representational state transfer, the transferal of data across HTTP using a client/server model.
* FETCH - Getting data from somewhere.
* Async - Retrieving data without requiring a website refresh or reload.
* Request - Asking for data.
* Response - The data received after a request.

### CRUD
Create, Read, Update, and Delete. A database should use all of these to be considered... well, a database.
