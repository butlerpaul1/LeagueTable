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




public class Delete extends AppCompatActivity {
    helper myDb;
    Button btnDelete;
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);

        myDb = new helper(this);
        btnDelete = (Button) findViewById(R.id.button_delete);
        id = (EditText) findViewById(R.id.id);
        deleteData();
    }
    public void deleteData() {

        btnDelete.setOnClickListener
            (
            new View.OnClickListener()
            {
                @Override
                public void onClick(View v)

                {
                    Integer deletedRows = myDb.deleteData(id.getText().toString());
                    if(deletedRows > 0)
                        try {
                            Toast.makeText(Delete.this,"Data Deleted",Toast.LENGTH_LONG).show();

                            // play sound
                            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(),notification );
                            r.play();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    else
                        Toast.makeText(Delete.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                }
            }
            );
    }
}
