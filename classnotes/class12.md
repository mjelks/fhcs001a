## Class 12 -- Yet More on Classes

---

## Static Data Fields

- One single data point for entire class
- Static fields are class-wide information / shared data

## Static methods

- can exist independently of class object
- might be accessed even if no object instantiated
- do not need any object at all if public


#### Static methods can only access 
- static Fields
- other static methods

- On the other hand, instance fields and methods can access static methods

## Object Instantiation

#### Declare an object reference (no memory allocated)
```java
CheckingAccount acct1; // just a reference -- init'd to a null value
double fee; // just initialized
acct1.deposit(1000) // error/crash NullReference
```

#### Instantiate an object
```java
// method 1
acct1 = new CheckingAccount(); // default constructor takes no params
// method 2
CheckingAccount acct2 = new CheckingAccount("James", 12345,100.00,'A');
```

#### Accessing fields/methods
- object reference via dot notation
```java
class Example {
  // static fields
  private static int x;
  public static double y;
  
  // instance fields
  private int a;
  public double b;

  // static methods
  // static method NOT ALLOWED to access an instance field
  public static void m1() { a = 3;  }  // NO
  
  // SAME AS ABOVE x is ok, b IS NOT
  private static void m2() {
    b = 2; 
    x = 1;
  }
  
  // instance methods
  // this one is ok -- instance method accessing instance field
  public void m3 () {
    a = 1;
  } 
  
  // ok as well, instance method accessing static field
  private void m4() {
    x = 2;
  }
}
Example e1; e1.m4() // error - have not instantiated object
Example e2 = new Example(); // VALID

// invalid b/c you it's private. need setter method to change value
Example.x = 5; 
// conversely y WILL work b/c it's public
Example.y = 10.0;
// NO, b/c it's an instance field
Example.b = 5.99
// this is valid
e2.b = 5.99; 
// invalid b/c a is private
e2.a = 20;

// NO - this is an instance method
Example.m3()
// YES
e2.m3(); 
// NO
e2.m4();
// this is possible
e2.m1();



```
