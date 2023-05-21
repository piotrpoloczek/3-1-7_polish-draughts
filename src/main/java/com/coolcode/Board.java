package com.coolcode;

public class Board {

    private final int size;
    private final Pawn[][] fields;
    private static final String whiteSymbol = "♙";
    private static final String blackSymbol = "♟";

    public Board(int size) {
        this.size = size;
        for (Pawn[] pawns : this.fields = new Pawn[this.size][this.size]) {
        }
        placePawns(this.size);
    }

    public int getSize() {
        return size;
    }

    private void placePawns(int size) {
        int blackPawns = (size * size) / 5;
        int whitePawns = (size * size) / 5;
        int nextColum = (int) ((int) whitePawns / (size / 2.0));
        for (int row = 0; row < nextColum; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0 && blackPawns > 0) {
                    fields[row][col] = new Pawn(row, col, blackSymbol);
                    blackPawns--;
                }
            }
        }
        for (int row = size - nextColum; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0 && whitePawns > 0) {
                    fields[row][col] = new Pawn(row, col, whiteSymbol);
                    whitePawns--;
                }
            }
        }
    }

    public void displayBoard() {

        // print column labels
        System.out.print(" ");
        for (int col = 1; col <= size; col++) {
            System.out.print(col);
        }
        System.out.println();

        // print row labels and field contents
        for (int row = 0; row < size; row++) {
            // print row label
            System.out.print((char) ('A' + row));


            // print field contents
            for (int col = 0; col < size; col++) {
                Pawn pawn = fields[row][col];
                if (pawn != null) {
                    System.out.print(pawn.getSymbol());

                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public boolean isPawnOnFields(Coordinates coordinates){
        Pawn pawn = getFieldByCoordinate(coordinates);
        return pawn != null;
    }

    public void movePawn(Coordinates curentCoordinates, Coordinates targetCoordinates) {
        Pawn pawn = getFieldByCoordinate(curentCoordinates);
        if (pawn.validateMove(targetCoordinates)) {
            pawn.setPosition(targetCoordinates);
            setFieldByCoordinate(pawn, targetCoordinates);
            removePawn(curentCoordinates);
        }
        else {
            System.out.println("Check rules!!! ");
        }
    }
    public void movePawnAttack(Coordinates curentCoordinates, Coordinates targetCoordinates) {
        Pawn startPawn = fields[curentCoordinates.getY()][curentCoordinates.getY()];
        int deltaX = Math.abs(targetCoordinates.getX() - curentCoordinates.getX());
        int deltaY = Math.abs(targetCoordinates.getY() - curentCoordinates.getY());

        // Sprawdzenie czy ruch jest diagonalny
        if (deltaX != deltaY) {
            return;
        }

        // Sprawdzenie czy pole docelowe jest puste
        if (fields[targetCoordinates.getX()][targetCoordinates.getY()] != null) {
            return;
        }

        // Sprawdzenie czy pole pomiędzy startem a końcem zawiera pionka przeciwnika
        int midX = (curentCoordinates.getX() + targetCoordinates.getX()) / 2;
        int midY = (curentCoordinates.getY() + targetCoordinates.getY()) / 2;
        Pawn midPawn = fields[midX][midY];
        if (midPawn == null){
            movePawn(curentCoordinates,targetCoordinates);
        }else {
            Coordinates hitPawn = fields[midX][midY].getPosition();
            movePawn(curentCoordinates,targetCoordinates);
            fields[midX][midY] = null;
            removePawn(hitPawn);
            return;
        }

        // Usunięcie pionka przeciwnika
        fields[midX][midY] = null;
    }

    public void removePawn(Coordinates coordinates) {
        setFieldByCoordinate(null, coordinates);
    }

    public Pawn[][] getFields() {
        return fields;
    }

    public Pawn getFieldByCoordinate(Coordinates coordinates) {
        return fields[coordinates.getX()][coordinates.getY()];
    }

    public void setFieldByCoordinate(Pawn pawn, Coordinates coordinates) {
        this.fields[coordinates.getX()][coordinates.getY()] = pawn;
    }

    // check if there is pawn with specific color
    private boolean isSymbolInFields(String symbol) {
        for (Pawn[] row : fields) {
            for (Pawn pawn : row) {
                if (pawn != null) {
                    if (pawn.getSymbol() == symbol) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkIfWhitePawnsExists() {
        return isSymbolInFields(whiteSymbol);
    }

    private boolean checkIfBlackPawnsExist() {
        return isSymbolInFields(blackSymbol);
    }

    public boolean checkWinner() {
        return !checkIfBlackPawnsExist() || !checkIfWhitePawnsExists();
    }

    public String getWinner() {
        if (checkIfWhitePawnsExists()) {
            return whiteSymbol;
        }
        return blackSymbol;
    }
}
