package org.snake;

public class Snake {

    public void generateSnake() {
        int snakeHead = 1;
        int snakeTail = 3;

        char[][] snake = new char[snakeHead][snakeTail];
        snake[0][0] = 'x';
        snake[0][1] = 'x';
        snake[0][2] = 'x';
    }

    public char[][] position(int x, int y) {
        x = (int)(Math.random() * 8);
        y = (int)(Math.random() * 36);
        return new char[x][y];
    }
}
