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

    // Getters and setters

    @Override
    public String toString() {
        return String.format(
                "MovieStats[date=%s, film=%s, genre=%s, studio=%s, percent=%d]",
                date, film, genre, studio, percent);
    }
}
