import java.util.Random;

public class Main {

    public static void main(String[] args) {
        try {

            int rows = 6;
            int cols = 6;
            char[][] matrix = generateRandomCharMatrix(rows, cols);

            System.out.println("Початкова матриця:");
            printMatrix(matrix);


            char[][] transposedMatrix = transposeMatrix(matrix);
            System.out.println("Транспонована матриця:");
            printMatrix(transposedMatrix);


            int sum = calculateSum(matrix);
            System.out.println("Сума елементів за умовою: " + sum);

        } catch (Exception e) {
            System.err.println("Виникла помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static char[][] generateRandomCharMatrix(int rows, int cols) {
        Random random = new Random();
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (char) ('A' + random.nextInt(26));
            }
        }
        return matrix;
    }


    private static char[][] transposeMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] transposed = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }


    private static int calculateSum(char[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int rowMax = Character.MIN_VALUE;
            int rowMin = Character.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                char current = matrix[i][j];
                if (i % 2 == 0) { // Парні рядки
                    rowMin = Math.min(rowMin, current);
                } else { // Непарні рядки
                    rowMax = Math.max(rowMax, current);
                }
            }
            sum += (i % 2 == 0) ? rowMin : rowMax;
        }
        return sum;
    }


    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
