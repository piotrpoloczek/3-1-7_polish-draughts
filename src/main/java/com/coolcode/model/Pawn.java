package com.coolcode.model;

public class Pawn {

    public static int Coordinates;
    private String symbol;
    private com.coolcode.model.Coordinates position;

    private boolean isCrowned;




    public Pawn(int row, int col, String symbol) {
        this.position = new Coordinates(row,col);
        this.symbol = symbol;
        this.isCrowned = false;
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

    public String getSymbol() {
        return symbol;
    }

    public Coordinates getPosition() {
        return position;
    }


    public void setPosition(Coordinates targetPosition) {
        this.position = targetPosition;
    }

    public boolean validateMove(Coordinates coordinates) {
        if (checkDiagonal(coordinates) & checkCoordinatesPositive(coordinates)) {
            return true;
        }
        return false;
    }


    private boolean checkCoordinatesPositive(Coordinates coordinates) {
        if (coordinates.getY() >= 0 & coordinates.getX() >= 0) {
            return true;
        }
        return false;
    }

    private boolean checkDiagonal(Coordinates coordinates) {
        if (
                (this.position.getX() == coordinates.getX() + 1
                        || this.position.getX() == coordinates.getX() - 1)
                        & (this.position.getY() == coordinates.getY() + 1
                        || this.position.getY() == coordinates.getY() - 1 )
        ) {
            return true;
        }
        return false;
    }

}


