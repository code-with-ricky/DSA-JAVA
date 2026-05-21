# Arrays — Problem Guide (P6 to P11)

This document explains programs **P6–P11** in the `ARRAYS` folder: problem statement, sample I/O (at least 2 per problem), approaches (brute force → better → optimized), dry runs, complexity per approach, edge cases, and reference solutions.

> **Note:** There is **no `P8`** file in the repository. This guide covers **P6, P7, P9, P10, P11** and marks P8 as skipped.

---

## Table of Contents

1. [P6 — Reverse Array](#p6--reverse-array)
2. [P7 — Shift Array by 1 Position](#p7--shift-array-by-1-position)
3. [P9 — Print Extremes in Alternate Order](#p9--print-extremes-in-alternate-order)
4. [P10 — Highest & Lowest Frequency Elements](#p10--highest--lowest-frequency-elements)
5. [P11 — Mode of Array](#p11--mode-of-array)
6. [Quick Reference](#quick-reference)

---

## P6 — Reverse Array

**File:** `P6_ReverseArray.java`

### Question

Given an array of `n` integers, **reverse** the array in place and print it.  
Example: `[1, 2, 3, 4]` → `[4, 3, 2, 1]`.

---

### Sample Input and Output

#### Example 1

**Input**

```
Enter size of array: 5
Enter array elements:
1 2 3 4 5
```

**Output**

```
Reversed array:
5 4 3 2 1
```

#### Example 2

**Input**

```
Enter size of array: 4
Enter array elements:
10 20 30 40
```

**Output**

```
Reversed array:
40 30 20 10
```

#### Example 3 (edge — single element)

| Input | Output |
|-------|--------|
| size `1`, `[42]` | `42` |

---

### Approaches

#### Method 1 — Brute force (extra array, forward fill)

Copy elements into a **new** array from end to start, then copy back or print the new array.

**Logic**

1. Create `rev[]` of size `n`.
2. For `i = 0` to `n-1`, set `rev[i] = arr[n - 1 - i]`.
3. Print `rev` (or copy into `arr`).

**Complexity**

| | Time | Space |
|---|------|-------|
| **Brute** | O(n) | O(n) extra array |

---

#### Method 2 — Better (swap using a loop index)

Use index `i` and swap `arr[i]` with `arr[n-1-i]` for `i` from `0` to `n/2-1` (same as two-pointer, written with index only).

**Logic**

```text
for i = 0 to (n/2 - 1):
    swap(arr[i], arr[n - 1 - i])
```

**Complexity**

| | Time | Space |
|---|------|-------|
| **Better** | O(n) | O(1) |

---

#### Method 3 — Optimized (two pointers) — **your solution**

Pointers `i` at start, `j` at end; swap and move until `i >= j`.

**Logic**

```text
i = 0, j = n - 1
while i < j:
    swap(arr[i], arr[j])
    i++, j--
```

**Complexity**

| | Time | Space |
|---|------|-------|
| **Optimized** | O(n) | O(1) |

This is the **best** approach for in-place reversal.

---

### Reference Solution (optimized — in repo)

```java
int i = 0, j = size - 1;
while (i < j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    i++;
    j--;
}
```

---

### Dry Run (two pointers)

**Input:** `[1, 2, 3, 4, 5]`

| Step | `i` | `j` | Array after swap |
|------|-----|-----|------------------|
| Start | 0 | 4 | `[1,2,3,4,5]` |
| Swap 0↔4 | 1 | 3 | `[5,2,3,4,1]` |
| Swap 1↔3 | 2 | 2 | `[5,4,3,2,1]` |
| `i < j` false | — | — | Done |

**Output:** `5 4 3 2 1`

---

### Edge Cases

| Case | Behavior |
|------|----------|
| `size = 0` | Loop `i<j` never runs; prints empty line (consider `size > 0` check) |
| `size = 1` | No swap; array unchanged ✓ |
| Odd / even length | Middle element (odd `n`) stays in place ✓ |

---

---

## P7 — Shift Array by 1 Position

**File:** `P7_ShiftArrayBy1Position.java`

### Question

Shift array elements by **one position**:

- **Left shift:** each element moves one index left; first element goes to the end.  
  `[1,2,3,4,5]` → `[2,3,4,5,1]`
- **Right shift:** each element moves one index right; last element goes to the front.  
  `[1,2,3,4,5]` → `[5,1,2,3,4]`

Your program performs **left shift first**, then **right shift** on the result (so you see both operations).

---

### Sample Input and Output

#### Example 1

**Input**

```
Enter size of array: 5
Enter array elements:
1 2 3 4 5
```

**Output**

```
Left Shifted array:
2 3 4 5 1
Right Shifted array:
1 2 3 4 5
```

*(Right shift on `[2,3,4,5,1]` restores original order.)*

#### Example 2

**Input**

```
Enter size of array: 4
Enter array elements:
10 20 30 40
```

**Output**

```
Left Shifted array:
20 30 40 10
Right Shifted array:
10 20 30 40
```

---

### Approaches — Left shift by 1

#### Method 1 — Brute force (new array)

Build `result[i] = arr[(i+1) % n]` or manually map indices.

**Complexity**

| | Time | Space |
|---|------|-------|
| **Brute** | O(n) | O(n) |

---

#### Method 2 — Better / Optimized (store first, shift left) — **your solution**

Save `arr[0]`, move `arr[i] = arr[i+1]` for `i = 0` to `n-2`, put saved value at `arr[n-1]`.

**Logic**

```text
first = arr[0]
for i = 0 to n-2: arr[i] = arr[i+1]
arr[n-1] = first
```

**Complexity**

| | Time | Space |
|---|------|-------|
| **Optimized** | O(n) | O(1) |

---

### Approaches — Right shift by 1

#### Method 1 — Brute force (new array)

`result[i] = arr[(i - 1 + n) % n]` or equivalent.

| | Time | Space |
|---|------|-------|
| **Brute** | O(n) | O(n) |

---

#### Method 2 — Optimized (store last, shift right) — **your solution**

```text
last = arr[n-1]
for i = n-1 down to 1: arr[i] = arr[i-1]
arr[0] = last
```

| | Time | Space |
|---|------|-------|
| **Optimized** | O(n) | O(1) |

---

#### Method 3 — Rotate trick (for **k** shifts, advanced)

Reverse whole array, reverse first `k`, reverse rest — useful for many left/right rotations in O(n) time, O(1) space. For **k = 1**, the linear shift above is simpler.

| | Time | Space |
|---|------|-------|
| **Reverse trick** | O(n) | O(1) |

---

### Reference Solution (in repo)

```java
// Left shift
int firstEle = arr[0];
for (int i = 0; i < size - 1; i++) {
    arr[i] = arr[i + 1];
}
arr[size - 1] = firstEle;

// Right shift
int lastEle = arr[size - 1];
for (int i = size - 1; i >= 1; i--) {
    arr[i] = arr[i - 1];
}
arr[0] = lastEle;
```

---

### Dry Run — Left shift

**Input:** `[1, 2, 3, 4, 5]`, `firstEle = 1`

| `i` | Action | Array |
|-----|--------|-------|
| 0 | `arr[0]=arr[1]` | `[2,2,3,4,5]` |
| 1 | `arr[1]=arr[2]` | `[2,3,3,4,5]` |
| 2 | `arr[2]=arr[3]` | `[2,3,4,4,5]` |
| 3 | `arr[3]=arr[4]` | `[2,3,4,5,5]` |
| end | `arr[4]=1` | `[2,3,4,5,1]` |

---

### Edge Cases

| Case | Left shift | Right shift |
|------|------------|-------------|
| `size = 1` | No change | No change |
| `size = 0` | Avoid reading elements | Add validation |
| `size = 2`, `[1,2]` | `[2,1]` | `[2,1]` left → `[1,2]` right |

---

---

## P9 — Print Extremes in Alternate Order

**File:** `P9_PrintExtremesInAlternate.java`

### Question

Print array elements in **alternate order from both ends**: first, last, second, second-last, … until all elements are printed.

Example: `[1, 2, 3, 4, 5]` → `1 5 2 4 3`  
Example: `[1, 2, 3, 4]` → `1 4 2 3`

---

### Sample Input and Output

#### Example 1

**Input**

```
Enter size of array: 5
Enter array elements:
1 2 3 4 5
```

**Output**

```
1 5 2 4 3
```

#### Example 2

**Input**

```
Enter size of array: 6
Enter array elements:
10 20 30 40 50 60
```

**Output**

```
10 60 20 50 30 40
```

#### Example 3 (even length)

| Input | Output |
|-------|--------|
| `4`, `[1,2,3,4]` | `1 4 2 3` |

---

### Approaches

#### Method 1 — Brute force (extra result array)

1. Two pointers `i`, `j`.
2. Append `arr[i]`, then `arr[j]` to a `List` or new array until `i > j`.
3. Print the list.

**Complexity**

| | Time | Space |
|---|------|-------|
| **Brute** | O(n) | O(n) for output storage |

---

#### Method 2 — Better (two pointers, print on the fly)

Same as optimized — no extra storage; print during traversal.

**Logic**

```text
i = 0, j = n - 1
while i <= j:
    print arr[i], arr[j]
    i++, j--
```

When `i == j` (odd length), the middle element is printed **once** (as `arr[i]` and `arr[j]` are the same index — you print it twice in current code; see edge note below).

**Complexity**

| | Time | Space |
|---|------|-------|
| **Better / Optimized** | O(n) | O(1) |

---

### Reference Solution (in repo)

```java
int i = 0, j = size - 1;
while (i <= j) {
    System.out.print(arr[i] + " " + arr[j] + " ");
    i++;
    j--;
}
```

---

### Dry Run

**Input:** `[1, 2, 3, 4, 5]`

| Step | `i` | `j` | Print |
|------|-----|-----|-------|
| 1 | 0 | 4 | `1 5` |
| 2 | 1 | 3 | `2 4` |
| 3 | 2 | 2 | `3 3` |

**Output:** `1 5 2 4 3 3` — middle `3` printed twice when `i == j`.

**Fix (concept):** When `i == j`, print only `arr[i]` once:

```text
if (i == j) print arr[i]
else print arr[i], arr[j]
```

For **even** `n`, `i` never equals `j` when loop ends correctly → `1 4 2 3` is correct.

---

### Edge Cases

| Case | Output pattern |
|------|----------------|
| `size = 1` | Single element printed twice with current code (`5 5`) — use `i == j` check |
| Odd length | Middle may print twice — refine with `if (i < j)` / `else if (i == j)` |
| `size = 0` | No output; validate `size > 0` |

---

---

## P10 — Highest & Lowest Frequency Elements

**File:** `P10_highest_lowest_frequency_elements.java`

### Question

Given an array, find:

1. An element with **highest frequency** (most occurrences).
2. An element with **lowest frequency** (fewest occurrences).

On **ties**, your repo solution uses **first appearance in the array** (`LinkedHashMap` order).

---

### Sample Input and Output

#### Example 1

**Input**

```
Enter size of array: 6
Enter array elements:
1 2 2 3 3 3
```

**Output**

```
Highest Frequency Element: 3 (frequency: 3)
Lowest Frequency Element: 1 (frequency: 1)
```

#### Example 2

**Input**

```
Enter size of array: 4
Enter array elements:
1 1 2 2
```

**Output**

```
Highest Frequency Element: 1 (frequency: 2)
Lowest Frequency Element: 1 (frequency: 2)
```

*(Same element can win both when only two distinct values share max and min in a tie sense — here both freqs are 2; first in map order is `1`.)*

#### Example 3 (invalid)

| Input | Output |
|-------|--------|
| `size = 0` | `Size of array cannot be negative or zero` |

---

### Approaches

#### Method 1 — Brute force (count each distinct element)

For each index `i`, count how many times `arr[i]` appears in the full array (avoid double-counting same value by only counting when `i` is first occurrence, or use nested loops over all pairs).

**Logic (concept)**

```text
for each distinct value v:
    count = 0
    for each element x in arr:
        if x == v: count++
    update max/min frequency and element
```

**Complexity**

| | Time | Space |
|---|------|-------|
| **Brute** | O(n²) | O(1) or O(k) for distinct set |

---

#### Method 2 — Better (sort + scan)

Sort array, traverse and count **runs** of equal values (e.g. `1,1,2,2,3` → frequencies 2,2,1).

**Complexity**

| | Time | Space |
|---|------|-------|
| **Better** | O(n log n) | O(1) if sort in-place, else O(n) |

---

#### Method 3 — Optimized (HashMap / LinkedHashMap) — **your solution**

1. One pass: build frequency map.
2. One pass over `entrySet`: track max count + element, min count + element.

**Complexity**

| | Time | Space |
|---|------|-------|
| **Optimized** | O(n) | O(k), k = distinct elements |

---

### Reference Solution (in repo)

```java
Map<Integer, Integer> freq = new LinkedHashMap<>();
for (int i = 0; i < size; i++) {
    int x = in.nextInt();
    freq.put(x, freq.getOrDefault(x, 0) + 1);
}

for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
    int ele = entry.getKey();
    int count = entry.getValue();
    if (count > highestFrequency) { /* update highest */ }
    if (count < lowestFrequency) { /* update lowest */ }
}
```

---

### Dry Run

**Input:** `[1, 2, 2, 3, 3, 3]`

**Frequencies:** `1→1`, `2→2`, `3→3`

| Key | Count | Highest (freq, ele) | Lowest (freq, ele) |
|-----|-------|---------------------|---------------------|
| 1 | 1 | (1, 1) | (1, 1) |
| 2 | 2 | (2, 2) | (1, 1) |
| 3 | 3 | (3, 3) | (1, 1) |

**Output:** Highest `3`, Lowest `1`

---

### Edge Cases

| Case | Note |
|------|------|
| All unique | All freq = 1; first key in map often wins both |
| One distinct value `[5,5,5]` | Highest = Lowest = `5` |
| Negative numbers | Works with `Integer` keys |
| Tie for highest | First in array order (`LinkedHashMap`) |

---

---

## P11 — Mode of Array

**File:** `P11_Mode_Of_Array.java`

### Question

The **mode** is the value that appears **most often**. If multiple values tie for the highest count, print **all** of them (your current program).

---

### Sample Input and Output

#### Example 1

**Input**

```
Enter size of array: 6
Enter array elements:
1 2 2 3 3 3
```

**Output**

```
Mode frequency: 3
Mode value(s): [3]
```

#### Example 2 (bimodal)

**Input**

```
Enter size of array: 4
Enter array elements:
1 1 2 2
```

**Output**

```
Mode frequency: 2
Mode value(s): [1, 2]
```

#### Example 3 (all unique)

**Input**

```
Enter size of array: 3
Enter array elements:
10 20 30
```

**Output**

```
Mode frequency: 1
Mode value(s): [10, 20, 30]
```

*(All tie; every distinct value is a mode.)*

---

### Approaches

#### Method 1 — Brute force

For each distinct value, count occurrences with an inner loop over the array. Track maximum frequency and all values that achieve it.

**Complexity**

| | Time | Space |
|---|------|-------|
| **Brute** | O(n²) | O(k) for list of modes |

---

#### Method 2 — Better (sort + linear scan)

After sorting, count consecutive equal elements; update max frequency and reset/collect modes when a higher run appears.

**Complexity**

| | Time | Space |
|---|------|-------|
| **Better** | O(n log n) | O(k) for modes list |

---

#### Method 3 — Optimized (HashMap, two passes) — **your solution**

**Pass 1:** Build `LinkedHashMap` frequencies.  
**Pass 2:** Find `highestFrequency`.  
**Pass 3:** Add every key with `count == highestFrequency` to `modes` list.

Can merge pass 2+3 in one loop over entries after max is known (your code uses two loops over entries — still O(k)).

**Complexity**

| | Time | Space |
|---|------|-------|
| **Optimized** | O(n) | O(k) |

---

### Single mode only (variant)

If you need **one** mode on tie (first in array):

```text
if (count > highestFrequency) update mode
```

Same as P10 highest-frequency logic.

---

### Reference Solution (all modes — in repo)

```java
// Pass 1: frequencies
for (int i = 0; i < size; i++) {
    int x = in.nextInt();
    freq.put(x, freq.getOrDefault(x, 0) + 1);
}

// Pass 2: max frequency
for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
    if (entry.getValue() > highestFrequency) {
        highestFrequency = entry.getValue();
    }
}

// Pass 3: collect all modes
for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
    if (entry.getValue() == highestFrequency) {
        modes.add(entry.getKey());
    }
}
```

---

### Dry Run (all modes)

**Input:** `[1, 1, 2, 2]`

| Step | Map / state |
|------|-------------|
| After read | `1→2`, `2→2` (insertion order) |
| Max freq | `2` |
| Collect | `count == 2` → keys `1` and `2` |

**Output:** `Mode value(s): [1, 2]`

---

### Edge Cases

| Case | Result |
|------|--------|
| `size <= 0` | Error message |
| Single element | One mode |
| All same | One mode |
| All unique | All elements in `modes` list |

---

---

## P8 — Not in repository

No `P8_*.java` file exists under `ARRAYS`. If you add it later (e.g. second largest, remove duplicates, merge sorted arrays), this section can be filled in the same format.

---

## Quick Reference

| Problem | Best approach | Time | Space |
|---------|---------------|------|-------|
| P6 Reverse | Two-pointer swap | O(n) | O(1) |
| P7 Left/right shift by 1 | Temp + linear shift | O(n) | O(1) |
| P9 Alternate extremes | Two pointers, print | O(n) | O(1) |
| P10 High/low frequency | LinkedHashMap | O(n) | O(k) |
| P11 Mode (all) | LinkedHashMap + 2 scans | O(n) | O(k) |

| Problem | Brute time | Better time | Optimized time |
|---------|------------|-------------|----------------|
| P6 | O(n), O(n) space | O(n), O(1) | O(n), O(1) |
| P7 | O(n), O(n) space | O(n), O(1) | O(n), O(1) |
| P9 | O(n), O(n) space | O(n), O(1) | O(n), O(1) |
| P10 | O(n²) | O(n log n) | O(n) |
| P11 | O(n²) | O(n log n) | O(n) |

---

## How to Compile and Run

From the `ARRAYS` folder:

```bash
javac P6_ReverseArray.java
java P6_ReverseArray
```

Use the **class name** without `.class`:

```bash
java P11_Mode_Of_Array
```

---

*Generated for the DSA-JAVA ARRAYS practice set (P6–P11).*
