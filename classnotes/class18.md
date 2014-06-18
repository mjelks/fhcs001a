## Class 18 -- Java Swing Event Handling Model

---

## Event Source

- User -> Event Source -> (generate an event) -> Listener

- one-to-many or many-to-one relationship between event sources and event listeners

- Event Source
  - frame
  - panel
  - button
  - textfield
  - checkbox

- Listener
  - a method to respond to the event    

### one-to-many (example resizing a window)

Event Source 1  -> EventListener1
                -> EventListener2  
                -> EventListener3  

### many-to-one (example listen to all button clicks)
                
Event Source 1  -> EventListener
Event Source 2
Event Source 3                


### register a listener for a component

```java
// <component_reference>.add<listener>(listener instance);
// JButton (event source) -> click on the button -> generates ActionEvent -> sent to -> ActionListener
JButton submitButton = new JButton("Submit");
submitButton.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    // do your stuff here
  }
}); 
```

- In order to access other component references in the same frame (or panel) we need to define all components as provate instance fields of the frame (or panel)