package com.coolcode.model;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int row, int col) {
        this.x = row;
        this.y = col;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
