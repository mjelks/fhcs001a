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