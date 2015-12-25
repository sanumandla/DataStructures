package main.java.general;

/**
 * Created by sridharanumandla on 11/20/14.
 */
public class NullRowColMatrixImproved {

    public static void main(String[] args) {
        NullRowColMatrixImproved improved = new NullRowColMatrixImproved();

        int source[][]={ {1,2,0,4,8}, {5,6,7,8,1}, {9,10,11,0,4}, {13,14,15,16,7} };

        System.out.println("Input array");
        improved.display(source);

        improved.nullRowCol(source);

        System.out.println("Output array");
        improved.display(source);
    }

    private void nullRowCol(int[][] source) {
        boolean entered = false;

        int row = 0;
        int column = 0;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                if (!entered) {
                    if (source[i][j] == 0) {
                        row = i;
                        column = j;
                        entered = true;
                        continue;
                    }
                } else if (source[i][j] == 0) {
                    source[row][j] = 0;
                    source[i][column] = 0;
                }
            }
        }

        for (int i = 0; i < source.length; i++) {
            if (source[i][column] == 0) {
                nullifyRow(source, i);
            }
        }

        for (int j = 0; j < source[0].length; j++) {
            if (source[row][j] == 0) {
                nullifyCol(source, j);
            }
        }
    }

    private void nullifyRow(int[][] source, int row) {
        for (int i = 0; i < source[0].length; i++) {
            source[row][i] = 0;
        }
    }

    private void nullifyCol(int[][] source, int col) {
        for (int i = 0; i < source.length; i++) {
            source[i][col] = 0;
        }
    }

    private void display(int[][] source) {
        for(int i = 0; i < source.length; i++) {
            for(int j = 0; j < source[0].length; j++) {
                System.out.print(" " + source[i][j]);
            }
            System.out.println();
        }
    }

}
