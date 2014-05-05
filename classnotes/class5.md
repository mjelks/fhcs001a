Class 05
------
#### GUI / Swing library

  ```java
  import java.swing.*;
  ```
  
#### JOptionPane
- class with I/O methods
- makes it trivial to popup a dialog
- user prompt (modal)
    
  #### commonly used methods: 
  ##### Input
  ```java
    showInputDialog()
    showConfirmDialog()
  ```
  ##### Output
  ```java      
      showMessageDialog()
  ```
 
  Each dialog can optionally display an icon:
    - ERROR_MESSAGE
    - INFORMATION_MESSAGE
    - WARNING_MESSAGE
    - QUESTION_MESSAGE
    - PLAIN_MESSAGE (no icon shown)
    
  ex:
  String buffer;
  buffer = (String) JOptionPane.showInputDialog("Prompt");
  
#### Java Methods
  
- ##### What?
  - group of statements that are logically related combined together to perform a specific task
- ##### Why?
  - break code into smaller/maintainable blocks (modularity)
  - ease in debugging
  - minimize code redundancy
  - encourages reuse
- ##### How?
  - two types of methods
    - *class* (global)
    - *instance* - instance of a class
        
    ex. DEFINING a Class method
    public static <return type> methodname(paramlist)
    
    DEFINING an instance method
    public <return type> methodname(paramlist)
    
