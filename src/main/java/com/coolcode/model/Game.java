package com.coolcode.model;

import com.coolcode.Util;
import com.coolcode.view.BoardView;

import java.util.Scanner;

public class Game {

    Scanner scanner;
    Board board;
    boolean gameOver;

    public Game() {
        scanner = new Scanner(System.in);
        gameOver = false;
    }

    public void start() {
        System.out.print("Enter board size (between 10 and 20): ");
        int size = scanner.nextInt();
        board = new Board(size);

        while (!gameOver) {
            playRound();
        };
    }

    private Coordinates getCoordinates(String message) {
        System.out.print(message);
        String position = scanner.next();
        Coordinates coordinates = Util.crateCoordinate(position,board.getSize());
        return coordinates;
    }


    private void playRound() {
        Coordinates currentCoordinates = getCoordinates("Provide current position: ");
        Coordinates targetCoordinates = getCoordinates("Provide target position: ");

        Pawn pawn = checkMove(currentCoordinates, targetCoordinates);
        if (pawn != null) {
            tryToMakeMove(pawn);
        }
    }

    private Pawn checkMove(Coordinates currentCoordinates, Coordinates targetCoordinates) {
        boolean isPawn = board.isPanwOnFields(currentCoordinates)
                && !board.isPanwOnFields(targetCoordinates);
        if (isPawn) {
            Pawn pawn = board.getFieldFromCoordinates(currentCoordinates);
            return pawn;
        }
        return null;
    }

    private void tryToMakeMove(Pawn pawn) {
        // TODO: make move;

    }

    private boolean checkForWinner() {
        // TODO: if player wins then return true else return false;`
        // trzeba by było jakoś zliczać pionki jednego i drugiego koloru czy jedna z tych grup jest równa zero
        // jeśli tak to gracz z przeciwnymi pionkami wygrał
        return true;
    }

}
