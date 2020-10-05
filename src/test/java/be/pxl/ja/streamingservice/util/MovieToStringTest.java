package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieToStringTest {

    private Movie testMovie;

    @BeforeEach
    public void init() {
        testMovie = new Movie("Titanic", Rating.OLDER_KIDS);
    }
    @Test
    public void ToStringDisplaysTitleAndReleaseDateIfReleaseDateIsKnown() {
        testMovie.setReleaseDate(LocalDate.of(1997, 1, 1));

        int releaseYear = testMovie.getReleaseDate().getYear();
        assertTrue(testMovie.toString().contains(String.valueOf(releaseYear)) && testMovie.toString().contains(testMovie.getTitle()));
    }

    @Test
    public void ToStringDisplaysTitleOnlyIfReleaseDateIsUnknown() {
        assertEquals(testMovie.getTitle(), testMovie.toString());
    }

}
