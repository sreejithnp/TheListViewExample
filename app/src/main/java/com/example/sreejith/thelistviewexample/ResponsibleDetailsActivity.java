package com.example.sreejith.thelistviewexample;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sreejith.thelistviewexample.datamodel.ResponsibleDataModel;
import com.example.sreejith.thelistviewexample.datamodel.ResponsibleRepository;

/**
 * Created by Sreejith on 6/12/2015.
 */
public class ResponsibleDetailsActivity extends Activity {
    ResponsibleRepository respo = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.responsible_layout);

        Intent respoIntent = getIntent();
        respo = (ResponsibleRepository) respoIntent.getExtras().get("resp");

        if(respo !=null)
        {
            EditText firstnameText = (EditText) findViewById(R.id.firstNameEditText);

            if(firstnameText!=null)
                firstnameText.setText(respo.FirstName);

            EditText middletnameText = (EditText) findViewById(R.id.middleNameEditText);

            if(middletnameText!=null)
                middletnameText.setText(respo.MiddleName);

            EditText surtnameText = (EditText) findViewById(R.id.surNameEditText);

            if(surtnameText!=null)
                surtnameText.setText(respo.SurName);
        }

    }

    public void closThisActivity(View view) {
        finish();
    }

    public void UpdateResponsible(View view) {

        view= view.getRootView();

        EditText firstnameText = (EditText) view.findViewById(R.id.firstNameEditText);

        if(firstnameText!=null)
            respo.FirstName = firstnameText.getText().toString();

        EditText middletnameText = (EditText) view.findViewById(R.id.middleNameEditText);

        if(middletnameText!=null)
            respo.MiddleName = middletnameText.getText().toString();

        EditText surtnameText = (EditText) view.findViewById(R.id.surNameEditText);

        if(surtnameText!=null)
            respo.SurName = surtnameText.getText().toString();

        DBOperations db = new DBOperations(this.getBaseContext());

        SQLiteDatabase dbWrite = db.getWritableDatabase();

        ResponsibleDataModel model = new ResponsibleDataModel();

        //Toast.makeText(getBaseContext(), "First Name " + respo.FirstName, Toast.LENGTH_LONG).show();

        boolean result = model.UpdateResponsible(dbWrite, respo);

        if(result == false)
        {
            Toast.makeText(getBaseContext(), "Cannot update", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "Updated", Toast.LENGTH_LONG).show();
            Intent gobackIntent = new Intent();
            setResult(RESULT_OK, gobackIntent);
            finish();
        }
    }
}
