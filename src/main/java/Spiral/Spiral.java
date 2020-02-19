package Spiral;

public class Spiral {
    static final int N = 5;

    public static void main(String[] args) {

        int[][] array = new int[N][N];
        int minCol = 0;
        int maxCol = N-1;
        int minRow = 0;
        int maxRow = N-1;

        for (int value = 1; value <= N * N; minCol++, minRow++, maxCol--, maxRow--) {

            for (int i = minCol; i <= maxCol; i++, value++) {
                array[minRow][i] = value;
            }

            for (int i = minRow + 1; i <= maxRow; i++, value++) {
                array[i][maxCol] = value;
            }

            for (int i = maxCol - 1; i >= minCol; i--, value++) {
                array[maxRow][i] = value;
            }

            for (int i = maxRow - 1; i >= minRow + 1; i--, value++) {
                array[i][minCol] = value;
            }
        }
        print(array);
    }

    public static void print(int[][] array) {
        for (int[] a : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(a[j] + "\t");
            }
            System.out.println();
        }
    }
}
