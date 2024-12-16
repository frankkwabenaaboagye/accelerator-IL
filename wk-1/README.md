## Solution
- [./IL-Week-1/README.md](./IL-Week-1/README.md)

## Exercises
* [Advanced Java Features (Object-Oriented Programming, Generics, Collections Framework)](#advanced-java-features-object-oriented-programming-generics-collections-framework)

   - [#1: Implement a Design Pattern](#implement-a-design-pattern)
   - [#2: Leverage Inner Classes for Data Encapsulation](#leverage-inner-classes-for-data-encapsulation)
   - [#3: Create a Generic Method for Data Validation](#create-a-generic-method-for-data-validation)
   - [#4: Design a Generic Class for Stack Data Structure](#design-a-generic-class-for-stack-data-structure)
   - [#5: Implement a Thread-Safe Cache using ConcurrentHashMap](#implement-a-thread-safe-cache-using-concurrenthashmap)
   - [#6:  Process a Collection using Stream API and Custom Comparator](#process-a-collection-using-stream-api-and-custom-comparator)

* [Exception Handling in Java: Advanced Concepts](#exception-handling-in-java-advanced-concepts)

   - [#1: Handling Checked and Unchecked Exceptions](#handling-checked-and-unchecked-exceptions)
   - [#2: Utilizing Nested Try-Catch Blocks](#utilizing-nested-try-catch-blocks)
   - [#3: Releasing Resources with finally Block](#releasing-resources-with-finally-block)
   - [#4: Creating a Custom Exception](#creating-a-custom-exception)


* [Java Concurrency (Multithreading) - Advanced Concepts](#java-concurrency-multithreading---advanced-concepts)

   - [#1: Implement a Thread Pool for Image Processing](#implement-a-thread-pool-for-image-processing)
   - [#2: Synchronized Block for Updating a Shared Counter](#synchronized-block-for-updating-a-shared-counter)
   - [#3: Deadlock Example and Prevention](#deadlock-example-and-prevention)


* [Advanced Data Structures (Trees & Graphs)](#advanced-data-structures-trees--graphs)

   - [#1: Implement a Balanced Binary Search Tree (AVL Tree)](#implement-a-balanced-binary-search-tree-avl-tree)
   - [#2: Utilize a Heap for Task Scheduling](#utilize-a-heap-for-task-scheduling)
   - [#3: Build a Trie for Autocomplete Functionality](#build-a-trie-for-autocomplete-functionality)
   - [#4: Implement Depth-First Search (DFS) on a Graph](#implement-depth-first-search-dfs-on-a-graph)


* [Advanced Algorithms: Greedy Algorithms and Dynamic Programming](#advanced-algorithms-greedy-algorithms-and-dynamic-programming)

   - [#1: Implement a Greedy Algorithm for the Fractional Knapsack Problem](#implement-a-greedy-algorithm-for-the-fractional-knapsack-problem)
   - [#2: Solve the Longest Common Subsequence (LCS) Problem using Dynamic Programming](#solve-the-longest-common-subsequence-lcs-problem-using-dynamic-programming)


---

### Advanced Java Features (Object-Oriented Programming, Generics, Collections Framework)

1. #### Implement a Design Pattern
- Choose a design pattern like Factory Method or Strategy.
- Design a real-world scenario applicable to the chosen pattern and implement it in Java using classes and methods.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)

2. #### Leverage Inner Classes for Data Encapsulation
- Create a class with an inner class to encapsulate helper functionality or data related to the outer class.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)


3. #### Create a Generic Method for Data Validation
- Implement a generic method that can validate different data types (e.g., numbers, strings) based on specific criteria.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)


4. #### Design a Generic Class for Stack Data Structure
- Create a generic Stack class that can hold objects of any data type, utilizing generics for type safety.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)

5. #### Implement a Thread-Safe Cache using ConcurrentHashMap
- Design a simple in-memory cache using ConcurrentHashMap to store key-value pairs with thread safety considerations.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)

6. #### Process a Collection using Stream API and Custom Comparator
- Choose a collection of data (e.g., list of objects).
- Implement a custom comparator to sort the collection based on specific criteria.
- Utilize the Stream API to filter, transform, and process elements within the sorted collection.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)

---

### Exception Handling in Java: Advanced Concepts

1. #### Handling Checked and Unchecked Exceptions
- Create methods that throw both checked and unchecked exceptions.
- Implement try-catch blocks to handle these exceptions appropriately, demonstrating the difference in handling requirements.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)

2. #### Utilizing Nested Try-Catch Blocks
- Simulate a scenario where you might need to handle multiple exceptions within nested code blocks.
- Implement nested try-catch blocks to catch specific exceptions at different levels of your code.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)

3. #### Releasing Resources with finally Block
- Create a method that opens a file for reading.
- Use a try-catch block to handle potential IOException while reading the file.
- Ensure the file is closed using a finally block, regardless of exceptions.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)

4. #### Creating a Custom Exception
- Design a scenario where a custom exception would be beneficial for your application.
- Create a custom exception class extending an appropriate base class (e.g., `RuntimeException`).
- Throw your custom exception within your code and handle it using a try-catch block.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)


---

### Java Concurrency (Multithreading) - Advanced Concepts
1. #### Implement a Thread Pool for Image Processing
- Simulate processing multiple images concurrently using a thread pool.
- Utilize an ExecutorService and create separate tasks for processing each image.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)
2. #### Synchronized Block for Updating a Shared Counter
- Create a class with a shared counter variable and a method to increment it.
- Implement a synchronized block to ensure thread safety when updating the counter variable.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)
3. #### Deadlock Example and Prevention
- Simulate a deadlock scenario involving two threads and two resources.
- Analyze the deadlock and modify your code to avoid it using proper lock ordering.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)


---

### Advanced Data Structures (Trees & Graphs)
1. ####  Implement a Balanced Binary Search Tree (AVL Tree)
- Design and implement an AVL Tree class with methods for insertion, deletion, and searching.
- Explore balancing operations (rotations) to maintain AVL Tree properties for efficient search and insertion.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)
2. #### Utilize a Heap for Task Scheduling
- Simulate a task scheduling scenario where tasks have priorities.
- Implement a Min Heap (priority queue) to efficiently schedule tasks based on their priority.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)
3. #### Build a Trie for Autocomplete Functionality
- Design a Trie data structure to store a set of words.
- Implement methods to search for prefixes and retrieve words that start with a given prefix.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)
4. ####  Implement Depth-First Search (DFS) on a Graph
- Represent a graph using an adjacency list or adjacency matrix.
- Implement a DFS algorithm to traverse all nodes in the graph, exploring connected nodes recursively.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)
5. ####  Find the Shortest Path with Dijkstra's Algorithm
- Design a scenario with a weighted graph representing a road network.
- Implement Dijkstra's algorithm to find the shortest path between two nodes in the graph based on edge weights (distances).
- [./IL-Week-1/README.md](./IL-Week-1/README.md)
6. ####  Calculate Minimum Spanning Tree with Prim's Algorithm
- Create a weighted graph representing connections between cities.
- Implement Prim's algorithm to find the minimum spanning tree that connects all cities with minimal total connection cost.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)

---

### Advanced Algorithms: Greedy Algorithms and Dynamic Programming
1. #### Implement a Greedy Algorithm for the Fractional Knapsack Problem
- Design a solution for the fractional knapsack problem, where you can take portions of items.
- Implement a greedy algorithm that prioritizes items with the highest value-to-weight ratio to 
   - fill the knapsack as much as possible while staying within the weight limit.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)
2. #### Solve the Longest Common Subsequence (LCS) Problem using Dynamic Programming
- Create a dynamic programming solution for finding the LCS of two given strings.
- Utilize a table to store solutions to subproblems (overlapping subsequences) and efficiently construct the LCS string.
- [./IL-Week-1/README.md](./IL-Week-1/README.md)
