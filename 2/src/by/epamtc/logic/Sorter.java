package by.epamtc.logic;

public class Sorter {
    public static void bubbleSort(int[][] arr, boolean ascending, SortType st ) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    int firstVal = 0;
                    int secVal = 0;

                    firstVal = st.takeElementValue(arr[j]);
                    secVal = st.takeElementValue(arr[j + 1]);

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

class RowSum implements SortType {

    @Override
    public int takeElementValue(int[] arr) {
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
}

class MaxValue implements SortType {

    @Override
    public int takeElementValue(int[] arr) {
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
}

class MinValue implements SortType {

    @Override
    public int takeElementValue(int[] arr) {
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
}