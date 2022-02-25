package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    public User(String email, String password, String nickName, String name, String birthDate) throws ParseException {
        Email = email;
        Password = password;
        NickName = nickName;
        Name = name;
        BirthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
        WatchList = new ArrayList<>();
    }
    public int Id;
    public String Email;
    public String Password;
    public String NickName;
    public String Name;
    public Date BirthDate;
    public List<Movie> WatchList;

    public boolean canWatch(Movie movie) {
        long difference_In_Time
                = (new Date(System.currentTimeMillis())).getTime() - BirthDate.getTime();
        long difference_In_Years
                = (difference_In_Time
                / (1000l * 60 * 60 * 24 * 365));
        if(difference_In_Years > movie.AgeLimit)
            return true;
        return false;
    }

    public boolean addToWatchList(Movie movie) {
        for (Movie mve : WatchList)
            if(mve.Id == movie.Id)
                return false;
        WatchList.add(movie);
        return true;
    }

    public void RemoveFromWatchList(Movie movie) throws Exception {
        for (Movie mve : WatchList)
            if(mve.Id == movie.Id){
                WatchList.remove(mve);
                return;
            }
        throw new Exception("MovieNotFound");


    }
}
