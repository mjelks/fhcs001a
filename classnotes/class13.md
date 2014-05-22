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





```
