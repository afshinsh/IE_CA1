package Views;

import Model.Movie;

import java.util.ArrayList;

public class MovieListView {
    public MovieListView(Movie movie) {
        Id = movie.Id;
        Name = movie.Name;
        Director = movie.Director;
        Genres = movie.Genres;
        rating = movie.ImdbRate;
    }

    public int Id;
    public String Name;
    public String Director;
    public ArrayList<String> Genres;
    public double rating;
}
