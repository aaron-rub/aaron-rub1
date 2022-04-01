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
