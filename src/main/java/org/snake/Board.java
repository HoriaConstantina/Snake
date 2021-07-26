package org.snake;

public class Board {

    int x = (int)(Math.random() * 8);
    int y = (int)(Math.random() * 36);
    Snake snake = new Snake();
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
        System.out.println();
    }

    public void updateBoard() {
        snake.position(x, y);

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (i == x && j == y) {
                    board[i][j] = 'x';
                    if (!(i > numberOfRows - 3) && (!(j > numberOfColumns - 3))) {
                        double random = Math.random() * 10;
                        if (random <= 5){
                            board[i][j + 1] = 'x';
                            board[i][j + 2] = 'x';
                        }
                        else {
                            board[i + 1][j] = 'x';
                            board[i + 2][j] = 'x';
                        }
                    }
                    else {
                        if (i <= numberOfRows - 2 || j <= numberOfColumns - 2) {
                            board[i][j] = '-';
                            board[i - 2][j - 2] = 'x';

                            double random = Math.random() * 10;
                            if (random <= 5){
                                board[i - 2][j - 1] = 'x';
                                board[i - 2][j] = 'x';
                            }
                            else {
                                board[i - 1][j - 2] = 'x';
                                board[i][j - 2] = 'x';
                            }
                        }
                    }
                }
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
