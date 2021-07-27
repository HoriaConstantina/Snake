package org.snake;

public class Snake {

    int x = 0;
    int y = 0;

    public int positionX(int x) {
        x = x + (int)(Math.random() * 8);
        return x;
    }

    public int positionY(int y) {
        y = y + (int)(Math.random() * 36);
        return y;
    }

    public int[] updatedPosition(int x, int y){
        int temp[] = new int[2];
        temp[0] = x;
        temp[1] = y;
        return temp;
    }


    public void gameOver() {
        System.out.println("You've lost! Try again sucker");
    }
}
