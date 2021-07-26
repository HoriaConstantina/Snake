package org.snake;

public class Game {

    Board board;
    Snake snake;

    public void startGame() {
        board = new Board();
        board.createBoard();
        snake = new Snake();
        snake.generateSnake();
        snake.startingPosition();
    }
}
