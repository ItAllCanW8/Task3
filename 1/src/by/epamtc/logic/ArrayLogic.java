package by.epamtc.logic;

import by.epamtc.entity.Array;

public class ArrayLogic {
    public static void bubbleSort(Array array) {
        if (array != null) {
            int arrSize = array.getSize();
            int temp = 0;

            for (int i = 0; i < arrSize; i++) {
                for (int j = 1; j < (arrSize - i); j++) {
                    if (array.get(j - 1) > array.get(j)) {
                        temp = array.get(j - 1);
                        array.replace(j - 1, array.get(j));
                        array.replace(j, temp);
                    }
                }
            }
        } else {
            //NullPtrException
        }
    }

    public static void selectionSort(Array array) {
        if (array != null) {

            int arrSize = array.getSize();

            for (int i = 0; i < arrSize; i++) {
                int min = array.get(i);
                int minId = i;

                for (int j = i + 1; j < arrSize; j++) {
                    if (array.get(j) < min) {
                        min = array.get(j);
                        minId = j;
                    }
                }

                int temp = array.get(i);
                array.replace(i, min);
                array.replace(minId, temp);
            }
        } else {
            //NullPtrException
        }
    }

    public static void insertSort(Array array) {
        if (array != null) {
            for (int i = 1; i < array.getSize(); i++) {
                int current = array.get(i);
                int j = i - 1;

                while (j >= 0 && current < array.get(j)) {
                    array.replace(j + 1, array.get(j));
                    j--;
                }

                array.replace(j + 1, current);
            }
        } else {
            //NullPtrException
        }
    }

    public static int binarySearch(Array sortedArr, int key) {
        if (sortedArr != null && key >= 0) {
            int low = 0;
            int high = sortedArr.getSize() - 1;
            int index = -1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (sortedArr.get(mid) < key) {
                    low = mid + 1;
                } else if (sortedArr.get(mid) > key) {
                    high = mid - 1;
                } else if (sortedArr.get(mid) == key) {
                    index = mid;
                    break;
                }
            }
            return index;
        } else {
            //BadDataException
            return -1;
        }
    }

    public static Pair maxAndMinValues(Array arr) {
        if (arr != null) {
            selectionSort(arr);

            int maxValue = arr.get(arr.getSize() - 1);
            int minValue = arr.get(0);

            return new Pair<Integer, Integer>(maxValue, minValue);
        } else {
            //NullPtrException
            return new Pair<Integer, Integer>(-1, -1);
        }
    }

    //сито эратосфена
    public static int[] primeNumbers(Array arr) {
        if (arr != null) {
            int n = arr.getSize();

            boolean[] isPrimeNumber = new boolean[n + 1];

            int[] primeNumbers = new int[n];

            for (int i = 2; i < n; i++)
                isPrimeNumber[i] = true;

            int index = 0;

            for (int i = 2; i < n; i++) {
                if (isPrimeNumber[i]) {
                    primeNumbers[index] = i;

                    for (int j = i; j * i <= n; j++) {
                        isPrimeNumber[i * j] = false;
                    }

                    index++;
                }
            }

            return primeNumbers;
        } else {
            //NullPtrException
            return new int[]{-1};
        }
    }

    public static int[] fibonacciNumbers(Array array) {
        if (array != null) {
            int length = array.getSize();
            int[] fibSequence = new int[length];
            int[] fibPresented = new int[length];

            fibSequence[0] = 0;
            fibSequence[1] = 1;

            int index = 0;

            for (int i = 2; i < length; i++) {
                fibSequence[i] = fibSequence[i - 1] + fibSequence[i - 2];

                if (binarySearch(array, fibSequence[i]) >= 0) {
                    fibPresented[index] = fibSequence[i];

                    index++;
                }
            }

            return fibPresented;
        } else {
            //NullPtrException
            return new int[]{-1};
        }
    }

    public static int[] noIdenticalDigits(Array arr) {
        if (arr != null) {

        int[] numbers = new int[arr.getSize()];

        int index = 0;

        for (int i = 0; i < arr.getSize(); i++) {
            int x = arr.get(i);

            if ((x >= 100) && (x < 1000)) {

                int firstDigit = x / 100;
                int secDigit = (x / 10) % 10;
                int thirdDigit = x % 10;

                if (firstDigit != secDigit
                        && firstDigit != thirdDigit
                        && secDigit != thirdDigit) {

                    numbers[index] = arr.get(i);
                    index++;
                }
            }
        }
            return numbers;
        } else {
            //NullPtrException
            return new int[]{-1};
        }
    }
}