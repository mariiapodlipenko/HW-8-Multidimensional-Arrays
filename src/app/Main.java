package app;

public class Main {

    final static int N = 4;

    public static void main(String[] args) {

        int[][] matrix = new int[N][N];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 50) + 1;
            }
        }

        System.out.println("Matrix 4x4:");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        int evenRowSum = 0;
        int oddRowSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i % 2 == 0) {
                    evenRowSum += matrix[i][j];
                } else {
                    oddRowSum += matrix[i][j];
                }
            }
        }

        System.out.println("Sum of elements in even rows: " + evenRowSum);
        System.out.println("Sum of elements in odd rows: " + oddRowSum);

        long evenColProduct = 1;
        long oddColProduct = 1;

        for (int j = 0; j < N; j++) {
            long columnProduct = 1;
            for (int i = 0; i < N; i++) {
                columnProduct *= matrix[i][j];
            }
            if (j % 2 == 0) {
                evenColProduct *= columnProduct;
            } else {
                oddColProduct *= columnProduct;
            }
        }

        System.out.println("Product of elements in even columns: " + evenColProduct);
        System.out.println("Product of elements in odd columns: " + oddColProduct);

        boolean isMagSqr = true;
        int sumdiagonal1 = 0;
        int sumdiagonal2 = 0;

        for (int i = 0; i < N; i++) {
            sumdiagonal1 += matrix[i][i];
            sumdiagonal2 += matrix[i][N - 1 - i];
        }
        if (sumdiagonal1 != sumdiagonal2) {
            isMagSqr = false;
        }

        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < N; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }

            if (rowSum != colSum || colSum != sumdiagonal1) {
                isMagSqr = false;
                break;
            }
        }

        if (isMagSqr) {
            System.out.println("The matrix is a Magic Square");
        } else {
            System.out.println("The matrix is NOT a Magic Square");
        }
    }
}
