Great! Here's a **Java-specific recursion template** you can use as a mental model for most problems — from basic recursion to backtracking and even DP.

---

## 🔁 **Basic Recursion Template in Java**

```java
// Return type depends on problem (int, boolean, void, List<String>, etc.)
ReturnType recursiveFunction(Parameters) {
    
    // Base Case: the simplest input you can solve directly
    if (base_condition) {
        return base_result;
    }

    // Recursive Case: call the function with a smaller problem
    // Possibly combine results of subproblems
    ReturnType result = recursiveFunction(smaller_input);

    // Post-processing (if needed)
    return final_result;
}
```

---

### ✅ Example 1: Factorial

```java
int factorial(int n) {
    if (n == 0) return 1; // base case
    return n * factorial(n - 1); // recursive case
}
```

---

## 🔙 **Backtracking Template in Java**

Backtracking is recursion with constraints + "undoing" choices (backtrack).

```java
void backtrack(State currentState, OtherParameters) {
    
    if (goal_reached) {
        // maybe add currentState to results
        return;
    }

    for (each possible choice) {
        if (isValid(choice)) {
            makeChoice(choice);           // Step 1: Choose
            backtrack(updatedState);      // Step 2: Explore
            undoChoice(choice);           // Step 3: Un-choose (Backtrack)
        }
    }
}
```

---

### ✅ Example 2: Subsets of a set

```java
List<List<Integer>> subsets = new ArrayList<>();

void generateSubsets(int[] nums, int index, List<Integer> current) {
    if (index == nums.length) {
        subsets.add(new ArrayList<>(current)); // base case
        return;
    }

    // Include current element
    current.add(nums[index]);
    generateSubsets(nums, index + 1, current);

    // Exclude current element (backtrack)
    current.remove(current.size() - 1);
    generateSubsets(nums, index + 1, current);
}
```

---

## 💡 **Memoized Recursion Template (for DP)**

Dynamic Programming with **top-down memoization** avoids repeated calls.

```java
Map<StateKey, ReturnType> memo = new HashMap<>();

ReturnType dp(StateKey key, OtherParameters) {
    if (base_condition) {
        return base_result;
    }

    if (memo.containsKey(key)) {
        return memo.get(key);
    }

    ReturnType result = recursiveCallsAndCombination();

    memo.put(key, result);
    return result;
}
```

---

### ✅ Example 3: Fibonacci with memoization

```java
Map<Integer, Integer> memo = new HashMap<>();

int fib(int n) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);

    int result = fib(n - 1) + fib(n - 2);
    memo.put(n, result);
    return result;
}
```

---

## 🧠 Common Debugging Tips

* Add print statements:

  ```java
  System.out.println("Calling with: " + param);
  ```
* Track call stack using parameters.
* Use a debugger in IntelliJ/VSCode to step through.

---

Would you like me to give you a **practice sheet with increasing recursion problems (Java-based)?**
