// Write a Java program to perform matrix addition and multiplication

public class matrix_ops {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};

        int rows = a.length;
        int cols = a[0].length;

        // Matrix addition
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("Matrix Addition:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

        // Matrix multiplication
        int[][] product = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                product[i][j] = 0;
                for (int k = 0; k < cols; k++) {
                    product[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("Matrix Multiplication:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
    }
}
