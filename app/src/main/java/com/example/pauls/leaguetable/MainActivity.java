package com.example.pauls.leaguetable;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {
    helper myDb;



    String[] menu = new String[]{ "View Table", "Insert", "Delete", "Update", "Exit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call helper, creates database
        myDb = new helper(this);

        setListAdapter(new
                ArrayAdapter<String>(this,android.R.layout.
                simple_list_item_1, menu));
    }

    //Displays list which is used as a menu, when an option is chosen it opens a new activity
    protected void onListItemClick (ListView l, View v, int position, long id){
        String item = (String) getListAdapter().getItem(position);
        switch ( position ) {
            case 0: Intent newActivity0 = new Intent(this, view.class );
                startActivity(newActivity0);
                break;

            case 1: Intent newActivity1 = new Intent(this, Insert.class );
                startActivity(newActivity1);
                break;

            case 2: Intent newActivity2 = new Intent(this, Delete.class );
                startActivity(newActivity2);
                break;

            case 3: Intent newActivity3 = new Intent(this, Update.class );
                startActivity(newActivity3);
                break;

            case 4:
                finish();
                break;


        }



    }

}