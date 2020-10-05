package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileAllowedToWatchTest {

    private Profile profile;

    @BeforeEach
    public void init() {
        profile = new Profile();
    }

    @Test
    public void noBirthDateNotAllowedToWatchAnyContentTest() {
        Content content = new Movie("Titanic", Rating.OLDER_KIDS);
        assertFalse(profile.allowedToWatch(content));
    }

    @Test
    public void matureContentNotAllowed() {
        Content matureContent = new TVShow("Wynonna Earp", Rating.MATURE, 4);
        profile.setDateOfBirth(LocalDate.of(2005, 4, 1));

        assertFalse(profile.allowedToWatch(matureContent));
    }

    @Test
    public void olderKidsContentAllowed() {
        Content olderKidsContent = new Movie("Booksmart", Rating.OLDER_KIDS);
        profile.setDateOfBirth(LocalDate.of(2005, 4, 1));

        assertTrue(profile.allowedToWatch(olderKidsContent));
    }

    @Test
    public void ageEqualToContentRatingMinimumAge() {
        Content teensContent = new Movie("D.E.B.S", Rating.TEENS);
        profile.setDateOfBirth(LocalDate.of(2008, 3, 2));

        assertTrue(profile.allowedToWatch(teensContent));
    }

    @Test
    public void ageJustBelowContentRatingMinimumAge() {
        Content teensContent = new Movie("Star Wars Episode VII", Rating.TEENS);
        profile.setDateOfBirth(LocalDate.of(2008, 10, 6));

        assertFalse(profile.allowedToWatch(teensContent));
    }
}
