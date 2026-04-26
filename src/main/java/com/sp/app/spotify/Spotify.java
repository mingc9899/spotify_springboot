package com.sp.app.spotify;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="top_streamed_songs")
public class Spotify {
    @Id
    private String title;
    private String artist;
    private String top_genre;
    private Integer year;
    private Integer beats_per_minute;
    private Integer energy;
    private Integer danceability;
    private Integer loudness_db;
    private Integer liveness;
    private Integer valence;
    private Integer length;
    private Integer acousticness;
    private Integer speechiness;
    private Integer popularity;

    public Spotify(){
    }

    public Spotify(String title, String artist, String top_genre, Integer year, Integer beats_per_minute, Integer energy, Integer danceability, Integer loudness_db, Integer liveness, Integer valance, Integer length, Integer acousticness, Integer speechiness, Integer popularity) {
        this.title = title;
        this.artist = artist;
        this.top_genre = top_genre;
        this.year = year;
        this.beats_per_minute = beats_per_minute;
        this.energy = energy;
        this.danceability = danceability;
        this.loudness_db = loudness_db;
        this.liveness = liveness;
        this.valence = valence;
        this.length = length;
        this.acousticness = acousticness;
        this.speechiness = speechiness;
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTop_genre() {
        return top_genre;
    }

    public void setTop_genre(String top_genre) {
        this.top_genre = top_genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getBeats_per_minute() {
        return beats_per_minute;
    }

    public void setBeats_per_minute(Integer beats_per_minute) {
        this.beats_per_minute = beats_per_minute;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getDanceability() {
        return danceability;
    }

    public void setDanceability(Integer danceability) {
        this.danceability = danceability;
    }

    public Integer getLoudness_db() {
        return loudness_db;
    }

    public void setLoudness_db(Integer loudness_db) {
        this.loudness_db = loudness_db;
    }

    public Integer getLiveness() {
        return liveness;
    }

    public void setLiveness(Integer liveness) {
        this.liveness = liveness;
    }

    public Integer getValence() {
        return valence;
    }

    public void setValence(Integer valence) {
        this.valence = valence;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(Integer acousticness) {
        this.acousticness = acousticness;
    }

    public Integer getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(Integer speechiness) {
        this.speechiness = speechiness;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

}
