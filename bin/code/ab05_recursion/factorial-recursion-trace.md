# Factorial Recursion Tree Trace

## Function Analysis
```java
public static int getFactorial(int n) {
    if (n <= 1)
        return 1;
    
    return n * getFactorial(n-1);
}
```

## Recursion Tree for getFactorial(4)

### Step-by-Step Trace:

```
getFactorial(4)
├── n = 4, n > 1, so continue
├── return 4 * getFactorial(3)
    ├── getFactorial(3)
    │   ├── n = 3, n > 1, so continue
    │   ├── return 3 * getFactorial(2)
    │       ├── getFactorial(2)
    │       │   ├── n = 2, n > 1, so continue
    │       │   ├── return 2 * getFactorial(1)
    │       │       ├── getFactorial(1)
    │       │       │   ├── n = 1, n <= 1, so return 1
    │       │       │   └── Base case reached!
    │       │       └── return 2 * 1 = 2
    │       └── return 3 * 2 = 6
    └── return 4 * 6 = 24
```

### Call Stack Visualization:

| Call Stack Level | Function Call | n Value | Condition Check | Action |
|------------------|---------------|---------|-----------------|---------|
| 1 | getFactorial(4) | 4 | 4 > 1 | return 4 * getFactorial(3) |
| 2 | getFactorial(3) | 3 | 3 > 1 | return 3 * getFactorial(2) |
| 3 | getFactorial(2) | 2 | 2 > 1 | return 2 * getFactorial(1) |
| 4 | getFactorial(1) | 1 | 1 <= 1 | return 1 (Base Case) |

### Unwinding Process:

```
Base Case: getFactorial(1) = 1
Level 3:  getFactorial(2) = 2 * getFactorial(1) = 2 * 1 = 2
Level 2:  getFactorial(3) = 3 * getFactorial(2) = 3 * 2 = 6
Level 1:  getFactorial(4) = 4 * getFactorial(3) = 4 * 6 = 24
```

### Memory Usage Analysis:

Each recursive call adds a new stack frame containing:
- Parameter `n`
- Return address
- Local variables (if any)

**Stack frames created:**
1. getFactorial(4) - n=4
2. getFactorial(3) - n=3  
3. getFactorial(2) - n=2
4. getFactorial(1) - n=1

**Total stack frames:** 4 (equals input value n)

### Time Complexity Verification:

- **Operations per call:** O(1) - just comparison and multiplication
- **Number of calls:** n (from n down to 1)
- **Total time:** O(n)

### Space Complexity Verification:

- **Stack frames:** n (one for each recursive call)
- **Space per frame:** O(1) - constant space per frame
- **Total space:** O(n)

### Final Result:
getFactorial(4) = 24

This trace demonstrates how recursion builds up the call stack during the "winding" phase and then unwinds it during the "unwinding" phase, with each level waiting for the result from the deeper level before completing its own computation. 