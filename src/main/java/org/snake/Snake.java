package org.snake;

public class Snake {

    public void generateSnake() {
        int snakeHead = 1;
        int snakeTail = 3;
        char[][] snake = new char[snakeHead][snakeTail];
    }

    public void position(int x, int y) {

    }

    public void startingPosition() {
        int x = (int)(Math.random() * 8);
        int y = (int)(Math.random() * 36);
        position(x, y);
        System.out.println(x + " " + y);
    }
}
