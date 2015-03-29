package com.nacatton.dicehabits.model;

import java.io.Serializable;

/**
 * Created by nacatton on 28/03/15.
 */
public class JournalItem implements Serializable{
    public Habit habit;
    public boolean completed;

    public JournalItem( Habit habit, boolean completed )
    {
        this.habit = habit;
        this.completed = completed;
    }
}
