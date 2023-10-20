import Adapters.ConsolePrinter;
import Adapters.MovieReviewsRepo;
import Adapters.UserCommand;
import Application.MovieUser;
import Domain.MovieSearchRequest;
import Ports.iFetchMovieReviews;
import Ports.iPrintMovieReviews;
import Ports.iUserInput;

public class App {
    public static void main(String[] args) throws Exception {
        
        iFetchMovieReviews fetchMovieReviews = new MovieReviewsRepo();
        iPrintMovieReviews printMovieReviews = new ConsolePrinter();

        iUserInput userCommand = new UserCommand(fetchMovieReviews, printMovieReviews);

        MovieUser movieUser = new MovieUser(userCommand);

        MovieSearchRequest starWars = new MovieSearchRequest("StarWars");
        MovieSearchRequest starTreck = new MovieSearchRequest("StarTreck");

        System.out.println(starWars.getMovieName());
        movieUser.processInput(starWars);

        System.out.println(starTreck.getMovieName());
        movieUser.processInput(starTreck);
    }
}
