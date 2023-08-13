package edu.sdccd.cisc191.template;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        List<MovieStats> stats = new CsvToBeanBuilder<MovieStats>(new InputStreamReader(Client.class.getResourceAsStream("/movies.csv")))
                .withType(MovieStats.class)
                .build()
                .parse();

        long streamTime = computeFilmStream(stats);
        long loopTime = computeFilmLoop(stats);

        System.out.println("\n-----RESULTS-----");
        System.out.println("Loop took " + loopTime + "ms to complete");
        System.out.println("Stream took " + streamTime + "ms to complete");
    }

    public static long computeFilmStream(List<MovieStats> stats) {
        System.out.println("\n-----Stream-----");
        long startTime = System.currentTimeMillis();

        Map<String, Integer> filmStats = stats.stream()
                .collect(Collectors.groupingBy(MovieStats::getFilm, TreeMap::new, Collectors.summingInt(MovieStats::getPercent)));

        filmStats.forEach((film, date) -> System.out.println(film + " " + date));

        return System.currentTimeMillis() - startTime;
    }

    public static long computeFilmLoop(List<MovieStats> stats) {
        System.out.println("\n-----Loop-----");
        long startTime = System.currentTimeMillis();

        Map<String, Integer> filmStats = new TreeMap<>();
        for (MovieStats stat : stats) {
            filmStats.merge(stat.getFilm(), stat.getPercent(), Integer::sum);
        }
        filmStats.forEach((film, date) -> System.out.println(film + " " + date));

        return System.currentTimeMillis() - startTime;
    }
}