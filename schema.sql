CREATE TABLE top_streamed_songs (
    title VARCHAR(255) PRIMARY KEY,
    artist VARCHAR(255),
    top_genre VARCHAR(255),
    year INTEGER,
    beats_per_minute INTEGER,
    energy INTEGER,
    danceability INTEGER,
    loudness_db INTEGER,
    liveness INTEGER,
    valence INTEGER,
    length INTEGER,
    acousticness INTEGER,
    speechiness INTEGER,
    popularity INTEGER
);
