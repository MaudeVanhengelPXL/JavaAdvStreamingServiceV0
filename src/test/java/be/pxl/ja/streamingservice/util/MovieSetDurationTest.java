package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieSetDurationTest {

    private Movie testMovie;

    @BeforeEach
    public void init() {
        testMovie = new Movie("Titanic", Rating.OLDER_KIDS);
    }
    @Test
    public void negativeDurationBecomesPositive() {
        testMovie.setDuration(-125);

        assertEquals(125, testMovie.getDuration());
    }

    @Test
    public void positiveDurationStaysUnchanged() {
        testMovie.setDuration(125);

        assertEquals(125, testMovie.getDuration());
    }
}
