## Class 14 -- Buffered Reader

---

## Read File Input

#### 

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String line = br.readLine();
```

#### file input

```java
String line = null;
BufferedReader br = null;
int sum = 0;
try {
  br = new BufferedReader(new FileReader("data.txt");
  while ( (line = br.readLine()) != null) {
    // process line
    sum += Integer.parseInt(line);
  }
  br.close();
} catch (IOException e) {
  if (br != null) {
    br.close();
    System.exit(0);
  }
  System.out.println("PROBLEM: " + e.printStackTrace());
}
```

#### File Read with Delimiters

```java
import java.io.*

public class FileReading {
  public static void main (String[] args) {
    BufferedReader br = null;
    // uses regular expressions (in this case, a character class with ;)
    String delimiters = "[;]";
    try {
      br = new BufferedReader(new FileReader("data.txt"));
      String line="";
      
      while ((line = br.readLine()) != null) {
        String[] fields = line.split(delimiters);
        for (String field : fields) {
          System.out.print(field + " ");
        }
        System.out.println();
      }
      br.close();
  } catch (IOException e) {
    if (br != null) {
      br.close();
      System.exit(0);
    }
  }
  
} // end class

```

#### Sorting & Searching

##### Elementaray Sorting Algorithms

###### Bubble Sort

- List of Integers
  - 90, 20, 57, 3, 12, 8, 15, 34, 7
- Sort ascending
- broken into 2 sublists
  - first one has the sorted elements
  - unsorted list gets pulled
  - pass one, 3 goes to front
  - pass two 7 goes to front, etc.
  - many passes
  - start from end of list, if last element < last element -1, swap
    - keep comparing as you reverse in the array
  -(O)n2 complexity (double for loop)
  
###### Selection Sort  
- List of Integers
  - 90, 20, 57, 3, 12, 8, 15, 34, 7
  - only requires one swap per pass
  - find the smallest element in the list, swap with the first element
  - still (O)n2 in complexity
