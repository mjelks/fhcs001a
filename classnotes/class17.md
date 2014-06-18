## Class 17 -- More GUI

---

## Setting a Border for each panel

```java
centerPanel.setBorder();
```

## Swing UI Components

### JLabel

```java
import javax.swing.*

JLabel label = new JLabel("Password: ");
```

### Buttons

```java
JButton submitButton = new JButton("Submit");
JButton clearButton = new JButton("Clear");
panel.add(submitButton);
panel.add(clearButton);
```

### Text Fields

```java
JTextField userText = new JTextField(20);
String text = userText.getText();
userText.setText("Spring 2014");
```

### Set Editable

```java
setEditable(true);
```

### Set Font

```java
setFont(new Font(<fontname>));
```

#### Check Boxes

```java
JCheckBox showMapCheckBox = new JCheckBox("Show Maps");
JCheckBox useGPSCheckBox = new JCheckBox("Use GPS");
panel1.add(showMapCheckBox);
panel2.add(useGPSCheckBox);
// to verify if checked
boolean checked = useGPSCheckBox.isSelected();
// to 'check' a checkbox
useGPSCheckBox.setSelected(true);
```