## 🚩 JVM Heap & GC Runtime Flags

### Key Heap Flags:

| Flag | Meaning |
| --- | --- |
| `-Xmx<size>` | Max heap size. E.g., `-Xmx16m` = 16MB. |
| `-Xms<size>` | Initial heap size. Prevents resizing. |
| `-Xmn<size>` | Size of Young Generation. Optional. |

---

### GC Flags:

| Flag | Meaning |
| --- | --- |
| `-XX:+UseG1GC` | Use G1 GC (default on Java 9+) |
| `-XX:+UseSerialGC` | Use Serial GC |
| `-XX:+UseParallelGC` | Use Parallel GC |
| `-XX:+UseConcMarkSweepGC` | Use CMS |
| `-XX:+UseZGC` | Use ZGC |
| `-verbose:gc` | Logs GC activity |
| `-XX:+PrintGCDetails` | Prints detailed GC info |
| `-XX:+PrintGCDateStamps` | Adds timestamp to GC logs |
| `-XX:+HeapDumpOnOutOfMemoryError` | Dumps heap to `.hprof` file when OOM happens |
| `-XX:HeapDumpPath=./dump.hprof` | Custom heap dump location |


## 🛠️ VisualVM Monitoring Recap

| Feature | What It Shows |
| --- | --- |
| **Heap graph** | Live memory usage |
| **GC Events** | When GC occurred |
| **Heap Dump** | Snapshot of all objects |
| **Threads** | What threads are running |
| **Classes** | How many classes are loaded |
| **Manual GC Button** | Forces GC manually |

### Scenario 4
- Memory Behavior Summary
- AnimalLeakCrash.java

| Round | Strings Added | Total Strings | Memory Status           |
| ----- | ------------- | ------------- | ----------------------- |
| 0     | 10            | 10            | Small heap usage        |
| 50    | 10            | 510           | Heap growing fast       |
| 100   | 10            | 1010          | GC struggles            |
| 100+  | 10            | 1000+         | 💥 **OutOfMemoryError** |

