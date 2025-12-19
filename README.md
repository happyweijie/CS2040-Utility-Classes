# CS2040 Utility Classes

A collection of Java utility classes specifically curated for [**CS2040 Data Structures and Algorithms**](https://nusmods.com/courses/CS2040/data-structures-and-algorithms) students. These classes build on the basic data structures to help you focus on solving lab problems rather than boilerplate code.

---

## Key Modules

### 1. Improved Kattio Class
Standard `Scanner` is often too slow for certain lab assignments. Kattis' `Kattio` class provides a faster alternative compared to using `BufferedReader` and `BufferedWriter`.

 I have improved `Kattio` by adding a `readLine` method required for certain labs. Now `Kattio` can serve as a replacement for `BufferedReader` for all lab assignments.

* **Initialization**: Create a Kattio instance: `Kattio io = new Kattio(System.in, System.out);`
* **Getting User Input**: Use `getInt`, `getLong`, `getDouble`, `getWord` and `readLine` to take in user input. `hasMoreTokens` is also useful for cases where input may not have a specified number of lines.
* **Output**: Use `print` or `println` to print output as needed.
* **Usage Tip**: Always call `io.flush()` and `io.close()` at the end of your `main` method to ensure all output is written.

### 2. Geometry Primitives (`Point`)
A 2D point class designed to handle floating-point precision issues using a defined threshold of $1 \times 10^{-15}$.

* **Distance Metrics**: Supports both Euclidean (`distanceTo`) and Manhattan (`manhattanDistanceTo`) distances.
* **Geometric Logic**: Includes methods for calculating gradients between points and absolute X-coordinates.
* **Sorting**: Implements `Comparable` interface to allow for deterministic sorting, sorting first based on X-coordinates then Y-coordinates.

### 3. Graph & Data Modeling Classes
These classes are essential for representing edges and adjacency information in graph algorithms like Dijkstra’s, Prim’s, or Kruskal’s.

| Class | Components | Typical Use Case |
| :--- | :--- | :--- |
| **`IntegerPair`** | `weight`, `v` | Adjacency list entries for weighted graphs. |
| **`IntegerTriple`** | `weight`, `u`, `v` | Edge lists for Kruskal’s MST algorithm. |
| **`PointPair`** | `weight`, `Point v` | Graph algorithms where nodes are geometric coordinates. |
| **`PointTriple`** | `weight`, `Point u`, `Point v` | Representing weighted edges between two `Point` objects. |
| **`Pair<T, U>`** | Generic `t`, `u` | A simple Java Record for lightweight data grouping. |

---

## 🛠️ Implementation Details

### Precision Handling
In Java, comparing doubles directly with `==` leads to errors due to precision. These classes utilize a `THRESHOLD` (epsilon) for comparisons:

```java
// Example from Point.java
if (Math.abs(point.x - this.x) < 1E-15) {
    // X-coordinates are considered equal
}
```

### OOP Principles & Immutability
Following the Object-Oriented Programming principles taught in [**CS2030 Programming Methodology II**](https://nusmods.com/courses/CS2030/programming-methodology-ii), these classes are designed to be **immutable**. Attributes are marked as `private` and `final` to prevent side effects, with access provided through getter methods. 

Feel free to modify the source code as required depending on whatever your specific needs.

Take Care :)
