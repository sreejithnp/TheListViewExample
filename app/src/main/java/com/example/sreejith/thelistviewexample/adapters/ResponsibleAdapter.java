package com.example.sreejith.thelistviewexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sreejith.thelistviewexample.R;
import com.example.sreejith.thelistviewexample.datamodel.ResponsibleRepository;

import java.util.List;

/**
 * Created by Sreejith on 6/11/2015.
 */
public class ResponsibleAdapter extends ArrayAdapter<ResponsibleRepository>
{
    public ResponsibleAdapter(Context context, int resource)
    {
        super(context, resource);
    }

    public ResponsibleAdapter(Context context, int resource, List<ResponsibleRepository> list)
    {
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v==null )
        {
            LayoutInflater vl = LayoutInflater.from(getContext());
            v=vl.inflate(R.layout.resposbible_list_layout, null);
        }

        ResponsibleRepository rp = getItem(position);
        if(rp!=null)
        {
            TextView t1 = (TextView) v.findViewById(R.id.firstNameText);
            TextView t2 = (TextView) v.findViewById(R.id.middleNameText);
            TextView t3 = (TextView) v.findViewById(R.id.surNameText);


            if(t1!=null)
            {
                t1.setText(rp.FirstName);
            }
            if(t2!=null)
            {
                t2.setText(rp.MiddleName);
            }
            if(t2!=null)
            {
                t3.setText(rp.SurName);
            }
        }

        return  v;
    }
}
