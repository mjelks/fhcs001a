## Class 12 -- Yet More on Classes

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
  
  // default constructor takes no parameters -- still important
  // constructors
  public checkingAccount() {} // default constructor
  // constructor does not specify return type or even void
  // primarily used for initing vars
  public checkingAccount(String name, int accountNumber, double balance) {
    this.name = name;
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.status = status;
  }

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

### Instance Methods

```java
public double getBalance() { return balance; }

public void setBalance(double balance) { balance += amount; }

void deposit(double amount) { balance += amount; }

public boolean withdraw(double amount) {
  boolean status = true;
  if (balance >= amount) {
    balnce -= amount;
  } else {
    status = false;
  }
}
```

#### Getters && Setters

- most of the time you have getters
  - read only methods

- setters for write 