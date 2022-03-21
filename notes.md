{% include navigation.html %}

# CSA

<details>
## Week 1 - [Ticket](https://github.com/Archkitten/CS-AP-2/issues/3)

### (TPT) Study Group Challenge 1

Challenges:
0. Sub-menu separates assignments into weeks.
1. Add and delete elements in a queue.
2. Merge 2 queues into an ordered fashion.
3. Reverse a queue using a stack.

### [Tri 3: Tech Talk 1: Linked Lists Part 2](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-1:-Linked-Lists-Part-2)

Linked List - Connects Objects to each other
```
import java.util.LinkedList;

LinkedList<String> myLinkedList = new LinkedList<String>();
myLinkedList.add("Above");
myLinkedList.add("Blob");
System.out.println(myLinkedList);
```

Generic T - Putting a Class inside an Array? {}

Iterable Interface - For each loop through... a Linked List?

Queue - Built on top of a List (FIRST IN FIRST OUT)
* (processes this one ->) above -> blob -> cup -> drip -> john -> leek -> nay -> ro -> wee -> null (<- add stuff here)
* To add elements, add to head (queuing)
* To delete elements, remove from tail (dequeue)

Stack - Also built on top of a List (LAST IN FIRST OUT)
* above (<- processes this one, new elements are also added here, like a stack of plates)
* blob
* cup
* drip
* john
* leek
* nay
* ro
* wee

Challenge 2 Hint: dequeue and requeue

nil - null

Challenge 3 Hint:
* Take a Queue, put it into a Stack, reprint the Stack.
* It works in theory, try it!

implements vs. extends
* 'implements' has no definition? usually from interface
* extends

Generic T - You can put whatever data type you wish into the LinkedList. Once a data type is put in, the entire LinkedList becomes (uses) that data type.
```
public class Queue<T> implements Iterable<T> {
    LinkedList<T> head, tail;
    // Rest of implementation not shown...
}
```

Double sided Linked List
* Previous Node
* and Next Node
* null <- above <-> blob <-> cup -> null
</details>
