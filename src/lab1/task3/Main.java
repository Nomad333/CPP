package lab1.task3;

public class Main {
    /*
    3. Створіть двовимірний масив довільної розмірності. Знайдіть
    найбільший елемент масиву. Перемістіть знайдений елемент у лівий верхній
    кут масиву шляхом перестановки рядків та стовпчиків масиву.
     */
    public static void main(String[] args) {
        int[][] arr = {
                {3, 5, 1},
                {7, 2, 4},
                {6, 8, 9}
        };

        moveMaxElToUpperLeftCorner(arr);
        
        System.out.println(arr[0][0]);
    }

    public static void moveMaxElToUpperLeftCorner(int[][] arr) {
        int maxEl = arr[0][0];
        int maxRow = 0;
        int maxCol = 0;

        // Знаходимо найбільший елемент та його позицію
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxEl) {
                    maxEl = arr[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        for (int i = maxRow; i > 0; i--) {
            swapRows(arr, i, i - 1);
        }
        for (int i = maxCol; i > 0; i--) {
            swapCols(arr, i, i - 1);
        }
    }

    public static void swapRows(int[][] arr, int row1, int row2) {
        int[] temp = arr[row1];
        arr[row1] = arr[row2];
        arr[row2] = temp;
    }

    public static void swapCols(int[][] arr, int col1, int col2) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i][col1];
            arr[i][col1] = arr[i][col2];
            arr[i][col2] = temp;
        }
    }
}
