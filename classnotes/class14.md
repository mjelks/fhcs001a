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
  }
  System.out.println("PROBLEM: " + e.getMessage());
}
```