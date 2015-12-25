package main.java.sorting;

/**
 * Created by sridhar.anumandla on 7/18/15.
 */
public class QuickSort {

    public void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        int mid = (low + high) / 2;

        int pivot = array[mid];

        while (i < j) {
            while (array[i] < pivot && i < high) {
                i++;
            }

            while (array[j] > pivot && j > low) {
                j--;
            }

            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        sort(array, low, j);
        sort(array, i, high);
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {10, 6, 7, 6, 3, 6, 1, 2};
//        int[] array = {5, 6, 3, 4, 1, 2, 0};
//        int array[] = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
        new QuickSort().sort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
