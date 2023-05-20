package com.coolcode.model;

public class Board {

    private int size;
    private Pawn[][] fields;
    private static final int MIN_SIZE = 10;
    private static final int MAX_SIZE = 20;


    public Board(int size) {
        this.size = size;
        this.fields = new Pawn[this.size][this.size];
    }

    public Board() {

    }

    public void setFields(Pawn[][] fields) {
        this.fields = fields;
    }

    public void createFields() {
        this.fields = new Pawn[this.size][this.size];
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMinSize() {
        return MIN_SIZE;
    }

    public int getMaxSize() {
        return MAX_SIZE;
    }

    public int getSize() {
        return size;
    }


    public boolean isPanwOnFields(Coordinates coordinates){
        Pawn pawn = getFieldFromCoordinates(coordinates);
        if (pawn != null){
            return true;
        }
        return false;
    }

    public void movePawn(Coordinates curentCoordinates, Coordinates targetCoordinates) {

        Pawn pawn = fields[curentCoordinates.getX()][curentCoordinates.getY()];
        if (pawn.validateMove(targetCoordinates)){;
        pawn.setPosition(targetCoordinates);

        fields[targetCoordinates.getX()][targetCoordinates.getY()] = pawn;
        removePawn(curentCoordinates);}
        else {
            System.out.println("Check rules!!! ");
        }
    }

    public void removePawn(Coordinates coordinates) {
        fields[coordinates.getX()][coordinates.getY()] = null;
        System.out.print(" ");
    }

    public Pawn[][] getFields() {
        return fields;
    }

    public Pawn getFieldFromCoordinates(Coordinates coordinates) {
        return this.fields[coordinates.getX()][coordinates.getY()];
    }

    public void setFieldFromCoordinates(Pawn pawn, Coordinates coordinates) {
        this.fields[coordinates.getX()][coordinates.getY()] = pawn;
    }

    private void placePawns() {
        int blackPawns = (size * size) / 5;
        System.out.println("blackPawns: " + blackPawns);
        int whitePawns = (size * size) / 5;
        int nextColum = (int) ((int) whitePawns / (size / 2.0));
        System.out.println("pawns: " + whitePawns + " nextcolumn: " + nextColum);
        for (int row = 0; row < nextColum; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0 && blackPawns > 0) {
                    fields[row][col] = new Pawn(row, col, "\u265F");
                    blackPawns--;
                }
            }
        }
        for (int row = size - nextColum; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0 && whitePawns > 0) {
                    fields[row][col] = new Pawn(row, col, "\u2659");
                    whitePawns--;
                }
            }
        }
    }
}
