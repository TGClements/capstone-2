package sudoku;

import javax.swing.*;

public class NumberGrid extends UserInterface {
    private JButton[][] buttonGrid;

    public NumberGrid() {

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

    private void setOnClick(JButton numButton) {

        try {
            String userVal = "0";
            System.out.println("User entered: " + userVal);

            while (Integer.parseInt(userVal) != 1 || Integer.parseInt(userVal) != 2 || Integer.parseInt(userVal) != 3
                    || Integer.parseInt(userVal) != 4 || Integer.parseInt(userVal) != 5
                    || Integer.parseInt(userVal) != 6 || Integer.parseInt(userVal) != 7
                    || Integer.parseInt(userVal) != 8 || Integer.parseInt(userVal) != 9) {
                userVal = JOptionPane.showInputDialog(this.f,
                        "Enter a value from 1-9. To clear the cell, enter 0.\n\nText will be ignored.\nIncorrect values will prompt this message again.");
                System.out.println("User entered: " + userVal);

                if (Integer.parseInt(userVal) == 1 || Integer.parseInt(userVal) == 2 || Integer.parseInt(userVal) == 3
                        || Integer.parseInt(userVal) == 4 || Integer.parseInt(userVal) == 5
                        || Integer.parseInt(userVal) == 6 || Integer.parseInt(userVal) == 7
                        || Integer.parseInt(userVal) == 8 || Integer.parseInt(userVal) == 9) {
                    numButton.setText(userVal);
                    break;
                }
                // Clear the cell
                if (Integer.parseInt(userVal) == 0) {
                    numButton.setText("");
                    break;
                }
            }
        } catch (java.lang.NumberFormatException nfe) {
            System.out.println("User either cancelled or entered text: " + nfe);
        }
    }

    public JButton[][] getButtonGrid() {
        return buttonGrid;
    }

    public int getButtonVal(int x, int y) {

        if (buttonGrid[y][x].getText() != "")
            return Integer.parseInt(buttonGrid[y][x].getText());
        else
            return -1;
    }

    public void setButtonVal(int val, int x, int y) {
        buttonGrid[y][x].setText("" + val);
    }

    public void setButtonVal(String val, int x, int y) {
        buttonGrid[y][x].setText(val);
    }

    public void setButtonEnabled(int x, int y) {
        buttonGrid[y][x].setEnabled(true);
    }

    public void setButtonDisabled(int x, int y) {
        buttonGrid[y][x].setEnabled(false);
    }
}