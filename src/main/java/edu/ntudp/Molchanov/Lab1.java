package edu.ntudp.Molchanov;

import java.util.Scanner;
import java.util.Random;

public class Lab1 {
    // Константи для діапазону рандомних чисел
    private static final int MIN_RANDOM_VALUE = -100;
    private static final int MAX_RANDOM_VALUE = 100;
    private static final int MAX_SIZE = 20;

    private static Scanner scanner = new Scanner(System.in);
    private static int[][] matrix;
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        System.out.println("=== Програма для роботи з матрицями ===\n");

        // Введення розмірів матриці
        inputMatrixSize();

        // Вибір способу створення матриці
        int choice = chooseCreationMethod();

        // Створення матриці
        if (choice == 1) {
            createMatrixManually();
        } else {
            createMatrixRandomly();
        }

        // Виведення матриці
        printMatrix();

        // Пошук мінімального елемента
        int min = findMinimum();
        System.out.println("\nМінімальний елемент: " + min);

        // Пошук максимального елемента
        int max = findMaximum();
        System.out.println("Максимальний елемент: " + max);

        // Розрахунок середнього арифметичного
        double avg = calculateAverage();
        System.out.printf("Середнє арифметичне: %.2f%n", avg);

        scanner.close();
    }

    /**
     * Метод для введення розмірів матриці
     */
    private static void inputMatrixSize() {
        do {
            System.out.print("Введіть кількість рядків (1-" + MAX_SIZE + "): ");
            rows = scanner.nextInt();
            if (rows < 1 || rows > MAX_SIZE) {
                System.out.println("Помилка! Кількість рядків повинна бути від 1 до " + MAX_SIZE);
            }
        } while (rows < 1 || rows > MAX_SIZE);

        do {
            System.out.print("Введіть кількість стовпців (1-" + MAX_SIZE + "): ");
            cols = scanner.nextInt();
            if (cols < 1 || cols > MAX_SIZE) {
                System.out.println("Помилка! Кількість стовпців повинна бути від 1 до " + MAX_SIZE);
            }
        } while (cols < 1 || cols > MAX_SIZE);

        matrix = new int[rows][cols];
    }

    /**
     * Метод для вибору способу створення матриці
     *
     * @return 1 - ручне введення, 2 - рандомне заповнення
     */
    private static int chooseCreationMethod() {
        int choice;
        do {
            System.out.println("\nОберіть спосіб створення матриці:");
            System.out.println("1 - Ручне введення з клавіатури");
            System.out.println("2 - Рандомне заповнення");
            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 2) {
                System.out.println("Помилка! Оберіть 1 або 2.");
            }
        } while (choice < 1 || choice > 2);

        return choice;
    }

    /**
     * Метод для ручного створення матриці
     */
    private static void createMatrixManually() {
        System.out.println("\nВведіть елементи матриці:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    /**
     * Метод для рандомного створення матриці
     */
    private static void createMatrixRandomly() {
        Random random = new Random();
        System.out.println("\nМатриця створюється рандомно...");
        System.out.println("Діапазон значень: від " + MIN_RANDOM_VALUE + " до " + MAX_RANDOM_VALUE);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE;
            }
        }
    }

    /**
     * Метод для виведення матриці на екран
     */
    private static void printMatrix() {
        System.out.println("\nМатриця:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%6d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Метод для пошуку мінімального елемента
     *
     * @return мінімальне значення в матриці
     */
    private static int findMinimum() {
        int min = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    /**
     * Метод для пошуку максимального елемента
     *
     * @return максимальне значення в матриці
     */
    private static int findMaximum() {
        int max = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    /**
     * Метод для розрахунку середнього арифметичного
     *
     * @return середнє арифметичне всіх елементів матриці
     */
    private static double calculateAverage() {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
                count++;
            }
        }

        return (double) sum / count;
    }
}
