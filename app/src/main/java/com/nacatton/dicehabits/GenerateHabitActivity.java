package com.nacatton.dicehabits;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nacatton.dicehabits.model.Habit;
import com.nacatton.dicehabits.model.JournalData;
import com.nacatton.dicehabits.model.JournalItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateHabitActivity extends Activity {
   public Handler mHandler = new Handler();
   public static Habit selectedHabit = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_habit);


        List<String> phrases = new ArrayList<String>();
        phrases.add( "\"Whatever you believe about yourself on the inside is what you will manifest on the outside.\"");
        phrases.add("\"What the mind can conceive and believe, it can achieve.\"");
        phrases.add("\"The minute you settle for less than you deserve, you get even less than you settled for.\"");
        phrases.add( "\"Perseverance is not a long race; it is many short races one after the other.\"");
        phrases.add("\"The will to win, the desire to succeed, the urge to reach your full potential, these are the keys that will unlock the door to personal excellence.\"");
        phrases.add("\"If you want to conquer fear, don’t sit home and think about it. Go out and get busy.\"");
        phrases.add("\"If you don’t design your own life plan, chances are you’ll fall into someone else’s plan. And guess what they have planned for you? Not much.\"");
        phrases.add("\"If you love life, do not waste time, for time is what life is made up of.\"");
        phrases.add("\"He who is not courageous enough to take risks will accomplish nothing in life.\"");
        phrases.add("\"If you don’t set a baseline standard for what you’ll accept in life, you’ll find it’s easy to slip into behaviors and attitudes or a quality of life that’s far below what you deserve.\"");
        phrases.add("\"Work joyfully and peacefully, knowing that right thoughts and right efforts will inevitably bring about right results.\"");
        phrases.add("\"I’m a great believer in luck, and I find the harder I work, the more luck I have.\"");
        phrases.add("\"You can never quit. Winners never quit, and quitters never win.\"");
        phrases.add("\"It’s always too early to quit.\"");
        phrases.add("\"If you can dream it, you can do it.\"");
        phrases.add("\"Continuous effort – not strength or intelligence – is the key to unlocking our potential.\"");
        phrases.add("\"Choose Happy. Believe me; There will be NO regrets, and it is BY FAR the BEST choice out there! FOR EVERYONE!!\"");
        phrases.add("\"Give yourself an even greater challenge than the one you are trying to master and you will develop the powers necessary to overcome the original difficulty.\"");
        phrases.add("\"Enter every activity without giving mental recognition to the possibility of defeat. Concentrate on your strengths, instead of your weaknesses… on your powers, instead of your problems.\"");
        phrases.add("\"Be patient with yourself. Self-growth is tender; it’s holy ground. There’s no greater investment.\"");
        phrases.add("\"Believe in yourself! Have faith in your abilities! Without a humble but reasonable confidence in your own powers you cannot be successful or happy.\"");
        phrases.add("\"Successful and unsuccessful people do not vary greatly in their abilities. They vary in their desires to reach their potential.\"");
        phrases.add("\"Pain is temporary. It may last a minute, or an hour, or a day, or a year, but eventually it will subside and something else will take its place. If I quit, however, it lasts forever.\"");
        phrases.add("\"My attitude is that if you push me towards something that you think is a weakness, then I will turn that perceived weakness into a strength.\"");
        phrases.add("\"Strength does not come from winning. Your struggles develop your strengths. When you go through hardships and decide not to surrender, that is strength.\"");
        phrases.add("\"We must train from the inside out. Using our strengths to attack and nullify any weaknesses. It’s not about denying a weakness may exist but about denying its right to persist.\"");
        phrases.add("\"It does not matter how slowly you go as long as you do not stop.\"");
        phrases.add("\"Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time.\"");
        phrases.add("\"Always do your best. What you plant now, you will harvest later.\"");
        phrases.add("\"Don't watch the clock; do what it does. Keep going.\"");

        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt( phrases.size() );

        final TextView myText = (TextView) findViewById(R.id.inspirationalQuote);
        myText.setText( phrases.get( index ) );

        TextView activityTaskView = (TextView) findViewById(R.id.activityTaskView );
        List<Habit> habits = SetHabitsActivity.habitsFactory.findAll();

        if (habits.size() > 0 ){
            int position = randomGenerator.nextInt(habits.size());
            GenerateHabitActivity.selectedHabit = habits.get(position);

            //intent.putExtra("habitID",habit.getPosition();
            //intent.getExtra("habitID",position);

            activityTaskView.setText(selectedHabit.getHabit().toUpperCase() + "\n"  + selectedHabit.getMinutes() + " mins!!!!");
        }



        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(200); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        activityTaskView.startAnimation(anim);

        Button nailedItButton = (Button) findViewById(R.id.nailedItButton);
        Button failedItButton = (Button) findViewById(R.id.failedItButton);

        nailedItButton.setOnTouchListener( new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    // do stuff
                    // change bg color
                    //view.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                    //view.invalidate();
                    view.setBackgroundColor( Color.parseColor( "#444444") );

                }

                if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    // do stuff
                    // change bg color
                    //view.getBackground().clearColorFilter();
                    //view.invalidate();
                    view.setBackgroundColor( Color.parseColor( "#888888") );

                    JournalData.journal.add( new JournalItem( GenerateHabitActivity.selectedHabit, true ) );
                    JournalData.saveToFile( view.getContext() );

                    Toast.makeText(view.getContext(), "CONGRATULATIONS! Keep up the good work!", Toast.LENGTH_LONG).show();
                    delayStartJournal();

                }
                return false;


            }
        });

        failedItButton.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    // do stuff
                    // change bg color
                    //view.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                    //view.invalidate();
                    view.setBackgroundColor( Color.parseColor( "#444444") );
                }

                if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    // do stuff
                    // change bg color
                    //view.getBackground().clearColorFilter();
                    //view.invalidate();
                    view.setBackgroundColor( Color.parseColor( "#888888") );

                    JournalData.journal.add( new JournalItem( GenerateHabitActivity.selectedHabit, false ) );
                    JournalData.saveToFile( view.getContext() );

                    Toast.makeText(view.getContext(), "OH NO! Remember to read the motivational quotes next time!", Toast.LENGTH_LONG).show();
                    delayStartJournal();

                }
                return false;


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.generate_habit, menu);
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


    private void delayStartJournal() {
        Handler handler = new Handler();
        handler.postDelayed(mLaunchTask,500);
    }

    //will launch the activity
    private Runnable mLaunchTask = new MyRunnable();

    private class MyRunnable implements Runnable {

        public void run() {
            Intent i = new Intent(getApplicationContext(),JournalActivity.class);
            startActivity(i);
        }
    }
}
