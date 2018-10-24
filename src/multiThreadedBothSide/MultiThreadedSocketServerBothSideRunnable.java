package multiThreadedBothSide;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MultiThreadedSocketServerBothSideRunnable implements Runnable {

    private Socket socket;

    public MultiThreadedSocketServerBothSideRunnable(Socket sock)
    {
        socket = sock;
    }

    @Override public void run() {
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject("This is my servers message for you!");
            wait();
            objectOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
