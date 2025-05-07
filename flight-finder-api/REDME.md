# Flight Finder

Flight Finder is a Java-based REST application built with Spring Boot. It provides an API to search for the number of occurrences of the word "flight" in a given input string.

## Features

- RESTful API to process input strings.
- Validates input using Spring Boot's validation framework.
- Logs application activity using SLF4J.
- Built with Java 17 and Maven.

## Prerequisites

- Java 17 or higher
- Maven 3.8 or higher

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/Mahirchaudhari/flight-finder.git
   cd flight-finder
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the API at `http://localhost:8080/api/flights`.

## API Endpoints

### POST `/api/flights/search`

**Description:** Searches for the number of occurrences of the word "flight" in the input string.

**Request Body:**
```json
{
  "inputKeyword": "flight flight flight"
}
```

**Response:**
```json
{
  "count": 3
}
```

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Validation
- SLF4J for logging