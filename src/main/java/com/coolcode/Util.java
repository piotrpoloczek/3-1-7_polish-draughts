package com.coolcode;

import java.util.HashMap;
import java.util.Scanner;

public class Util {
    private static final int MIN_BOARD_SIZE = 10;
    private static final int MAX_BOARD_SIZE = 20;

    public static int[] convertCoordinateToArray(String userInput, int size) {
        int[] indices = new int[2];
        userInput = userInput.toUpperCase();
        String letter = userInput.substring(0, 1);
        int col = Integer.parseInt(userInput.substring(1))-1;
        int row = convertStringToInteger(letter, size);

        indices[0] = row;
        indices[1] = col;

        return indices;
    }

    public static int convertStringToInteger(String letter, int size) {
        HashMap<String, Integer> columnsDict = new HashMap<>();

        for (int row = 0; row < size; row++) {
            columnsDict.put(String.valueOf((char) ('A' + row)), row);
        }

        return columnsDict.get(String.valueOf(letter.charAt(0)));
    }

    public static Coordinates crateCoordinate (String position, int size){
        int[] current = Util.convertCoordinateToArray(position, size);
        int Row = current[0];
        int Col = current[1];
        Coordinates coordinates = new Coordinates(Row, Col);
        return  coordinates;
    };

    public static int getBoardSize(){
        Scanner scanner = new Scanner(System.in);
        int size;
        while (true) {
            System.out.print("Enter board size (between 10 and 20): ");
            try {
                size = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Enter valid number!");
                continue;
            }
            if (MIN_BOARD_SIZE <= size && size <= MAX_BOARD_SIZE) {
                return size;
            } else {
                System.out.println("Board size should be between 10 and 20");
            }
        }
    }
}
