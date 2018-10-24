import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static int COMMUNICATION_PORT = 2981;


    private static ServerSocket server;


    public static void main(String args[]) throws IOException, ClassNotFoundException {

        server = new ServerSocket(COMMUNICATION_PORT);

        while(true) {
            System.out.println("Waiting for client request");
            Socket socket = server.accept();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject("This is my message for you!");
            objectOutputStream.close();
            socket.close();
        }
    }
}
