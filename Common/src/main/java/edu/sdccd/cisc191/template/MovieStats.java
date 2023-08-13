package edu.sdccd.cisc191.template;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.sql.Date;

public class MovieStats {
    @CsvDate(value = "yyyy")
    @CsvBindByName(column = "Date")
    private Date date;

    @CsvBindByName(column = "Film")
    private String film;

    @CsvBindByName(column = "Genre")
    private String genre;

    @CsvBindByName(column = "Studio")
    private String studio;

    @CsvBindByName(column = "Percent")
    private int percent;

    @Override
    public String toString() {
        return String.format(
                "MovieStats[date=%s, film=%s, genre=%d, studio=%d, percent=%d]",
                date, film, genre, studio, percent);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) { this.film = film; }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio (String studio) {
        this.studio = studio;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
