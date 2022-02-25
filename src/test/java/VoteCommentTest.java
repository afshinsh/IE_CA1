import Main.Commands.*;
import Model.Rate;
import Storage.Storage;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class VoteCommentTest {


    public void voteToSara(){
        VoteComment voteComment = new VoteComment();
        voteComment.voteComment("{\"userEmail\": \"sara@ut.ac.ir\", \"commentId\": 1, \"vote\": 1}");
    }

    @Test
    public void testUserNotFound() {
        try {
            voteToSara();
        }
        catch (Exception e){
            assertEquals(e.getMessage(), "UserNotFound");
        }
    }

    @Test
    public void testCommentNotFound() {
        try {
            AddUser addUser = new AddUser();
            addUser.addUser("{\"email\": \"sara@ut.ac.ir\", \"password\": \"sara1234\", \"name\": \"Sara\", \"nickname\": \"sara\", \"birthDate\": \"1998-03-11\"}");
            voteToSara();
        }
        catch (Exception e){
            assertEquals(e.getMessage(), "CommentNotFound");
        }
    }
    @Test
    public void testInvalidVoteValue() {
        try {
            AddUser addUser = new AddUser();
            addUser.addUser("{\"email\": \"sara@ut.ac.ir\", \"password\": \"sara1234\", \"name\": \"Sara\", \"nickname\": \"sara\", \"birthDate\": \"1998-03-11\"}");
            addUser.addUser("{\"email\": \"saman@ut.ac.ir\", \"password\": \"saman1234\", \"name\": \"Saman\", \"nickname\": \"saman\", \"birthDate\": \"2014-01-01\"}");
            AddComment addComment = new AddComment();
            addComment.addComment("{\"userEmail\": \"saman@ut.ac.ir\", \"movieId\": 1, \"text\": \"Interesting Movie\"}");
            VoteComment voteComment = new VoteComment();
            voteComment.voteComment("{\"userEmail\": \"sara@ut.ac.ir\", \"commentId\": 1, \"vote\": 2}");

        }
        catch (Exception e){
            assertEquals(e.getMessage(), "InvalidVoteValue");
        }
    }

    @Test
    public void testSuccessful() throws Exception {

        AddUser addUser = new AddUser();
        addUser.addUser("{\"email\": \"sara@ut.ac.ir\", \"password\": \"sara1234\", \"name\": \"Sara\", \"nickname\": \"sara\", \"birthDate\": \"1998-03-11\"}");

        addUser.addUser("{\"email\": \"saman@ut.ac.ir\", \"password\": \"saman1234\", \"name\": \"Saman\", \"nickname\": \"saman\", \"birthDate\": \"2014-01-01\"}");
        AddActor addActor = new AddActor();
        addActor.addActor("{\"id\": 1, \"name\": \"Marlon Brando\", \"birthDate\": \"1924-04-03\", \"nationality\": \"American\"}\n");
        addActor.addActor("{\"id\": 2, \"name\": \"Al Pacino\", \"birthDate\": \"1940-04-25\", \"nationality\": \"American\"}\n");
        addActor.addActor("{\"id\": 3, \"name\": \"James Caan\", \"birthDate\": \"1940-03-26\", \"nationality\": \"American\"}\n");
        AddMovie addMovie = new AddMovie();
        addMovie.addMovie("{\"id\": 1, \"name\": \"The Godfather\", \"summary\": \"The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.\", \"releaseDate\": \"1972-03-14\", \"director\": \"Francis Ford Coppola\", \"writers\": [\"Mario Puzo\", \"Francis Ford Coppola\"], \"genres\": [\"Crime\", \"Drama\"], \"cast\": [1, 2, 3], \"imdbRate\": 9.2, \"duration\": 175, \"ageLimit\": 14}");
        AddComment addComment = new AddComment();
        addComment.addComment("{\"userEmail\": \"saman@ut.ac.ir\", \"movieId\": 1, \"text\": \"Interesting Movie\"}");
        var likesBeforeVote = Storage.Database.GetCommentLike(1);
        voteToSara();
        var likesAfterVote = Storage.Database.GetCommentLike(1);
        assertEquals(likesAfterVote - likesBeforeVote, 1);
    }

}
