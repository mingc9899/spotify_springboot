# Spotify Top 100 Songs API

A RESTful CRUD API built with Spring Boot that manages a database of the top 100 streamed Spotify songs. Supports filtering by title, artist, and year, as well as ranking songs by popularity.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

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

The API will be available at `http://localhost:8080`

---

## API Endpoints

### Get Songs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/spotify` | Get all songs |
| GET | `/api/spotify?title={title}` | Search songs by title |
| GET | `/api/spotify?artist={artist}` | Get songs by artist |
| GET | `/api/spotify?year={year}` | Get songs by year |
| GET | `/api/spotify/rank?rank={rank}` | Get song by popularity rank (1-100) |

### Manage Songs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/spotify` | Add a new song |
| PUT | `/api/spotify` | Update an existing song |
| DELETE | `/api/spotify/{title}` | Delete a song by title |

### Example Request Body (POST/PUT)

```json
{
    "title": "Song Title",
    "artist": "Artist Name",
    "top_genre": "pop",
    "year": 2019,
    "beats_per_minute": 120,
    "energy": 80,
    "danceability": 75,
    "loudness_db": -5,
    "liveness": 10,
    "valence": 60,
    "length": 200,
    "acousticness": 15,
    "speechiness": 5,
    "popularity": 90
}
```

---

## Project Structure

```
src/
└── main/
    ├── java/spotify/
    │   ├── Spotify.java              # Entity
    │   ├── SpotifyController.java    # REST Controller
    │   ├── SpotifyService.java       # Business Logic
    │   └── SpotifyRepository.java    # Data Access
    └── resources/
        ├── application.example.properties
        └── schema.sql
```
