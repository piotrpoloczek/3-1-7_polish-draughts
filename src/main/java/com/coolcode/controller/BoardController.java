package com.coolcode.controller;

import com.coolcode.model.Board;
import com.coolcode.model.Pawn;
import com.coolcode.view.BoardView;
import com.coolcode.view.UserInput;

public class BoardController {


    private Board board;
    private BoardView boardView;
    private UserInput userInput;



    public BoardController() {
        board = new Board();
        boardView = new BoardView();
    }

    public void setBoardSize() {
        int size = boardView.getNumberBetween(board.getMinSize(), board.getMaxSize());
        board.setSize(size);
        board.createFields();
    }


}
