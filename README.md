# Zomato Clone App

A simple Zomato-like food delivery application built with React JS (Frontend) and Spring Boot (Backend).

## Project Structure

```
Zomato_APP/
├── frontend/                 # React JS UI
│   ├── src/
│   │   ├── components/      # Reusable components (Header, RestaurantCard)
│   │   ├── pages/           # Page components (Home, RestaurantDetail, Order)
│   │   ├── App.js
│   │   └── index.js
│   ├── public/
│   │   └── index.html
│   └── package.json
│
└── backend/                  # Spring Boot REST API
    ├── src/main/java/com/zomato/clone/
    │   ├── controller/      # REST Controllers
    │   ├── service/         # Business logic
    │   ├── model/           # Entity models
    │   ├── repository/      # Data access
    │   ├── config/          # Configuration & data initialization
    │   └── ZomatoCloneApplication.java
    ├── src/main/resources/
    │   └── application.properties
    └── pom.xml
```

## Features

### Frontend (React)
- ✅ Browse all restaurants
- ✅ View restaurant details and menu
- ✅ Add/remove items from cart
- ✅ Quantity adjustment
- ✅ Place orders
- ✅ View order history
- ✅ Responsive design
- ✅ Clean and intuitive UI

### Backend (Spring Boot)
- ✅ REST API for all operations
- ✅ Restaurant management
- ✅ Food/Menu management
- ✅ Order management
- ✅ CORS enabled for frontend integration
- ✅ H2 in-memory database
- ✅ Automatic sample data initialization

## Getting Started

### Prerequisites

**Backend:**
- Java 17 or higher
- Maven 3.6.0 or higher

**Frontend:**
- Node.js 14 or higher
- npm 6 or higher

### Backend Setup

1. Navigate to the backend folder:
```bash
cd backend
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

Sample data will be automatically initialized with 4 restaurants and 16 food items.

### Frontend Setup

1. Navigate to the frontend folder:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm start
```

The frontend will open on `http://localhost:3000`

## API Documentation

### Base URL
```
http://localhost:8080/api
```

### Restaurants
- `GET /restaurants` - Get all restaurants
- `GET /restaurants/{id}` - Get restaurant by ID
- `POST /restaurants` - Create restaurant
- `PUT /restaurants/{id}` - Update restaurant
- `DELETE /restaurants/{id}` - Delete restaurant

### Foods
- `GET /foods` - Get all foods
- `GET /foods/restaurant/{restaurantId}` - Get foods by restaurant ID
- `GET /foods/{id}` - Get food by ID
- `POST /foods` - Create food
- `PUT /foods/{id}` - Update food
- `DELETE /foods/{id}` - Delete food

### Orders
- `GET /orders` - Get all orders
- `GET /orders/{id}` - Get order by ID
- `POST /orders` - Create order
- `PUT /orders/{id}` - Update order
- `DELETE /orders/{id}` - Delete order

## Sample Data

The backend comes with pre-populated data:

**Restaurants:**
1. Pizza Hut - Italian, Pizza
2. Burger King - Fast Food, Burgers
3. Chow Chow - Chinese, Asian
4. South Indian Kitchen - South Indian, Dosa

**Foods:** 4 items per restaurant (Pizza, Burgers, Noodles, Dosa, etc.)

## Technologies Used

### Frontend
- React 18.2.0
- React Router 6.8.0
- Axios 1.3.0
- CSS3

### Backend
- Spring Boot 3.1.0
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## How to Use

1. **Browse Restaurants** - The home page displays all available restaurants
2. **View Menu** - Click on any restaurant to see its menu items
3. **Add to Cart** - Click "Add" button to add items to your cart
4. **Adjust Quantity** - Use +/- buttons to change quantity
5. **Checkout** - Click "Checkout" to place your order
6. **View Orders** - Navigate to "Orders" section to see your order history

## Project Architecture

### Frontend Architecture
- Component-based structure
- React Router for navigation
- Axios for HTTP requests
- CSS Modules for styling

### Backend Architecture
- Layered architecture (Controller → Service → Repository)
- REST API design
- JPA/Hibernate for ORM
- In-memory H2 database for development

## Future Enhancements

- User authentication and authorization
- Payment integration
- Real-time order tracking
- Restaurant ratings and reviews
- Search and filtering
- Address management
- Multiple delivery options
- Promotional codes
- Admin dashboard

## Troubleshooting

### Frontend can't connect to backend
- Ensure backend is running on port 8080
- Check CORS configuration in backend
- Clear browser cache and reload

### Backend won't start
- Ensure Java 17+ is installed
- Check port 8080 is not in use
- Run `mvn clean install` to resolve dependencies

### Sample data not loading
- Check application logs for errors
- Ensure H2 database is properly configured
- Restart the backend

## License

This project is open source and available for educational purposes.

## Author

Created as a simple demonstration of full-stack web development with React and Spring Boot.

..

readme