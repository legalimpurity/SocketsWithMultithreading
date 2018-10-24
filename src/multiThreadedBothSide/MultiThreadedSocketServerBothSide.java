package multiThreadedBothSide;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static constants.Configs.COMMUNICATION_PORT;

public class MultiThreadedSocketServerBothSide {




    public static void main(String args[]) throws IOException {

        ServerSocket server;

        int POOL_SIZE=10;

        ExecutorService executor = Executors.newCachedThreadPool();

        server = new ServerSocket(COMMUNICATION_PORT);

        while(true) {
            System.out.println("Waiting for clients.");

            // Blocks until a client asks to make a connection.
            Socket socket = server.accept();

            // Manages the connection on a different thread.
            executor.submit(new MultiThreadedSocketServerBothSideRunnable(socket));

        }
    }

}
