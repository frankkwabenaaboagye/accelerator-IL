# Week 2
- [Design Patterns: Mastering the Art of Reusable Object-Oriented Solutions](#design-patterns-mastering-the-art-of-reusable-object-oriented-solutions)
- [Unit Testing vs. Integration Testing with Mockito](#unit-testing-vs-integration-testing-with-mockito)
- [Integration Testing](#integration-testing)
- [Spring MVC: Building Flexible and Maintainable Web Applications](#spring-mvc-building-flexible-and-maintainable-web-applications)
- Lab: Building a Spring MVC Web Application with Database Integration

- [Solution - ./week2/README.md ](./week2/README.md)

---

## Design Patterns: Mastering the Art of Reusable Object-Oriented Solutions 
- Creational Patterns:
    - `Singleton`
        - Implement a Singleton class for a Logger that ensures only one instance exists and provides methods for writing log messages.
        - [Solution - ./week2/README.md ](./week2/README.md)
    - `Factory Method`
        - Design a Factory class that can create different types of Shape objects (e.g., Circle, Square) based on the provided type.
        - [Solution - ./week2/README.md ](./week2/README.md)
    - `Abstract Factory`
        - Implement an Abstract Factory that can create families of UI components (e.g., Button, Checkbox) for Windows and MacOS platforms.
        - [Solution - ./week2/README.md ](./week2/README.md)
- Structural Patterns:
    - `Adapter`
        - Create an Adapter class that allows you to use a legacy payment processing library with a modern API.
        - [Solution - ./week2/README.md ](./week2/README.md)
    - `Facade`
        - Develop a Facade class for a complex e-commerce order processing system, offering simplified methods for placing and managing orders.
        - [Solution - ./week2/README.md ](./week2/README.md)
- Behavioral Patterns:
    - `Strategy`
        - Design a Strategy interface for sorting algorithms (e.g., Bubble Sort, Quick Sort) and implement concrete classes for each algorithm.
        - [Solution - ./week2/README.md ](./week2/README.md)
    - `Observer`
        - Create a Subject (e.g., Weather Station) and Observer (e.g., Display) classes to demonstrate weather data updates being notified to registered displays.
        - [Solution - ./week2/README.md ](./week2/README.md)
    - `Template`
        - Design a Template Method for data encryption that defines the overall process (key generation, encryption, decryption) with specific steps implemented by subclasses for different encryption algorithms.
        - [Solution - ./week2/README.md ](./week2/README.md)


## Unit Testing vs. Integration Testing with Mockito
-  Unit Testing with Mockito
    - `Scenario`: Develop a class OrderServiceImpl that interacts with an OrderRepository to save orders.
    - `Unit Test`: Implement a unit test using JUnit to verify `OrderServiceImpl.saveOrder` method functionality.
        - Use Mockito to mock the `OrderRepository` interface.
        - Configure the mock to behave in a specific way (e.g., return a success flag when save is called).
        - Call saveOrder on the service and assert that the mock repository's save method is called with the correct order object
- [Solution - ./week2/README.md ](./week2/README.md)


## Integration Testing
- Common Integration Testing Strategies
    - `Big Bang Approach (Less Preferred)`:
        - Simulate a big bang approach by integrating a simple e-commerce application's frontend, backend logic, and database layer all at once. 
        - Write basic integration tests to verify core functionalities like product browsing and order placement. 
        - While this may uncover major issues quickly, pinpoint the root cause of failures can be difficult.
    - `Top-Down Approach`:
        - Design a scenario for a library management system. Start by testing high-level functionalities like searching for books and managing user accounts with stubs for lower-level modules like database access. 
        - Gradually replace stubs with real database interactions as you move down the layers. This helps isolate errors in higher-level logic.
    - `Bottom-Up Approach`:
        - Develop a social media application. Begin by creating unit tests for individual modules like user profile management and news feed retrieval. 
        - Then, integrate these modules into a smaller group (e.g., profile management and user login) to test their interaction.
        - Progressively build upon these successes to integrate larger groups of modules. This approach offers good control over individual components but may miss higher-level integration issues.
    - `Hybrid Approach (Preferred)`:
        - Combine the top-down and bottom-up approaches for an inventory management system.
        - Test the high-level functionality of order processing with bottom-up assembled modules like product service and shopping cart, initially using stubs for external systems (e.g., payment gateway).
        - Gradually replace stubs with real integrations as you gain confidence. This provides a balance between control and efficiency.
- [Solution - ./week2/README.md ](./week2/README.md)

## Spring MVC: Building Flexible and Maintainable Web Applications
- Building a Simple Spring MVC Application:
    - Create a Spring MVC project to display a welcome message on the homepage ("/").
    - Develop a controller method with @RequestMapping("/") to handle GET requests.
    - Prepare a model with a message attribute and a view name (e.g., "welcome.jsp").
    - Configure a view resolver to map the logical view name `("welcome")` to a physical JSP file.
- Handling User Input with a Form:
    - Extend the previous to create a form on the welcome page to capture a user's name.
    - Implement a controller method with `@RequestMapping(value="/", method=RequestMethod.POST)` to handle form submissions (POST requests).
    - Access form data using request parameters in the controller method.
    - Update the model with the user's name and redirect to a new view (e.g., `"greeting.jsp"`) displaying a personalized greeting.

- [Solution - ./week2/README.md ](./week2/README.md)

## Building a Spring MVC Web Application with Database Integration
- Project Setup:
    - Use Maven to create a new Spring MVC project.
    - Include necessary Spring MVC dependencies in your pom.xml file (e.g., spring-webmvc, spring-jdbc).
    - Configure a datasource bean in your application context (e.g., using a DataSource interface implementation) to connect to your chosen database.
- Entity Model:
    - Define a Java class representing a "ToDo Item" with attributes like id, title, and completed.
    - Annotate this class with @Entity (from JPA) to mark it as a persistent entity that maps to a database table.
- Data Access Layer (DAO):
    - Create a DAO (Data Access Object) interface to define methods for CRUD (Create, Read, Update, Delete) operations on the ToDo items.
    - Implement the DAO using JPA repositories. Spring Data JPA provides convenient implementations for basic CRUD operations.
    - Inject the EntityManager bean (responsible for interacting with the database) into your DAO implementation.
- Controller:
    - Develop a Spring MVC controller class annotated with @Controller.
    - Define controller methods for handling user interactions:
        - `/todos`: List all available ToDo items (using the DAO to retrieve data).
        - `/todo/add`: Handle form submissions for adding new ToDo items (use DAO to persist the new item).
        - `/todo/complete/{id}`: Mark a specific ToDo item as complete by its ID (update the item in the database using DAO)
- Views:
    - Create JSP (or your preferred view technology) files for displaying the ToDo list and adding new items.
    - Use Spring MVC expressions (e.g., ${todos}) to access model data (list of ToDo items) in your views.
    - Utilize HTML forms for user input (adding new items) and submit them to appropriate controller methods.

- [Solution - ./week2/README.md](./week2/README.md)


