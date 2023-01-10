//File: SimpleLinkedListTest.java.
//Add a file header comment or a class header comment to your work.

package assign3_template;

/**
* Assign 3 Template.
* Testing different methods (successful and failed calls)
*
*/
public class SimpleLinkedListTest {
//main method
public static void main(String[] args) {

//create an empty singly linked list of int values
//append some integers
//test each implemented method using at least 2 calls:

// successful call, failed call

//--Following code were given in Lec#6 --//

//create an empty list

SimpleLinkedList numbers = new SimpleLinkedList();

//append 3 integers

numbers.add(10);

numbers.add(20);

numbers.add(30);

//dump the contents in the list in the original order

System.out.println(numbers);

//or use:

//System.out.println(numbers.toString());

System.out.println ("List contains 30: " + numbers.contains(30));
System.out.println ("List contains 50: " + numbers.contains(50));

numbers.add(1, 15);
numbers.add(3, 25);
System.out.println(numbers);

System.out.println ("Size: " + numbers.size());
System.out.println ("Index of 15: " + numbers.indexOf(15));
System.out.println ("Value at index 1: " + numbers.get(1));

System.out.println ("Remove 15: " + numbers.removeByValue(15));
System.out.println ("Remove item from index 1: " + numbers.removeByIndex(1));

System.out.println (numbers);
}
}