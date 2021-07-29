package org.snake;

public class Food {

    public void generateFood(int[] food) {
        food[0] = (int)(Math.random() * 8);
        food[1] = (int)(Math.random() * 36);
    }
}
