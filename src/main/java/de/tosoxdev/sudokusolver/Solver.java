package de.tosoxdev.sudokusolver;

import de.tosoxdev.sudokusolver.core.Sudoku;

public class Solver {
    public static void solve(Sudoku sudoku) {
        solve(sudoku, 0);
    }

    private static void solve(Sudoku sudoku, int tile) {
        int size = sudoku.getSize();
        int row = tile / size;
        int column = tile % size;

        // End of recursive loop
        if (row == size) {
            System.out.println("Possible solution:");
            System.out.println(sudoku);
            return;
        }

        // Solve sudoku recursively
        if (sudoku.getTileAt(row, column).isEmpty()) {
            for (int number = 1; number <= size; number++) {
                if (isTileValid(sudoku, row, column, number)) {
                    sudoku.getTileAt(row, column).setNumber(number);
                    solve(sudoku, tile + 1);
                    sudoku.getTileAt(row, column).clear();
                }
            }
        } else {
            solve(sudoku, tile + 1);
        }
    }

    private static boolean isTileValid(Sudoku sudoku, int row, int column, int number) {
        int size = sudoku.getSize();
        if (!isSectorValid(sudoku, row, column, number)) return false;

        for (int rows = 0; rows < size; rows++) {
            for (int columns = 0; columns < size; columns++) {
                if (sudoku.getTileAt(row, columns).getNumber() == number) return false; // Is row valid
                if (sudoku.getTileAt(rows, column).getNumber() == number) return false; // Is column valid
            }
        }

        return true;
    }

    private static boolean isSectorValid(Sudoku sudoku, int row, int column, int number) {
        int size = sudoku.getSize();

        int rowStart = getSectorStart(size, row);
        int rowEnd = getSectorEnd(size, rowStart);

        int columnStart = getSectorStart(size, column);
        int columnEnd = getSectorEnd(size, columnStart);

        for (int rows = rowStart; rows <= rowEnd; rows++) {
            for (int columns = columnStart; columns <= columnEnd; columns++) {
                if (sudoku.getTileAt(rows, columns).getNumber() == number) return false;
            }
        }

        return true;
    }

    private static int getSectorStart(int size, int position) {
        return (int)((float)(position / (int)(Math.sqrt(size))) * (int)(Math.sqrt(size)));
    }

    private static int getSectorEnd(int size, int sectorStart) {
        return sectorStart + ((int)(Math.sqrt(size)) - 1);
    }
}
