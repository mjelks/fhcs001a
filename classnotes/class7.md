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

1. One way selection
```
if (cond) { stmt; }
```

2. Two way selection
```
if (cond) { 
  stmt;
}
else {
  // do stuff 
}
```

3. Multi way selection (nested if/else)
```
if (cond1) {}
else if (cond2) {} 
else {}
```
