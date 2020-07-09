// package sudoku;

// import javax.swing.*;

// // Creating the abstract class here to fulfill the core requirement. I wanted to not use an 
// // abstract class here and just extend UserInterface from ThreadedTimer. But I really saw
// // no other better place for me to try to use an abstract class.
// abstract class Timer extends Thread {

//     public void reset() {
//     }

//     private void updateLabel() {
//     }
// }

// public class ThreadedTimer extends Timer {

//     private int timeElapsedSec;

//     public ThreadedTimer() {

//         timeElapsedSec = 0;
//     }

//     @Override
//     public void run() {

//         System.out.println("thread started.");

//         while (true) {
//             try {
//                 Thread.sleep(1000);
//                 timeElapsedSec++;
//                 System.out.println("Elapsed Time: " + timeElapsedSec + "s");
//                 updateLabel();
//             } catch (InterruptedException ie) {
//                 System.out.println("Thread was interrupted: " + ie);
//             }
//         }

//     }

//     public void reset() {
//         timeElapsedSec = 0;
//     }

//     private void updateLabel() {

//         //setTimeElapsed("Elapsed Time: " + timeElapsedSec + "s");
//         try {

//             //timeritem.setText("Elapsed Time: " + timeElapsedSec + "s");
//         } catch (NullPointerException npe) {
//             System.out.println("some problem here: " + npe);
//         }

//     }

// }