//Assign 4, Peron class.
//  Represent an applicant, or an employee

package assign4_template;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {

//Item 3. in Assign 4 Document.
private String name;
private byte[] degree;
private ArrayList<String> skill_set;
    //define the constructor with given name, degree, and skill list

public Person(String name, byte[] degree, ArrayList<String> skill_set) {
super();
this.name = name;
this.degree = degree;
this.skill_set = skill_set;
}
    //define getters
    //define setters
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public byte[] getDegree() {
return degree;
}
public void setDegree(byte[] degree) {
this.degree = degree;
}

public ArrayList<String> getSkill_set() {
return skill_set;
}
public void setSkill_set(ArrayList<String> skill_set) {
this.skill_set = skill_set;
}

//define toString()
@Override
public String toString() {
return "Person [name=" + name + ", degree=" + Arrays.toString(degree) + ", skill_set=" + skill_set + "]";
}


//define data fields: name, degree, skill list ("Java, C#, C++", etc.)
// skill list: must be array list or linked list
//define the constructor with given name, degree, and skill list

//define getters

//define setters

//define toString()

}