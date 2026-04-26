package com.sp.app.spotify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/spotify")
public class SpotifyController {
    private final SpotifyService spotifyService;

    @Autowired
    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping
    public List<Spotify> getSongs(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String artist,
        @RequestParam(required = false) Integer year
    ){
        if (title != null){
            return spotifyService.getSongByTitle(title);
        }
        else if (artist != null){
            return spotifyService.getTitleByArtist(artist);
        }
        else if (year != null){
            return spotifyService.getTitleByYear(year);
        }
        else return spotifyService.getTitleList();
    }
    @GetMapping("/rank")
    public ResponseEntity<?> getRank(@RequestParam Integer rank) {
        try {
            Spotify song = spotifyService.getSongByRank(rank);
            return ResponseEntity.ok(song);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Spotify> addSong(@RequestBody Spotify spotify){
        Spotify createdSong = spotifyService.addSong(spotify);
        return new ResponseEntity<>(createdSong, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Spotify> updateSong(@RequestBody Spotify spotify){
        Spotify updatedSong = spotifyService.updateSong(spotify);
        if (updatedSong != null){
            return new ResponseEntity<>(updatedSong, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{songTitle}")
    public ResponseEntity<String> deleteSong(@PathVariable String songTitle){
        boolean deleted = spotifyService.deleteSong(songTitle);
        if (deleted){
            return new ResponseEntity<>("Song deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Song not found.", HttpStatus.NOT_FOUND);
    }
}
