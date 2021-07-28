package org.snake;

import java.util.Arrays;

public class Board {

    int x = 0;
    int y = 0;
    Snake snake = new Snake();
    Food food = new Food();
    int numberOfRows = 8;
    int numberOfColumns = 36;
    char[][] board = new char[numberOfRows][numberOfColumns];

    int [] snakeHead = new int[2];
    int [] body1 = new int[2];
    int [] body2 = new int[2];

    int[] foodGenerated = new int[2];


    public void createBoard() {

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                board[i][j] = '-';
            }
        }
        x = snake.positionX(x);
        y = snake.positionY(y);

        snakeHead[0] = x;
        snakeHead[1] = y;

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
                            board[i - 2][j - 2] = 'X';

                            snakeHead = snake.updatedPosition(i-2, j-2);

                            double random = Math.random() * 10;
                            if (random <= 5) {
                                board[i - 2][j - 1] = 'x';
                                body1 = snake.updatedPosition(i - 2,j - 1);
                                board[i - 2][j] = 'x';
                                body2 = snake.updatedPosition(i - 2, j);
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
        food.generateFood(foodGenerated);

        if (foodGenerated[0] == snakeHead[0] || foodGenerated[0] == body1[0] || foodGenerated[0] == body2[0] || foodGenerated[1] == snakeHead[1] || foodGenerated[1] == body1[1] || foodGenerated[1] == body2[1]) {
            food.generateFood(foodGenerated);
            board[foodGenerated[0]] [foodGenerated[1]] = '*';
        }
        else {
            board[foodGenerated[0]] [foodGenerated[1]] = '*';
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
        boolean isHeadVerticalTop;
        boolean isHeadVerticalBottom;
        boolean isHeadHorizontalLeft;
        boolean isHeadHorizontalRight;

        isHeadVerticalTop = snake.checkIfVerticalWithHeadOnTop(snakeHead[0], body1[0], body2[0]);
        isHeadVerticalBottom = snake.checkIfVerticalWithHeadOnBottom(snakeHead[0], body1[0], body2[0]);
        isHeadHorizontalRight = snake.checkIfHorizontalWithHeadOnRight(snakeHead[1], body1[1], body2[1]);
        isHeadHorizontalLeft = snake.checkIfHorizontalWithHeadOnLeft(snakeHead[1], body1[1], body2[1]);

        board[body2[0]][body2[1]] = '-';


        char userMove = 'a';


        if (isHeadVerticalTop && userMove == 's') {
            System.out.println("Wrong Direction! Please use another key for movement");
        } else if (isHeadHorizontalLeft && userMove == 'd') {
            System.out.println("Wrong Direction! Please use another key for movement");
        } else if (isHeadVerticalBottom && userMove == 'w') {
            System.out.println("Wrong Direction! Please use another key for movement");
        } else if (isHeadHorizontalRight && userMove == 'a') {
            System.out.println("Wrong Direction! Please use another key for movement");
        } else {
            switch (userMove) {
                case 'w':
                    body2 = snake.updatedPosition(body1[0], body1[1]);
                    body1 = snake.updatedPosition(snakeHead[0], snakeHead[1]);
                    snakeHead[0] -= 1;
                    snakeHead = snake.updatedPosition(snakeHead[0], snakeHead[1]);
                    board[snakeHead[0]][snakeHead[1]] = 'X';
                    board[body1[0]][body1[1]] = 'x';
                    board[body2[0]][body2[1]] = 'x';
                    System.out.println(Arrays.toString(snakeHead));
                    break;
                case 's':
                    body2 = snake.updatedPosition(body1[0], body1[1]);
                    body1 = snake.updatedPosition(snakeHead[0], snakeHead[1]);
                    snakeHead[0] += 1;
                    snakeHead = snake.updatedPosition(snakeHead[0], snakeHead[1]);
                    board[snakeHead[0]][snakeHead[1]] = 'X';
                    board[body1[0]][body1[1]] = 'x';
                    board[body2[0]][body2[1]] = 'x';
                    System.out.println(Arrays.toString(snakeHead));
                    break;
                case 'a':
                    body2 = snake.updatedPosition(body1[0], body1[1]);
                    body1 = snake.updatedPosition(snakeHead[0], snakeHead[1]);
                    snakeHead[1] -= 1;
                    snakeHead = snake.updatedPosition(snakeHead[0], snakeHead[1]);
                    board[snakeHead[0]][snakeHead[1]] = 'X';
                    board[body1[0]][body1[1]] = 'x';
                    board[body2[0]][body2[1]] = 'x';
                    System.out.println(Arrays.toString(snakeHead));
                    break;
                case 'd':
                    body2 = snake.updatedPosition(body1[0], body1[1]);
                    body1 = snake.updatedPosition(snakeHead[0], snakeHead[1]);
                    snakeHead[1] += 1;
                    snakeHead = snake.updatedPosition(snakeHead[0], snakeHead[1]);
                    board[snakeHead[0]][snakeHead[1]] = 'X';
                    board[body1[0]][body1[1]] = 'x';
                    board[body2[0]][body2[1]] = 'x';
                    System.out.println(Arrays.toString(snakeHead));
                    break;
            }


            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfColumns; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }
        public void gameOver () {
            System.out.println("GAME OVER!");
        }

}



