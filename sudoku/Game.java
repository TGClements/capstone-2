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

        // Lambda for left shift
        lambdaShiftLeft lsl = (rowNum, shiftVal) -> {

            int i = 0;

            // Shift the values starting from the shift value
            for (int j = shiftVal; j < 9; j++) {

                masterGrid[rowNum][i] = masterGrid[rowNum - 1][j];

                i++;
            }

            // Shift the remaining values
            int k = 0;
            for (int j = (9 - shiftVal); j < 9; j++) {

                masterGrid[rowNum][i] = masterGrid[rowNum - 1][k];

                i++;
                k++;
            }

            return 0;
        };
        // Lambda for right shift
        lambdaShiftRight lsr = (rowNum, shiftVal) -> {

            int i = 0;

            // Shift the values starting from the shift value
            for (int j = shiftVal; j < 9; j++) {

                masterGrid[rowNum][j] = masterGrid[rowNum - 1][i];

                i++;
            }

            // Shift the remaining values
            int k = 0;
            for (int j = (9 - shiftVal); j < 9; j++) {

                masterGrid[rowNum][k] = masterGrid[rowNum - 1][i];

                i++;
                k++;
            }

            return 0;
        };
        // Lambda for down shift
        lambdaShiftDown lsd = (colNum, shiftVal) -> {

            int i = 0;

            // Shift the values starting from the shift value
            for (int j = shiftVal; j < 9; j++) {

                masterGrid[j][colNum] = masterGrid[i][colNum - 1];

                i++;
            }

            // Shift the remaining values
            int k = 0;
            for (int j = (9 - shiftVal); j < 9; j++) {

                masterGrid[k][colNum] = masterGrid[i][colNum - 1];

                i++;
                k++;
            }

            return 0;
        };
        // Lambda for up shift
        lambdaShiftUp lsu = (colNum, shiftVal) -> {

            int i = 0;

            // Shift the values starting from the shift value
            for (int j = shiftVal; j < 9; j++) {

                masterGrid[i][colNum] = masterGrid[j][colNum - 1];

                i++;
            }

            // Shift the remaining values
            int k = 0;
            for (int j = (9 - shiftVal); j < 9; j++) {

                masterGrid[i][colNum] = masterGrid[k][colNum - 1];

                i++;
                k++;
            }

            return 0;
        };

        // Do logic for randomly shifting
        int selector = (int) (Math.random() * (4 - 1 + 1) + 1);
        switch (selector) {
            case 1:
                generateFirstRow();
                generateLeftShiftedPuzzle(lsl);
                System.out.println("Generated left-shifted puzzle.");
                break;
            case 2:
                generateFirstRow();
                generateRightShiftedPuzzle(lsr);
                System.out.println("Generated right-shifted puzzle.");
                break;
            case 3:
                generateFirstCol();
                generateDownShiftedPuzzle(lsd);
                System.out.println("Generated down-shifted puzzle.");
                break;
            case 4:
                generateFirstCol();
                generateUpShiftedPuzzle(lsu);
                System.out.println("Generated up-shifted puzzle.");
                break;
            default:
                break;
        }
    }

    // Interfaces for the Lambdas
    static interface lambdaShiftLeft {
        public int shiftLeft(int rowNum, int shiftVal);
    }

    static interface lambdaShiftRight {
        public int shiftRight(int rowNum, int shiftVal);
    }

    static interface lambdaShiftDown {
        public int shiftDown(int colNum, int shiftVal);
    }

    static interface lambdaShiftUp {
        public int shiftUp(int colNum, int shiftVal);
    }

    static int shiftLeft(int rowNum, int shiftVal, lambdaShiftLeft lsl) {
        return lsl.shiftLeft(rowNum, shiftVal);
    }

    static int shiftRight(int rowNum, int shiftVal, lambdaShiftRight lsr) {
        return lsr.shiftRight(rowNum, shiftVal);
    }

    static int shiftDown(int colNum, int shiftVal, lambdaShiftDown lsd) {
        return lsd.shiftDown(colNum, shiftVal);
    }

    static int shiftUp(int colNum, int shiftVal, lambdaShiftUp lsu) {
        return lsu.shiftUp(colNum, shiftVal);
    }

    // Randomly generate a first valid Row 
    private void generateFirstRow() {

        // Generate the first row
        for (int j = 0; j < 9; j++) {

            // Pick a random number from 1-9
            int newVal = (int) (Math.random() * (9 - 1 + 1) + 1);
            System.out.println(newVal);

            if (isValidForRow(newVal)) {
                masterGrid[0][j] = newVal;

            } else {
                j--;
            }
        }
    }

    // Randomly generate a first valid column 
    private void generateFirstCol() {

        // Generate the first row
        for (int i = 0; i < 9; i++) {

            // Pick a random number from 1-9
            int newVal = (int) (Math.random() * (9 - 1 + 1) + 1);
            System.out.println(newVal);

            if (isValidForCol(newVal)) {
                masterGrid[i][0] = newVal;

            } else {
                i--;
            }
        }
    }

    // Check if a new value is valid and not already repeated in the row
    private boolean isValidForRow(int newValue) {

        for (int j = 0; j < 9; j++) {
            System.out.println("Comparing " + masterGrid[0][j] + " to " + newValue);
            if (newValue == masterGrid[0][j]) {
                System.out.println("Requested value not valid for this row.");
                return false;
            }
        }

        return true;
    }

    // Check if a new value is valid and not already repeated in the column
    private boolean isValidForCol(int newValue) {

        for (int i = 0; i < 9; i++) {
            System.out.println("Comparing " + masterGrid[i][0] + " to " + newValue);
            if (newValue == masterGrid[i][0]) {
                System.out.println("Requested value not valid for this row.");
                return false;
            }
        }

        return true;
    }

    // Perform shifts to generate a valid puzzle
    private void generateLeftShiftedPuzzle(lambdaShiftLeft lsl) {

        lsl.shiftLeft(1, 3);
        lsl.shiftLeft(2, 3);

        lsl.shiftLeft(3, 1);
        lsl.shiftLeft(4, 3);
        lsl.shiftLeft(5, 3);

        lsl.shiftLeft(6, 1);
        lsl.shiftLeft(7, 3);
        lsl.shiftLeft(8, 3);
    }

    // Perform shifts to generate a valid puzzle
    private void generateRightShiftedPuzzle(lambdaShiftRight lsr) {

        lsr.shiftRight(1, 3);
        lsr.shiftRight(2, 3);

        lsr.shiftRight(3, 1);
        lsr.shiftRight(4, 3);
        lsr.shiftRight(5, 3);

        lsr.shiftRight(6, 1);
        lsr.shiftRight(7, 3);
        lsr.shiftRight(8, 3);
    }

    // Perform shifts to generate a valid puzzle
    private void generateDownShiftedPuzzle(lambdaShiftDown lsd) {

        lsd.shiftDown(1, 3);
        lsd.shiftDown(2, 3);

        lsd.shiftDown(3, 1);
        lsd.shiftDown(4, 3);
        lsd.shiftDown(5, 3);

        lsd.shiftDown(6, 1);
        lsd.shiftDown(7, 3);
        lsd.shiftDown(8, 3);
    }

    // Perform shifts to generate a valid puzzle
    private void generateUpShiftedPuzzle(lambdaShiftUp lsu) {

        lsu.shiftUp(1, 3);
        lsu.shiftUp(2, 3);

        lsu.shiftUp(3, 1);
        lsu.shiftUp(4, 3);
        lsu.shiftUp(5, 3);

        lsu.shiftUp(6, 1);
        lsu.shiftUp(7, 3);
        lsu.shiftUp(8, 3);
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