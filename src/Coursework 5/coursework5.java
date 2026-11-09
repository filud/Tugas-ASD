/** 
 * Nama : Muhammad Lutfi Aqil Hibatullah 
 * NRP  : 5026251098
 * Kelas: ASD(C)
 **/

import java.util.*;

public class coursework5 {
    public static void main(String[] args) {
        int[] test = {7, 3, 8, -1, 9, 2, 5, 17};

        System.out.println("\n=== Merge Sort & Reverse ===");
        mergeSort(test);
        System.out.println("Merge Sort:");
        for(int i : test) {
            System.out.print(i + " ");
        }
        System.out.println("\nReverse:");
        reverse(test);
        for(int i : test) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] test2 = {7, 3, 8, -1, 9, 2, 5, 17};

        System.out.println("\n=== Recursive Linear Search ===");
        System.out.println(recursiveLinearSearch(test2.clone(), 0, 17));

        System.out.println("\n=== Recursive Binary Search ===");
        System.out.println(recursiveBinarySearch(test2.clone(), 0, 5, 9));
    }

    public static void mergeSort(int[] array) {
        int length = array.length;
        if(length <= 1) {
            return;
        }

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; // left array
        int j = 0; // right array

        for(; i < length; i++) {
            if(i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);

    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0;
        int l = 0;
        int r = 0;

        // check condition for merge
        while(l < leftSize && r < rightSize) {
            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static int recursiveLinearSearch(int[] array, int index, int target) {
        if(index >= array.length) {
            return -1;
        } else if(array[index] == target) {
            return index;
        } else {
            return recursiveLinearSearch(array, index + 1, target);
        }
    }

    public static int recursiveBinarySearch(int[] array, int low, int high, int target) {
        if(low > high) {
            return -1;
        } else {
            int mid = (low + high) / 2;
            if(array[mid] == target) {
                return mid;
            } else if(array[mid] < target) {
                return recursiveBinarySearch(array, mid + 1, high, target);
            } else {
                return recursiveBinarySearch(array, low, mid - 1, target);
            }
        }
    }
}