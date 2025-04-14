# Part - 1 & Part 2: Java Performance Optimization & Memory Management & Garbage Collection
- Summary:

    This section focuses on techniques to identify and improve the performance of your
    Java applications.

- Key Theory:
    - Performance Bottlenecks:
        - Areas in your code that slow down application execution.
        - Common bottlenecks include inefficient algorithms, database queries, and
        excessive object creation.
    - Profiling Tools:
        - Help identify performance bottlenecks by measuring execution time and
        resource usage.
        - Examples include `JProfiler`, `YourKit`.
    - Performance Optimization Techniques:
        - Optimize algorithms and data structures for efficiency.
        - Minimize database interactions and use caching mechanisms.
        - Properly manage object creation and memory usage.
- Task:
    1. Choose a Java application to profile (e.g., existing project or sample application).
    2. Use a profiling tool to identify performance bottlenecks in your application.
    3. Implement performance optimization techniques based on profiling results.
    4. Re-run the profile and measure the performance improvements achieved.
- Task:
    1. Review the basics of Java memory management and garbage collection.
    2. Analyze common scenarios that can lead to memory leaks in Java applications.
    3. Explore tools like VisualVM for monitoring memory usage and GC activity.
    4. Implement techniques to avoid memory leaks in your Java code (e.g., closing
    resources properly).
    
- Solution
    - [./part1/README.md](./part1/README.md)


# Part 3: Testing Frameworks (JUnit & Selenium)
- Task
    1. Set up JUnit in your Java project for unit testing.
    2. Write unit tests for your chosen application (e.g., test individual methods or
    functionalities).
    3. Explore Selenium for web UI automation.
    4. Write Selenium tests to automate basic interactions with a web application
    (optional).

- Solutions
    - [./TestingFrameworks/README.md](./TestingFrameworks/README.md)


# Part 4: CI/CD with Jenkins
- Task
    1. Set up a Jenkins server (local or cloud-based).
    2. Create a CI/CD pipeline in Jenkins for your Java application.
    3. Integrate your code repository (e.g., Git) with Jenkins for automatic builds upon
    code changes.
    4. Configure Jenkins jobs for building, testing (using JUnit), and optionally deploying
    your application.

- Solution
    - [./]