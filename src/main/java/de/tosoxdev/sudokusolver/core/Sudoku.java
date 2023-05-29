package de.tosoxdev.sudokusolver.core;

public class Sudoku {
    private final int size;
    private final Tile[][] board;

    public Sudoku(int[][] grid) {
        size = grid.length;
        board = new Tile[size][size];
        fill(grid);
    }

    public int getSize() {
        return size;
    }

    public Tile getTileAt(int row, int column) {
        return board[row][column];
    }

    private void fill(int[][] grid) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Tile();
                board[i][j].setNumber(grid[i][j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            // Numbers and vertical separators
            for (int j = 0; j < size; j++) {
                sb.append(board[i][j]);
                sb.append(((j + 1) % (int) Math.sqrt(size) == 0) && (j + 1 != size) ? " | " : " ");
            }

            // Horizontal separators
            if (((i + 1) % (int)Math.sqrt(size) == 0) && (i + 1 != size)) {
                sb.append("\n");
                sb.append("- ".repeat(Math.max(0, size + (int) Math.sqrt(size) - 1)));
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
