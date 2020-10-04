package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Movie extends be.pxl.ja.opdracht1.Content implements be.pxl.ja.opdracht1.Playable {
    public static final int LONG_PLAYING_TIME = 2 * 60 + 15;
    //Long playing time qualifies as two hours and 15 minutes

    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;

    public Movie(String title, be.pxl.ja.opdracht1.Rating maturityRating) {
        super(title, maturityRating);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void play() {
        System.out.println("Playing " + this);
    }

    @Override
    public void pause() {
        System.out.println("Pausing " + this);
    }

    public void setDuration(int duration) {
        this.duration = Math.abs(duration);
    }
    
    public boolean isLongPlayingTime() {
        return duration >= LONG_PLAYING_TIME;
    }

    public String getPlayingTime() {
        if (this.getDuration() == 0) {
            return "?";
        } else if (this.getDuration() < 60) {
            return this.getDuration() + " min";
        } else if (this.getDuration() % 60 == 0) {
            return ((this.getDuration() / 60) + " h");
        } else {
            return (this.getDuration() / 60) + " h " + (this.getDuration() % 60) + " min";
        }
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        if (releaseDate != null) {
            return String.format("%s (%s)", super.toString(), releaseDate.getYear());
        }
        return super.toString();
    }
}
