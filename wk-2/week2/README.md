# Solutions

- [Singleton](#singleton)
- [Factory Method](#factory-method)
- [Abstract Factory](#abstract-factory)
- [Adapter](#adapter)
- [Facade](#facade)
- [Strategy](#strategy)
- [Observer](#observer)
- [Template](#tempalate)
- [Unit Testing with Mockito](#unit-testing-with-mockito)
- [Basic Integration Testing](#basic-integration-testing)

---

## Singleton

- `Private static instance`: The instance variable holds the single instance of the Logger class.
- `Private constructor` 🔒 : This prevents any external class from instantiating the Logger directly.
- `Thread-safe singleton initialization` 🧵🔐: The `getInstance()` method is thread-safe, ensuring that only one instance is created even in multi-threaded environments. The synchronized block inside the method ensures that only one thread can initialize the instance at a time.
- `Logging methods`: The `log()` method simply prints log messages to the console. Additional methods (`info()`, `error()`) have been added for different log levels.
- 📂 [Solution - src/main/java/frank/DesignPatterns/creational/singleton/](src/main/java/frank/DesignPatterns/creational/singleton/)

## 🏭 Factory Method

- `Shape Interface`: The base interface for all shapes.
- `Circle and Square`: Concrete implementations of Shape.
- `ShapeFactory` 🛠️: A factory class that creates the correct shape based on input.
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

- 📂 [Solution - src/main/java/frank/DesignPatterns/creational/factorymethod/](src/main/java/frank/DesignPatterns/creational/factorymethod/)

## Abstract Factory

- Structure
  - `Abstract Products` - Interfaces for the UI components (🖲️ Button, ✅ Checkbox).
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

- 📂 [Solution - src/main/java/frank/DesignPatterns/creational/abstractfactory/ ](src/main/java/frank/DesignPatterns/creational/abstractfactory/)

## Adapter

- Structure
  - Legacy System:

    - The `LegacyPaymentProcessor` works with a processPayment method.
    - It accepts `customerId` and `amount` as input.

  - Adapter
    - The adapter "translates" the modern account number format to a format that the legacy system understands.
      - For example:
        - `MODERN12345` → `LEGACY12345`
    - If the payment amount is invalid (e.g., <= 0), it defaults to a small positive value.
    - Simulates a processing fee of $0.50 that might be required for the legacy system
- 📂 [src/main/java/frank/DesignPatterns/structural/adapater/](src/main/java/frank/DesignPatterns/structural/adapater/)

## 🎭 Facade

- The `OrderFacade` acts as a single point of entry for clients to perform tasks like placing an order, viewing the catalog, or checking product availability.
- Behind the scenes, the facade coordinates with the following subsystems:
  - Inventory System 📦
  - Payment System 💳
  - Shipping System 🚚
- Without Facade: The client would need to interact with each subsystem individually
- With Facade:The client calls a single method, such as placeOrder, and the OrderFacade handles everything internally

```plaintext
                                 +-----------------------------+
                                 |        OrderFacade          |
                                 |-----------------------------|
                                 | + displayCatalog()          |
                                 | + placeOrder()              |
                                 | + checkProductAvailability()|
                                 +-----------------------------+
                                              |   |   |
                               ----------------    |    -----------------
                              |                    |                    |
                 +-----------------+      +-----------------+      +----------------+
                 |   Inventory     |      |    Payment      |      |    Shipping    |
                 |-----------------|      |-----------------|      |----------------|
                 | + addProduct()  |      | + processPayment()|    | + shipProduct()|
                 | + isAvailable() |      |                 |      |                |
                 | + reduceStock() |      |                 |      |                |
                 +-----------------+      +-----------------+      +----------------+

                                              |
                                 +-----------------------------+
                                 |          Product            |
                                 |-----------------------------|
                                 | - id: String                |
                                 | - name: String              |
                                 | - type: String              |
                                 |-----------------------------|
                                 | + getId()                   |
                                 | + getName()                 |
                                 | + getType()                 |
                                 +-----------------------------+

                                              ^
                                              |
                                 +-----------------------------+
                                 |       FrankECommerceApp     |
                                 |-----------------------------|
                                 | - main(args: String[])      |
                                 |-----------------------------|
                                 |   Uses OrderFacade          |
                                 +-----------------------------+

```

- Client
  - `FrankECommerceApp` interacts only with the OrderFacade.
  - It does not need to interact with subsystems directly.
- 📂 [Solution - src/main/java/frank/DesignPatterns/structural/facade/](src/main/java/frank/DesignPatterns/structural/facade/)

## Strategy

- `Strategy Interface`: defines the `sort()` method, which is implemented by various sorting algorithms.
- `Concrete Strategies`: `BubbleSort` and `QuickSort` implement the SortStrategy interface and provide their respective sorting logic.
- `Context`: The SortingContext class maintains a reference to a SortStrategy object and delegates the sorting task to the strategy.

```plaintext
          +----------------------+
          |   SortStrategy       | <---- Interface
          +----------------------+
          | + sort(int[] array)  |
          +----------------------+
                    ^
                    |
         +----------+----------+
         |                     |
+-------------------+   +-------------------+
|   BubbleSort      |   |   QuickSort       |
+-------------------+   +-------------------+
| + sort(int[] array)|   | + sort(int[] array)|
+-------------------+   +-------------------+

                       ^
                       |
                       |
              +----------------------+
              |  SortingContext      |
              +----------------------+
              | - strategy: SortStrategy |
              +----------------------+
              | + setSortStrategy()   |
              | + sortArray(int[])    |
              +----------------------+

```

- [Solution - src/main/java/frank/DesignPatterns/behavioral/strategy/](src/main/java/frank/DesignPatterns/behavioral/strategy/)

## Observer

- The `WeatherStation` maintains a list of `observers` (`Display` objects).
- Whenever the temperature changes via `setTemperature()`, the WeatherStation calls `notifyObservers()` to update all registered Display objects.
- Each Display object implements Observer and responds to the `update()` method, printing the new temperature.
- A display can be removed from the list of observers via the `removeObserver()` method, and it will no longer receive updates when the temperature changes.

```plaintext
 +--------------------------+        1       +--------------------------+
 |     WeatherStation        |----------------|         Observer         |
 +--------------------------+                +--------------------------+
 | - observers: List<Observer> |               | + update(temp: float)    |
 | - temperature: float       |               +--------------------------+
 +--------------------------+                          ^
 | + setTemperature(temp: float): void |               |
 | + getTemperature(): float            |              |
 | + addObserver(o: Observer): void     |              |
 | + removeObserver(o: Observer): void  |              |
 | + notifyObservers(): void            |              |
 +--------------------------+                          |
          ^                                            |
          |                                            |
          |                                            |
          |                                            |
 +--------------------------+                +--------------------------+
 |       Display             |                |       ConcreteObserver   |
 +--------------------------+                +--------------------------+
 | - displayName: String     |                | - subject: WeatherStation |
 +--------------------------+                +--------------------------+
 | + update(temp: float)     |                | + update(temp: float)     |
 +--------------------------+                +--------------------------+

```

- 📂 [Solution - src/main/java/frank/DesignPatterns/behavioral/observer/](src/main/java/frank/DesignPatterns/behavioral/observer/)

## Tempalate

- `DataEncryption`: Abstract class defining the template method for data encryption
- `AESEncryption` (Concrete Class)
- `DESEncryption` (Concrete Class)
- `FrankEncryption` (Concrete Class)

```plaintext

                 +------------------+
                 |  DataEncryption  |
                 +------------------+
                 | +encryptData()   |
                 | +generateKey()   |
                 | +encrypt()       |
                 | +decryptData()   |
                 +------------------+
                         ^
                         |
     +-------------------+------------------+
     |                                      |
+-------------------+                  +------------------+
|  AESEncryption    |                  |   DESEncryption   |
+-------------------+                  +------------------+
| +generateKey()    |                  | +generateKey()    |
| +encrypt()        |                  | +encrypt()        |
| +decryptData()    |                  | +decryptData()    |
+-------------------+                  +------------------+
                         ^
                         |
                 +------------------+
                 |  FrankEncryption |
                 +------------------+
                 | +generateKey()   |
                 | +encrypt()       |
                 | +decryptData()   |
                 +------------------+

```

- 📂 [Solution - src/main/java/frank/DesignPatterns/behavioral/template/](src/main/java/frank/DesignPatterns/behavioral/template/)

## Unit Testing with Mockito

- `testSaveOrder_ShouldReturnTrue_WhenOrderIsSavedSuccessfully`
  - This test verifies that when an order is successfully saved (the repository returns true), the `saveOrder` method returns true.
- `testSaveOrder_ShouldReturnFalse_WhenOrderSaveFails`
  - This test verifies that if the order save fails (repository returns false), the `saveOrder` method returns false.
- 📂 [Solution - ./src/main/java/frank/UnitTestingwithMockitoIntegrationTesting/unit/](./src/main/java/frank/UnitTestingwithMockitoIntegrationTesting/unit/)
- 🔗 [Test] (src/test/java/frank/UnitTestingwithMockitoIntegrationTesting/unit/test/)

## Basic Integration Testing

- `testSaveOrder_ShouldPersistOrderInDatabase`:
  - The test validates the interaction between `OrderServiceImpl` and the `in-memory H2` database to ensure that Order entities are correctly persisted and retrieved.
- 📂 [Solution - ./src/main/java/frank/UnitTestingwithMockitoIntegrationTesting/integration/](./src/main/java/frank/UnitTestingwithMockitoIntegrationTesting/integration/)
- 🔗 [Test](./src/test/java/frank/UnitTestingwithMockitoIntegrationTesting/integration/)
