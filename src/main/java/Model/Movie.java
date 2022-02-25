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
        rates = new ArrayList<>();
    }
    public Movie(){
        Id = -1;
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

    public ArrayList<Rate> rates;


    private double getImdbRate(){
        double sum = ImdbRate;
        for (int i = 0; i < rates.size(); i++) {
            sum += rates.get(i).Score;
        }
        return sum / (rates.size() + 1) ;
    }
    private void updateImdbRate(int before , int after){
        double sum = ImdbRate * (rates.size() + 1);
        sum = sum - before + after;
        ImdbRate = sum / (rates.size() + 1);
    }

    public void RateMovie(Rate rate){

        for (Rate rt : rates)
            if(rt.UserEmail.equals(rate.UserEmail)){
                updateImdbRate(rt.Score, rate.Score);
                rt = rate;
                return;
            }
        rates.add(rate);
        ImdbRate = getImdbRate();
    }

}
