import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Начало программы");
        System.out.println("Начнём!");
        Scanner scanner = new Scanner(System.in);
        int n;
        logger.log("Просим пользователя ввести входные данные для списка");
        while(true) {
            try {
                System.out.println("Введите размер списка:");
                n = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                logger.log("Пользователь произвел некорректный ввод размера");
                System.out.println("Некорректный ввод размера");
            }
        }
        int m;
        while (true) {
            try {
                System.out.println("Введите верхнюю границу значений элементов:");
                m = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                logger.log("Пользователь произвел некорректный ввод границы");
                System.out.println("Некорректный ввод границы");
            }
        }
        logger.log("Создаем и наполняем список");
        Random r = new Random();
        int finalM = m;
        List<Integer> numlist = new ArrayList<>(Arrays.asList(new Integer[n]))
                .stream()
                .map(num -> r.nextInt(finalM))
                .toList();
        StringBuilder sb = new StringBuilder(n);
        sb.append("Вот случайный список: ");
        for (Integer num : numlist) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите число для фильтрации списка:");
        int f;
        while (true) {
            try {
                f = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                logger.log("Пользователь произвел некорректный ввод числа фильтрации");
                System.out.println("Некорректный ввод числа фильтрации");
            }
        }
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(f);
        List<Integer> filteredList = filter.filterOut(numlist);
        logger.log("Фильтрация завершена, прошло фильтрацию элементов: " + filteredList.size() + " из " + numlist.size());
        sb.delete(0, sb.length());
        sb.append("Вот отфильтрованный список: ");
        for (Integer num : filteredList) {
            sb.append(num).append(" ");
        }
        logger.log("Выводим результат на экран");
        System.out.println(sb);
        logger.log("Завершаем программу");
    }
}
