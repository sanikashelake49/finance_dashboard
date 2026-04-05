# 💰 Finance Data Processing & Access Control Backend

## 📌 Overview

This project is a backend system for a Finance Dashboard that manages financial records, users, and role-based access control.

It provides secure APIs for handling transactions, generating insights, and enforcing access permissions based on user roles.

---

## 🚀 Features

### 🔐 Authentication & Authorization

* User Registration & Login
* JWT-based Authentication
* Password Encryption using BCrypt
* Role-Based Access Control (RBAC)

### 👥 User Management

* Create and manage users
* Assign roles (Admin, Analyst, Viewer)
* Active/Inactive user handling

### 💰 Financial Records

* Create, Read, Delete financial records
* Record types: Income / Expense
* Category-based tracking
* Date-based records

### 📊 Dashboard Analytics

* Total Income
* Total Expenses
* Net Balance
* Category-wise totals
* Recent transactions

### 🔍 Filtering & Pagination

* Filter by type (Income/Expense)
* Filter by category
* Pagination support

### ⚠️ Validation & Error Handling

* Input validation using annotations
* Global exception handling
* Meaningful error responses

---

## 🛠️ Tech Stack

* Java 17+
* Spring Boot 3
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* MySQL / H2 Database
* Maven

---

## 📂 Project Structure

```
com.finance.dashboard
 ┣ config
 ┣ controller
 ┣ dto
 ┣ entity
 ┣ exception
 ┣ repository
 ┣ security
 ┣ service
```

---

## 🔐 Roles & Permissions

| Role    | Permissions                |
| ------- | -------------------------- |
| ADMIN   | Full access (CRUD + Users) |
| ANALYST | View + Filter + Dashboard  |
| VIEWER  | View only                  |

---

## 📡 API Endpoints

### 🔑 Auth APIs

* POST `/auth/register`
* POST `/auth/login`

### 👤 User APIs

* POST `/users`

### 💰 Financial Records

* POST `/records`
* GET `/records?page=0&size=5`
* GET `/records/filter`
* DELETE `/records/{id}`

### 📊 Dashboard

* GET `/dashboard`

---

## 🧪 Sample Request

### Register

```json
{
  "name": "Admin",
  "email": "admin@gmail.com",
  "password": "1234",
  "role": "ADMIN"
}
```

### Login

```json
{
  "email": "admin@gmail.com",
  "password": "1234"
}
```

---

## 🔑 Authentication Header

```
Authorization: Bearer <JWT_TOKEN>
```

---

## ⚙️ Setup Instructions

1. Clone repository

```
git clone https://github.com/your-username/finance-dashboard-backend.git
```

2. Navigate to project

```
cd finance-dashboard-backend
```

3. Run project

```
mvn spring-boot:run
```

4. Access APIs

```
http://localhost:8080
```

---

## 🧠 Assumptions

* Roles are predefined (Admin, Analyst, Viewer)
* JWT is used for stateless authentication
* Simple financial model (no currency conversion)
* Basic validation implemented

---

## ✨ Optional Enhancements (Future Scope)

* Full JWT authentication filter
* Refresh tokens
* Swagger API documentation
* Deployment (Render / AWS)
* Unit & Integration Testing

---

## 📌 Conclusion

This project demonstrates strong backend fundamentals including:

* Clean architecture
* Secure authentication
* Role-based authorization
* Data processing and aggregation

---

## 👩‍💻 Author

Sanika Shelake

