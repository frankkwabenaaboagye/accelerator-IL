
## Singleton
- `Private static instance`: The instance variable holds the single instance of the Logger class.
- `Private constructor` 🔒 : This prevents any external class from instantiating the Logger directly.
- `Thread-safe singleton initialization` 🧵🔐: The `getInstance()` method is thread-safe, ensuring that only one instance is created even in multi-threaded environments. The synchronized block inside the method ensures that only one thread can initialize the instance at a time.
- `Logging methods`: The `log()` method simply prints log messages to the console. Additional methods (`info()`, `error()`) have been added for different log levels.

## Factory Method
- `Shape Interface`: The base interface for all shapes.
- `Circle and Square`: Concrete implementations of Shape.
- `ShapeFactory`: A factory class that creates the correct shape based on input.
- DrawingPanel: A JPanel used to render the shapes.
- UML class diagram

```plaintext
+--------------------+
|      Shape         | <-------------+  
+--------------------+               |
| +draw(g: Graphics) |               |
+--------------------+               |
         ^                           |
         |                           |
+------------------+    +------------------+
|     Circle       |    |     Square       |
+------------------+    +------------------+
| +draw(g, x, y)   |    | +draw(g, x, y)   |
+------------------+    +------------------+
         ^                          ^
         |                          |
+-------------------+    +----------------------+
|  ShapeFactory     |----|  DrawingPanel        |
+-------------------+    +----------------------+
| +getShape()       |    | +paintComponent(g)   |
+-------------------+    +----------------------+

```

## Abstract Factory
- Structure
    - `Abstract Products` - Interfaces for the UI components (Button, Checkbox).
    - `Concrete Products` - Platform-specific implementations of the UI components.
    - `Abstract Factory` - Interface to create abstract products.
    - `Concrete Factories` - Platform-specific factories that instantiate concrete products.
    - Client - The code that interacts with the abstract factory to create platform-specific components.
- class digram
```plaintext
           +-------------------+
           |    UIFactory      |<----------------------------------+
           |-------------------|                                   |
           | + createButton()   |                                  |
           | + createCheckbox() |                                  |
           +-------------------+                                   |
                ^    ^                                             |
                |    |                                             |
 +-----------------+  +------------------+              +------------------+
 |  WindowsUIFactory|  |  MacOSUIFactory  |              |   Client        |
 +-----------------+  +------------------+              +------------------+
 | + createButton() |  | + createButton()  |             | - button        |
 | + createCheckbox()|  | + createCheckbox()|            | - checkbox      |
 +-----------------+  +------------------+               | + renderUI()    |
          |                   |                         +------------------+
          |                   |
 +-------------------+  +-------------------+
 | WindowsButton     |  | MacOSButton       |
 +-------------------+  +-------------------+
 | + render()        |  | + render()        |
 +-------------------+  +-------------------+
          |                   |
 +-------------------+  +-------------------+
 | WindowsCheckbox   |  | MacOSCheckbox     |
 +-------------------+  +-------------------+
 | + render()        |  | + render()        |
 +-------------------+  +-------------------+


```