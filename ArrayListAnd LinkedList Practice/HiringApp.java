package assign4_template;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Scanner;


public class HiringApp {
    //Define the data structures for 3 different groups of people:
    //  new applicants
    //  current employees (those who were hired), 
    //  past employees (those who were fired)
    //
    //Hint: for queue: Queue<Person>,  ArrayDeque, LinkedList
    //      for stack: Deque<Person>   ArrayDeque, LinkedList
static Scanner sc= new Scanner(System.in);
static int choice;
public static void main(String[] args) {

//use stack since employees has FIFO sequence

Queue<Person> applicants=new LinkedList<Person>();
ArrayDeque<Person> currentEmployees=new ArrayDeque<Person>();

ArrayDeque<Person> pastEmployees=new ArrayDeque<Person>();

 //loop until the user decides to quit.
 //display the menu
//get the menu choice
do
{
System.out.print("Action{1 to accept, 2 to hire , 3 to fire, 4 quit }");
getChoice();
//process user selected service request.
switch(choice){

    case 1: applicants.add(getApplication());

break;
//hire method
//check if there is a past employee to hire
case 2: if(!pastEmployees.isEmpty()) {
Person p=pastEmployees.pollLast();
currentEmployees.add(p);
System.out.println(p.getName()+" hired");
}
  //check if there is an applicant to hire
else if(!applicants.isEmpty()) {
Person p=applicants.poll();
currentEmployees.add(p);
System.out.println(p.getName()+" hired");
}
else
System.out.println("mesg for supervisor : There is nobody to hire");

break;
 //fire method
case 3: if(!currentEmployees.isEmpty()) {
    //check if there is a past employee to hire
Person p=currentEmployees.pollLast();
pastEmployees.add(p);
System.out.println(p.getName()+" fired");
}
else
{
Person p=applicants.poll();
currentEmployees.add(p);
System.out.println(p.getName()+" fired");

}

break;

case 4:
break;
}
}while(choice!=4);

}

  //other methods for code modularization
    //method for getting user choice
public static int getChoice() {
choice=sc.nextInt();
return -1;

}

//method for accepting an applicant and reurn this applicant as a Person object
public static Person getApplication() {
    //display prompt for user to enter an applicant's name and degree
System.out.println("Enter the applicant'name degree");
String name=sc.next();
sc.nextLine();
//display prompt for user to enter an applicant's skill list
        //  (first how many skills, then enter skill one by one)
        //use a loop to get each skill
System.out.println("Enter the number of Skill and skill list");
int noOfSkill=sc.nextInt();
ArrayList<String> skill =new ArrayList<String>();
for(int i=0;i<noOfSkill;i++)
{
skill.add(sc.next());
}
 //a Person object using the name, degree, skill list
Person p=new Person(name, null,skill);
//and return this Person object
return p;
}


}