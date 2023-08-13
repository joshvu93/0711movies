package edu.sdccd.cisc191.template;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            Request request = new Request("getMovies");
            out.writeObject(request);

            Response response = (Response) in.readObject();
            List<Movie> movies = response.getMovies();

            for (Movie movie : movies) {
                System.out.println(movie.getFilm() + " - " + movie.getGenre() + " - " + movie.getStudio());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
