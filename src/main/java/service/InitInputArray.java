package service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JMBRUN on 01/12/2016.
 * Read the input from a file and return an array of Integer
 */
public class InitInputArray {

    public Integer[] initArray() throws Exception {

        String filePath = "input-array.txt";
        File inputFile = new File("src/main/resources/" + filePath);

        List<Integer> integers = new ArrayList<>();

        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        scanner.close();

        // Defensive return : maybe be improved with Optional pattern
        if (integers == null) {
            return null;
        }

        return integers.toArray(new Integer[integers.size()] );
    }

}
