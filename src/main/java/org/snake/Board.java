package org.snake;

public class Board {

    int x = 0;
    int y = 0;
    Snake snake = new Snake();
    int numberOfRows = 8;
    int numberOfColumns = 36;
    char[][] board = new char[numberOfRows][numberOfColumns];

    int [] snakeHead = new int[2];
    int [] body1 = new int[2];
    int [] body2 = new int[2];

    public void createBoard() {

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                board[i][j] = '-';
            }
        }
        x = snake.positionX(x);
        y = snake.positionY(y);

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (i == x && j == y) {
                    board[i][j] = 'X';
                    if (!(i > numberOfRows - 3) && (!(j > numberOfColumns - 3))) {
                        double random = Math.random() * 10;
                        if (random <= 5) {
                            board[i][j + 1] = 'x';
                            body1 = snake.updatedPosition(i,j+1);
                            board[i][j + 2] = 'x';
                            body2 = snake.updatedPosition(i,j+2);
                        } else {
                            board[i + 1][j] = 'x';
                            body1 = snake.updatedPosition(i + 1,j);
                            board[i + 2][j] = 'x';
                            body2 = snake.updatedPosition(i + 2,j);
                        }
                    } else {
                        if (i <= numberOfRows - 2 || j <= numberOfColumns - 2) {
                            board[i][j] = '-';
                            board[i - 2][j - 2] = 'x';

                            double random = Math.random() * 10;
                            if (random <= 5) {
                                board[i - 2][j - 1] = 'x';
                                body1 = snake.updatedPosition(i - 2,j - 1);
                                board[i - 2][j] = 'x';
                                body2 = snake.updatedPosition(i - 2,j);
                            } else {
                                board[i - 1][j - 2] = 'x';
                                body1 = snake.updatedPosition(i - 1,j - 2);
                                board[i][j - 2] = 'x';
                                body2 = snake.updatedPosition(i,j - 2);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void updateBoard() {
        board[body2[0]][body2[1]] = '-';
        body2[0] = body1[0];
        body2[1] = body2[1];
        body1[0] = x;
        body1[1] = y;



        char userMove = 's';


        switch (userMove) {
            case 'w':
                x -= 1;
                snakeHead = snake.updatedPosition(x,y);
                break;
            case 's':
                x += 1;
                snakeHead = snake.updatedPosition(x,y);
                break;
            case 'a':
                y -= 1;
                snakeHead = snake.updatedPosition(x,y);
                break;
            case 'd':
                y += 1;
                snakeHead = snake.updatedPosition(x,y);
                break;
        }
        x = snakeHead[0];
        y = snakeHead[1];
        if(snakeHead[0] == body1[0] && snakeHead[1] == body1[1]){
            gameOver();
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (i == x && j == y) {
                    board[snakeHead[0]][snakeHead[1]] = 'X';
                    board[body1[0]][body1[1]] = 'x';
                    board[body2[0]][body2[1]] = 'x';
                }
            }
        }



        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void gameOver(){
        System.out.println("GAME OVER!");
    }


}


