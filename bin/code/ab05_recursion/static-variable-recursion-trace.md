# Static Variable Recursion Trace

## Function Analysis
```java
static int globalCounter = 0;

public static int f1(int n) {
    if (n > 0) {
        globalCounter++;
        return f1(n-1) + globalCounter;
    }
    return 0;
}
```

## Recursion Tree for f1(4)

### Key Concept: Static Variable Behavior
- `globalCounter` is shared across all recursive calls
- It gets incremented at each recursive call
- The value used in addition is the **current** value of `globalCounter` at the time of unwinding

### Step-by-Step Trace:

```
f1(4)
├── n = 4, n > 0, so continue
├── globalCounter++ (globalCounter becomes 1)
├── return f1(3) + globalCounter
    ├── f1(3)
    │   ├── n = 3, n > 0, so continue
    │   ├── globalCounter++ (globalCounter becomes 2)
    │   ├── return f1(2) + globalCounter
    │       ├── f1(2)
    │       │   ├── n = 2, n > 0, so continue
    │       │   ├── globalCounter++ (globalCounter becomes 3)
    │       │   ├── return f1(1) + globalCounter
    │       │       ├── f1(1)
    │       │       │   ├── n = 1, n > 0, so continue
    │       │       │   ├── globalCounter++ (globalCounter becomes 4)
    │       │       │   ├── return f1(0) + globalCounter
    │       │       │       ├── f1(0)
    │       │       │       │   ├── n = 0, n <= 0, so return 0
    │       │       │       │   └── Base case reached!
    │       │       │       └── return 0 + 4 = 4
    │       │       └── return 4 + 4 = 8
    │       └── return 8 + 4 = 12
    └── return 12 + 4 = 16
└── Final result: 16
```

### Call Stack with Global Counter Tracking:

| Call Stack Level | Function Call | n Value | globalCounter After Increment | Action |
|------------------|---------------|---------|-------------------------------|---------|
| 1 | f1(4) | 4 | 1 | return f1(3) + globalCounter |
| 2 | f1(3) | 3 | 2 | return f1(2) + globalCounter |
| 3 | f1(2) | 2 | 3 | return f1(1) + globalCounter |
| 4 | f1(1) | 1 | 4 | return f1(0) + globalCounter |
| 5 | f1(0) | 0 | 4 | return 0 (Base Case) |

### Unwinding Process with Values:

```
Base Case: f1(0) = 0
Level 4:  f1(1) = f1(0) + globalCounter = 0 + 4 = 4
Level 3:  f1(2) = f1(1) + globalCounter = 4 + 4 = 8
Level 2:  f1(3) = f1(2) + globalCounter = 8 + 4 = 12
Level 1:  f1(4) = f1(3) + globalCounter = 12 + 4 = 16
```

### Global Counter Evolution:

```
Initial: globalCounter = 0

f1(4) called:
├── globalCounter++ → globalCounter = 1
├── f1(3) called:
│   ├── globalCounter++ → globalCounter = 2
│   ├── f1(2) called:
│   │   ├── globalCounter++ → globalCounter = 3
│   │   ├── f1(1) called:
│   │   │   ├── globalCounter++ → globalCounter = 4
│   │   │   ├── f1(0) called:
│   │   │   │   └── No increment (base case)
│   │   │   └── globalCounter remains 4
│   │   └── globalCounter remains 4
│   └── globalCounter remains 4
└── globalCounter remains 4
```

### Memory Usage Analysis:

**Stack frames created:**
1. f1(4) - n=4, globalCounter=1
2. f1(3) - n=3, globalCounter=2
3. f1(2) - n=2, globalCounter=3
4. f1(1) - n=1, globalCounter=4
5. f1(0) - n=0, globalCounter=4 (base case)

**Static variable:**
- `globalCounter` is stored in static memory (class level)
- Shared across all function calls
- Not part of the call stack

### Time and Space Complexity:

**Time Complexity: O(n)**
- Each recursive call performs constant time operations
- Total number of calls: n+1 (from n down to 0)
- Linear time complexity

**Space Complexity: O(n)**
- Maximum stack depth: n+1
- Each stack frame: O(1) space
- Static variable: O(1) additional space
- Total space: O(n)

### Key Insights:

1. **Static Variable Impact**: The global counter affects the computation at each level
2. **Shared State**: All recursive calls share the same `globalCounter` variable
3. **Final Value Used**: During unwinding, all levels use the final value of globalCounter (4)
4. **Final Result**: 0 + 4 + 4 + 4 + 4 = 16

### Mathematical Pattern:

For f1(n), the result is:
```
f1(n) = f1(n-1) + final_globalCounter_value
```

Where `final_globalCounter_value` is the value of globalCounter after all increments (which equals n).

### Final Result:
f1(4) = 16

This trace demonstrates how static variables can create complex interactions in recursive functions, where the shared state affects the computation at each recursive level. The key insight is that during unwinding, all levels use the final value of the global counter. 