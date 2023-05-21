package com.coolcode;

public class Pawn {

    public static int Coordinates;
    private final String symbol;
    private Coordinates position;

    private boolean isCrowned;

    public Pawn(int row, int col, String symbol) {
        this.position = new Coordinates(row,col);
        this.isCrowned = false;
        this.symbol = symbol;
    }

    public void crownPawn() {
        // TODO if the pawn go to the oposite board then it should set the isCrowned field to true
        this.isCrowned = true;
    }


    public String getXYPosition() {
        Coordinates position = getPosition();
        int positionX = position.getX();
        int positionY = position.getY();

        String stringBuilder = positionX +
                "|" +
                positionY;

        return stringBuilder;
    }

    public Coordinates getPosition() {
        return position;
    }


    public void setPosition(Coordinates targetPosition) {
        this.position = targetPosition;
    }


    public boolean validateMove(Coordinates coordinates) {
        if (!checkDiagonal(coordinates)){
            return false;
        } else if (!checkCoordinatesPositive(coordinates)) {
            return false;
        }
        return true;
    }

    private boolean checkDiagonal(Coordinates coordinates) {
        int deltaX = Math.abs(coordinates.getX() - this.position.getX());
        int deltaY = Math.abs(coordinates.getY() - this.position.getY());
        return deltaX == deltaY;
        }
    private boolean checkCoordinatesPositive(Coordinates coordinates) {
        return coordinates.getY() >= 0 & coordinates.getX() >= 0;
    }

//        public boolean validateMove(Coordinates coordinates) {
//        return checkDiagonal(coordinates) && checkCoordinatesPositive(coordinates);
//    }
//
//    private boolean checkCoordinatesPositive(Coordinates coordinates) {
//        return coordinates.getY() >= 0 & coordinates.getX() >= 0;
//    }

//    private boolean checkDiagonal(Coordinates coordinates) {
//        return (this.position.getX() == coordinates.getX() + 1
//                || this.position.getX() == coordinates.getX() - 1)
//                && (this.position.getY() == coordinates.getY() + 1
//                || this.position.getY() == coordinates.getY() - 1);
//    }


    public String getSymbol() {
        return symbol;
    }
}


