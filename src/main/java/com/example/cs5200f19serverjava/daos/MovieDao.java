package com.example.cs5200f19serverjava.daos;

import com.example.cs5200f19serverjava.models.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    private static MovieDao instance = null;
    private MovieDao() {}
    public static MovieDao getInstance() {
        if(instance == null)
            instance = new MovieDao();
        return instance;
    }
    String CREATE_MOVIE = "INSERT INTO MOVIES (imdbId, title) VALUES ('IMDBID', 'TITLE')";
    String FIND_ALL_MOVIES = "SELECT * FROM movies";
    String FIND_BY_ID = "SELECT * FROM movies WHERE id=";
    String DELETE_MOVIE = "DELETE FROM MOVIES WHERE id=";
    String UPDATE_MOVIE = "UPDATE MOVIES SET imdbId=IMDBID WHERE id=";
    String PUPDATE_MOVIE = "UPDATE MOVIES SET imdbId=? WHERE id=?";

    public void createMovie(Movie movie) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs5200_fall_2019?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "cs5200", "cs5200");
            statement = connection.createStatement();
            String SQL = CREATE_MOVIE.replaceAll("TITLE", movie.getTitle());
            SQL = SQL.replaceAll("IMDBID", movie.getImdbId());
            statement.executeUpdate(SQL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Movie> findAllMovies() {
        List<Movie> movies =
                new ArrayList<Movie>();
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs5200_fall_2019?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "cs5200", "cs5200");
            statement = connection.createStatement();
            results = statement
                    .executeQuery(FIND_ALL_MOVIES);
            while(results.next()) {
                int id = results.getInt("id");
                String imdbId = results.getString("imdbId");
                String title = results.getString("title");
                Movie movie = new Movie(id, imdbId, title, null, null);
                movies.add(movie);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
    public Movie findMovieById(int id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs5200_fall_2019?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "cs5200", "cs5200");
            statement = connection.createStatement();
            results = statement
                    .executeQuery(FIND_BY_ID + id);
            if(results.next()) {
                String imdbId = results.getString("imdbId");
                String title = results.getString("title");
                Movie movie = new Movie(id, imdbId, title, null, null);
                return movie;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Movie findMovieByTitle(String title) {
        return null;
    }
    public void updateMovie(int id,
                            Movie newMovie) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs5200_fall_2019?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "cs5200", "cs5200");
            statement = connection.createStatement();
            String SQL = UPDATE_MOVIE + id;
            SQL = SQL.replaceAll("IMDBID", newMovie.getImdbId());
            statement.executeUpdate(SQL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteMovie(int id) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs5200_fall_2019?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "cs5200", "cs5200");
            statement = connection.createStatement();
            String SQL = DELETE_MOVIE + id;
            statement.executeUpdate(SQL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pupdateMovie(int id,
                            Movie newMovie) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs5200_fall_2019?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "cs5200", "cs5200");
            statement = connection.prepareStatement(PUPDATE_MOVIE);
            statement.setString(1, newMovie.getImdbId());
            statement.setInt(2, newMovie.getId());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
