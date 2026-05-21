# Ecommerce API

A Spring Boot ecommerce backend application with authentication, products, cart, and order management.

## Live Demo

API Base URL: `https://ecommerce-production-xxxx.up.railway.app`
Swagger UI: `https://ecommerce-production-xxxx.up.railway.app/swagger-ui/index.html`

## Features

- User authentication with JWT
- Product management
- Shopping cart
- Order processing
- Role-based access control
- REST API endpoints
- Unit testing with JUnit and Mockito

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JWT
- Maven
- PostgreSQL
- JUnit 5
- Mockito

## Setup Instructions

### Clone the repository

```bash
git clone https://github.com/SamTeng22/ecommerce
```

### Navigate to the project

```bash
cd ecommerce
```

### Configure the database

Update the `application.properties` file:

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### Run the application

```bash
mvn spring-boot:run
```

## Running Tests

```bash
mvn test
```

## Running with Docker

Make sure Docker Desktop is running, then:

```bash
docker-compose up --build
```

The app will be available at `http://localhost:8080`
API docs at `http://localhost:8080/swagger-ui/index.html`

To stop:

```bash
docker-compose down
```

### API Documentation

Once running, visit the interactive API docs at:
http://localhost:8080/swagger-ui/index.html

## API Endpoints

| Method | Endpoint                     | Description                  | Access        |
| ------ | ---------------------------- | ---------------------------- | ------------- |
| GET    | /api/products                | Get all products             | Public        |
| GET    | /api/products/{id}           | Get product by ID            | Public        |
| POST   | /api/products                | Create a product             | Admin         |
| PUT    | /api/products/{id}           | Update a product by ID       | Admin         |
| DELETE | /api/products/{id}           | Delete a product by ID       | Admin         |
| GET    | /api/orders                  | Get all of user's orders     | Authenticated |
| GET    | /api/orders/{orderId}        | Get an order by ID           | Authenticated |
| POST   | /api/orders/checkout         | Checkout of an order         | Authenticated |
| PUT    | /api/orders/{orderId}/status | Update an order's status     | Admin         |
| POST   | /api/auth/login              | Login                        | Public        |
| POST   | /api/auth/register           | Register                     | Public        |
| GET    | /api/cart                    | Get cart contents            | Authenticated |
| POST   | /api/cart/items              | Add item to cart             | Authenticated |
| DELETE | /api/cart/items/{cartItemId} | Delete an item from the cart | Authenticated |
| GET    | /api/categories              | Get all categories           | Public        |
| GET    | /api/categories/{id}         | Get category by ID           | Public        |
| POST   | /api/categories              | Create a category            | Admin         |
| PUT    | /api/categories/{id}         | Update a category by ID      | Admin         |
| DELETE | /api/categories/{id}         | Delete a category by ID      | Admin         |

## Author

Samantha Teng
