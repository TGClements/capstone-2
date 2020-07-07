package sudoku;

import java.util.*;

public class Game {

    int masterGrid[][];

    // Game will house the rules, hold score, etc.
    public Game() {

        masterGrid = new int[9][9];

        System.out.println("Generating master grid.");
        generateMasterGrid();

        //displayMasterGrid();
    }

    private void generateMasterGrid() {

        for (int j = 0; j < 9; j++) {

            // Pick a random number from 1-9
            int newVal = (int) (Math.random() * (9 - 1 + 1) + 1);
            System.out.println(newVal);

            if (isValidForCol(newVal)) {
                masterGrid[0][j] = newVal;

            } else {
                j--;
            }
        }

        shiftLeft(1, 3);
        shiftLeft(2, 3);

        shiftLeft(3, 1);
        shiftLeft(4, 3);
        shiftLeft(5, 3);

        shiftLeft(6, 1);
        shiftLeft(7, 3);
        shiftLeft(8, 3);

        displayMasterGrid();
    }

    private boolean isValidForCol(int newValue) {

        for (int j = 0; j < 9; j++) {
            System.out.println("Comparing " + masterGrid[0][j] + " to " + newValue);
            if (newValue == masterGrid[0][j]) {
                System.out.println("Requested value not valid for this column.");
                return false;
            }
        }

        return true;
    }

    // maybe convert this to lambda
    private void shiftLeft(int rowNum, int shiftVal) {

        int i = 0;

        for (int j = shiftVal; j < 9; j++) {

            masterGrid[rowNum][i] = masterGrid[rowNum - 1][j];

            i++;
        }

        int k = 0;
        for (int j = (9 - shiftVal); j < 9; j++) {

            masterGrid[rowNum][i] = masterGrid[rowNum - 1][k];

            i++;
            k++;
        }

    }

    private void displayMasterGrid() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(masterGrid[i][j]);
                System.out.print(" ");

            }
            System.out.print("\n");
        }

        System.out.println("\n");
    }

    public int getGridValue(int x, int y) {

        return masterGrid[y][x];
    }
}