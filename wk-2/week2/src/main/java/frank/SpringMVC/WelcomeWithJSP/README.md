# Working With JSP

This project demonstrates the use of Spring MVC with JSP to create a simple web application. It includes a welcome page and an extension to capture user input via a form.

---

## **Welcome Page**

The application starts with a welcome page (`welcome.jsp`) that displays a static message to the user.

### Features:
- Renders a welcome message: **"Welcome to Spring MVC with JSP!"**
- Implements `@GetMapping` to load the view.

---

## **Extension: Capturing User Input via Forms**

The application extends the functionality by adding a form on the welcome page to capture a user's name. Upon form submission, a personalized greeting is displayed on a new page (`greeting.jsp`).

### Features:
1. **Form Submission**:
    - Captures the user's name via an HTML form.
    - Submits data via a `POST` request to the server.

2. **Personalized Greeting**:
    - Displays a custom greeting message using the submitted name.
    - Redirects to `greeting.jsp`.

---

## **Routes Table**

| HTTP Method | Route | Description                    | View          |
|-------------|-------|--------------------------------|---------------|
| `GET`       | `/`   | Displays the welcome page.     | `welcome.jsp` |
| `POST`      | `/`   | Handles form submission.       | `greeting.jsp`|

---
