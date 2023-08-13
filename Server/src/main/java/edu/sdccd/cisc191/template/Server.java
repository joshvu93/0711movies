package edu.sdccd.cisc191.template;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Server {
    private static final int PORT = 12345;
    private List<MovieStats> movieStatsList;

    public Server() {
        loadMovieStatsFromCSV();
    }

    private void loadMovieStatsFromCSV() {
        try (FileReader reader = new FileReader("src/main/resources/movies.csv")) {
            CsvToBean<MovieStats> csvToBean = new CsvToBeanBuilder<MovieStats>(reader)
                    .withType(MovieStats.class)
                    .withSkipLines(1) // Skip header
                    .build();

            movieStatsList = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
