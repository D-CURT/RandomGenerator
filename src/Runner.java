import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        System.out.println(new RandomGenerator().getRandomNumbers(50,0, 2));
        /*List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new RandomGenerator().getRandomNumber(0, 100));
        }
        System.out.println(list);*/

    }
}
