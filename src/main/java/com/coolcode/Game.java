package com.coolcode;

import java.util.Scanner;

public class Game {

<<<<<<< HEAD
    private View view;
    private Board board;
    private static final int MIN_SIZE = 10;
    private static final int MAX_SIZE = 20;


    public Game() {
        view = new View();
        int size = view.getBoardSize(MIN_SIZE, MAX_SIZE, "Enter board size.");
        board = new Board(size);

    }

    public void twoPlayersMode() {

        Scanner scanner = new Scanner(System.in);
=======
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        // get size of the board from user
        int size = Util.getBoardSize();
>>>>>>> piotr



        while (true) {
            board.displayBoard();

            // get user current coordinates
<<<<<<< HEAD
            Coordinates currentCoordinates = getCurrentCoordinates();
=======
            System.out.print("Enter Pawn position: ");
            String currentPosition = scanner.next();
            Coordinates currentCoordinates = Util.crateCoordinate(currentPosition, board.getSize());
>>>>>>> piotr

            // get user target coordinates
            Coordinates targetCoordinates = getTargetCoordinates();

            // move pawn
            board.movePawn(currentCoordinates, targetCoordinates);

<<<<<<< HEAD
=======
            // validate the coordinates
//            boolean isPawn = board.isPawnOnFields(currentCoordinates)
//                    && !board.isPawnOnFields(targetCoordinates);
//            if (isPawn) {
//                board.movePawn(currentCoordinates, targetCoordinates);
//                board.displayBoard();
//            } else {
                board.movePawnAttack(currentCoordinates, targetCoordinates);
                board.displayBoard();

>>>>>>> piotr

            // check for winner in the match
            if (board.checkWinner()) {
                String winnerSymbol = board.getWinner();
                System.out.println("The winner of the match is " + winnerSymbol);
                break;
            }
        }
    }

    private Coordinates getCurrentCoordinates() {
        while (true) {
            String position = view.getField("Enter current coordinates: ");
            Coordinates coordinates = Util.crateCoordinate(position, board.getSize());

            // check if there is a pawn
            if (board.isPawnOnFields(coordinates)) {
                return coordinates;
            }
        }
    }

    private Coordinates getTargetCoordinates() {
        while (true) {
            String position = view.getField("Enter target coordinates: ");
            Coordinates coordinates = Util.crateCoordinate(position, board.getSize());

            // check if there is a pawn
            if (!board.isPawnOnFields(coordinates)) {
                return coordinates;
            }
        }
    }


}
