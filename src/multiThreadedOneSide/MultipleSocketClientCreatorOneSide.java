package multiThreadedOneSide;

import java.io.IOException;
import java.util.stream.IntStream;

public class MultipleSocketClientCreatorOneSide {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        IntStream.range(0, 10).parallel().forEach(
            nbr -> {
                System.out.println("Creating Client "+nbr);
                try {
                    MultipleSocketClientClassOneSide mscc = new MultipleSocketClientClassOneSide(nbr);
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
