package de.tosoxdev.sudokusolver.core;

public class Tile {
    private static final int EMPTY = 0;
    private int number;

    public Tile() {
        clear();
    }

    public void clear() {
        number = EMPTY;
    }

    public boolean isEmpty() {
        return number == EMPTY;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
