# Spotify Top 100 Songs API

A full-stack CRUD application built with Spring Boot and vanilla JavaScript that manages a database of the top 100 streamed Spotify songs. Features a Spotify-themed frontend with search/filter, and a REST API supporting filtering by title, artist, and year as well as ranking songs by popularity.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- HTML/CSS/JavaScript (Frontend)

---

## Getting Started

### Prerequisites

- Java 17+
- PostgreSQL
- Maven

### Database Setup

1. Create a PostgreSQL database called `spotify`
2. Run `schema.sql` to create the `top_streamed_songs` table
3. Import `top_streamed_songs.csv` into the table

### Configuration

1. Copy `application.example.properties` to `application.properties`
2. Fill in your database credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/spotify
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

### Running the App

```bash
mvn spring-boot:run
```

The app will be available at `http://localhost:8080`

---

## Frontend

Open `http://localhost:8080/index.html` in your browser after starting the app.

Features:
- View all 100 songs in a table
- Search and filter by title, artist, and year
- Add, edit, and delete songs via modal forms
- Spotify-themed dark UI

---



