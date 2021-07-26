package org.snake;

public class Board {

    int numberOfRows = 8;
    int numberOfColumns = 36;
    char[][] board = new char[numberOfRows][numberOfColumns];

    public void createBoard() {

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++){
                board[i][j] = '-';
            }
        }
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
