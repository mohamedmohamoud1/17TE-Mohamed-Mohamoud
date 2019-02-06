package gameoflife;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameOfLife {

    private int worldWidth = 40;
    private int worldHeight = 20;
    private char[][] world = new char[worldWidth][worldHeight];

    public GameOfLife() {
        initWorld();
        setSeed();
        startGame();
    }

    private void initWorld() {
        for (int i = 0; i < worldWidth; i++) {
            for (int j = 0; j < worldHeight; j++) {
                world[i][j] = '.';
            }
        }
    }

    private void setSeed() {
        for (int i = 0; i < worldWidth; i++) {
            for (int j = 0; j < worldHeight; j++) {
                if (Math.random() < 0.2) {
                    world[i][j] = 'X';
                }
            }
        }
    }

    /**
     * Undersöker omgivningen kring en spesifik
     *
     * @return
     */
    private int checkSurroundings(int xPos, int yPos) {
        int countNeighbours = 0;

        for (int x = xPos - 1; x <= xPos + 1; x++) {
            for (int y = yPos - 1; y <= yPos + 1; y++) {
                if (!(x == xPos && y == yPos)) {
                    try {
                        if (world[x][y] == 'X') {

                            countNeighbours++;
                        }
                    } catch (Exception ex) {

                    }
                }
            }
        }

        return countNeighbours;
    }

    private void updateWorld() {
        //Skapa en temporär värld
        char[][] newWorld = new char[worldWidth][worldHeight];

        //Gå igenom den gamla världen, punkt för punkt och tillämpa reglerna.
        int border = 1;

        for (int i = 0 + border; i < worldWidth - border; i++) {
            for (int j = 0 + border; j < worldHeight - border; j++) {
                newWorld[i][j] = '.';

                //Räkna antalet grannar.
                int neighbours = checkSurroundings(i, j);

                if (world[i][j] == 'X') {

                    //Any live cell with fewer than two live neighbors dies, as if by underpopulation.
                    if (neighbours < 2) {
                        newWorld[i][j] = '.';
                    }

                    //Any live cell with two or three live neighbors lives on to the next generation.
                    if (neighbours >= 2 && neighbours <= 3) {
                        newWorld[i][j] = 'X';
                    }

                    //Any live cell with more than three live neighbors dies, as if by overpopulation.
                    if (neighbours > 3) {
                        newWorld[i][j] = '.';
                    }
                }

                //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                if (neighbours == 3 && world[i][j] == '.') {
                    newWorld[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < worldWidth; i++) {
            for (int j = 0; j < worldHeight; j++) {
                world[i][j] = newWorld[i][j];
            }
        }
    }

    private void printWorld() {
        System.out.println("======================================");
        for (int i = 0; i < this.worldHeight; i++) {
            for (int j = 0; j < this.worldWidth; j++) {
                System.out.print(world[j][i]);
            }
            System.out.println();
        }
    }

    private void startGame() {
        printWorld();
        while (true) {
            try {
                Thread.sleep(1000);
                updateWorld();
                printWorld();
            } catch (InterruptedException ex) {
                Logger.getLogger(GameOfLife.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new GameOfLife();
    }
}
