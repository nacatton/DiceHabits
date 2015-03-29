package com.nacatton.dicehabits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.nacatton.dicehabits.model.JournalData;
import com.nacatton.dicehabits.model.JournalItem;

public class JournalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        ListView journalListView = (ListView) findViewById(R.id.listView);
        // Fills the journal list
        String[] listEntries = new String[ JournalData.journal.size() ];
        for ( int i = 0; i < JournalData.journal.size(); i++ )
        {
            JournalItem currJournalItem = JournalData.journal.get( i );
            String completed = ( currJournalItem.completed ? "(Nailed it!)" : "(Failed it...)" );
            listEntries[i] = currJournalItem.habit.getHabit() + " " + completed;
        }

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, listEntries );
        journalListView.setAdapter(arrayAdapter);

        final Button backToDiceButton = (Button) findViewById(R.id.button);

        backToDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DiceHabitsActivity.class);
                startActivity(intent);
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.journey, menu);
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
