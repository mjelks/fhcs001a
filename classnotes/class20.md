## Class 20 -- Inner Classes & Recursion

---

## Using Inner Classes as a Panel / ActionListener

```java
// becomes an ActionListener by using 'implements' keyword
class ButtonPanel extends JPanel implements ActionListener {
  public ButtonPanel(<pass in text fields if you need to access elements outside class>) {
    // create buttons
  }
  
  public void actionPerformed(ActionEvent e) {

  }
}
```

## Recursion

### How do we solve a problem recursively?

#### Example: Large Factorial calculation

n! = 1 * 2 * 3 * n-1 * n
6! = 1 * 2 * 3 * 4 * 5 * 6

```java
long factorial (int n) {
  if (n == 1) {
    return 1;
  } else {
   return n * factorial(n-1);
  }
}
```

#### Example 2: Print the first n integers in reverse order

```Java
for (int i=n; i <=1; i--) {
  SOP(i);
  void printReverse(int n) {
    if (n==1) {
      SOP(n);
    } else {
      SOP(n);
      printReverse(n-1);
    }
  }
}
```