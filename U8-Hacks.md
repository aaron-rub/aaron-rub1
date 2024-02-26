## FRQ Question 4

(a) A number group represents a group of integers defined in some way. It could be empty, or it could contain one or more integers.

Write an interface named NumberGroup that represents a group of integers. The interface should have a single contains method that determines if a given integer is in the group. For example, if group1 is of type NumberGroup, and it contains only the two numbers -5 and 3, then group1.contains(-5) would return true, and group1.contains(2) would return false. Write the complete NumberGroup interface. It must have exactly one method.

```java
public interface NumberGroup{
    public boolean contains(int num);
}
public class Numbers implements NumberGroup{
    private List<Integer> numbers;
    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
    @Override
    public boolean contains(int num){
        return numbers.contains(num);
    }
}
public class Test1{
    public static void main(String[] args) {
        NumberGroup group1 = new Numbers(Arrays.asList(-5,3));
        System.out.println("group1 contains -5: "+group1.contains(-5));
        System.out.println("group1 contains 2: "+group1.contains(2));
    }
}
Test1.main(null);
```

(b) A range represents a number group that contains all (and only) the integers between a minimum value and a maximum value, inclusive. Write the Range class, which is a NumberGroup. The Range class represents the group of int values that range from a given minimum value up through a given maximum value, inclusive. For example,the declaration

NumberGroup range1 = new Range(-3, 2);

represents the group of integer values -3, -2, -1, 0, 1, 2.

Write the complete Range class. Include all necessary instance variables and methods as well as a constructor that takes two int parameters. The first parameter represents the minimum value, and the second parameter represents the maximum value of the range. You may assume that the minimum is less than or equal to the maximum.

```java
public class Range implements NumberGroup{
    private int min;
    private int max;
    public Range(int min, int max){
        this.min = min;
        this.max = max;
    }
    @Override
    public boolean contains(int num) {
        return num >= min && num <= max;
    }
}
public class Test2{
    public static void main(String[] args) {
        NumberGroup range1 = new Range(-3, 2);
        System.out.println("range1 contains -5: "+range1.contains(-5));
        System.out.println("range1 contains 2: "+range1.contains(2));
        System.out.println("range1 contains 10: "+range1.contains(10));
    }
}
Test2.main(null);
```
(c) The MultipleGroups class (not shown) represents a collection of NumberGroup objects and isa NumberGroup. The MultipleGroups class stores the number groups in the instance variable groupList (shown below), which is initialized in the constructor.

private List groupList;

Write the MultipleGroups method contains. The method takes an integer and returns true if and only if the integer is contained in one or more of the number groups in groupList.

```java
public class MultipleGroups implements NumberGroup {
    private List<NumberGroup> groupList;
    public MultipleGroups(List<NumberGroup> groupList) {
        this.groupList = groupList;
    }
    public boolean contains(int num) {
        for (NumberGroup g : groupList) {
            if (g.contains(num)) {
                return true;
            }
        }
        return false;
    }
}
public class Test3{
    public static void main(String[] args) {
        List<NumberGroup> groups = new ArrayList<>();
        groups.add(new Range(5, 8));
        groups.add(new Range(10, 12));
        groups.add(new Range(1, 6));
        MultipleGroups multiple1 = new MultipleGroups(groups);
        System.out.println("multiple1 contains 2: "+multiple1.contains(2));
        System.out.println("multiple1 contains 9: "+multiple1.contains(9));
        System.out.println("multiple1 contains 6: "+multiple1.contains(6));
    }
}
Test3.main(null);
```


This FRQ dives into Classes and Interfaces, making us work with an interface called NumberGroup to check if specific numbers are part of different groups. We created a few classes: one that stores numbers in a list, another that defines a range of numbers, and a third that combines multiple ranges. It's all about using Object-Oriented Programming (OOP) and abstraction to make our code neat, easy to write, and even easier to update. We had to override a method to fit our needs, whether it was checking a list, a range, or multiple ranges.