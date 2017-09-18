package com.example.pauls.leaguetable;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Pauls on 23/11/2016.
 */


public class view extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        helper myDb;
        myDb = new helper(this);

        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            // show message
            showMessage("Error", "Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :" + res.getString(0) + "\n");
            buffer.append("Team :" + res.getString(1) + "\n");
            buffer.append("Player :" + res.getString(2) + "\n");
            buffer.append("Games Played :" + res.getString(3) + "\n");
            buffer.append("Goals For :" + res.getString(4) + "\n");
            buffer.append("Goals Against :" + res.getString(5) + "\n");
            buffer.append("Goal Difference :" + res.getString(6) + "\n");
            buffer.append("Points :" + res.getString(7) + "\n\n");
        }

        // Show all data
        showMessage("Data", buffer.toString());
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}

