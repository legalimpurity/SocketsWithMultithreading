package multiThreadedOneSide;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static constants.Configs.COMMUNICATION_PORT;

public class MultiThreadedSocketServerOneSide {




    public static void main(String args[]) throws IOException {

        ServerSocket server;

        int POOL_SIZE=10;

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        server = new ServerSocket(COMMUNICATION_PORT);

        while(true) {
            System.out.println("Waiting for clients.");

            // Blocks until a client asks to make a connection.
            Socket socket = server.accept();

            // Manages the connection on a different thread.
            executor.submit(()->{
                ObjectOutputStream objectOutputStream = null;
                try {
                    objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject("This is my servers message for you!");
                    objectOutputStream.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
    }

}
