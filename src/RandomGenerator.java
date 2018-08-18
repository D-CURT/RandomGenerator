import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private int getNumber(int min, int max) {
        return new Random().nextInt((max + 1) - min) + min;
    }

    private List<Integer> getNumbers(int numberCount, int min, int max) {
        List<Integer> result = new ArrayList<>();
        int iterator = numberCount;
        while (iterator > 0) {
            int number = getNumber(min, max);
            result.add(number);
            iterator--;
        }
        return result;
    }

    public int getRandomNumber(int min, int max) {
        int listCapacity = 1000;
        List<List<Integer>> numbers = new ArrayList<>(listCapacity);
        int iterator = listCapacity;
        while (iterator > 0) {
            numbers.add(new ArrayList<>(getNumbers(listCapacity, min, max)));
            iterator--;
        }
        return numbers.get(getNumber(0, listCapacity - 1)).get(getNumber(0, listCapacity - 1));
    }

    public List<Integer> getRandomNumbers(int numberCount, int min, int max) {
        List<Integer> result = new ArrayList<>();
        int iterator = numberCount;
        while (iterator > 0) {
            int number = getRandomNumber(min, max);
            result.add(number);
            iterator--;
        }
        return result;
    }

}
