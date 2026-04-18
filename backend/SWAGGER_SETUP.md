# Swagger/OpenAPI Setup for Zomato Clone Backend

## Overview

Swagger/OpenAPI has been integrated into the Zomato Clone backend to provide interactive API documentation and testing capabilities.

## What's Added

### Dependencies
- `springdoc-openapi-starter-webmvc-ui` (v2.0.2) - Provides Swagger UI and OpenAPI 3.0 support

### Configuration
- `OpenAPIConfig.java` - Bean configuration for OpenAPI metadata
- Enhanced `application.properties` with Swagger configuration
- Annotations on all controllers and models

## Accessing Swagger UI

### Interactive Swagger UI
```
http://localhost:8080/swagger-ui.html
```

This provides:
- Visual interface for all API endpoints
- Try out functionality to test endpoints
- Request/response schemas
- Parameter descriptions
- HTTP status code documentation

### OpenAPI JSON Specification
```
http://localhost:8080/v3/api-docs
```

This is the machine-readable OpenAPI specification that can be imported into other tools.

## Features

### 1. Comprehensive Documentation
All endpoints are documented with:
- Clear operation summaries
- Detailed descriptions
- Expected request/response formats
- Status codes and error handling
- Parameter validation rules

### 2. Interactive Testing
- Test all API endpoints directly from Swagger UI
- View live responses
- Validate request payloads
- Debug API calls

### 3. Model Documentation
All entity models include:
- Field descriptions
- Example values
- Data types and constraints
- Required vs optional fields

### 4. API Organization
Endpoints are organized by tags:
- **Restaurants** - Restaurant management endpoints
- **Foods** - Food/Menu management endpoints
- **Orders** - Order management endpoints

## Endpoints Documentation

### Restaurants API
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/restaurants` | Get all restaurants |
| GET | `/api/restaurants/{id}` | Get restaurant by ID |
| POST | `/api/restaurants` | Create new restaurant |
| PUT | `/api/restaurants/{id}` | Update restaurant |
| DELETE | `/api/restaurants/{id}` | Delete restaurant |

### Foods API
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/foods` | Get all foods |
| GET | `/api/foods/restaurant/{restaurantId}` | Get foods by restaurant |
| GET | `/api/foods/{id}` | Get food by ID |
| POST | `/api/foods` | Create new food |
| PUT | `/api/foods/{id}` | Update food |
| DELETE | `/api/foods/{id}` | Delete food |

### Orders API
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/orders` | Get all orders |
| GET | `/api/orders/{id}` | Get order by ID |
| POST | `/api/orders` | Create new order |
| PUT | `/api/orders/{id}` | Update order |
| DELETE | `/api/orders/{id}` | Delete order |

## Annotations Used

### Controller Annotations
- `@Tag` - Groups related endpoints
- `@Operation` - Describes endpoint functionality
- `@ApiResponse` - Documents expected responses
- `@ApiResponses` - Multiple response codes

### Model Annotations
- `@Schema` - Describes entity/property
- Field examples and descriptions
- Data type information

## Testing with Swagger

### Example: Creating a Restaurant

1. Open Swagger UI at `http://localhost:8080/swagger-ui.html`
2. Navigate to **Restaurants** section
3. Click on `POST /api/restaurants`
4. Click "Try it out"
5. Enter restaurant data in JSON:
```json
{
  "name": "Pizza Palace",
  "cuisine": "Italian",
  "address": "100 Food Street",
  "rating": 4.7,
  "deliveryTime": 25,
  "deliveryCharge": 40
}
```
6. Click "Execute"
7. View the response

## Sample cURL Requests

### Get All Restaurants
```bash
curl -X GET "http://localhost:8080/api/restaurants" \
  -H "accept: application/json"
```

### Create a Restaurant
```bash
curl -X POST "http://localhost:8080/api/restaurants" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Pizza Palace",
    "cuisine": "Italian",
    "address": "100 Food Street",
    "rating": 4.7,
    "deliveryTime": 25,
    "deliveryCharge": 40
  }'
```

### Get Foods by Restaurant
```bash
curl -X GET "http://localhost:8080/api/foods/restaurant/1" \
  -H "accept: application/json"
```

### Place an Order
```bash
curl -X POST "http://localhost:8080/api/orders" \
  -H "Content-Type: application/json" \
  -d '{
    "restaurantId": 1,
    "totalAmount": 599.0,
    "items": [
      {
        "id": 1,
        "name": "Margherita Pizza",
        "price": 299.0,
        "quantity": 2
      }
    ]
  }'
```

## Advanced Configuration

### Customizing Swagger UI
Edit `application.properties`:

```properties
# Sort endpoints by method (get, post, etc.)
springdoc.swagger-ui.operations-sorter=method

# Sort tags alphabetically
springdoc.swagger-ui.tags-sorter=alpha

# Customize the path
springdoc.swagger-ui.path=/api-docs.html

# Disable Swagger UI
springdoc.swagger-ui.enabled=false

# Disable OpenAPI JSON endpoint
springdoc.api-docs.enabled=false
```

## Integration with Frontend

The frontend can use the OpenAPI specification to:
- Auto-generate TypeScript types
- Validate API responses
- Generate mock data
- Document API contracts

## Troubleshooting

### Swagger UI not loading
- Ensure backend is running on port 8080
- Check that springdoc dependency is installed
- Verify `application.properties` configuration

### Endpoints not showing up
- Ensure controllers have `@RestController` annotation
- Check that endpoints have proper HTTP method annotations
- Verify `@Tag` annotation on controller

### Response schemas not displayed
- Add `@Schema` annotations to model classes
- Ensure models have getters/setters (Lombok handles this)
- Check that request body contains proper JSON

## Resources

- [springdoc-openapi documentation](https://springdoc.org/)
- [OpenAPI 3.0 Specification](https://spec.openapis.org/oas/v3.0.3)
- [Swagger UI Documentation](https://github.com/swagger-api/swagger-ui)

## Security Note

Currently, Swagger UI is accessible to everyone. For production:
- Add authentication to Swagger endpoints
- Disable Swagger UI in production (`springdoc.swagger-ui.enabled=false`)
- Use API versioning
- Document security requirements

## Next Steps

- Use Swagger UI to test all endpoints
- Verify request/response formats
- Share OpenAPI spec with frontend team
- Use it for API contract testing
