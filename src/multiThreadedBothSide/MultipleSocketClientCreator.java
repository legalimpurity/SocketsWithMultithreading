package multiThreadedBothSide;

import java.io.IOException;
import java.util.stream.IntStream;

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
