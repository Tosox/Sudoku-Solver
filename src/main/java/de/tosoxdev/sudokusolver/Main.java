package de.tosoxdev.sudokusolver;

import de.tosoxdev.sudokusolver.core.Sudoku;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a path to the Sudoku file");
            return;
        }

        int[][] grid = SudokuParser.parse(args[0]);
        if (grid == null) {
            System.out.println("Please provide a valid path to the Sudoku file");
            return;
        }

        Sudoku sudoku = new Sudoku(grid);
        System.out.println("Input Sudoku:");
        System.out.println(sudoku);

        Solver.solve(sudoku);
    }
}
