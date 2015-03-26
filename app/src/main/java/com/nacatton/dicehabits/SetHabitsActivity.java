package com.nacatton.dicehabits;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SetHabitsActivity extends Activity {

    EditText enterHabit1, enterTime1, enterHabit2, enterTime2, enterHabit3, enterTime3, enterHabit4, enterTime4,
            enterHabit5, enterTime5, enterHabit6, enterTime6;
    Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_habits);

        enterHabit1 = (EditText) findViewById(R.id.enterHabit1);
        enterTime1 = (EditText)findViewById(R.id.enterTime1);
        enterHabit2 = (EditText) findViewById(R.id.enterHabit2);
        enterTime2 = (EditText)findViewById(R.id.enterTime2);
        enterHabit3 = (EditText) findViewById(R.id.enterHabit3);
        enterTime3 = (EditText)findViewById(R.id.enterTime3);
        enterHabit4 = (EditText) findViewById(R.id.enterHabit4);
        enterTime4 = (EditText)findViewById(R.id.enterTime4);
        enterHabit5 = (EditText) findViewById(R.id.enterHabit5);
        enterTime5 = (EditText)findViewById(R.id.enterTime5);
        enterHabit6 = (EditText) findViewById(R.id.enterHabit6);
        enterTime6 = (EditText)findViewById(R.id.enterTime6);

        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (enterHabit1.getText().toString().matches("")) {

                    String habit1 = enterHabit1.getText().toString();
                }

                if (enterTime1.getText().toString().matches("")) {

                    String Time1 = enterTime1.getText().toString();

                }
                if (enterHabit2.getText().toString().matches("")) {

                    String habit2 = enterHabit2.getText().toString();
                }

                if (enterTime2.getText().toString().matches("")) {

                    String Time2 = enterTime2.getText().toString();
                }

                if (enterHabit3.getText().toString().matches("")) {

                    String habit3 = enterHabit3.getText().toString();
                }

                if (enterTime3.getText().toString().matches("")) {

                    String Time3 = enterTime3.getText().toString();

                }
                if (enterHabit4.getText().toString().matches("")) {

                    String habit4 = enterHabit4.getText().toString();
                }

                if (enterTime4.getText().toString().matches("")) {

                    String Time4 = enterTime4.getText().toString();


                }
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
