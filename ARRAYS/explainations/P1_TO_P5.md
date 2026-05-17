# Arrays — Problem Guide (P1 to P5)

This document explains each program in the `ARRAYS` folder: problem statement, sample I/O, solution, dry run, complexity, edge cases, and optional optimizations.

---

## Table of Contents

1. [P1 — Average of Array](#p1--average-of-array)
2. [P2 — Linear Search](#p2--linear-search)
3. [P3 — Sum of Positive and Negative Numbers](#p3--sum-of-positive-and-negative-numbers)
4. [P4 — Count Zeros and Ones](#p4--count-zeros-and-ones)
5. [P5 — First Unsorted Element](#p5--first-unsorted-element)

---

## P1 — Average of Array

**File:** `P1_AverageOfArray.java`

### Question

Given an array of integers, calculate and print the **average** of all elements.

\[
\text{average} = \frac{\text{sum of all elements}}{\text{number of elements}}
\]

### Sample Input and Output

**Input**

```
Enter the size of the array: 5
Enter array elements:
10 20 30 40 50
```

**Output**

```
Average: 30.0
```

**Another example**

| Input | Output |
|-------|--------|
| size = `4`, elements `1 2 3 4` | `Average: 2.5` |
| size = `0` | `Invalid Size` |

---

### Solution

```java
import java.util.Scanner;

class P1_AverageOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        if (size > 0) {
            int[] arr = new int[size];
            int sum = 0;
            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            double average = (sum * 1.0) / size;
            System.out.println("Average: " + average);
        } else {
            System.out.println("Invalid Size");
        }

        sc.close();
    }
}
```

---

### Logic

1. Read `size`. If `size <= 0`, print invalid message and stop.
2. Create array of length `size`.
3. Read each element; add it to `sum` in the **same loop** (single pass).
4. Compute `average = sum / size` using **floating-point division** (`sum * 1.0`) so the result is not truncated.
5. Print the average.

---

### Dry Run

**Input:** `size = 4`, elements `2, 4, 6, 8`

| Step | `i` | `arr[i]` | `sum` (after) |
|------|-----|----------|---------------|
| Start | — | — | `0` |
| Read | `0` | `2` | `2` |
| Read | `1` | `4` | `6` |
| Read | `2` | `6` | `12` |
| Read | `3` | `8` | `20` |

\[
\text{average} = \frac{20 \times 1.0}{4} = 5.0
\]

**Output:** `Average: 5.0`

---

### Time and Space Complexity

| | Complexity | Reason |
|---|------------|--------|
| **Time** | **O(n)** | One loop over `n` elements |
| **Space** | **O(n)** | Array of size `n` (+ O(1) for `sum`) |

---

### Edge Cases

| Case | Input | Behavior |
|------|--------|----------|
| Invalid size | `size = 0` or negative | `Invalid Size` — avoids division by zero |
| Single element | `size = 1`, `[42]` | average = `42.0` |
| Negative numbers | `[-2, 4]` | sum = `2`, average = `1.0` |
| Integer division trap | sum=7, size=2 | `(7 * 1.0) / 2` → `3.5` (not `3`) |

**Example — invalid size**

```
Enter the size of the array: 0
Invalid Size
```

No array is created; no division by `0`.

---

### Optimizations

#### 1. Single pass (already applied)

Reading and summing in one loop avoids a second traversal.

#### 2. Use `long` for sum (overflow safety)

If many large values are added, `int sum` can overflow. Use `long` for the accumulator.

**Optimization code**

```java
long sum = 0;
for (int i = 0; i < size; i++) {
    arr[i] = sc.nextInt();
    sum += arr[i];
}
double average = (double) sum / size;
```

#### 3. Skip storing the array (only if average is needed)

If you do not need the array after input, you can sum without `arr[]` — **O(1)** extra space (besides input).

```java
long sum = 0;
for (int i = 0; i < size; i++) {
    sum += sc.nextInt();
}
double average = (double) sum / size;
```

---

---

## P2 — Linear Search

**File:** `P2_LinearSearch.java`

### Question

Given an array and a target value `ele`, find whether `ele` exists. If yes, print its **first index**; if not, print that it is not present.

### Sample Input and Output

**Input**

```
Enter the size of the array: 6
Enter array elements:
5 12 7 12 9 3
Enter element to search: 12
```

**Output**

```
12 present in array at index: 1
```

**Not found**

```
Enter element to search: 99
99 not present in the array
```

---

### Solution

```java
import java.util.Scanner;

public class P2_LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        if (size > 0) {
            int[] arr = new int[size];
            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.print("Enter element to search: ");
            int ele = sc.nextInt();

            int index = -1;
            for (int i = 0; i < size; i++) {
                if (arr[i] == ele) {
                    index = i;
                    break;
                }
            }

            if (index == -1)
                System.out.println(ele + " not present in the array");
            else
                System.out.println(ele + " present in array at index: " + index);
        } else {
            System.out.println("Invalid Size");
        }

        sc.close();
    }
}
```

---

### Logic

1. Read array (after validating `size > 0`).
2. Read target `ele`.
3. Set `index = -1` (means “not found”).
4. Scan from left to right; on first match, set `index = i` and **`break`** (first occurrence only).
5. If `index == -1`, print not found; else print index.

---

### Dry Run

**Array:** `[5, 12, 7, 12, 9, 3]`, **search:** `12`

| `i` | `arr[i]` | `arr[i] == 12`? | `index` | Action |
|-----|----------|-----------------|---------|--------|
| `0` | `5` | No | `-1` | continue |
| `1` | `12` | Yes | `1` | **break** |

**Output:** `12 present in array at index: 1` (not index `3`, because of `break`).

**Search:** `99` — loop finishes, `index` stays `-1` → not present.

---

### Time and Space Complexity

| | Complexity | Reason |
|---|------------|--------|
| **Time** | **O(n)** worst/average | May scan entire array |
| **Time** | **O(1)** best | Target at index `0` |
| **Space** | **O(n)** | Storage for array |

For an **unsorted** array, linear search is appropriate; you cannot do better without extra structure (e.g. sorting + binary search).

---

### Edge Cases

| Case | Input | Output |
|------|--------|--------|
| Invalid size | `0` | `Invalid Size` |
| Single element, found | `[7]`, search `7` | index `0` |
| Single element, not found | `[7]`, search `1` | not present |
| Duplicates | `[1,2,2,3]`, search `2` | index `1` (first only) |
| Target at last index | `[1,2,3]`, search `3` | index `2` |

---

### Optimizations

#### 1. Early exit with `break` (already applied)

Stops as soon as the first match is found.

#### 2. Extract a reusable method

Same logic, easier to test and reuse.

**Optimization code**

```java
public static int linearSearch(int[] arr, int ele) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == ele) {
            return i;
        }
    }
    return -1;
}

// In main:
int index = linearSearch(arr, ele);
```

#### 3. Enhanced `for` loop (readability only)

Same time complexity:

```java
int index = -1;
int i = 0;
for (int x : arr) {
    if (x == ele) {
        index = i;
        break;
    }
    i++;
}
```

---

---

## P3 — Sum of Positive and Negative Numbers

**File:** `P3_SumOfPositiveNegativeNumbers.java`

### Question

Given an array, compute:

- **Sum of positive numbers** (values `> 0`)
- **Sum of negative numbers** (values `< 0`)

Zeros are included in neither sum.

### Sample Input and Output

**Input**

```
Enter the size of the array: 6
Enter array elements:
3 -2 5 -7 0 4
```

**Output**

```
Sum of positive numbers: 12
Sum of negative numbers: -9
```

Explanation: positives `3 + 5 + 4 = 12`, negatives `-2 + (-7) = -9`, zero ignored.

---

### Solution

```java
import java.util.Scanner;

public class P3_SumOfPositiveNegativeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        if (size > 0) {
            int[] arr = new int[size];
            int sumPositive = 0, sumNegative = 0;
            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] > 0) sumPositive += arr[i];
                else if (arr[i] < 0) sumNegative += arr[i];
            }

            System.out.println("Sum of positive numbers: " + sumPositive);
            System.out.println("Sum of negative numbers: " + sumNegative);
        } else {
            System.out.println("Invalid Size");
        }

        sc.close();
    }
}
```

---

### Logic

1. Validate `size > 0`.
2. For each element:
   - if `> 0` → add to `sumPositive`
   - else if `< 0` → add to `sumNegative`
   - if `== 0` → skip both
3. Print both sums.

---

### Dry Run

**Elements:** `3, -2, 5, -7, 0, 4`

| `i` | `arr[i]` | Condition | `sumPositive` | `sumNegative` |
|-----|----------|-----------|---------------|---------------|
| `0` | `3` | `> 0` | `3` | `0` |
| `1` | `-2` | `< 0` | `3` | `-2` |
| `2` | `5` | `> 0` | `8` | `-2` |
| `3` | `-7` | `< 0` | `8` | `-9` |
| `4` | `0` | neither | `8` | `-9` |
| `5` | `4` | `> 0` | `12` | `-9` |

---

### Time and Space Complexity

| | Complexity |
|---|------------|
| **Time** | **O(n)** — one pass |
| **Space** | **O(n)** — array storage |

---

### Edge Cases

| Case | Input | Result |
|------|--------|--------|
| All positive | `[1, 2, 3]` | pos `6`, neg `0` |
| All negative | `[-1, -2]` | pos `0`, neg `-3` |
| Only zeros | `[0, 0, 0]` | both `0` |
| Invalid size | `0` | `Invalid Size` |
| Mix with zero | see sample | zero skipped |

---

### Optimizations

#### 1. Single pass (already applied)

Read and classify in one loop.

#### 2. Use `long` for sums (overflow)

Large arrays with large magnitudes can overflow `int` when summing.

**Optimization code**

```java
long sumPositive = 0, sumNegative = 0;
for (int i = 0; i < size; i++) {
    arr[i] = sc.nextInt();
    if (arr[i] > 0) sumPositive += arr[i];
    else if (arr[i] < 0) sumNegative += arr[i];
}
```

#### 3. Sum without storing array

If only sums are required:

```java
long sumPositive = 0, sumNegative = 0;
for (int i = 0; i < size; i++) {
    int x = sc.nextInt();
    if (x > 0) sumPositive += x;
    else if (x < 0) sumNegative += x;
}
```

---

---

## P4 — Count Zeros and Ones

**File:** `P4_CountZerosAndOnes.java`

### Question

Given an array (typically binary: only `0` and `1`), count how many **0s** and how many **1s** appear.

### Sample Input and Output

**Input**

```
Enter the size of the array: 8
Enter array elements:
1 0 1 1 0 0 1 0
```

**Output**

```
Number of 0s: 4
Number of 1s: 4
```

---

### Solution

```java
import java.util.Scanner;

public class P4_CountZerosAndOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        if (size > 0) {
            int[] arr = new int[size];
            int count0 = 0, count1 = 0;
            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] == 0) count0 += 1;
                else count1 += 1;
            }

            System.out.println("Number of 0s: " + count0);
            System.out.println("Number of 1s: " + count1);
        } else {
            System.out.println("Invalid Size");
        }

        sc.close();
    }
}
```

---

### Logic

1. Validate `size > 0`.
2. For each element:
   - if `0` → increment `count0`
   - else → increment `count1` (assumes only `0` and `1` in input)
3. Print both counts.

**Note:** `count0 + count1` should equal `size` only when every element is `0` or `1`.

---

### Dry Run

**Elements:** `1, 0, 1, 1, 0, 0, 1, 0`

| `i` | `arr[i]` | `count0` | `count1` |
|-----|----------|----------|----------|
| `0` | `1` | `0` | `1` |
| `1` | `0` | `1` | `1` |
| `2` | `1` | `1` | `2` |
| `3` | `1` | `1` | `3` |
| `4` | `0` | `2` | `3` |
| `5` | `0` | `3` | `3` |
| `6` | `1` | `3` | `4` |
| `7` | `0` | `4` | `4` |

---

### Time and Space Complexity

| | Complexity |
|---|------------|
| **Time** | **O(n)** |
| **Space** | **O(n)** |

Counting cannot exceed **O(n)** time because every element may need to be seen once.

---

### Edge Cases

| Case | Input | Output |
|------|--------|--------|
| All zeros | `[0,0,0]` | 0s=`3`, 1s=`0` |
| All ones | `[1,1]` | 0s=`0`, 1s=`2` |
| Invalid size | `0` | `Invalid Size` |
| Non-binary value `2` | `[0,2,1]` | current `else` counts `2` as a `1` — **wrong** for strict binary |

**Example — why strict `else if` matters**

Input: `[0, 2, 1]` with current code → `count0=1`, `count1=2` (treats `2` as `1`).

---

### Optimizations

#### 1. Single pass (already applied)

#### 2. Strict binary check with `else if`

Only count `1` when the value is exactly `1`; ignore or handle other values.

**Optimization code**

```java
for (int i = 0; i < size; i++) {
    arr[i] = sc.nextInt();
    if (arr[i] == 0) {
        count0++;
    } else if (arr[i] == 1) {
        count1++;
    }
    // optional: else → invalid element (skip or warn)
}
```

#### 3. Count without array

```java
int count0 = 0, count1 = 0;
for (int i = 0; i < size; i++) {
    int x = sc.nextInt();
    if (x == 0) count0++;
    else if (x == 1) count1++;
}
```

#### 4. Use `count0++` instead of `count0 += 1`

Same logic, common style for counters.

---

---

## P5 — First Unsorted Element

**File:** `P5_FirstUnsortedElement.java`

### Question

In a **non-decreasing** (ascending) array, each element should satisfy `arr[i] >= arr[i-1]`. Find the **first unsorted element** — the value at the **leftmost index** where order breaks: first `i` (from `1` to `size-1`) such that `arr[i] < arr[i-1]`.

If the array is already sorted, report that.

### Sample Input and Output

**Input**

```
Enter the size of the array: 5
Enter array elements:
1 3 2 4 5
```

**Output**

```
First Unsorted Element: 2
```

(`2 < 3` at index `2` — first violation.)

**Sorted array**

```
Enter array elements:
1 2 2 4 5
```

**Output**

```
Array is already sorted.
```

---

### Solution

```java
import java.util.Scanner;

public class P5_FirstUnsortedElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        if (size > 0) {
            int[] arr = new int[size];
            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            int firstUnsortedElement = 0;
            boolean found = false;
            for (int i = 1; i < size; i++) {
                if (arr[i] < arr[i - 1]) {
                    firstUnsortedElement = arr[i];
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("First Unsorted Element: " + firstUnsortedElement);
            } else {
                System.out.println("Array is already sorted.");
            }
        } else {
            System.out.println("Invalid Size");
        }

        sc.close();
    }
}
```

---

### Logic

1. Read array (`size > 0`).
2. Start loop at `i = 1` (first element has no left neighbor to compare).
3. If `arr[i] < arr[i - 1]`, order breaks at `i`:
   - answer = `arr[i]`
   - set `found = true`, `break`
4. If loop ends without `found`, array is non-decreasing.

**Why `found` flag?** Avoid printing a wrong default when the array is sorted (especially `size == 1` or `size == 2` sorted).

---

### Dry Run

**Array:** `[1, 3, 2, 4, 5]`

| `i` | `arr[i]` | `arr[i-1]` | `arr[i] < arr[i-1]`? | Action |
|-----|----------|------------|----------------------|--------|
| `1` | `3` | `1` | No | continue |
| `2` | `2` | `3` | **Yes** | `found=true`, answer=`2`, **break** |

**Output:** `First Unsorted Element: 2`

**Sorted:** `[1, 2, 3]`

| `i` | Violation? |
|-----|------------|
| `1` | `2 < 1`? No |
| `2` | `3 < 2`? No |

No violation → `Array is already sorted.`

---

### Time and Space Complexity

| | Complexity |
|---|------------|
| **Time** | **O(n)** — one scan, early `break` on find |
| **Space** | **O(n)** — array |

---

### Edge Cases

| Case | Input | Output |
|------|--------|--------|
| Invalid size | `0` | `Invalid Size` |
| One element | `1`, `[7]` | `Array is already sorted.` |
| Two elements, sorted | `2`, `[1, 2]` | sorted message |
| Two elements, unsorted | `2`, `[2, 1]` | `First Unsorted Element: 1` |
| Duplicates OK | `[1, 2, 2, 3]` | sorted (`2 >= 2`) |
| Break at end | `[1, 2, 4, 3]` | `3` (`3 < 4` at index `3`) |

**Dry run — `size = 1`, `[7]`**

- Loop: `i = 1`, condition `1 < 1` is false → loop never runs.
- `found` stays `false` → sorted message. **No crash** on `arr[1]`.

---

### Optimizations

#### 1. Single unified loop (already applied)

Replaces separate checks for start, middle, and end.

#### 2. Return index instead of value (if required)

**Optimization code**

```java
int firstUnsortedIndex = -1;
for (int i = 1; i < size; i++) {
    if (arr[i] < arr[i - 1]) {
        firstUnsortedIndex = i;
        break;
    }
}

if (firstUnsortedIndex != -1) {
    System.out.println("First unsorted at index: " + firstUnsortedIndex
        + ", value: " + arr[firstUnsortedIndex]);
} else {
    System.out.println("Array is already sorted.");
}
```

#### 3. Extract method

```java
public static int firstUnsortedIndex(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] < arr[i - 1]) {
            return i;
        }
    }
    return -1;
}
```

---

## Quick Reference

| Problem | Core idea | Time | Space |
|---------|-----------|------|-------|
| P1 Average | Sum all, divide by n (float division) | O(n) | O(n) |
| P2 Linear Search | Scan until match, first index | O(n) | O(n) |
| P3 Pos/Neg Sum | Classify each element in one pass | O(n) | O(n) |
| P4 Count 0/1 | Increment counters per value | O(n) | O(n) |
| P5 First Unsorted | First `i` where `arr[i] < arr[i-1]` | O(n) | O(n) |

---

## How to Compile and Run

From the `ARRAYS` folder:

```bash
javac P1_AverageOfArray.java
java P1_AverageOfArray
```

Use the class name **without** `.class`:

```bash
java P2_LinearSearch
```

---

*Generated for the DSA-JAVA ARRAYS practice set.*
