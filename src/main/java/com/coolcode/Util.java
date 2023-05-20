package com.coolcode;

import com.coolcode.model.Coordinates;

import java.util.HashMap;

public class Util {


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
        int[] curent = Util.convertCoordinateToArray(position, size);
        int Row = curent[0];
        int Col = curent[1];
        Coordinates coordinates = new Coordinates(Row, Col);
        return  coordinates;
    };
}
