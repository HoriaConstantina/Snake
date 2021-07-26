package org.snake;

public class Game {

    Board board;
    Snake snake;

    public void startGame() {
        board = new Board();
        board.createBoard();
        board.updateBoard();

    }
}
