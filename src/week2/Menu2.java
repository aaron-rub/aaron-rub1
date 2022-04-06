package src.week2;

// these are the imports used to make the hashmap and user input work
import java.util.HashMap;
import java.util.Map;
// import that allows for user input
import java.util.Scanner;

public class Menu2 {
    // this is creating the hashmap variable
    Map<Integer, MenuRow> menu = new HashMap<>();

    // this is the constructor that allows that allows the class to be created and function properly
    public Menu2(MenuRow[] rows) {
        // variable i is being set to 0 and specified as an integer 
        int i = 0;
        // this is a for loop that iterates over rows variable initialized by the contsructor
        for (MenuRow row : rows) {
            menu.put(i++, new MenuRow(row.getTitle(), row.getAction()));
        }
    }
  
    // using (get) to create a getter for the i
    public MenuRow get(int i) {
        return menu.get(i);
    }
       // this prints all the Menu Rows that was initialized by the constructor
    public void print() {
        for (Map.Entry<Integer, MenuRow> pair : menu.entrySet()) {
            System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
        }
    }
// runs the program
    public static void main(String[] args) {
        Driver.main(args);
    }

}


// creating a class called MenuRow

class MenuRow {
    String title;
    Runnable action;

    // this is the constuctor that initialises the variables title and action
    public MenuRow(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }
// this is a getter returning the variable initialized in the constructor
    public String getTitle() {
        return this.title;
    }
    
    // this is a getter returning the variable initialized in the constructor
    public Runnable getAction() {
        return this.action;
    }
// this allows the program to run
    public void run() {
        action.run();
    }
}

// class called driver
class Driver {
    // this is what runs the menu
    public static void main(String[] args) {
        // this is creating an array called rows
        // this array contains all the weekly assignments / challenges
        MenuRow[] rows = new MenuRow[]{
                new MenuRow("Exit", () -> main(null)),
                new MenuRow("Calculator", () -> Calculator.main(null)),
                new MenuRow("Stack Driver", () -> StackDriver.main(null)),
                new MenuRow("Input Calculator", () -> Calc.main(null)),
        };

        Menu2 menu = new Menu2(rows);
// while loop that holds the week 2 menu and contains the try catch function to test for errors in the code and user input
        while (true) {
            // infinite while loop until break is called
            System.out.println("Week 2 Menu:");
            menu.print();
            // this is testing the inputed rows variable for user input
            try {
                Scanner sc = new Scanner(System.in);
              
                int selection = sc.nextInt();
                System.out.println("");

                
                // this allows break to be called from the menu
                try {
                    MenuRow row = menu.get(selection);
                    if (row.getTitle().equals("Exit"))
                        return;
                    row.run();
                    // this catches the errors and prevents the program from stopping unintentionally 
                } catch (Exception e) {
                    System.out.printf("\nInvalid selection: %d \n\n", selection);
                }
            } catch (Exception e) {
                System.out.println("\nInput is not a number\n");
            }
        }
    }
}

