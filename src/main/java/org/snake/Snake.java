package org.snake;

public class Snake {

    public int positionX(int x) {
        x += (int)(Math.random() * 8);
        return x;
    }

    public int positionY(int y) {
        y += (int)(Math.random() * 36);
        return y;
    }

    public int[] updatedPosition(int x, int y){
        int temp[] = new int[2];
        temp[0] = x;
        temp[1] = y;
        return temp;
    }

    public boolean checkIfVerticalWithHeadOnTop(int x, int x1, int x2) {
        if (x + 1 == x1 && x1 + 1 == x2) {
            return true;
        }

        return false;
    }

    public boolean checkIfVerticalWithHeadOnBottom(int x, int x1, int x2) {
        if (x - 1 == x1 && x1 - 1 == x2) {
            return true;
        }
        return false;
    }

    public boolean checkIfHorizontalWithHeadOnRight(int y, int y1, int y2) {
        if (y - 1 == y1 && y1 - 1 == y2) {
            return true;
        }

        return false;
    }

    public boolean checkIfHorizontalWithHeadOnLeft(int y, int y1, int y2) {
        if (y + 1 == y1 && y1 + 1 == y2) {
            return true;
        }
        return false;
    }

    public void gameOver() {
        System.out.println("You've lost! Try again sucker");
    }
}
