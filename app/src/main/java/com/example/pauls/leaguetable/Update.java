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
 * Created by Pauls on 24/11/2016.
 */


public class Update extends AppCompatActivity {
    //Declare vars

    helper myDb;
    EditText id, teamName, playerName, gamesPlayed, goalsFor, goalsAgainst, goalDifference, points;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        myDb = new helper(this);

        //Casting
        id = (EditText) findViewById(R.id.id);
        teamName = (EditText) findViewById(R.id.teamName);
        playerName = (EditText) findViewById(R.id.playerName);
        gamesPlayed = (EditText) findViewById(R.id.gamesPlayed);
        goalsAgainst = (EditText) findViewById(R.id.goalsAgainst);
        goalsFor = (EditText) findViewById(R.id.goalsFor);
        goalDifference = (EditText) findViewById(R.id.goalDifference);
        points = (EditText) findViewById(R.id.points);

        btnUpdate = (Button) findViewById(R.id.button_update);

        updateData();
    }
    public  void updateData() {
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //call DATABASE query, convert to strings
                        boolean isUpdate = myDb.updateData(id.getText().toString(),
                                teamName.getText().toString(),playerName.getText().toString(),
                                gamesPlayed.getText().toString(), goalsAgainst.getText().toString(), goalsFor.getText().toString()
                                ,goalDifference.getText().toString(),points.getText().toString());

                        if(isUpdate == true)
                        try {
                            //give conformation if the query was successful
                            Toast.makeText(Update.this,"Data Updated",Toast.LENGTH_LONG).show();
                            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                            r.play();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        else
                            Toast.makeText(Update.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
