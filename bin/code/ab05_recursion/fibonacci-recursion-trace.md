# Fibonacci Recursion Tree Trace

## Function Analysis
```java
public static int getFibonacci(int n) {
    if (n == 1)
        return 1;
    else if (n <= 0)
        return 0;
    
    return getFibonacci(n-1) + getFibonacci(n-2);
}
```

## Recursion Tree for getFibonacci(4)

### Complete Recursion Tree:
```
getFibonacci(4)
├── n = 4, n > 1, so continue
├── return getFibonacci(3) + getFibonacci(2)
    ├── getFibonacci(3)
    │   ├── n = 3, n > 1, so continue
    │   ├── return getFibonacci(2) + getFibonacci(1)
    │       ├── getFibonacci(2)
    │       │   ├── n = 2, n > 1, so continue
    │       │   ├── return getFibonacci(1) + getFibonacci(0)
    │       │       ├── getFibonacci(1)
    │       │       │   ├── n = 1, so return 1
    │       │       │   └── Base case reached!
    │       │       ├── getFibonacci(0)
    │       │       │   ├── n = 0, so return 0
    │       │       │   └── Base case reached!
    │       │       └── return 1 + 0 = 1
    │       ├── getFibonacci(1)
    │       │   ├── n = 1, so return 1
    │       │   └── Base case reached!
    │       └── return 1 + 1 = 2
    └── getFibonacci(2)  ← REPEATED CALCULATION!
        ├── n = 2, n > 1, so continue
        ├── return getFibonacci(1) + getFibonacci(0)
            ├── getFibonacci(1)
            │   ├── n = 1, so return 1
            │   └── Base case reached!
            ├── getFibonacci(0)
            │   ├── n = 0, so return 0
            │   └── Base case reached!
            └── return 1 + 0 = 1
└── return 2 + 1 = 3
```

### Call Stack Visualization:

| Call Stack Level | Function Call | n Value | Condition Check | Action |
|------------------|---------------|---------|-----------------|---------|
| 1 | getFibonacci(4) | 4 | 4 > 1 | return getFibonacci(3) + getFibonacci(2) |
| 2 | getFibonacci(3) | 3 | 3 > 1 | return getFibonacci(2) + getFibonacci(1) |
| 3 | getFibonacci(2) | 2 | 2 > 1 | return getFibonacci(1) + getFibonacci(0) |
| 4 | getFibonacci(1) | 1 | 1 == 1 | return 1 (Base Case) |
| 4 | getFibonacci(0) | 0 | 0 <= 0 | return 0 (Base Case) |
| 3 | getFibonacci(1) | 1 | 1 == 1 | return 1 (Base Case) |
| 2 | getFibonacci(2) | 2 | 2 > 1 | return getFibonacci(1) + getFibonacci(0) |
| 3 | getFibonacci(1) | 1 | 1 == 1 | return 1 (Base Case) |
| 3 | getFibonacci(0) | 0 | 0 <= 0 | return 0 (Base Case) |

### Function Call Count Analysis:

**Total function calls for getFibonacci(4):**
- getFibonacci(4): 1 call
- getFibonacci(3): 1 call
- getFibonacci(2): 2 calls (repeated!)
- getFibonacci(1): 3 calls (repeated!)
- getFibonacci(0): 2 calls (repeated!)

**Total: 9 function calls**

### Repeated Calculations Highlighted:

```
getFibonacci(2) is calculated 2 times:
├── First time: from getFibonacci(3)
└── Second time: from getFibonacci(4)

getFibonacci(1) is calculated 3 times:
├── First time: from getFibonacci(2) → getFibonacci(3)
├── Second time: from getFibonacci(2) → getFibonacci(4)
└── Third time: from getFibonacci(3)

getFibonacci(0) is calculated 2 times:
├── First time: from getFibonacci(2) → getFibonacci(3)
└── Second time: from getFibonacci(2) → getFibonacci(4)
```

### Memory Usage Analysis:

**Maximum stack depth:** O(n)
- The longest path from root to leaf is n levels deep
- Each recursive call adds one stack frame
- Stack frames contain: parameter n, return address

**Stack frames at maximum depth:**
1. getFibonacci(4)
2. getFibonacci(3)
3. getFibonacci(2)
4. getFibonacci(1) or getFibonacci(0)

### Time Complexity Verification:

**Pattern for function calls:**
- getFibonacci(n) makes 2 recursive calls
- Each of those makes 2 more calls
- This creates a binary tree structure
- Total calls ≈ 2^n (exponential growth)

**For getFibonacci(4):**
- Theoretical maximum: 2^4 = 16 calls
- Actual calls: 9 (some paths terminate early due to base cases)
- Still exponential growth pattern

### Space Complexity Verification:

- **Stack depth:** O(n) - longest path from root to leaf
- **Space per frame:** O(1) - constant space per stack frame
- **Total space:** O(n)

### Final Result:
getFibonacci(4) = 3

### Key Insights:

1. **Exponential Time Complexity:** The number of function calls grows exponentially with n
2. **Repeated Calculations:** Many subproblems are solved multiple times
3. **Linear Space Complexity:** Only one path is stored in memory at any time
4. **Inefficiency:** This naive approach is very inefficient for larger values of n
5. **Optimization Opportunity:** Dynamic programming can reduce time complexity to O(n) by avoiding repeated calculations

### Comparison with Factorial:
- **Factorial:** O(n) time, O(n) space - efficient recursive approach
- **Fibonacci:** O(2^n) time, O(n) space - inefficient due to repeated calculations 