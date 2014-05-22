## Class 13 -- Object Composition

---

## Object Composition

#### Is a class that contains other classes as instance fields

```java
class Circle {
  private double radius;
  private Point center;
  
  // default constructor
  public Circle () {
    radius = 0.0;
  }
  
  // center point constructor
  public Circle (double r; double x, double y) {
    radius = r;
    center = new Point(x,y);
  }
  
  public Circle(double r, Point p) {
    radius = r;
    center = p;
  }
}

public static void createCircle() {
  Point p1 = new Point (1.0, 2.0);
  Circle c = new Circle(5.0, p1);
}
```

## Objects && Arrays

- when you declare an array, just declaring a reference to an array


```java
// reference to integer array
int[] arr; 

// arr is now pointing to array of integers from 0-31 index elements
arr = new int[32];

// Objects require more steps
Point[] points; // reference to array of points objects
// creates 32 'references' to point objects
points = new Point[32];
// points[i] is NOT a Point obj
// points[i] is a REFERENCE to a Point object
for (int i=0; i<points.length; i++) {
  points[i] = new Point();
}
```