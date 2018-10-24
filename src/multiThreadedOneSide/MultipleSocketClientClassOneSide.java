package multiThreadedOneSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import static constants.Configs.COMMUNICATION_PORT;
import static constants.Configs.HOST_ADDRESS;

public class MultipleSocketClientClassOneSide {

    public MultipleSocketClientClassOneSide(int clientID) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(HOST_ADDRESS, COMMUNICATION_PORT);
        ObjectInputStream inputStream = null;
        inputStream = new ObjectInputStream(socket.getInputStream());
        String message = (String) inputStream.readObject();
        System.out.println("Message from Server to client "+clientID+" : "+ message);
        inputStream.close();
    }
}
