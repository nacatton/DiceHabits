package com.nacatton.dicehabits.model;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by nacatton on 28/03/15.
 */
public class JournalData
{
    public static ArrayList<JournalItem> journal = new ArrayList<JournalItem>();
    private static String fileName ="journal.io";

    public static void saveToFile(Context context) {

        FileOutputStream fos = null;
        ObjectOutputStream os = null;
        try {
            fos = context.openFileOutput(JournalData.fileName, Context.MODE_PRIVATE);
            os = new ObjectOutputStream(fos);
            os.writeObject( JournalData.journal );
            os.close();
            fos.close();
        } catch (IOException e) {
            Log.e("JournalData", e.getMessage());
            e.printStackTrace();
        }
    }
    public static void readFile(Context context) {
        FileInputStream fis = null;
        ObjectInputStream is = null;
        try {
            fis = context.openFileInput(JournalData.fileName);
            is = new ObjectInputStream(fis);
            JournalData.journal = (ArrayList<JournalItem>) is.readObject();
            is.close();
            fis.close();
        } catch (IOException e) {
            Log.e("JournalData", e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Log.e("JournalData", e.getMessage());
            e.printStackTrace();
        }
    }

}
