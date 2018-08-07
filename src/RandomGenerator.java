import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private int getNumber(int min, int max) {
        return new Random().nextInt((max + 1) - min);
    }

    public List<Integer> getRandomNumbers(int numberCount, int min, int max) {
        List<Integer> result = new ArrayList<>();
        int iterator = numberCount;
        while (iterator > 0) {
            int number = getRandomNumber(min, max);
            if (!result.isEmpty() && !result.contains(number)) {
                result.add(number);
                iterator--;
            }
        }
        return result;
    }

    public int getRandomNumber(int min, int max) {
        int listCapacity = 10;
        List<ListHolder> numbers = new ArrayList<>(10);
        int iterator = listCapacity;
        while (iterator > 0) {
            List<Integer> numberList = new ArrayList<>(getRandomNumbers(listCapacity, min, max));
            numbers.add(new ListHolder(numberList));
            iterator--;
        }
        return numbers.get(getNumber(0, --listCapacity)).getList().get(getNumber(0, --listCapacity));
    }
}
