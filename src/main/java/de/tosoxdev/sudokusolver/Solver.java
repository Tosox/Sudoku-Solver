package de.tosoxdev.sudokusolver;

import de.tosoxdev.sudokusolver.core.Sudoku;

public class Solver {
    public static void solve(Sudoku sudoku) {
        int[][] sudokuByReference = new int[sudoku.getSize()][sudoku.getSize()];
        solve(sudoku, 0, sudokuByReference);
        sudoku = new Sudoku(sudokuByReference);

        System.out.println("Possible solution:");
        System.out.println(sudoku);
    }

    private static void solve(Sudoku sudoku, int tile, int[][] solvedSudokuOut) {
        int size = sudoku.getSize();
        int row = tile / size;
        int column = tile % size;

        // End of recursive loop
        if (row == size) {
            int[][] solvedSudoku = sudoku.toArray();
            for (int i = 0; i < sudoku.getSize(); i++) {
                System.arraycopy(solvedSudoku[i], 0, solvedSudokuOut[i], 0, sudoku.getSize());
            }
            return;
        }

        // Solve sudoku recursively
        if (sudoku.getTileAt(row, column).isEmpty()) {
            for (int number = 1; number <= size; number++) {
                if (isTileValid(sudoku, row, column, number)) {
                    sudoku.getTileAt(row, column).setNumber(number);
                    solve(sudoku, tile + 1, solvedSudokuOut);
                    sudoku.getTileAt(row, column).clear();
                }
            }
        } else {
            solve(sudoku, tile + 1, solvedSudokuOut);
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
