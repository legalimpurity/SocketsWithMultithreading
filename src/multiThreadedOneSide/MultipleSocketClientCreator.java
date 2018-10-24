package multiThreadedOneSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.stream.IntStream;

import static constants.Configs.*;

public class MultipleSocketClientCreator {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        IntStream.range(0, 10).parallel().forEach(
            nbr -> {
                System.out.println("Creating Client "+nbr);
                try {
                    MultipleSocketClientClass mscc = new MultipleSocketClientClass(nbr);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println(nbr);
            }
        );
    }


}
