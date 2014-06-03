## Class 15 -- Searching and GUI

---

## Searching Algorithms

#### Sequential Search [ O(n) complexity ]

##### Start from the beginning of the list, examining one element at a time until the end of the list
  
- Go through entire list until a match or til the end
- Type of data store may determine method of search

```Java
int SeqSearch (int[] list, int target) {
  for (int i = 0; i< list.length; i++) {
    if (target == list[i]) {
      return i;
    }
  }
  
  return -1;
}
```

### Binary Search [ O(log2) complexity ]

- The list must be sorted
- Very fast, very efficient
- Worst case scenario it talkes only log2 n comparisons to determine if a target if found or not

```java
// 8 | 10 | 15 | 19 | 73 | 100 | 200
int target = 100
// go to median
// 19 < 100 - split the array -> take the right side in this case
// cut the list in half again, comparison, repeat as necessary until exhaustion
```

## GUI

- Create top level window -> 'Frame'
  - Add in 'Panels'
  
#### To build a Java GUI application we need to import 3 packages:

```java
import java.awt.*; // containers
import java.awt.event.*; // events
improt javax.swing.*; // UI components
```

Swing library offers:
- richer & more convenient set of UI Components
- depend less on the underlying target platform
- more consistent user experience across platforms

**BUT**

#### Swing library is NOT thread safe

- need to use the event dispatch thread to handle this situation

### Process of developing GUI

#### GUI DESIGN (BUILDING PROCESS)

- Create the top-level window (frame)
  - determine the **frame's** attributes such as title, size, location, default behavior
- Set the **frame's** layout scheme if needed
  - each frame will have a default layout manager
- Create **panels** and add them to the **frame** based on your chosen layout scheme
- Create UI Components and add them to the **panels**  based on your chosen layout scheme for the panel
  - the panels can have diff. layout managers depending on how you want to arrange the UI components on the panels
  
#### GUI BEHAVIOR

##### Once we have finished with **GUI DESIGN** , need to provide event handlers for UI Components

- Delegate the GUI startup process to the event dispatch thread (**EDT**)

```Java
class MyAppFrmae Extends JFrame {
  public MyAppFrame() {
    setTitle("AppFrame");
    Dimension dis = kit.getScreenSize();
    int screenWidth = dis.width;
    int screenHeight = dis.height;
  }
}
```
  