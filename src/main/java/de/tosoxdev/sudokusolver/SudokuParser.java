package de.tosoxdev.sudokusolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SudokuParser {
    public static int[][] parse(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
            int currentIndex = -1;

            while (reader.ready()) {
                // Check if line is just a new line
                String line = reader.readLine();
                if (line.isEmpty()) {
                    continue;
                }

                // Add new row
                grid.add(new ArrayList<>());
                currentIndex++;

                // Add digit to row and ignore other characters
                char[] lineChars = line.toCharArray();
                for (char character : lineChars) {
                    if (Character.isDigit(character)) {
                        grid.get(currentIndex).add(Character.getNumericValue(character));
                    }
                }
            }

            return grid.stream().map(a -> a.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
        } catch (IOException e) {
            return null;
        }
    }
}
