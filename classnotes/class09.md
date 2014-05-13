## Class 09

### More on Arrays

#### 1: Array Creation
```java
/* 
  reference to an array of integers
  at this point, no physical memory allocated
*/
int [] zipcodes; 

// this is a syntax error
// zipcodes is not "initialized"
zipcodes[0] = 94022; 

if (zipcodes == null) // true
```

#### 2: Array initialization
```java
double [] balances; // init the array

// allocate 1000 doubles in memory
// initialize the memory data as well
balances = new double[1000]; 
```
balances --> 0,1,2,etc.

```java
boolean [] options; // init the array

// allocate 1000 doubles in memory
// initialize the array elements data to 'false'
options = new boolean[8]; 
```

#### 3: New Java syntax on for loop (pseudo-foreach)

```java
String [] fruits = {"Apples", "Oranges", "Lemons"};
for (String element : fruits ) {
  System.out.println(element);
}

// another example
int sum = 0;
int [] scores = {89, 75, 38, 87};
for (int score : scores) {
  sum += score;
}
```

#### 4: Reference assignment
```java
/*
  In java you can assign references. 
  Physical memory points to same physical memory space.
*/

int [] list1 = {1,2,3,4}; // list1 pointer to array of four elements
int [] list2; // null object 
list2 = list1; // reference to list1
// to copy contents of list1 to list2, 2 options, manual, or JAVA internaliseer
// MANUAL method
// all elements of list2 has four elements that == 0
list2 = new int [list1.length]; 
for (int i=0;i<list1.length;i++) {
  list2[i] = list1[i];
}

// Java Library method
// System.arraycopy(from,fromIndex,to,toIndex,count);
System.arraycopy(list1,0,list2,0,list1.length);
```

##### 5. Array Sort
```java
import java.util.*;

// sort array in ascending order
Array.sort(array);
```

### Java Classes

- **Classes** are building blocks of an OOP Language
- Objects of the same type are defined or represented by a **common class** 
  (Car, Book, Inventory)
- A **class** is a blueprint from which individual objets are created/instatiated

#### C.java
```java
package network;
class A {

}
class B {

}
public class C {

}
```

#### D.java
```java
// to access class A and class B
// need to split them into their own class files (classA.java)
import network.*;

public class D {

}
```