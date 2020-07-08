package sudoku;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    final AtomicInteger value = new AtomicInteger(10);

    public static void main(String args[]) {
        UserInterface ui = new UserInterface();
        ui.initUI();
    }
}