package Views;

import Model.Movie;

import java.util.ArrayList;

public class MovieView {
    public MovieView(Movie movie){
        Id = movie.Id;
        Name = movie.Name;
        Genres = movie.Genres;
        Director = movie.Director;
        ImdbRate = movie.ImdbRate;
    }
    public int Id;
    public String Name;
    public ArrayList<String> Genres;
    public String Director;
    public double ImdbRate;

}
