package com.example.pauls.leaguetable;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Pauls on 23/11/2016.
 */


public class Insert extends AppCompatActivity {
       //Declare vars

    helper myDb;
    EditText teamName, playerName, gamesPlayed, goalsFor, goalsAgainst, goalDifference, points;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        myDb = new helper(this);

        //Casting
        teamName = (EditText) findViewById(R.id.teamName);
        playerName = (EditText) findViewById(R.id.playerName);
        gamesPlayed = (EditText) findViewById(R.id.gamesPlayed);
        goalsAgainst = (EditText) findViewById(R.id.goalsAgainst);
        goalsFor = (EditText) findViewById(R.id.goalsFor);
        goalDifference = (EditText) findViewById(R.id.goalDifference);
        points = (EditText) findViewById(R.id.points);
        points = (EditText) findViewById(R.id.points);

        btnAddData = (Button) findViewById(R.id.button_add);

        AddData();
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //call DATABASE query, convert to strings

                        boolean isInserted = myDb.insertData(teamName.getText().toString(),
                                playerName.getText().toString(),
                                gamesPlayed.getText().toString(), goalsAgainst.getText().toString(), goalsFor.getText().toString()
                        ,goalDifference.getText().toString(),points.getText().toString());
                        if(isInserted == true)
                        try {
                            Toast.makeText(Insert.this,"Data Inserted",Toast.LENGTH_LONG).show();
                            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(),notification );
                            r.play();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        else
                            Toast.makeText(Insert.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
