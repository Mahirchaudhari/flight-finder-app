# ✈️ Flight Finder App

A full-stack flight word counter app built with **React (Vite)** for the frontend and **Spring Boot** for the backend. It allows users to input any text and checks how many times the word **"flight"** can be formed from the characters in the input.

---

## 📁 Project Structure

```
flight-finder-app/
├── flight-finder-api/         # Spring Boot application
│   └── src/...
├── flight-finder/        # React app built with Vite
│   ├── src/
│   ├── index.html
│   └── vite.config.js
└── README.md
```

---

## 🚀 Getting Started

### 🧩 Prerequisites

- Java 17+
- Node.js 18+
- Maven
- Git

---

## ⚙️ Backend: Spring Boot API

### 📦 Features

- REST endpoint: `POST /api/flights/search`
- Input: JSON with a single field `"input"`
- Output: JSON with a count of how many times `"flight"` can be formed

### 🔧 Setup

```bash
cd flight-finder-api
./mvnw spring-boot:run
```

By default, the server runs at: `http://localhost:8081`

---

## 🌐 Frontend: React (Vite)

### ✨ Features

- Input field to type text
- Live count of "flight" word occurrences
- Clean and responsive UI

### 🔧 Setup

```bash
cd frontend
npm install
npm run dev
```

The frontend runs at: `http://localhost:5173`

---

## 🔗 API Contract

**Endpoint:** `POST /api/flights/search`  
**Request:**
```json
{
  "inputKeyword": "flightflight"
}
```

**Response:**
```json
{
  "count": 2
}
```

**Validation:**
- Input must be at least 3 characters
- Returns 400 Bad Request if validation fails

---

## 🧪 Testing

### Backend
```bash
cd flight-finder-api
./mvnw test
```
