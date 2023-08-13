//package edu.sdccd.cisc191.template;
//
//import com.opencsv.bean.CsvToBeanBuilder;
//
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.stream.Collectors;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//public class MovieGUI extends Application {
//    private Client client;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        client = new Client();
//
//        primaryStage.setTitle("Movie Management");
//
//        GridPane grid = new GridPane();
//        grid.setAlignment(javafx.geometry.Pos.CENTER);
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(25, 25, 25, 25));
//
//        // Create movie input fields
//        TextField nameField = new TextField();
//        TextField genreField = new TextField();
//        TextField studioField = new TextField();
//        TextField ratingField = new TextField();
//        TextField yearField = new TextField();
//
//        // Add movie labels and input fields to the grid
//        grid.add(new Label("Name:"), 0, 0);
//        grid.add(nameField, 1, 0);
//        grid.add(new Label("Genre:"), 0, 1);
//        grid.add(genreField, 1, 1);
//        grid.add(new Label("Studio:"), 0, 2);
//        grid.add(studioField, 1, 2);
//        grid.add(new Label("Rating:"), 0, 3);
//        grid.add(ratingField, 1, 3);
//        grid.add(new Label("Year:"), 0, 4);
//        grid.add(yearField, 1, 4);
//
//        // Create buttons
//        Button addButton = new Button("Add Movie");
//        Button removeButton = new Button("Remove Movie");
//
//        // Add buttons to the grid
//        grid.add(addButton, 0, 5);
//        grid.add(removeButton, 1, 5);
//
//        // Set button actions
//        addButton.setOnAction(e -> addMovie(
//                nameField.getText(),
//                genreField.getText(),
//                studioField.getText(),
//                Integer.parseInt(ratingField.getText()),
//                Integer.parseInt(yearField.getText())
//        ));
//
//        removeButton.setOnAction(e -> removeMovie(nameField.getText()));
//
//        Scene scene = new Scene(grid, 400, 300);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private void addMovie(String name, String genre, String studio, int rating, int year) {
//        try {
//            client.startConnection("127.0.0.1", 4444);
//
//            // Create a movie request
//            Movie requestMovie = new Movie(name, genre, studio, rating, year);
//            String jsonRequest = Movie.toJSON(requestMovie);
//
//            // Send the movie request
//            client.out.println(jsonRequest);
//
//            // Read and print the movie response
//            String jsonResponse = client.in.readLine();
//            Movie responseMovie = Movie.fromJSON(jsonResponse);
//            System.out.println("Added movie: " + responseMovie.toString());
//
//            client.stopConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void removeMovie(String name) {
//        // Implement the logic to send a remove request to the server
//        // You'll need to handle this in the Client class and Server class
//    }
//}
