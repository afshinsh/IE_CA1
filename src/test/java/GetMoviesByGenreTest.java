import Main.Commands.AddActor;
import Main.Commands.AddMovie;
import Main.Mapper;
import Model.User;
import Storage.Storage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class GetMoviesByGenreTest {
    String genre;

    @Before
    public void setup() throws ParseException {
        User user = new User("sajjad@ut.ac.ir", "sajjad1234", "Sajjad", "Sajjad", "2000-06-14");
        Storage.Database.Users.add(user);
        AddActor addActor = new AddActor();
        addActor.addActor("{\"id\": 1, \"name\": \"Marlon Brando\", \"birthDate\": \"1924-04-03\", \"nationality\": \"American\"}\n");
        addActor.addActor("{\"id\": 2, \"name\": \"Al Pacino\", \"birthDate\": \"1940-04-25\", \"nationality\": \"American\"}\n");
        addActor.addActor("{\"id\": 3, \"name\": \"James Caan\", \"birthDate\": \"1940-03-26\", \"nationality\": \"American\"}\n");

        new AddMovie().addMovie("{\"id\": 1, \"name\": \"The Godfather\", \"summary\": \"The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.\", \"releaseDate\": \"1972-03-14\", \"director\": \"Francis Ford Coppola\", \"writers\": [\"Mario Puzo\", \"Francis Ford Coppola\"], \"genres\": [\"Crime\", \"Drama\"], \"cast\": [1, 2, 3], \"imdbRate\": 9.2, \"duration\": 175, \"ageLimit\": 14}\n");
    }

    @Test
    public void testEmptyList() throws JsonProcessingException {
        genre = "Action";
        assertEquals(Mapper.MapGenreMovies(genre), "[]");
    }

    @Test
    public void testValuableList() throws JsonProcessingException {
        new AddMovie().addMovie("{\"id\": 1, \"name\": \"The Godfather\", \"summary\": \"The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.\", \"releaseDate\": \"1972-03-14\", \"director\": \"Francis Ford Coppola\", \"writers\": [\"Mario Puzo\", \"Francis Ford Coppola\"], \"genres\": [\"Crime\", \"Drama\"], \"cast\": [1, 2, 3], \"imdbRate\": 9.2, \"duration\": 175, \"ageLimit\": 14}\n");
        genre = "Drama";
        assertEquals(Mapper.MapGenreMovies(genre), "[{\"Id\":1,\"Name\":\"The Godfather\",\"Director\":\"Francis Ford Coppola\",\"Genres\":[\"Crime\",\"Drama\"],\"rating\":9.2}]");

    }
}
