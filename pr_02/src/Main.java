import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Режим командной строки
        if (args.length > 0) {
            System.out.println("Аргументы командной строки:");
            for (String arg : args) {
                System.out.println(arg);
            }
            runFromArgs(args);
            return;
        }

        // Интерактивный режим (меню)
        while (true) {
            System.out.println("\nВыберите задачу:");
            System.out.println("1 - Наименьшее и наибольшее из трех чисел");
            System.out.println("2 - Вывести N раз число K");
            System.out.println("3 - Длина незанятой части отрезка");
            System.out.println("4 - Минимальный и максимальный элемент массива");
            System.out.println("5 - Массив из N первых нечетных чисел");
            System.out.println("6 - Два соседних элемента с максимальной суммой");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите первое число: ");
                    double a1 = scanner.nextDouble();
                    System.out.print("Введите второе число: ");
                    double b1 = scanner.nextDouble();
                    System.out.print("Введите третье число: ");
                    double c1 = scanner.nextDouble();
                    task01(a1, b1, c1);
                    break;
                case 2:
                    System.out.print("Введите K: ");
                    int k2 = scanner.nextInt();
                    System.out.print("Введите N: ");
                    int n2 = scanner.nextInt();
                    task02(k2, n2);
                    break;
                case 3:
                    System.out.print("Введите A: ");
                    double a3 = scanner.nextDouble();
                    System.out.print("Введите B: ");
                    double b3 = scanner.nextDouble();
                    task03(a3, b3);
                    break;
                case 4:
                    System.out.print("Введите количество чисел (N): ");
                    int n4 = scanner.nextInt();
                    if (n4 <= 0) {
                        System.out.println("Ошибка: N должно быть больше 0.");
                        break;
                    }
                    int[] arr4 = new int[n4];
                    System.out.println("Введите " + n4 + " чисел:");
                    for (int i = 0; i < n4; i++) {
                        arr4[i] = scanner.nextInt();
                    }
                    task04(arr4);
                    break;
                case 5:
                    System.out.print("Введите количество чисел (N): ");
                    int n5 = scanner.nextInt();
                    task05(n5);
                    break;
                case 6:
                    System.out.print("Введите количество чисел (N): ");
                    int n6 = scanner.nextInt();
                    if (n6 < 2) {
                        System.out.println("Ошибка: нужно минимум 2 числа.");
                        break;
                    }
                    int[] arr6 = new int[n6];
                    System.out.println("Введите " + n6 + " чисел:");
                    for (int i = 0; i < n6; i++) {
                        arr6[i] = scanner.nextInt();
                    }
                    task06(arr6);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    // ================= РЕЖИМ АРГУМЕНТОВ =================
    public static void runFromArgs(String[] args) {
        if (args.length < 1) return;
        int taskNumber = Integer.parseInt(args[0]);

        switch (taskNumber) {
            case 1:
                if (args.length < 4) {
                    System.out.println("Ошибка: для задачи 1 нужны три числа.");
                    return;
                }
                task01(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                break;
            case 2:
                if (args.length < 3) {
                    System.out.println("Ошибка: для задачи 2 нужны K и N.");
                    return;
                }
                task02(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                break;
            case 3:
                if (args.length < 3) {
                    System.out.println("Ошибка: для задачи 3 нужны A и B.");
                    return;
                }
                task03(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                break;
            case 4:
                if (args.length < 2) {
                    System.out.println("Ошибка: для задачи 4 нужны N и числа.");
                    return;
                }
                int n4 = Integer.parseInt(args[1]);
                if (args.length < 2 + n4) {
                    System.out.println("Ошибка: указано меньше чисел, чем заявлено в N.");
                    return;
                }
                int[] arr4 = new int[n4];
                for (int i = 0; i < n4; i++) {
                    arr4[i] = Integer.parseInt(args[i + 2]);
                }
                task04(arr4);
                break;
            case 5:
                if (args.length < 2) {
                    System.out.println("Ошибка: для задачи 5 нужно указать N.");
                    return;
                }
                task05(Integer.parseInt(args[1]));
                break;
            case 6:
                if (args.length < 2) {
                    System.out.println("Ошибка: для задачи 6 нужны N и числа.");
                    return;
                }
                int n6 = Integer.parseInt(args[1]);
                if (args.length < 2 + n6) {
                    System.out.println("Ошибка: указано меньше чисел, чем заявлено в N.");
                    return;
                }
                int[] arr6 = new int[n6];
                for (int i = 0; i < n6; i++) {
                    arr6[i] = Integer.parseInt(args[i + 2]);
                }
                task06(arr6);
                break;
            default:
                System.out.println("Неверный номер задачи.");
        }
    }

    // Задача 1 (54)
    public static void task01(double a, double b, double c) {
        System.out.println("Наименьшее: " + min(a, b, c));
        System.out.println("Наибольшее: " + max(a, b, c));
    }

    public static double min(double a, double b) { return a < b ? a : b; }
    public static double min(double a, double b, double c) { return min(min(a, b), c); }
    public static double max(double a, double b) { return a > b ? a : b; }
    public static double max(double a, double b, double c) { return max(max(a, b), c); }

    // Задача 2 (71)
    public static void task02(int k, int n) {
        if (n <= 0) {
            System.out.println("Ошибка: N должно быть больше 0.");
            return;
        }
        printNTimes(k, n);
    }

    public static void printNTimes(int k, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(k);
            if (i < n) System.out.print(" ");
        }
        System.out.println();
    }

    // Задача 3 (111)
    public static void task03(double a, double b) {
        if (a <= 0 || b <= 0) {
            System.out.println("Ошибка: A и B должны быть положительными.");
            return;
        }
        if (a <= b) {
            System.out.println("Ошибка: A должно быть больше B.");
            return;
        }
        double remainder = remainderBySubtraction(a, b);
        System.out.println("Длина незанятой части: " + remainder);
    }

    public static double remainderBySubtraction(double a, double b) {
        while (a >= b) {
            a -= b;
        }
        return a;
    }

    // Задача 4 (141)
    public static void task04(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Ошибка: массив пуст.");
            return;
        }
        System.out.println("Минимальный элемент: " + findMin(arr));
        System.out.println("Максимальный элемент: " + findMax(arr));
    }

    public static int findMin(int[] arr) {
        return findMin(arr, 0, arr.length - 1);
    }

    public static int findMin(int[] arr, int from, int to) {
        int min = arr[from];
        for (int i = from + 1; i <= to; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static int findMax(int[] arr) {
        return findMax(arr, 0, arr.length - 1);
    }

    public static int findMax(int[] arr, int from, int to) {
        int max = arr[from];
        for (int i = from + 1; i <= to; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    // Задача 5 (171)
    public static void task05(int n) {
        if (n <= 0) {
            System.out.println("Ошибка: N должно быть больше 0.");
            return;
        }
        
        int[] oddArray = new int[n];
        
        // Заполняем массив первыми N положительными нечетными числами
        for (int i = 0; i < n; i++) {
            // Формула нечетного числа: 2 * i + 1 (при i=0 это 1, при i=1 это 3)
            oddArray[i] = 2 * i + 1;
        }
        
        System.out.println("Сформированный массив:");
        for (int i = 0; i < n; i++) {
            System.out.print(oddArray[i] + " ");
        }
        System.out.println();
    }

    // Задача 6 (211)
    public static void task06(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Ошибка: нужно минимум два элемента.");
            return;
        }

        int maxSum = arr[0] + arr[1];
        int bestIndex = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int currentSum = arr[i] + arr[i + 1];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestIndex = i;
            }
        }

        System.out.println("Соседние элементы с максимальной суммой (" + maxSum + "):");
        System.out.println(arr[bestIndex] + " и " + arr[bestIndex + 1]);
    }
}