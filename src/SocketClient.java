import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("127.0.0.1", SocketServer.COMMUNICATION_PORT);
        ObjectInputStream inputStream = null;
        inputStream = new ObjectInputStream(socket.getInputStream());
        String message = (String) inputStream.readObject();
        System.out.println("Message: " + message);
        inputStream.close();
    }

}
