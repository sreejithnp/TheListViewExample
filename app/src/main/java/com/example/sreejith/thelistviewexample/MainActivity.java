package com.example.sreejith.thelistviewexample;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sreejith.thelistviewexample.adapters.ResponsibleAdapter;
import com.example.sreejith.thelistviewexample.datamodel.ResponsibleDataModel;
import com.example.sreejith.thelistviewexample.datamodel.ResponsibleRepository;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShowList();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(getBaseContext(), "Responsible Updated", Toast.LENGTH_LONG).show();

        ShowList();
    }

    private void ShowList()
    {
        DBOperations db = new DBOperations(this.getBaseContext());

        SQLiteDatabase dbRead = db.getReadableDatabase();

        ResponsibleDataModel model = new ResponsibleDataModel();

        ArrayList<ResponsibleRepository> respoList = model.GetAllRespobibles(dbRead);

        ResponsibleAdapter rAdapter = new ResponsibleAdapter(this.getBaseContext(), R.layout.resposbible_list_layout,respoList);

        ListView lv = (ListView) findViewById(R.id.theListView);

        lv.setAdapter(rAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ResponsibleRepository repo = (ResponsibleRepository) adapterView.getItemAtPosition(i);
                Intent getResponsibleIntent;
                getResponsibleIntent = new Intent(getBaseContext(), ResponsibleDetailsActivity.class);

                final int result = 1;

                getResponsibleIntent.putExtra("resp", repo);

                startActivity(getResponsibleIntent);
            }
        });
    }


}
