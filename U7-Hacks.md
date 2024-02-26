## FRQ Question 3
(a) Write the SparseArray method getValueAt. The method returns the value of the sparse array element at a given row and column in the sparse array. If the list entries contains an entry with the specified row and column, the value associated with the entry is returned. If there is no entry in entries corresponding to the specified row and column, 0 is returned.

```java
public class SparseArrayEntry{
    private int row;
    private int col;
    private int value;
    public SparseArrayEntry(int r, int c, int v){
        row = r;
        col = c;
        value = v;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public int getValue(){
        return value;
    }
}
public class SparseArray{
    private int numRows;
    private int numCols;
    private List<SparseArrayEntry> entries;
    public SparseArray(){
        entries = new ArrayList<SparseArrayEntry>();
    }
    public int getNumRows(){
        return numRows;
    }
    public int getNumCols(){
        return numCols;
    }
    public void addEntry(SparseArrayEntry entry) {
        entries.add(entry);
        numRows = Math.max(numRows, entry.getRow() + 1);
        numCols = Math.max(numCols, entry.getCol() + 1);
    }
    public int getValueAt(int row, int col){
        for (SparseArrayEntry e : entries){
            if (e.getRow() == row && e.getCol() == col) {
                return e.getValue();
            }
        }
        return 0;
    }
}
public class Test1 {
    public static void main(String[] args) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.addEntry(new SparseArrayEntry(1, 4, 4));
        sparseArray.addEntry(new SparseArrayEntry(2, 0, 1));
        sparseArray.addEntry(new SparseArrayEntry(3, 1, -9));
        sparseArray.addEntry(new SparseArrayEntry(1, 1, 5));
        System.out.println("The value at (1, 4) is " + sparseArray.getValueAt(1, 4));
        System.out.println("The value at (2, 0) is " + sparseArray.getValueAt(2, 0));
        System.out.println("The value at (3, 1) is " + sparseArray.getValueAt(3, 1));
        System.out.println("The value at (1, 1) is " + sparseArray.getValueAt(1, 1));
        System.out.println("Number of Cols: " +sparseArray.getNumCols());
    }
}
Test1.main(null);
```

(b) Write the SparseArray method removeColumn. After removing a specified column from a sparsearray:

All entries in the list entries with column indexes matching col are removed from the list.

All entries in the list entries with column indexes greater than col are replaced by entries with column indexes that are decremented by one (moved one column to the left).

The number of columns in the sparse array is adjusted to reflect the column removed.

```java
public class SparseArrayEntry{
    private int row;
    private int col;
    private int value;
    public SparseArrayEntry(int r, int c, int v){
        row = r;
        col = c;
        value = v;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public int getValue(){
        return value;
    }
}
public class SparseArray{
    private int numRows;
    private int numCols;
    private List<SparseArrayEntry> entries;
    public SparseArray(){
        entries = new ArrayList<SparseArrayEntry>();
    }
    public int getNumRows(){
        return numRows;
    }
    public int getNumCols(){
        return numCols;
    }
    public void addEntry(SparseArrayEntry entry) {
        entries.add(entry);
        numRows = Math.max(numRows, entry.getRow() + 1);
        numCols = Math.max(numCols, entry.getCol() + 1);
    }
    public int getValueAt(int row, int col){
        for (SparseArrayEntry e : entries){
            if (e.getRow() == row && e.getCol() == col) {
                return e.getValue();
            }
        }
        return 0;
    }
    public void removeColumn(int col){
        numCols--;
        for(int i = entries.size()-1;i>=0;i--){
            if(entries.get(i).getCol()==col){
                entries.remove(i);
            }
        }
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getCol()>col) {
                SparseArrayEntry old = entries.get(i);
                SparseArrayEntry newE = new SparseArrayEntry(old.getRow(), (old.getCol() - 1), old.getValue());
                entries.set(i, newE);
            }
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.addEntry(new SparseArrayEntry(1, 4, 4));
        sparseArray.addEntry(new SparseArrayEntry(2, 0, 1));
        sparseArray.addEntry(new SparseArrayEntry(3, 1, -9));
        sparseArray.addEntry(new SparseArrayEntry(1, 1, 5));
        System.out.println("The value at (1, 4) is " + sparseArray.getValueAt(1, 4));
        System.out.println("The value at (2, 0) is " + sparseArray.getValueAt(2, 0));
        System.out.println("The value at (3, 1) is " + sparseArray.getValueAt(3, 1));
        System.out.println("The value at (1, 1) is " + sparseArray.getValueAt(1, 1));
        System.out.println("Number of Cols: " +sparseArray.getNumCols());
        sparseArray.removeColumn(1);
        System.out.println("The value at (1, 4) is " + sparseArray.getValueAt(1, 4));
        System.out.println("The value at (1, 3) is " + sparseArray.getValueAt(1, 3)+" because the columns shifted");
        System.out.println("The value at (2, 0) is " + sparseArray.getValueAt(2, 0));
        System.out.println("The value at (3, 1) is " + sparseArray.getValueAt(3, 1));
        System.out.println("The value at (1, 1) is " + sparseArray.getValueAt(1, 1));
        System.out.println("Number of Cols: " +sparseArray.getNumCols());
    }
}
Test2.main(null);
```

This FRQ was all about playing with ArrayLists and 2D Arrays. It challenged us to tweak and play around with data in an ArrayList, showcasing why ArrayLists are pretty handy due to their flexibility. We had to dig into the list, grab specific values, and even yank some out. It was like being a data magician, making some elements appear and others disappear, all while keeping track of our rows and columns. 