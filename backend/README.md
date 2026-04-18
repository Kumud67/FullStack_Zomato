# Zomato Clone - Backend

Spring Boot backend for the Zomato Clone application.

## Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

## Installation

```bash
mvn clean install
```

## Running the Application

```bash
mvn spring-boot:run
```

Or build and run the JAR:

```bash
mvn clean package
java -jar target/zomato-clone-1.0.0.jar
```

The application will run on `http://localhost:8080`

## Swagger UI Documentation

Access the interactive API documentation at:
```
http://localhost:8080/swagger-ui.html
```

OpenAPI JSON specification:
```
http://localhost:8080/v3/api-docs
```

The Swagger UI allows you to:
- View all available endpoints
- See request/response schemas
- Test API endpoints directly
- View detailed parameter and response information

## API Endpoints

### Restaurants
- `GET /api/restaurants` - Get all restaurants
- `GET /api/restaurants/{id}` - Get restaurant by ID
- `POST /api/restaurants` - Create new restaurant
- `PUT /api/restaurants/{id}` - Update restaurant
- `DELETE /api/restaurants/{id}` - Delete restaurant

### Foods
- `GET /api/foods` - Get all foods
- `GET /api/foods/restaurant/{restaurantId}` - Get foods by restaurant
- `GET /api/foods/{id}` - Get food by ID
- `POST /api/foods` - Create new food
- `PUT /api/foods/{id}` - Update food
- `DELETE /api/foods/{id}` - Delete food

### Orders
- `GET /api/orders` - Get all orders
- `GET /api/orders/{id}` - Get order by ID
- `POST /api/orders` - Create new order
- `PUT /api/orders/{id}` - Update order
- `DELETE /api/orders/{id}` - Delete order

## Features

- REST API for managing restaurants, foods, and orders
- H2 in-memory database for easy development
- CORS support for frontend integration
- Sample data initialization on startup
- Clean architecture with Service layer pattern

## Sample Data

The application automatically initializes with sample data:
- 4 Restaurants (Pizza Hut, Burger King, Chow Chow, South Indian Kitchen)
- 16 Food items across different categories
- Ready to place orders

## Technologies Used

- Spring Boot 3.1.0
- Spring Data JPA
- H2 Database
- Lombok
- Maven
