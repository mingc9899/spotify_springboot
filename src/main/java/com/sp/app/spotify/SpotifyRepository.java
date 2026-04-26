package com.sp.app.spotify;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpotifyRepository extends JpaRepository<Spotify,String> {
    void deleteByTitle(String title);
    Optional<Spotify> findByTitle(String title);
    List<Spotify> findAllByOrderByPopularityDesc();
}
