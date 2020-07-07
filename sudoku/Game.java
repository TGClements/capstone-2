package sudoku;

public class Game {

    int masterGrid[][];

    // Game will house the rules, hold score, etc.
    public Game() {

        masterGrid = new int[9][9];

        System.out.println("Generating master grid.");
        generateMasterGrid();

        displayMasterGrid();
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

        // Lambda for left shift
        lambdaShiftLeft lsl = (rowNum, shiftVal) -> {

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

            return 0;
        };

        // Perform shifts to generate a valid puzzle
        lsl.shiftLeft(1, 3);
        lsl.shiftLeft(2, 3);

        lsl.shiftLeft(3, 1);
        lsl.shiftLeft(4, 3);
        lsl.shiftLeft(5, 3);

        lsl.shiftLeft(6, 1);
        lsl.shiftLeft(7, 3);
        lsl.shiftLeft(8, 3);
    }

    // Interface for Lambda
    static interface lambdaShiftLeft {
        public int shiftLeft(int rowNum, int shiftVal);
    }

    static int shiftLeft(int rowNum, int shiftVal, lambdaShiftLeft lsl) {
        return lsl.shiftLeft(rowNum, shiftVal);
    }

    // Generate a valid first column to then shift
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

    // Print out the grid
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

    // Return the int value of a grid location
    public int getGridValue(int x, int y) {

        return masterGrid[y][x];
    }
}