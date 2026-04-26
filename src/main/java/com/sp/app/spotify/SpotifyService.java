package com.sp.app.spotify;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SpotifyService {
    private final SpotifyRepository spotifyRepository;

    @Autowired
    public SpotifyService(SpotifyRepository spotifyRepository) {
        this.spotifyRepository = spotifyRepository;
    }

    public List<Spotify> getTitleList(){return spotifyRepository.findAll();}

    public List<Spotify> getTitleByArtist(String artist){
        return spotifyRepository.findAll().stream()
                .filter(spotify -> artist.equals(spotify.getArtist()))
                .collect(Collectors.toList());
    }
    public List<Spotify> getSongByTitle(String title){
        return spotifyRepository.findAll().stream()
                .filter(spotify -> spotify.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Spotify> getTitleByYear(Integer year){
        return spotifyRepository.findAll().stream()
                .filter(spotify -> spotify.getYear().equals(year))
                .collect(Collectors.toList());
    }

    public Spotify getSongByRank(Integer rank){
        if (rank == null || rank <= 0 || rank > 100){
            throw new IllegalArgumentException("Rank must be a positive integer within 1-100.");
        }
        if (rank > spotifyRepository.findAllByOrderByPopularityDesc().size()) {
            throw new IllegalArgumentException("Rank exceeds available songs.");
        }
        List<Spotify> sortedSongs = spotifyRepository.findAllByOrderByPopularityDesc();
        return sortedSongs.get(rank - 1);
    }

    public Spotify addSong(Spotify spotify){
        return spotifyRepository.save(spotify);
    }

    public Spotify updateSong(Spotify spotify){
        Optional<Spotify> existingSong = spotifyRepository.findByTitle(spotify.getTitle());

        if (existingSong.isPresent()){
            Spotify updatedSong = existingSong.get();
            updatedSong.setTitle(spotify.getTitle());
            updatedSong.setArtist(spotify.getArtist());
            updatedSong.setYear(spotify.getYear());
            updatedSong.setPopularity(spotify.getPopularity());

            return spotifyRepository.save(updatedSong);
        }
        return null;
    }
    @Transactional
    public boolean deleteSong(String title){
        Optional<Spotify> song = spotifyRepository.findByTitle(title);
        if (song.isPresent()){
            spotifyRepository.deleteByTitle(title);
            return true;
        }
        return false;
    }

}
