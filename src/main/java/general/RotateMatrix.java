package main.java.general;

/**
 * User: sridhar.anumandla
 * Date: 11/13/14
 * Time: 10:35 PM
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int length = 5;
        int source[][]={ {1,2,3,4,8}, {5,6,7,8,1}, {9,10,11,12,4}, {13,14,15,16,7}, {5,3,15,16,8} };
//        int source[][]={ {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16} };

        RotateMatrix object = new RotateMatrix();

        System.out.println("Input");
        object.display(source, length);

        int result[][] = object.rotateMatrix(source, length);

        System.out.println("Output");
        object.display(result, length);
    }


    private int[][] rotateMatrix(int[][] source, int length) {
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - 1 - i; j++) {
                int top = source[i][j];
                int left = source[length - j - 1][i];
                int bottom = source[length - i - 1][length - j - 1];
                int right = source[j][length - i - 1];

                source[i][j] = left;
                source[length - j - 1][i] = bottom;
                source[length - i - 1][length - j - 1] = right;
                source[j][length - i - 1] = top;
            }
        }

        return source;
    }

    private void display(int[][] source, int length) {
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                System.out.print(source[i][j] + " ");
            }
            System.out.println();
        }
    }

}
