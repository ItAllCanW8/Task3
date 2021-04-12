package by.epamtc.logic;

public class Sorter {
    public static int rowSum(int[] arr) {
        if (arr != null) {
            int sum = 0;

            for (int x : arr)
                sum += x;

            return sum;
        } else {
            //NullPtrException
            return -1;
        }
    }

    public static int maxValue(int[] arr) {
        if (arr != null) {
            int max = arr[0];

            for (int x : arr)
                if (max < x)
                    max = x;

            return max;
        } else {
            //NullPtrException
            return -1;
        }
    }

    public static int minValue(int[] arr) {
        if (arr != null) {
            int min = arr[0];

            for (int x : arr)
                if (min > x)
                    min = x;

            return min;
        } else {
            //NullPtrException
            return -1;
        }
    }

    public static void bubbleSort(int[][] arr, SortType type, boolean ascending) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    int firstVal = 0;
                    int secVal = 0;

                    switch (type) {
                        case SUM: {
                            firstVal = rowSum(arr[j]);
                            secVal = rowSum(arr[j + 1]);
                        }
                        case MAX_ELEMENTS: {
                            firstVal = maxValue(arr[j]);
                            secVal = maxValue(arr[j + 1]);
                        }
                        case MIN_ELEMENTS: {
                            firstVal = minValue(arr[j]);
                            secVal = minValue(arr[j + 1]);
                        }
                    }

                    if (firstVal > secVal && ascending || firstVal < secVal && !ascending) {
                        int[] temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        } else {
            //NullPtrException
        }
    }
}
