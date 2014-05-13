## Class 11 -- More on Classes

---

## Sample:
```java
public class CheckingAccount {
  // instance fields
  // fields belong to an instance
  // always exist when creating a new object
  // initialized to some value by java for you on object creation
  private String name; // i.e. init to null on obj. creation
  private int accountNumber;
  private double balance;
  private char status;
  
  // constructors
  public checkingAccount() {} // default constructor

} // end class
``` 

### Access Modifiers

**public > protected > package > private**

|access modifier|same class|same package|subclass| package|
|---------------|:--------:|:----------:|:------:|:------:|
|Public         |Y         |Y           |Y       |Y       |
|Protected      |Y         |Y           |Y       |N       |
|Package        |Y         |Y           |N       |N       |
|Private        |Y         |N           |N       |N       |