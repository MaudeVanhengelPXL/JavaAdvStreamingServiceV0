package be.pxl.ja.streamingservice.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MovieIsLongPlayingTimeTest {

    private Movie movie;
    //to use multiple times in test

    @BeforeEach
    //This method will be used before the run of each test
    public void init() {
        movie = new Movie("Titanic", Rating.OLDER_KIDS);
    }

    @Test
    public void returnsFalseIfDurationLessThanLongPlayingTime() {
        // ARRANGE (prepare test data)
        movie.setDuration(Movie.LONG_PLAYING_TIME - 1);

        // ACT (using method we want to test)
        boolean result = movie.isLongPlayingTime();

        // ASSERTS (validation)
        assertFalse(result);
    }

    @Test
    public void returnsTrueIfDurationMoreThanLongPlayingTime() {
        movie.setDuration(Movie.LONG_PLAYING_TIME + 1);

        assertTrue(movie.isLongPlayingTime());
        //ACT and ASSERT in one line
    }

    @Test
    public void returnsTrueIfDurationEqualsLongPlayingTime() {
        movie.setDuration(Movie.LONG_PLAYING_TIME);

        assertTrue(movie.isLongPlayingTime());
    }

}
