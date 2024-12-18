# ToDo App

This project is a simple ToDo application built with Spring Boot and JSP. 
It allows users to view, add, and mark tasks as completed. The application uses H2 in-memory database and 
implements basic CRUD operations for ToDo items.

## Features
- **View ToDo List**: Displays a list of all ToDo items.
- **Add ToDo Item**: Allows users to add new tasks to the list.
- **Mark As Complete**: Users can mark tasks as completed.

## Technologies
- **Spring Boot**: Backend framework.
- **Spring Data JPA**: For interacting with the H2 database.
- **JSP**: For rendering views.
- **H2 Database**: In-memory database for data persistence.


## Routes

| HTTP Method | Route                           | Description                           |
|-------------|---------------------------------|---------------------------------------|
| GET         | /todos                          | Displays the list of all ToDo items. |
| POST        | /todo/add                       | Adds a new ToDo item.                |
| GET         | /todo/complete/{id}             | Marks a specific ToDo item as completed. |

## Configuration
The application uses an H2 in-memory database, configured to close the database after the application exits.

```java
dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
