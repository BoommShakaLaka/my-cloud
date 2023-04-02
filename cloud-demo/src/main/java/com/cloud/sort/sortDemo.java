package com.cloud.sort;

public class sortDemo {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // 冒泡排序
        int[] arr = {1, 3, 2, 5, 4};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // 选择排序
        int[] arr1 = {1, 3, 2, 5, 4};
        for (int i = 0; i < arr1.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[j] < arr1[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr1[i];
                arr1[i] = arr1[min];
                arr1[min] = temp;
            }
        }
        // 插入排序
        int[] arr2 = {1, 3, 2, 5, 4};
        for (int i = 1; i < arr2.length; i++) {
            int temp = arr2[i];
            int j = i;
            while (j > 0 && temp < arr2[j - 1]) {
                arr2[j] = arr2[j - 1];
                j--;
            }
            arr2[j] = temp;
        }
        // 希尔排序
        int[] arr3 = {1, 3, 2, 5, 4};
        int gap = arr3.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr3.length; i++) {
                int temp = arr3[i];
                int j = i;
                while (j - gap >= 0 && temp < arr3[j - gap]) {
                    arr3[j] = arr3[j - gap];
                    j -= gap;
                }
                arr3[j] = temp;
            }
            gap /= 2;
        }
        // 归并排序
        int[] arr4 = {1, 3, 2, 5, 4};
        mergeSort(arr4, 0, arr4.length - 1);
        // 快速排序
        int[] arr5 = {1, 3, 2, 5, 4};
        quickSort(arr5, 0, arr5.length - 1);
        // 堆排序
        int[] arr6 = {1, 3, 2, 5, 4};
        heapSort(arr6);
        // 基数排序
        int[] arr7 = {1, 3, 2, 5, 4};
        radixSort(arr7);
        // 二分查找
        int[] arr8 = {1, 3, 2, 5, 4};
        int index = binarySearch(arr8, 0, arr8.length - 1, 5);
        System.out.println(index);
    }


    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
    }


    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }


    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }
    }
}