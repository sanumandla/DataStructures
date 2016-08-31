package com.agilone.auth.test;

// Question:
//        Given an array of integers, count the total pair combinations of elements which satisfies the following requirement:
//        i < j && A[i] > A[j]

// Steps
// 1. Can have 2 loops to iterate over the collection and find the total number of pairs that satisfy the criteria
// 2. Time complexity would be O(n-squared)
// 3. This can be achieved in O(nlogn)
// 4. First sort the array using merge sort or quick sort in descending order
// 5. Then iterate over the loop to count number of duplicates. Since every number at i will be greater than i+1
public class FindPairsFirstGreaterThanSecond {

    private void copyArray(int[] array, int[] auxiliary, int low, int high) {
        for (int i = low; i <= high; i++) {
            auxiliary[i] = array[i];
        }
    }

    private void sort(int[] array, int[] auxiliary, int low, int mid, int high) {
        copyArray(array, auxiliary, low, high);

        int i = low;
        int j = mid;
        int k = low;

        while(i < mid && j <= high) {
            if (auxiliary[i] >= auxiliary[j]) {
                array[k++] = auxiliary[i++];
            } else {
                array[k++] = auxiliary[j++];
            }
        }

        while(i < mid) {
            array[k++] = auxiliary[i++];
        }

        while(j <= high) {
            array[k++] = auxiliary[j++];
        }
    }

    private void merge(int[] array, int[] auxiliary, int low, int high) throws Exception {
        if (array == null) {
            throw new Exception("Invalid array");
        }

        if (low >= high) {
          return;
        }

        int mid = (low + high) / 2;
        merge(array, auxiliary, low, mid);
        merge(array, auxiliary, mid + 1, high);
        sort(array, auxiliary, low, mid + 1, high);
    }

    public static void main(String[] args) throws Exception {
//        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
//        int array[] = { 4, 1, 3, 2 };
//        int array[] = { 3, 2, 1 };
        int array[] = {1, 5, 3, 6, 4, 2};
        int[] auxiliary = new int[array.length];
        FindPairsFirstGreaterThanSecond instance = new FindPairsFirstGreaterThanSecond();
        instance.merge(array, auxiliary, 0, array.length - 1);

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        int length = array.length;
        int sum = 0;
        for (int i = 1; i < length; i++) {
            sum += (length - i);
        }
        System.out.println("\n" + sum);

        // (3, 2, 1) = (3,2) (3,1) = 2
        // (2,1) = 1

        // 4, 3, 2, 1 = 3 + 2 + 1
        // (4,3) (4,2) (4,1)  = 3
        // (3, 2) (3, 1)  = 2
        // (2, 1) = 1

        // 1, 5, 2, 3, 6, 4
        // 6, 5, 4, 3, 2, 1
        // (6, 5) (6, 4) (6, 3) (6, 2) (6, 1) = 5
        // (5, 4) (5, 3) (5, 2) (5, 1) = 4
        // (4,3) (4,2) (4,1)  = 3
        // (3, 2) (3, 1)  = 2
        // (2, 1) = 1
    }

}
