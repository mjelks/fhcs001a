## Class 16 -- More GUI

---

## Swing Layout Management

- All components are placed inside a container (using the .add method)
- The container's layout manager will determine 
  - position of the added component
  - size of the added component
- How to arrange the components in a container
  - panels inside a frame
  - panels inside another panel
  - UI component inside a panel
  
## Layout Managers

### Border Layout Manager

- Arrange and resize the components to fit 5 regions:
  - NORTH
  - SOUTH  
  - EAST
  - WEST 
  - CENTER
- Each region can contain only one component
- The component may grow to occupy the entire region
- This is the default layout manager for JFrame

#### 1. How to get a BorderLayout manager in a frame

```Java
class MyFrame extends JFrame {
  public MyFrame() {
    BorderLayout layout = (BorderLayout) getLayout();
  }
}
```

#### 2. How to set BorderLayout for a container

```Java
JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());
```

#### 3. How to add a component onto a BorderLayout region

```Java
JLabel label = new JLabel("Spring 2014");
tadd(label, BorderLayout.NORTH);
```

### FlowLayout Manager

- Default layout for JPanel
- Arrange the components in a directional (pre-defined) flow (horiz.)
- By default, all components will be placed in the center of the panel
  - if out of room, flows down to a new row
  
#### 1. to set alignment for FlowLayout  

```java
setAlignment(FlowLayout.LEFT);
setAlignment(FlowLayout.RIGHT);

JPanel panel - new JPanel();
panel.setLayout(new FlowLayout(FlowLayout.LEFT));

// setting alignment after the fact
FlowLayout layout = panel.getLayout();
layout.setAlignment(FlowLayout.LEFT);
```
