package src.week0;
// no imports

// creating a public class called swapper
public class Swapper {
    // creating an int value
    private int value;
// this is the constructor that initializes the variable named value
    public Swapper(Integer value) {
        this.value = value;
    }

    // this is switching a variable into a string using format (custom formating)
    public String toString() {
        return (String.format("%d", this.value));
    }

    // if statement that checks 2 values to find the lower one and put it on the left side
    public void swapToLowHighOrder(Swapper i) {
        if (this.value > i.value) {
            int tmp = this.value;
            this.value = i.value;
            i.value = tmp;
        }
    }

  // public static void is the tester function 
    public static void swapper(int n0, int n1) {
        Swapper a = new Swapper(n0);
        Swapper b = new Swapper(n1);
        System.out.println("Before: " + a + " " + b);
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        // this is what is printed when you activate the menu
        System.out.println("After: " + a + " " + b);
        System.out.println();
    }
// this is also a tester function
    public static void main(String[] ags) {
        Swapper.swapper(21, 16);
        Swapper.swapper(16, 21);
        Swapper.swapper(16, -1);
    }

}
