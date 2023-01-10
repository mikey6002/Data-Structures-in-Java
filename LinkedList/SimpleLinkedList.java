//File: SimpleLinkedList.java.
//Add a file header comment or a class header comment to your work.
package assign3_template;

/**
* Assign 3 template.
* Implement more methods in List interface.
*
*/

public class SimpleLinkedList {

private static class Node {
private int data;
private Node next;

private Node(int data) {
this.data = data;
next = null;
}
}

//the reference to the first Node in this linked list.
private Node top;

//the size of this linked list
private int size;

//create an empty linked list
public SimpleLinkedList() {
top = null;
size = 0;
}

//append newItem
public boolean add(int newItem) {
Node temp = new Node(newItem);
if (top == null) { //empty list
    top = temp;
}
else { //non-empty list

//locate last node
    Node current = top; //start with the first node

    while (current.next != null) { //check if current node is not the last node
        current = current.next; //move on to the next node on the list
}
current.next = temp; //append the new node immediately following the current node
}

size++;
return true;
}

//return a string that contains all integers (in the original sequence) in the linked list.
@Override
public String toString() {
String result = ""; //result string
Node current = top; //start with first Node
while (current != null) { //check if there is still nodes remaining
    result += current.data; //add the integer in current Node to the result string
    result += "-->";
    current = current.next; //move on to the next Node
}
return result;
}

//-------Start of Assign 3 --------/
//2.1.2 Coding Requirements
//You can call other methods to complete a method.
//You can also add private methods, and then call these methods
// to complete a method required in this assignment.
//You are NOT allowed to add or remove data fields to/from SimpleLinkedList class.
//You are NOT allowed to change the definition of Node class.
//2.1.1 What Code to Add
//-----Required ---------------//
//Remove the first occurrence of the specified item from this linked list.
// If success, return true. Otherwise, return false.

public boolean removeByValue(int item) {
//add your own code
Node current = top;
Node pre = null;

while(current!=null && current.data!=item){
    pre = current;
    current = current.next;
}
if(current==null)
    return false;

    pre.next = current.next;
    size--;
    return true;
}

//add item to be at [index];
// if index is [0, size-1], insert item between [index-1] and [index]
// if index is size, append item to the end of this linked list.
public void add(int index, int item) {
//check if index is invalid
if(index<0 ||index>size)
return;
size++;
Node newnode = new Node(item);
if(index==0){
    newnode.next = top;
    top = newnode;
return;
}
Node tmp = top;
Node pre = null;
for(int i=0; i<index; i++){
    pre = tmp;
    tmp = tmp.next;
}
pre.next = newnode;
newnode.next = tmp;
}

//Get the integer item at the specified position and return the integer value.
//If the index is not valid, throw an exception or print an error message
// and return Integer.MIN_VALUE.
public int get(int index) {
//check if index is invalid
if(index<0 || index>=size){
    System.out.println ("Error: Invalid index");
    return Integer.MIN_VALUE;
}
Node current = top;
int i = 0;
while(i<index){
    current = current.next;
    i++;
}
return current.data;
}

//Search this linked list for the first occurrence of the specified integer: item.
//If the item is found, return its index. Otherwise return -1.
public int indexOf(int item) {
Node current = top;
int index = 0;
while(current!=null && current.data!=item){
    current = current.next;
    index++;
}
if(current.data==item)
    return index;
    return -1;
}

//Find out if the specified integer: item is in this linked list.
// Returns true if yes, false otherwise.
public boolean contains(int item) {
Node current = top;

while(current!=null && current.data!=item){
    current = current.next;
}
if(current==null)
    return false;

    return true;

}

//return how many integers are in this linked list
public int size() {
//add your own code
return size;

}

//-----Bonus ---------------//
//Remove the item at the specified position from this linked list and
// return the removed item.
//If the index is not valid, throw an exception or print an error message
// and return Integer.MIN_VALUE.
public int removeByIndex(int index) {
//check if index is invalid
if(index<0 ||index>=size){
    System.out.println ("Error: Invalid index");
    return Integer.MIN_VALUE;
}

Node current = top;
Node pre = null;

int i=0;
while(i<index){
pre = current;
current = current.next;
i++;
}
int item = current.data;
pre.next = current.next;
size--;
return item;

}
}