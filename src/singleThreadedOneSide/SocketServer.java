package singleThreadedOneSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static constants.Configs.COMMUNICATION_PORT;

public class SocketServer {

    private static ServerSocket server;

    public static void main(String args[]) throws IOException, ClassNotFoundException {

        server = new ServerSocket(COMMUNICATION_PORT);

        while(true) {
            System.out.println("Waiting for client request");
            Socket socket = server.accept();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject("This is my servers message for you!");
            objectOutputStream.close();
            socket.close();
        }
    }
}
