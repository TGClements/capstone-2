package sudoku;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class UserInterface {

    JFrame f;
    private JMenuBar menuBar;
    private JMenu mainMenu, currentGame, options, helpMenu;
    private JMenuItem newEGame, newMGame, newHGame, newXGame, instructions, quit, lockInCorrect, checkWin;

    NumberGrid ng;

    Game g;

    public UserInterface() {
        f = new JFrame("Sudoku");

    }

    public void initUI() {
        // Create the menu bar
        menuBar = new JMenuBar();

        // Create the main menu
        createMainMenu();
        createCurrentGameMenu();
        createHelpMenu();

        // Set the menu bar to the frame
        f.setJMenuBar(menuBar);

        renderButtonGrid();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(515, 560);
        f.setLayout(new BorderLayout());
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }

    private void createMainMenu() {

        // Build the main menu
        mainMenu = new JMenu("Sudoku");
        mainMenu.setMnemonic(KeyEvent.VK_S);
        menuBar.add(mainMenu);

        // Build the menu items
        newEGame = new JMenuItem("New Easy Game");
        newEGame.setMnemonic(KeyEvent.VK_E);
        newEGame.addActionListener(e -> {

            // Start a new Easy game when clicked
            startNewEGame();
        });
        newMGame = new JMenuItem("New Medium Game");
        newMGame.setMnemonic(KeyEvent.VK_M);
        newMGame.addActionListener(e -> {

            // Start a new Medium game when clicked
            startNewMGame();
        });
        newHGame = new JMenuItem("New Hard Game");
        newHGame.setMnemonic(KeyEvent.VK_H);
        newHGame.addActionListener(e -> {

            // Start a new Hard game when clicked
            startNewHGame();
        });
        newXGame = new JMenuItem("New Expert Game");
        newXGame.setMnemonic(KeyEvent.VK_X);
        newXGame.addActionListener(e -> {

            // Start a new Expert game when clicked
            startNewXGame();
        });

        quit = new JMenuItem("Quit");
        quit.setMnemonic(KeyEvent.VK_Q);
        quit.addActionListener(e -> {
            quit();
        });

        // Add the items to the menu
        mainMenu.add(newEGame);
        mainMenu.add(newMGame);
        mainMenu.add(newHGame);
        mainMenu.add(newXGame);
        mainMenu.addSeparator();
        mainMenu.add(quit);
    }

    private void createCurrentGameMenu() {

        // Build the "Current Game" options menu
        currentGame = new JMenu("Current Game");
        currentGame.setMnemonic(KeyEvent.VK_C);
        menuBar.add(currentGame);

        // Build the menu items
        lockInCorrect = new JMenuItem("Lock in Correct Cells");
        lockInCorrect.setMnemonic(KeyEvent.VK_L);
        lockInCorrect.addActionListener(e -> {
            lockInCorrectAnswers();
        });
        checkWin = new JMenuItem("Check Win");
        checkWin.setMnemonic(KeyEvent.VK_W);
        checkWin.addActionListener(e -> {
            checkGameWin();
        });

        // Add the items to the menu
        currentGame.add(lockInCorrect);
        currentGame.add(checkWin);
        currentGame.setEnabled(false);
    }

    private void createHelpMenu() {

        // Build the help menu
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(helpMenu);

        // Build the menu items
        instructions = new JMenuItem("Instructions");
        instructions.setMnemonic(KeyEvent.VK_I);
        instructions.addActionListener(e -> {
            displayInstructions();
        });

        // Add items to menu
        helpMenu.add(instructions);
    }

    private void renderButtonGrid() {
        // Initialize the number grid
        ng = new NumberGrid();
        JButton[][] tempButtonGrid = ng.getButtonGrid();

        // Coordinates for displaying the buttons
        int coordx = 20;
        int coordy = 20;

        // Add the buttons in a grid
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tempButtonGrid[i][j].setLocation(coordx, coordy);
                f.add(tempButtonGrid[i][j]);

                // Set next coords for the next button & create a space for every 3x3 box
                if ((j + 1) % 3 == 0) {
                    coordx += 55;
                } else {
                    coordx += 50;
                }
            }
            // Reset x coords
            coordx = 20;

            // Set next coords for the next button & create a space for every 3x3 box
            if ((i + 1) % 3 == 0) {
                coordy += 55;
            } else {
                coordy += 50;
            }
        }
    }

    private void startNewEGame() {
        resetButtonState();

        g = new Game();
        populateButtonGrid(45);

        currentGame.setEnabled(true);
    }

    private void startNewMGame() {
        resetButtonState();

        g = new Game();
        populateButtonGrid(35);

        currentGame.setEnabled(true);
    }

    private void startNewHGame() {
        resetButtonState();

        g = new Game();
        populateButtonGrid(25);

        currentGame.setEnabled(true);
    }

    private void startNewXGame() {
        resetButtonState();

        g = new Game();
        populateButtonGrid(15);

        currentGame.setEnabled(true);
    }

    private void populateButtonGrid(int numToShow) {

        // Pick 25 random spots to show in the grid
        int visibleButtons[] = new int[numToShow];

        for (int i = 0; i < visibleButtons.length; i++) {
            int newVal = (int) (Math.random() * (80 - 0 + 1) + 0);
            boolean valAlreadyExists = false;

            for (int j = 0; j < visibleButtons.length; j++) {
                if (visibleButtons[j] == newVal) {
                    valAlreadyExists = true;
                    i--;
                }
            }

            try {
                if (!valAlreadyExists) {
                    visibleButtons[i] = newVal;
                }
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println("Taking a while to select which buttons to show: " + aioobe);
            }

        }

        Arrays.sort(visibleButtons);

        System.out.println(Arrays.toString(visibleButtons));

        int counter = 0;

        // Set the randomly picked spaces to their values, then disable them
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                for (int k = 0; k < visibleButtons.length; k++) {
                    if (visibleButtons[k] == counter) {
                        ng.setButtonVal(g.getGridValue(j, i), j, i);
                        ng.setButtonDisabled(j, i);
                        break;
                    } else {
                        ng.setButtonVal("", j, i);
                    }
                }

                counter++;
            }
        }
    }

    private void quit() {
        f.dispose();
    }

    private void displayInstructions() {

        final String gameInstructions = "Sudoku rules for beginners:\n- Only use the numbers 1 to 9\n- Avoid trying to guess the solution to the puzzle\n- Only use each number once in each row, column, & grid\n- Use the process of elimination as a tactic";

        JOptionPane.showMessageDialog(f, gameInstructions, "Instructions", JOptionPane.INFORMATION_MESSAGE);

        System.out.println("displaying the instructions.");
    }

    // Reset all buttons to be enabled again
    private void resetButtonState() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ng.setButtonEnabled(j, i);
            }
        }
    }

    private void lockInCorrectAnswers() {

        // Iterate through the grid to check the values
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // Check the buttons against the master grid
                if (ng.getButtonVal(j, i) == g.getGridValue(j, i)) {
                    System.out.println("Value matches for " + i + "," + j + "!");
                    ng.setButtonDisabled(j, i);
                } else {
                    System.out.println("Value does not match for " + i + "," + j + "!");
                }
            }
        }

    }

    private void checkGameWin() {

        int numMatches = 0;

        // Iterate through the grid to check the values
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // Check the buttons against the master grid
                if (ng.getButtonVal(j, i) == g.getGridValue(j, i)) {
                    System.out.println("Value matches for " + i + "," + j + "!");
                    numMatches++;
                } else {
                    System.out.println("Value does not match for " + i + "," + j + "!");
                }
            }
        }

        if (numMatches == 81) {
            System.out.println("You win!");
            lockInCorrectAnswers();
            JOptionPane.showMessageDialog(f, "You Win!!", "Winner", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Not a winner yet...");
            JOptionPane.showMessageDialog(f, "Not a winner yet...", "Keep going!", JOptionPane.ERROR_MESSAGE);
        }
    }

}