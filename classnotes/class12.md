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

1. Declare an object reference (no memory allocated)
```java
CheckingAccount acct1; // just a reference -- init'd to a null value
double fee; // just initialized
acct1.deposit(1000) // error/crash NullReference
```

2. Instantiate an object
```java
// method 1
acct1 = new CheckingAccount(); // default constructor takes no params
// method 2
CheckingAccount acct2 = new CheckingAccount("James", 12345,100.00,'A');
```
