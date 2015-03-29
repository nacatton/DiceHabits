package com.nacatton.dicehabits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.nacatton.dicehabits.model.JournalData;
import com.nacatton.dicehabits.model.JournalItem;

import java.util.LinkedList;
import java.util.List;

public class JournalActivity extends Activity {

    private List<String> listEntries = new LinkedList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);


        ListView journalListView = (ListView) findViewById(R.id.listView);
        // Fills the journal list
        listEntries = new LinkedList<String>();
        for ( int i = 0; i < JournalData.journal.size(); i++ )
        {
            JournalItem currJournalItem = JournalData.journal.get( i );
            String completed = ( currJournalItem.completed ? "(Nailed it!)" : "(Failed it...)" );
            listEntries.add(currJournalItem.habit.getHabit() + " - " + currJournalItem.habit.getMinutes() + "Min - " + completed);
        }

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, listEntries);
        journalListView.setAdapter(arrayAdapter);

        final Button backToDiceButton = (Button) findViewById(R.id.button);

        backToDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DiceHabitsActivity.class);
                startActivity(intent);
            }

        });

        final Button clearDataButton = (Button) findViewById(R.id.clearDataButton); // init it
        clearDataButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                JournalData.journal.clear(); // this list which you hava passed in Adapter for your listview
                JournalData.saveToFile(JournalActivity.this);
                listEntries.clear();
                arrayAdapter.notifyDataSetChanged(); // notify to listview for refresh

            }

        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,DiceHabitsActivity.class);
        startActivity(intent);

    }

}
