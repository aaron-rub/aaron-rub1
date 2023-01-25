## Weekly TODO list

<!-- .slide -->
```java
import javax.swing.*; // import the swing library for creating the table

public class TableExample {
    public static void main(String[] args) {
        String[] columnNames = {"Assignment", "Topic", "Completed"}; // define the column names for the table
        Object[][] data = { // define the data for the table
            {"", 25, "Male"},
            {"Jane", 30, "Female"},
            {"Bob", 35, "Male"},
            {"Alice", 40, "Female"}
        };
        
        JTable table = new JTable(data, columnNames); // create the table using the data and column names
        JScrollPane scrollPane = new JScrollPane(table); // add a scroll pane to the table
        JFrame frame = new JFrame(); // create a frame to display the table
        frame.add(scrollPane); // add the scroll pane (containing the table) to the frame
        frame.setSize(300, 150); // set the size of the frame
        frame.setVisible(true); // make the frame visible
    }
}
```
