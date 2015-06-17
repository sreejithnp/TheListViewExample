package com.example.sreejith.thelistviewexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sreejith.thelistviewexample.R;

/**
 * Created by Sreejith on 6/4/2015.
 */
public class MyAdapter extends ArrayAdapter<String>
{

    public MyAdapter(Context context, String[] resource) {
        super(context, R.layout.image_list_layout, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflator = LayoutInflater.from(getContext());

        View theView = inflator.inflate(R.layout.image_list_layout, parent, false);

        String selectedText = getItem(position);

        TextView myTextView = (TextView) theView.findViewById(R.id.TextView1);

        myTextView.setText(selectedText);

        ImageView myImageView = (ImageView) theView.findViewById(R.id.ImageView1);

        return theView;
    }
}
