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

