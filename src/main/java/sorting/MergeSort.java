package main.java.sorting;

/**
 * Created by sridhar.anumandla on 7/8/15.
 */
public class MergeSort {

    public void merge(int[] array, int[] auxiliary, int low, int mid, int high) {
        copyArray(array, auxiliary, low, high);

        int i = low;
        int j = mid;
        int k = low;        // If this is not the case then you will be replacing starting the first element always
                            // for any given sub-array

        // j will be equal to high in many scenarios to if we don't mention this then the elements would be skipped from
        // sorting
        while (i < mid && j <= high) {
            if (auxiliary[i] <= auxiliary[j]) {
                array[k++] = auxiliary[i++];
            } else if (auxiliary[j] < auxiliary[i]) {
                array[k++] = auxiliary[j++];
            }
        }

        // Copy rest of the elements as it is

        while (i < mid) {
            array[k++] = auxiliary[i++];
        }

        while (j < high) {
            array[k++] = auxiliary[j++];
        }
    }

    public void sort(int[] array, int[] auxiliary, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        sort(array, auxiliary, low, mid);
        sort(array, auxiliary, mid + 1, high);
        merge(array, auxiliary, low, mid + 1, high);
    }

    private void copyArray(int array[], int auxiliary[], int low, int high) {
        for (int i = low; i <= high; i++) {
            auxiliary[i] = array[i];
        }
    }

    public static void main(String[] args) {
//        int[] array = {10, 7, 3, 6, 1, 2};
//        int[] array = {5, 6, 3, 4, 1, 2, 0};
        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        int[] auxiliary = new int[array.length];
        new MergeSort().sort(array, auxiliary, 0, array.length - 1);

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
