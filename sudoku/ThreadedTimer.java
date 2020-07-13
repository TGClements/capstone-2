package sudoku;

// Creating the abstract class here to fulfill the core requirement. I wanted to not use an 
// abstract class here and just extend Thread from ThreadedTimer. But I really saw
// no other better place for me to try to use an abstract class.
abstract class Timer extends Thread {

    public void reset() {
    }

    private void updateLabel() {
    }
}

class ThreadedTimer extends Timer {

    private int timeElapsedSec;
    private boolean alive = true;

    public ThreadedTimer() {

        timeElapsedSec = 0;
    }

    @Override
    public void run() {

        System.out.println("Timer started.");

        while (alive) {
            try {
                Thread.sleep(1000);
                timeElapsedSec++;
                // System.out.println("Elapsed Time: " + timeElapsedSec + "s");
                updateLabel();
            } catch (InterruptedException ie) {
                System.out.println("Thread was interrupted: " + ie);
            }
        }

    }

    // Reset the timer counter
    public void reset() {
        timeElapsedSec = 0;
    }

    // Stop the thread
    public void tStop() {
        alive = false;
    }

    // Get the elapsed time
    public int getTime() {
        return timeElapsedSec;
    }

    // Update the label on the GUI with the new time
    private void updateLabel() {

        UserInterface.setTimeElapsed("Elapsed Time: " + timeElapsedSec + "s");
    }
}