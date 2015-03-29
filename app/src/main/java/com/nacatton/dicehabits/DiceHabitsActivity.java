package com.nacatton.dicehabits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nacatton.dicehabits.model.JournalData;


public class DiceHabitsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_habits);

        JournalData.readFile( this );

        final Button enterHabitsButton = (Button) findViewById(R.id.enterHabitsButton);
        enterHabitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),SetHabitsActivity.class);
                startActivity(intent);
            }

        });



        ImageButton diceButton = (ImageButton) findViewById(R.id.diceButton);

        diceButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (SetHabitsActivity.habitsFactory.findAll().size() > 0) {
                    Intent intent = new Intent(view.getContext(), GenerateHabitActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(view.getContext(), "Set your activities first!", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button journalButton = (Button) findViewById(R.id.journalButton);

        journalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),JournalActivity.class);
                startActivity(intent);
            }
        });
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dice_habits, menu);
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
