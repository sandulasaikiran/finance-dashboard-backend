# Finance Dashboard Backend

Spring Boot backend for financial records CRUD, filtering, and dashboard analytics.

## Features
- Create records
- View records
- Update records
- Delete records
- Filter by type
- Filter by category
- Dashboard summary
- H2 database
- Swagger UI
- Spring Security config

## APIs
- POST /api/records
- GET /api/records
- GET /api/records/{id}
- PUT /api/records/{id}
- DELETE /api/records/{id}
- GET /api/records/type/{type}
- GET /api/records/category/{category}
- GET /api/dashboard/summary

## Swagger
http://localhost:8081/swagger-ui/index.html