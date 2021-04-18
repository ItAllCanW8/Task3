package by.epamtc.util;

import by.epamtc.entity.Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ArrayFiller {
    public static int readInt() {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt())
            scanner.next();

        return scanner.nextInt();
    }

    public static void fillFromConsole(Array arr) {
        for (int i = 0; i < arr.getSize(); i++)
            arr.replace(i, readInt());
    }

    public static void randomFill(Array arr) {
        Random rand = new Random();

        for (int i = 0; i < arr.getSize(); i++)
            arr.replace(i, rand.nextInt());
    }

    public static Array fillFromFile(String name) throws FileNotFoundException {
        File file = new File(name);
        Scanner scanner = new Scanner(file);

        int length = scanner.nextInt();

        if (length <= 0)
            return null;

        int[] array = new int[length];

        Array arr = new Array(array, array.length);

        for (int i = 0; i < arr.getSize(); i++) {
            if (!scanner.hasNextInt())
                //WrongDataException
            arr.replace(i, scanner.nextInt());
        }

        return arr;
    }
}

