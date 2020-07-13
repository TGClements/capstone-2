package sudoku;

import java.util.*;

public class BestTimes {

    private List<Integer> timeList;

    public BestTimes() {

        timeList = Arrays.asList(0, 0, 0, 0, 0);
    }

    // Check if the value can replace one already in the list
    public boolean canAddToList(int time) {

        // If there is a zero contained, the new value can be added.
        // If the new value is less than the max value, it can be added.
        for (int i = 0; i < timeList.size(); i++) {
            if (timeList.stream().min(Integer::compare).get() == 0
                    || time < timeList.stream().max(Integer::compare).get()) {
                return true;
            }
        }

        return false;
    }

    public void addToList(int time) {

        int zero;

        // If there's a 0, replace that, otherwise replace the max of the list
        if (timeList.stream().min(Integer::compare).get() == 0) {
            zero = 0;
            timeList.set(timeList.indexOf(zero), time);
        } else {
            // Get the max and replace it
            int max = timeList.stream().max(Integer::compare).get();
            timeList.set(timeList.indexOf(max), time);
        }

        // Sort the list
        Collections.sort(timeList);
    }

    public String getFormattedTimeList() {

        String formattedTimeList = "";

        for (int i = 0; i < timeList.size(); i++) {
            formattedTimeList += (i + 1) + ". " + timeList.get(i) + "s\n";
        }

        return formattedTimeList;
    }
}