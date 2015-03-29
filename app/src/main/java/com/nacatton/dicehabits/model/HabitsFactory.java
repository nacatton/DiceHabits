package com.nacatton.dicehabits.model;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nacatton on 27/03/15.
 */
public class HabitsFactory {
    private List<Habit> habits = new ArrayList<Habit>();
    private String fileName ="habits.io";

    public void saveToFile(Context context) {

        FileOutputStream fos = null;
        ObjectOutputStream os = null;
        try {
            fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            os = new ObjectOutputStream(fos);
            os.writeObject(habits);
            os.close();
            fos.close();
        } catch (IOException e) {
            Log.e("HabitsFactory", e.getMessage());
            e.printStackTrace();
        }
    }
    public void readFile(Context context) {
        FileInputStream fis = null;
        ObjectInputStream is = null;
        try {
            fis = context.openFileInput(fileName);
            is = new ObjectInputStream(fis);
            habits = (ArrayList<Habit>) is.readObject();
            is.close();
            fis.close();
        } catch (IOException e) {
            Log.e("HabitsFactory", e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Log.e("HabitsFactory", e.getMessage());
            e.printStackTrace();
        }
    }
    /*
     * Saves new or existing Habit
     */
    public Habit save(Habit habit) {

        boolean found = false;
        for (int i=0; i < habits.size(); i++) {
            Habit currentHabit = habits.get(i);
            if (currentHabit.getPosition() == habit.getPosition()) {
                habits.set(i, habit);
                found = true;
                break;
            }
        }
        if(!found) {
            habits.add(habit);
        }
        return habit;
    }




    public Habit delete(Habit habit) {
        //TODO implement the rest of this method
        throw new RuntimeException("Not implemented");
    }

    public List<Habit> findAll() {
        return habits;
    }

}
