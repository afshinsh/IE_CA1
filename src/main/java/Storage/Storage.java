package Storage;

import Model.Actor;
import Model.Movie;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    static public class Database{
        public static List<Movie> Movies = new ArrayList<>();
        public static List<User> Users = new ArrayList<>();
        public static List<Actor> Actors = new ArrayList<>();

    }

}
