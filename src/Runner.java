import java.io.IOException;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws IOException {
        RandomGenerator generator = new RandomGenerator();
        boolean exit = false;
        System.out.println("Random generator welcome you.");
        try {
            pause();
            do {
                System.out.println("\n\nMain menu:");
                System.out.println(1 + ") Get a number;");
                System.out.println(2 + ") Get an array of numbers;");
                System.out.println(3 + ") Exit the generator.");
                int menuItem = inputNumber();
                switch (menuItem) {
                    case 1:
                        Queue<Integer> queue = getMin_MaxValue();
                        int min = queue.poll();
                        int max = queue.poll();
                        System.out.print("\nYour number is: " + generator.getRandomNumber(min, max));
                        pause();
                        break;
                    case 2:  break;
                    case 3:
                        exit = true;
                        break;
                    default: System.out.println("\nError: input a number (1-3):"); break;
                }
            } while (!exit);
        /*List<Integer> list = new RandomGenerator().getRandomNumbers(30, 0, 7);
        String s;
        for (int i = 0; i < list.size(); i++) {
            if ((i + 1) % 10 == 0)
                s = "; \n";
            else
                s = ", ";
            System.out.print(list.get(i) + s);
        }
        System.out.println("\nPress any key to close.");

            System.in.read();*/
        } catch (IOException e) {
            pause();
        }

    }

    private static void pause() throws IOException{
        System.out.println("\nPress any key to continue.");
        int tmp;
        do {
            tmp = System.in.read();
        } while (tmp != 10);
    }

    private static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, input a number: ");
        String buffer = scanner.nextLine();
        if (checkInput(buffer)) return Integer.parseInt(buffer);
        else return 0;
    }

    private static boolean checkInput(String buffer) {
        for (int i = 0; i < buffer.length(); i++)
            if (!Character.isDigit(buffer.charAt(i)))
                return false;
        return true;
    }

    private static Queue<Integer> getMin_MaxValue() {
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println("Your min value:");
        queue.add(inputNumber());
        System.out.println("Your max value:");
        queue.add(inputNumber());
        return queue;
    }
}
