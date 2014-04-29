## Class 07

### Relational Operators (comparators)
**< <= > >= == !=**

```java
int score = 90;
if (score <= 95) {} //-> true
if (score > 92) {} // -> false
if (score == 90) {} // -> true
```

*should only apply to numeric data (use other comparison methods on objects)*

### Truth Tables

#### && Logical operator

```
[exp1  exp2] [exp1 && exp2]--> evaluated to some boolean value (true/false)
[T      T]        T
[T      F]        F
[F      T]        F
[F      F]        F
```

####Java has short-circuit evaluation
**If expression 1 is false, no need to evaluate expression2**

#### OR logical operator

```
[exp1  exp2] [exp1 || exp2]--> evaluated to some boolean value (true/false)
[T      T]        T
[T      F]        T
[F      T]        T
[F      F]        F
```

**If expression 1 is true, no need to evaluate expression2**

#### NOT logical operator (unary)

```
[exp  !exp]
[T      F]
[F      T]
```

#### In range test
```java
(x >= a) && (x <= b)
(x < a) || (x > b)
```

### Selection Structures
To allow a program to make decisions based on different conditions.
(boolean condition evaluation)

- One way selection
```
if (cond) { stmt; }
```

- Two way selection
```
if (cond) { 
  stmt;
}
else {
  // do stuff 
}
```

- Multi way selection (nested if/else)
```
if (cond1) {}
else if (cond2) {} 
else {}
```

- Switch statement
```java
int year;
double minimumWage;
switch (year) {
  case 2014: 
    minimumWage = 15.00;
    break;
  case 2013:
    minimumWage = 12.75;
    break;
  default:
    minimumWage = 9.75;
    break;
```

*If you forget the **break** portion, it will spill to the next case block*

### Iteration / Loop Structures

####Iteration structures are used to group related statements into a block.

- for loop (know in advance how many times to iterate)
```java
for (exp1; looptest_exp; exp2) {
  stmt1;
  stmt2;
}

for (int line=1;line <= 100; line++) {
  System.out.format("%3d%n",line);
}

// print odd numbers
for (int line=1;line <= 100; line+=2) {
  System.out.format("%3d%n",line);
}
```
