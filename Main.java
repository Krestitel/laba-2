import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Задание 1: Класс кнопки
class Button {
    private int clickCount;

    public Button() {
        this.clickCount = 0;
    }

    public void click() {
        clickCount++;
        System.out.println("Button was clicked " + clickCount + " times");
    }
}

// Задание 2: Класс весов
class Balance {
    private int leftWeight;
    private int rightWeight;

    public Balance() {
        this.leftWeight = 0;
        this.rightWeight = 0;
    }

    public void addLeft(int weight) {
        leftWeight += weight;
    }

    public void addRight(int weight) {
        rightWeight += weight;
    }

    public void result() {
        if (leftWeight == rightWeight) {
            System.out.println("=");
        } else if (rightWeight > leftWeight) {
            System.out.println("R");
        } else {
            System.out.println("L");
        }
    }
}

// Задание 3: Класс колокола
class Bell {
    private boolean isDing = true;

    public void sound() {
        if (isDing) {
            System.out.println("ding");
        } else {
            System.out.println("dong");
        }
        isDing = !isDing;
    }
}

// Задание 4: Разделитель четных и нечетных чисел
class OddEvenSeparator {
    private List<Integer> numbers;

    public OddEvenSeparator() {
        numbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void even() {
        System.out.print("Четные числа: ");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public void odd() {
        System.out.print("Нечетные числа: ");
        for (int num : numbers) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}

// Задание 5: Класс таблицы
class Table {
    private int[][] data;
    private int rows;
    private int cols;

    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(data[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public double average() {
        if (rows == 0 || cols == 0) return 0;

        double sum = 0;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += data[i][j];
                count++;
            }
        }
        return sum / count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 1: Кнопка ===");
        Button button = new Button();
        System.out.print("Сколько раз нажать на кнопку? ");
        int clickCount = scanner.nextInt();
        for (int i = 0; i < clickCount; i++) {
            button.click();
        }
        scanner.nextLine(); // очистка буфера

        System.out.println("\n=== Задание 2: Весы ===");
        Balance balance = new Balance();
        System.out.print("Введите вес для левой чаши: ");
        int leftWeight = scanner.nextInt();
        balance.addLeft(leftWeight);

        System.out.print("Введите вес для правой чаши: ");
        int rightWeight = scanner.nextInt();
        balance.addRight(rightWeight);

        System.out.print("Результат: ");
        balance.result();
        scanner.nextLine(); // очистка буфера

        System.out.println("\n=== Задание 3: Колокол ===");
        Bell bell = new Bell();
        System.out.print("Сколько раз прозвонить колокол? ");
        int bellRings = scanner.nextInt();
        for (int i = 0; i < bellRings; i++) {
            bell.sound();
        }
        scanner.nextLine(); // очистка буфера

        System.out.println("\n=== Задание 4: Разделитель чисел ===");
        OddEvenSeparator separator = new OddEvenSeparator();
        System.out.print("Сколько чисел хотите добавить? ");
        int numberCount = scanner.nextInt();

        for (int i = 0; i < numberCount; i++) {
            System.out.print("Введите число " + (i + 1) + ": ");
            int num = scanner.nextInt();
            separator.addNumber(num);
        }

        separator.even();
        separator.odd();
        scanner.nextLine(); // очистка буфера

        System.out.println("\n=== Задание 5: Таблица ===");
        System.out.print("Введите количество строк таблицы: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов таблицы: ");
        int cols = scanner.nextInt();

        Table table = new Table(rows, cols);

        System.out.println("Заполните таблицу значениями:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Введите значение для ячейки [" + i + "][" + j + "]: ");
                int value = scanner.nextInt();
                table.setValue(i, j, value);
            }
        }

        System.out.println("\nТаблица:");
        System.out.println(table.toString());

        System.out.println("Хотите прочитать значение из ячейки? (y/n)");
        scanner.nextLine(); // очистка буфера
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            System.out.print("Введите номер строки: ");
            int row = scanner.nextInt();
            System.out.print("Введите номер столбца: ");
            int col = scanner.nextInt();
            System.out.println("Значение в ячейке [" + row + "][" + col + "]: " + table.getValue(row, col));
        }

        System.out.println("Количество строк: " + table.rows());
        System.out.println("Количество столбцов: " + table.cols());
        System.out.println("Среднее арифметическое: " + table.average());

        scanner.close();
    }
}