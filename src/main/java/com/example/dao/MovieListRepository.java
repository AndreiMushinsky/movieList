package com.example.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.core.Movie;

public interface MovieListRepository extends JpaRepository<Movie, Long> {
  List<Movie> findByUser(String user);
}
