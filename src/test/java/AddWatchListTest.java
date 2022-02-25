import Main.Commands.AddActor;
import Main.Commands.AddMovie;
import Main.Commands.AddUser;
import Model.Rate;
import Model.User;
import Model.WatchList;
import Storage.Storage;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class AddWatchListTest {


    @Before
    public void setup() throws ParseException {
        User user = new User("sajjad@ut.ac.ir", "sajjad1234", "Sajjad", "Sajjad", "2000-06-14");
        Storage.Database.Users.add(user);
        AddActor addActor = new AddActor();
        addActor.addActor("{\"id\": 1, \"name\": \"Marlon Brando\", \"birthDate\": \"1924-04-03\", \"nationality\": \"American\"}\n");
        addActor.addActor("{\"id\": 2, \"name\": \"Al Pacino\", \"birthDate\": \"1940-04-25\", \"nationality\": \"American\"}\n");
        addActor.addActor("{\"id\": 3, \"name\": \"James Caan\", \"birthDate\": \"1940-03-26\", \"nationality\": \"American\"}\n");

        new AddMovie().addMovie("{\"id\": 1, \"name\": \"The Godfather\", \"summary\": \"The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.\", \"releaseDate\": \"1972-03-14\", \"director\": \"Francis Ford Coppola\", \"writers\": [\"Mario Puzo\", \"Francis Ford Coppola\"], \"genres\": [\"Crime\", \"Drama\"], \"cast\": [1, 2, 3], \"imdbRate\": 9.2, \"duration\": 175, \"ageLimit\": 14}\n");
        user.WatchList.add(Storage.Database.Movies.get(0));
    }

    @Test
    public void testUserNotFound() {
        try {
            Storage.Database.AddWatchList(new WatchList("saman@ut.ac.ir", 1));
        } catch (Exception e) {
            assertEquals(e.getMessage(), "UserNotFound");
        }
    }

    @Test
    public void testMovieNotFound() {
        try {
            Storage.Database.AddWatchList(new WatchList("sajjad@ut.ac.ir", 2));
        } catch (Exception e) {
            assertEquals(e.getMessage(), "MovieNotFound");
        }
    }

    @Test
    public void testMovieAlreadyExist() {
        try {
            Storage.Database.AddWatchList(new WatchList("sajjad@ut.ac.ir", 1));
        } catch (Exception e) {
            assertEquals(e.getMessage(), "MovieAlreadyExists");
        }
    }
}