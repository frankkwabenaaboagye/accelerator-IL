# SportSphere - E-Commerce Platform 🏀⚽🎾

## Overview 🌍
SportSphere is a sports e-commerce platform built with **Spring Boot** for the backend, **MongoDB** for data persistence, and **Angular** for the frontend. The system allows users to browse sports products, place orders, and manage products and orders.

This project follows the **Big Bang Approach** for integration testing, where all components (frontend, backend, and database) are tested simultaneously after initial development to ensure that all parts of the system work together cohesively.

---

## Technologies Used 🔧

### Backend:
- **Spring Boot**: Framework for building the backend services.
- **MongoDB**: NoSQL database for storing product and order data.
- **Spring Data MongoDB**: Repository support for MongoDB.
- **Spring Boot Test**: For writing integration tests.

### Frontend:
- **Angular**: Frontend framework for building a dynamic, client-side user interface.
- **HttpClient**: For making HTTP requests to the backend APIs.

---

## Project Structure 🗂️

### Backend:
1. **Model Classes**: Represent the core data entities (`Product`, `Order`).
2. **Controller Classes**: Handle HTTP requests for interacting with products and orders.
3. **Service Classes**: Implement business logic for product and order management.
4. **Repository Classes**: Handle database interactions using Spring Data MongoDB.
5. **Integration Tests**: Verify the system's functionalities with real interactions between components.

### Frontend:
1. **ProductComponent**: Displays and manages the products, allowing users to create, view, and delete products.
2. **OrderComponent**: Manages the order creation and deletion process.
3. **ProductService & OrderService**: Service classes to interact with backend APIs for products and orders.

---

## API Endpoints 🌐

| **Endpoint**                       | **Method** | **Description**                                    |
|------------------------------------|------------|----------------------------------------------------|
| `/products/read-all`               | `GET`      | Retrieve all products.                             |
| `/products/read?id={id}`           | `GET`      | Get a product by ID.                               |
| `/products/create`                 | `POST`     | Create a new product.                              |
| `/products/delete?id={id}`         | `DELETE`   | Delete a product by ID.                            |
| `/orders/read-all`                 | `GET`      | Retrieve all orders.                               |
| `/orders/read?id={id}`             | `GET`      | Get an order by ID.                                |
| `/orders/create`                   | `POST`     | Create a new order.                                |
| `/orders/delete?id={id}`           | `DELETE`   | Delete an order by ID.                             |

---

## Integration Testing 🔍

### Big Bang Approach 🎯

In this project, **Big Bang Integration Testing** was adopted. The **Big Bang Approach** tests the entire system by integrating all components (backend, database, and frontend) together at once. The goal is to test that the application as a whole functions as expected when all individual parts are connected and running.

### Key Features Tested:
1. **Product API Endpoints**:
   - Retrieve all products.
   - Retrieve a single product by ID.

2. **Order API Endpoints**:
   - Create a new order.

### Integration Test Flow 🚀

1. **Spring Boot Test Setup**:
   - The integration tests are written using **`@SpringBootTest`** and **`@AutoConfigureMockMvc`** to test the real application context with MockMvc, ensuring the backend APIs are correctly wired and functioning.
   
2. **MockMvc**:
   - **MockMvc** is used to simulate HTTP requests and validate responses, allowing tests to run without starting a full web server.

3. **Database Setup**:
   - Each test starts by clearing the product and order collections in MongoDB to ensure a clean slate before testing.
   
4. **Test Cases**:
   - **ProductControllerIntegrationTest**:
     - `testGetAllProducts`: Validates fetching all products from the `/products/read-all` endpoint.
     - `testGetProductById`: Validates fetching a specific product by its ID from the `/products/read` endpoint.
   
   - **OrderControllerIntegrationTest**:
     - `testPlaceOrder`: Verifies creating an order with the `/orders/create` endpoint.

5. **Assertions**:
   - The tests check that the responses from the API match the expected values, such as verifying product details (name, price) and order details (product ID, quantity).

---

