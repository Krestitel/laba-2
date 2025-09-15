import java.util.Scanner;

public class Tasks {

    // Задание №1: Проверка возможности построения треугольника
    public static String triangleCheck(double a, double b, double c) {
        if (a + b > c && a + c > b && b + c > a) {
            return "Треугольник";
        } else {
            return "Не треугольник";
        }
    }

    // Задание №2: Длина отрезка
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Задание №3: Отрицательная степень
    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            return base * power(base, exponent - 1);
        } else {
            return 1 / (base * power(base, -exponent - 1));
        }
    }

    // Задание №4: Рекурсивное возведение в степень
    public static double recursivePower(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * recursivePower(x, n - 1);
    }

    // Задание №5: Числа Трибовочки
    public static int tribonacci(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание №1: Проверка треугольника ===");
        System.out.print("Введите три стороны треугольника: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        System.out.println(triangleCheck(a, b, c));

        System.out.println("\n=== Задание №2: Длина отрезка ===");
        System.out.print("Введите координаты двух точек (x1 y1 x2 y2): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        System.out.printf("Расстояние: %.2f\n", distance(x1, y1, x2, y2));

        System.out.println("\n=== Задание №3: Отрицательная степень ===");
        System.out.print("Введите основание и показатель степени: ");
        double base = scanner.nextDouble();
        int exp = scanner.nextInt();
        System.out.printf("Результат: %.4f\n", power(base, exp));

        System.out.println("\n=== Задание №4: Рекурсивное возведение в степень ===");
        System.out.print("Введите основание и неотрицательный показатель: ");
        double x = scanner.nextDouble();
        int n = scanner.nextInt();
        System.out.printf("Результат: %.4f\n", recursivePower(x, n));

        System.out.println("\n=== Задание №5: Числа Трибовочки ===");
        System.out.print("Введите номер числа Трибовочки: ");
        int num = scanner.nextInt();
        System.out.println("T(" + num + ") = " + tribonacci(num));

        scanner.close();
    }
}