package main.java.general;

/**
 * User: sridhar.anumandla
 * Date: 11/14/14
 * Time: 8:12 AM
 */
public class NullRowColMatrix {

    public static void main(String[] args) {
        int row = 4;
        int col = 5;

        int source[][]={ {1,2,0,4,8}, {5,6,7,8,1}, {9,10,11,0,4}, {13,14,15,16,7} };

        NullRowColMatrix object = new NullRowColMatrix();

        System.out.println("Input");
        object.display(source, row, col);

        object.nullifyRowColumn(source, row, col);
        System.out.println("Output");
        object.display(source, row, col);
    }

    private void nullifyRowColumn(int[][] source, int row, int column) {
        int[][] statusHolder = new int[row][column];
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if (source[i][j] == 0 && !isVisited(statusHolder, i, j)) {
                    replaceRowColWithValue(source, i, j, row, column, 0);
                    replaceRowColWithValue(statusHolder, i, j, row, column, -1);
                }
            }
        }
    }

    private boolean isVisited(int[][] statusHolder, int rowIndex, int colIndex) {
        return statusHolder[rowIndex][colIndex] == -1;
    }

    private void replaceRowColWithValue(int[][] source, int rowIndex, int colIndex, int row, int column, int value) {
        // Nullify column
        for (int i = 0; i < column; i++) {
            source[rowIndex][i] = value;
        }

        // Nullify row
        for (int i = 0; i < row; i++) {
            source[i][colIndex] = value;
        }
    }

    private void display(int[][] source, int row, int column) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(source[i][j] + " ");
            }
            System.out.println();
        }
    }

}
