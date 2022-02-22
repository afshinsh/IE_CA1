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
        public static int UserId = 1;
        public static void AddActor(Actor actor){
            for (Actor act: Actors) {
                if(act.Id == actor.Id){
                    act = actor;
                    return;
                }
            }
            Actors.add(actor);
        }

        public static void AddMovie(Movie movie){
            for (Movie mve: Movies) {
                if(mve.Id == movie.Id){
                    mve = movie;
                    return;
                }
            }
            Movies.add(movie);
        }

        public static void AddUser(User user){
            user.Id = UserId++;
            Users.add(user);
        }

    }

}
