package org.snake;

public class Game {

    boolean isGameRunning = true;
    Board board;

    public void startGame() {
        board = new Board();
        board.createBoard();

        try{

            while (isGameRunning){
                for (int i = 0; i < 1000; i++) {
                    board.updateBoard();
                }
                isGameRunning = false;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ooops! You have lost! :(");
            board.printScore();
        }

    }
}
