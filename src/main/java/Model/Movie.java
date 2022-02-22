package Model;

import java.util.ArrayList;

public class Movie {
    public Movie(int id, String name, String summary, String releaseDate, String director, ArrayList<String> writers,
                 ArrayList<String> genres, ArrayList<Integer> cast, double imdbRate, long duration, int ageLimit){
        Id = id;
        Name = name;
        Summary = summary;
        ReleaseDate = releaseDate;
        Director = director;
        Writers = writers;
        Genres = genres;
        Cast = cast;
        ImdbRate = imdbRate;
        Duration = duration;
        AgeLimit = ageLimit;
    }
    public int Id;
    public String Name;
    public String Summary;
    public String ReleaseDate;
    public String Director;
    public ArrayList<String> Writers;
    public ArrayList<String> Genres;
    public ArrayList<Integer> Cast;
    public double ImdbRate;
    public long Duration;
    public int AgeLimit;

}
