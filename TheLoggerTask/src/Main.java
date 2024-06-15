import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int size;
    private static int boundaryForValues;
    private static int treshold;

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        Scanner scanner = new Scanner(System.in);

        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
        } else {
            logger.log("Введено не число!");
        }
        if (size <= 0) {
            logger.log("Введено некорректное число!");
        }

        System.out.print("Введите верхнюю границу для значений: ");
        if (scanner.hasNextInt()) {
            boundaryForValues = scanner.nextInt();
        } else {
            logger.log("Введено не число!");
        }
        if (boundaryForValues <= 0) {
            logger.log("Введено некорректное число!");
        }

        logger.log("Создаём и наполняем список");
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(boundaryForValues));
        }

        System.out.println("Вот случайный список: " + numbers);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        if (scanner.hasNextInt()) {
            treshold = scanner.nextInt();
        } else {
            logger.log("Введено не число!");
        }
        if (treshold <= 0 || treshold > boundaryForValues) {
            logger.log("Введено некорректное число!");
        }
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(numbers);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result);
        logger.log("Завершаем программу");

    }
}