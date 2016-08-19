package com.example.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import com.example.core.Movie;
import com.example.dao.MovieListRepository;

@Controller
@RequestMapping("/movies")
public class MovieListController {

  private MovieListRepository movieListRepository;

  @Autowired
  public MovieListController(MovieListRepository movieListRepository) {
    this.movieListRepository = movieListRepository;
  }

  @RequestMapping(value="/{user}", method=RequestMethod.GET)
  public String directorsMovies(@PathVariable String user, Model model) {
    List<Movie> movieList = movieListRepository.findByUser(user);
    if (movieList != null) {
      model.addAttribute("user", user);
      model.addAttribute("movies", movieList);
    }
    return "movieList";
  }

  @RequestMapping(value="/{user}", method=RequestMethod.POST)
  public String addToMovieList(@PathVariable String user, Movie movie) {
    movie.setUser(user);
    movieListRepository.save(movie);
    return "redirect:/{user}";
  }
}
