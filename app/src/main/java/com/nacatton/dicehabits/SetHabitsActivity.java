package com.nacatton.dicehabits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nacatton.dicehabits.model.Habit;
import com.nacatton.dicehabits.model.HabitsFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class SetHabitsActivity extends Activity {
    public static HabitsFactory habitsFactory = new HabitsFactory();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_habits);
        SetHabitsActivity.habitsFactory.readFile(this);
        List<Habit> habits = SetHabitsActivity.habitsFactory.findAll();
        final List<EditText> habitTextList = new LinkedList<EditText>();
        final List<EditText> timeTextList = new LinkedList<EditText>();

        EditText enterHabit1 = (EditText) findViewById(R.id.enterHabit1);
        habitTextList.add(enterHabit1);
        EditText enterTime1 = (EditText) findViewById(R.id.enterTime1);
        timeTextList.add(enterTime1);
        EditText enterHabit2 = (EditText) findViewById(R.id.enterHabit2);
        habitTextList.add(enterHabit2);
        EditText enterTime2 = (EditText) findViewById(R.id.enterTime2);
        timeTextList.add(enterTime2);
        EditText enterHabit3 = (EditText) findViewById(R.id.enterHabit3);
        habitTextList.add(enterHabit3);
        EditText enterTime3 = (EditText) findViewById(R.id.enterTime3);
        timeTextList.add(enterTime3);
        EditText enterHabit4 = (EditText) findViewById(R.id.enterHabit4);
        habitTextList.add(enterHabit4);
        EditText enterTime4 = (EditText) findViewById(R.id.enterTime4);
        timeTextList.add(enterTime4);
        EditText enterHabit5 = (EditText) findViewById(R.id.enterHabit5);
        habitTextList.add(enterHabit5);
        EditText enterTime5 = (EditText) findViewById(R.id.enterTime5);
        timeTextList.add(enterTime5);
        EditText enterHabit6 = (EditText) findViewById(R.id.enterHabit6);
        habitTextList.add(enterHabit6);
        EditText enterTime6 = (EditText) findViewById(R.id.enterTime6);
        timeTextList.add(enterTime6);

        final Iterator<EditText> habitEditIter = habitTextList.iterator();
        Iterator<EditText> timeEditIter = timeTextList.iterator();
        Iterator<Habit> habitIterator = habits.iterator();
        int position = 0;
        try {
            for (int i = 0; i<habitTextList.size(); i++) {
                position = 0;
                EditText habitEditText = habitEditIter.next();
                EditText timeEditText = timeEditIter.next();
                if (habitIterator.hasNext()) {
                    Habit habit = habitIterator.next();
                    habitEditText.setText(habit.getHabit());
                    timeEditText.setText(String.valueOf(habit.getMinutes()));
                } else {
                    habitEditText.setText("");
                    timeEditText.setText("");
                }
            }
        } catch (Exception e) {
            Log.d("SetHabitsActivity", "position=" + position);
        }

        Button saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = 0;
                Iterator<EditText> habitIter = habitTextList.iterator();
                Iterator<EditText> timeIter = timeTextList.iterator();
                while (habitIter.hasNext()) {
                    String habitString = habitIter.next().getText().toString();
                    String timeString = timeIter.next().getText().toString();

                    if (!habitString.isEmpty() && !timeString.isEmpty()) {
                        Habit habit = new Habit();
                        habit.setHabit(habitString);
                        habit.setMinutes(Integer.parseInt(timeString));
                        habit.setPosition(position);
                        habitsFactory.save(habit);
                    } else {
                        habitsFactory.delete(position);
                    }
                    position++;
                }
                habitsFactory.saveToFile(SetHabitsActivity.this);
                Intent intent = new Intent(view.getContext(),DiceHabitsActivity.class);
                startActivity(intent);

                Toast.makeText(view.getContext(), "Save Successful", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.set_habits, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
