package lab1.task4;

public class Main {
    /*
    4. Створіть функцію що перевірить чи є переданий квадратний масив
магічним квадратом. Магічний квадрат – квадратна таблиця, заповнена таким
чином, що сума чисел у кожному рядку, стовпчику і на обох діагоналях
однакова.
     */

    public static void main(String[] args) {
        int[][] magicSquare = {
                {8, 1, 6},
                {3, 5, 7},
                {4, 9, 2}
        };

        int[][] nonMagicSquare = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Is magic square: " + isMagicSquare(magicSquare));
        System.out.println("Is magic square: " + isMagicSquare(nonMagicSquare));
    }

    public static boolean isMagicSquare(int[][] square) {
        var n = square.length;
        var magicSum = n * (n * n + 1) / 2;

        var rowsLen = square.length;
        var colsLen = square[0].length;

        for (int i = 0; i < rowsLen; i++) {
            if (sumRow(square, i) != magicSum) {
                return false;
            }
        }
        for (int i = 0; i < colsLen; i++) {
            if (sumCol(square, i) != magicSum) {
                return false;
            }
        }

        // Перевірка діагоналей
        int diag1Sum = sumDiag(square, false);
        int diag2Sum = sumDiag(square, true);

        if (diag1Sum != magicSum || diag2Sum != magicSum) {
            return false;
        }

        return true;
    }

    public static int sumDiag(int[][] square, boolean reverse) {
        int sum = 0;
        int n = square.length;
        for (int i = 0; i < n; i++) {
            sum += reverse ? square[i][i] : square[i][n - 1 - i];
        }
        return sum;
    }

    public static int sumRow(int[][] square, int row) {
        int sum = 0;
        for (int i = 0; i < square[row].length; i++) {
            sum += square[row][i];
        }
        return sum;
    }

    public static int sumCol(int[][] square, int col) {
        int sum = 0;
        for (int[] ints : square) {
            sum += ints[col];
        }
        return sum;
    }

}
