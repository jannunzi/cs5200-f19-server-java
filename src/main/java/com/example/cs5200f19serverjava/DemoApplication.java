package com.example.cs5200f19serverjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//
//		MovieDao dao = MovieDao.getInstance();
//		List<Movie> movies = dao.findAllMovies();
//		for(Movie movie: movies) {
//			System.out.println(movie.getTitle());
//		}
//
		SpringApplication.run(DemoApplication.class, args);
	}

}
