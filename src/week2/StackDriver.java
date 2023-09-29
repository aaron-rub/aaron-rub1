package src.week2;

import src.week1.ConsoleMethods;
import src.week2.StackDriver;

public class StackDriver {

    private Stack stack;
    private String dataType="";
    private int count;

    public StackDriver()
    {
        count = 0;
        stack = new Stack();
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void pushStack(Object[] objects)
    {
        ConsoleMethods.println("Add " + dataType);
        for (Object o : objects)
        {
            stack.push(o);
            ConsoleMethods.println("Push: " + stack.peek() + " " + stack);
            this.count++;
        }
        ConsoleMethods.println();

    }

    public void showStack()
    {
        ConsoleMethods.println("Size: " + count);
        ConsoleMethods.println("Top Element: " + stack.peek());
        ConsoleMethods.println("Full Stack: " + stack);
        ConsoleMethods.println();
    }

    public void popStack()
    {
        ConsoleMethods.println("Delete " + dataType);
        for (int x = 0; x<count; x++)
        {
            ConsoleMethods.println("Pop: " + stack.pop() + " " + stack);
        }
    }

    /*
     * Illustrate different Objects that can be placed on same Stack
     */
    public static void main(String[] args)
    {
        StackDriver trial = new StackDriver();

        // mixed stack
        trial.setDataType("Alphabet then Cupcakes then Animals");
        trial.showStack();
        trial.popStack();
    }

}