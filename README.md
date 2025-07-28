# Investment Portfolio Tracker – Spring Boot + MongoDB

This project is a real-world CRUD backend built with Spring Boot 3 and MongoDB. It allows you to track your investment
transactions (stocks, ETFs, etc.) using a clean and modular architecture. Ideal for learning full-stack dev with real
use cases.

## 🚀 Features

- 📦 CRUD operations on investment transactions
- 🧾 RESTful APIs with OpenAPI + Swagger UI
- 🧠 MongoDB support with Spring Data Mongo
- 🔁 DTO ↔ Entity mapping using MapStruct
- 🧼 Clean architecture with service/repository layering
- 📋 Global exception handling
- 🔍 Swagger UI for testing APIs
- 🐳 Docker-compatible MongoDB setup
- ✅ Feature-based folder structure

## ⚙️ Getting Started

### - Run MongoDB (via Docker)

```bash
docker run -d \
--name mongo \
-p 27017:27017 \
-e MONGO_INITDB_DATABASE=dev-db \
mongo:latest
```

This runs MongoDB locally on localhost:27017.

### - Clone and Run the Project

```bash
git clone https://github.com/your-username/tspark-investment-portfolio-backend.git
cd tspark-investment-portfolio-backend
./gradlew bootRun
```

### - Configure application.yml

Example config (already included):

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/dev-db
``` 

### - Explore the APIs via Swagger

Open in browser: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## 🧪 Sample API Usage

### ➕ Create Transaction

```http
POST /api/portfolio
{
  "symbol": "AAPL",
  "type": "BUY",
  "quantity": 10,
  "price": 195.25,
  "date": "2025-07-21"
}
```

### 📥 Get All

```http
GET /api/portfolio
```

### 🔄 Update

```http
PUT /api/portfolio/{id}
{
  "symbol": "AAPL",
  "type": "SELL",
  "quantity": 5,
  "price": 200.00,
  "date": "2025-07-22"
}
```

### ❌ Delete

```http
DELETE /api/portfolio/{id}
```

## 💡 Want to Learn More?

Check out the companion article: 📘 Build a Real-Time Use Case with MongoDB and Spring Boot