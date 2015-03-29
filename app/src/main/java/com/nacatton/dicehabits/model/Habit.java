package com.nacatton.dicehabits.model;

import java.io.Serializable;

/**
 * Created by nacatton on 27/03/15.
 */
public class Habit implements Serializable {
    private String habit;
    private int minutes;
    private int position;

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
