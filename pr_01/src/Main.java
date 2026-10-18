import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Если переданы аргументы
        if (args.length > 0) {
            System.out.println("Аргументы командной строки:");

            for (String arg : args) {
                System.out.println(arg);
            }

            runFromArgs(args);

            scanner.close();
            return;
        }

        while (true) {
            System.out.println("\nВыберите задачу:");
            System.out.println("1 - Периметр квадрата");
            System.out.println("2 - Стоимость конфет");
            System.out.println("3 - Изменение числа");
            System.out.println("4 - Большее из двух чисел");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Введите сторону квадрата a: ");
                    double a = scanner.nextDouble();

                    task01(a);
                    break;

                case 2:
                    System.out.print("Введите количество конфет X (кг): ");
                    double x = scanner.nextDouble();

                    System.out.print("Введите стоимость X кг (руб.): ");
                    double A = scanner.nextDouble();

                    System.out.print("Введите количество конфет Y (кг): ");
                    double y = scanner.nextDouble();

                    task02(x, A, y);
                    break;

                case 3:
                    System.out.print("Введите целое число: ");
                    int number = scanner.nextInt();

                    task03(number);
                    break;

                case 4:
                    System.out.print("Введите первое число: ");
                    double first = scanner.nextDouble();

                    System.out.print("Введите второе число: ");
                    double second = scanner.nextDouble();

                    task04(first, second);
                    break;

                case 0:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Ошибка: такой задачи нет.");
            }
        }
    }

    // Запуск задач через аргументы 
    public static void runFromArgs(String[] args) {

        int task = Integer.parseInt(args[0]);

        switch (task) {

            case 1:
                if (args.length < 2) {
                    System.out.println("Ошибка: для задачи 1 нужно указать сторону a.");
                    return;
                }

                double a = Double.parseDouble(args[1]);
                task01(a);
                break;

            case 2:
                if (args.length < 4) {
                    System.out.println("Ошибка: для задачи 2 нужны X, A и Y.");
                    return;
                }

                double x = Double.parseDouble(args[1]);
                double A = Double.parseDouble(args[2]);
                double y = Double.parseDouble(args[3]);

                task02(x, A, y);
                break;

            case 3:
                if (args.length < 2) {
                    System.out.println("Ошибка: для задачи 3 нужно указать число.");
                    return;
                }

                int number = Integer.parseInt(args[1]);
                task03(number);
                break;

            case 4:
                if (args.length < 3) {
                    System.out.println("Ошибка: для задачи 4 нужны два числа.");
                    return;
                }

                double first = Double.parseDouble(args[1]);
                double second = Double.parseDouble(args[2]);

                task04(first, second);
                break;

            default:
                System.out.println("Ошибка: такой задачи нет.");
        }
    }

    // Задача 1
    public static void task01(double a) {
        if (a <= 0) {
            System.out.println("Ошибка: сторона квадрата должна быть больше 0.");
            return;
        }

        double P = 4 * a;

        System.out.println("Периметр квадрата P = " + P);
    }

    // Задача 2
    public static void task02(double x, double A, double y) {
        if (x <= 0) {
            System.out.println("Ошибка: количество X должно быть больше 0.");
            return;
        }

        if (A < 0) {
            System.out.println("Ошибка: стоимость не может быть отрицательной.");
            return;
        }

        if (y < 0) {
            System.out.println("Ошибка: количество Y не может быть отрицательным.");
            return;
        }

        double pricePerKg = A / x;
        double priceYKg = pricePerKg * y;

        System.out.println("Стоимость 1 кг конфет = " + pricePerKg + " руб.");
        System.out.println("Стоимость " + y + " кг конфет = " + priceYKg + " руб.");
    }

    // Задача 3
    public static void task03(int number) {
        if (number > 0) {
            number = number - 8;
        }

        System.out.println("Полученное число: " + number);
    }

    // Задача 4
    public static void task04(double a, double b) {
        if (a > b) {
            System.out.println("Большее число: " + a);
        } else {
            System.out.println("Большее число: " + b);
        }
    }
}
