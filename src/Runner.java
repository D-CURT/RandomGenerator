
import java.io.IOException;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws IOException {
        RandomGenerator generator = new RandomGenerator();
        Queue<Integer> queue;
        int quantity, min, max;
        boolean exit = false;
        System.out.println("\nThe random generator welcome you.");
        try {
            do {
                pause();
                System.out.println("\n\nMain menu:");
                System.out.println(1 + ") Get a number;");
                System.out.println(2 + ") Get an array of numbers;");
                System.out.println(3 + ") Exit the generator.");
                System.out.print("Choose a menu item: ");
                int menuItem = inputNumber();
                switch (menuItem) {
                    case 1:
                        queue = getQueueValues(menuItem);
                        min = queue.poll();
                        max = queue.poll();
                        System.out.print("\nYour number is: " + generator.getRandomNumber(min, max));
                        break;
                    case 2:
                        queue = getQueueValues(menuItem);
                        quantity = queue.poll();
                        min = queue.poll();
                        max = queue.poll();
                        List<Integer> list = generator.getRandomNumbers(quantity, min, max);
                        System.out.println("\nYour numbers are:");
                        int marker = (max <= 100)? 1 : (max <= 1000)? 2 : (max <= 10000)? 3 : (max <= 100000)? 4 : (max <= 1000000)? 5 : 6;
                        String f;
                        switch (marker) {
                            case 1: f = "%2d"; break;
                            case 2: f = "%3d"; break;
                            case 3: f = "%4d"; break;
                            case 4: f = "%5d"; break;
                            case 5: f = "%6d"; break;
                            default: f = "%7d";
                        }
                        String s;

                        for (int i = 0; i < list.size(); i++) {
                            if ((i + 1) % 10 == 0)
                                s = "; \n";
                            else
                                s = ", ";
                            System.out.printf(f + s, list.get(i));
                        }
                        break;
                    case 3:
                        exit = true;
                        break;
                    default: System.out.println("\nError: input a number (1-3):"); break;
                }
            } while (!exit);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    private static void pause() throws IOException {
        System.out.println("\nPress [Enter] to continue.");

        int tmp;
        do {
            tmp = System.in.read();
        } while (tmp != 10);
    }

    private static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
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

    private static Queue<Integer> getQueueValues(int menuItem) {
        Queue<Integer> queue = new ArrayDeque<>();
        if (menuItem == 2) {
            System.out.print("\nQuantity of numbers: ");
            queue.add(inputNumber());
        }
        System.out.print("\nYour min value: ");
        queue.add(inputNumber());
        System.out.print("\nYour max value: ");
        queue.add(inputNumber());
        return queue;
    }
}
