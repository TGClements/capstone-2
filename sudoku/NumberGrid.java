package sudoku;

import javax.swing.*;
import java.awt.*;

public class NumberGrid extends UserInterface {
    private JButton[][] buttonGrid;

    public NumberGrid() {

        // Create a 9x9 grid of buttons. Each button is visible, has size of 50x50, and set
        // to say 0. Each button also has a listener attached.
        buttonGrid = new JButton[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JButton numButton = new JButton("0");
                numButton.setVisible(true);
                numButton.setSize(50, 50);
                numButton.addActionListener(e -> {

                    setOnClick(numButton);
                });

                buttonGrid[i][j] = numButton;
            }
        }
    }

    // Set the onclick for a Button
    private void setOnClick(JButton numButton) {

        // Do some darkmode checking
        if (UserInterface.darkmode) {
            UIManager.put("OptionPane.background", Color.BLACK);
            UIManager.put("Panel.background", Color.BLACK);
            UIManager.put("OptionPane.messageForeground", Color.WHITE);
            UIManager.put("Button.background", Color.WHITE);
        } else {
            UIManager.put("OptionPane.background", Color.WHITE);
            UIManager.put("Panel.background", Color.WHITE);
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", Color.LIGHT_GRAY);
        }

        try {
            String userVal = "0";

            // While a user enters in a digit that is not 1-9
            while (Integer.parseInt(userVal) != 1 || Integer.parseInt(userVal) != 2 || Integer.parseInt(userVal) != 3
                    || Integer.parseInt(userVal) != 4 || Integer.parseInt(userVal) != 5
                    || Integer.parseInt(userVal) != 6 || Integer.parseInt(userVal) != 7
                    || Integer.parseInt(userVal) != 8 || Integer.parseInt(userVal) != 9) {
                userVal = JOptionPane.showInputDialog(this.f,
                        "Enter a value from 1-9. To clear the cell, enter 0.\n\nText will be ignored.\nIncorrect values will prompt this message again.");

                // If the user enters 1-9, set the text of the clicked button to what was entered
                if (Integer.parseInt(userVal) == 1 || Integer.parseInt(userVal) == 2 || Integer.parseInt(userVal) == 3
                        || Integer.parseInt(userVal) == 4 || Integer.parseInt(userVal) == 5
                        || Integer.parseInt(userVal) == 6 || Integer.parseInt(userVal) == 7
                        || Integer.parseInt(userVal) == 8 || Integer.parseInt(userVal) == 9) {
                    numButton.setText(userVal);
                    break;
                }
                // Clear the cell if user enters 0
                if (Integer.parseInt(userVal) == 0) {
                    numButton.setText("");
                    break;
                }
            }
        } catch (java.lang.NumberFormatException nfe) { // Catch and ignore text input
            System.out.println("User either cancelled or entered text: " + nfe);
        }
    }

    // Return the entire grid
    public JButton[][] getButtonGrid() {
        return buttonGrid;
    }

    // Return a specific JButton
    public JButton getButton(int x, int y) {
        return buttonGrid[y][x];
    }

    // Get the user-entered value of the button
    public int getButtonVal(int x, int y) {

        if (buttonGrid[y][x].getText() != "")
            return Integer.parseInt(buttonGrid[y][x].getText());
        else
            return -1;
    }

    // Set the button value as an int
    public void setButtonVal(int val, int x, int y) {
        buttonGrid[y][x].setText("" + val);
    }

    // Set the button value as a String
    public void setButtonVal(String val, int x, int y) {
        buttonGrid[y][x].setText(val);
    }

    // Enable a button
    public void setButtonEnabled(int x, int y) {
        buttonGrid[y][x].setEnabled(true);
    }

    // Disable a button
    public void setButtonDisabled(int x, int y) {
        buttonGrid[y][x].setEnabled(false);
    }
}