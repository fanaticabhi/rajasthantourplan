package com.example.abhi.rajasthantourplan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abhi on 19-03-2018.
 */

public class customadapter extends BaseAdapter {
    ArrayList<String>place = new ArrayList<String>();
    ArrayList<String>placetype = new ArrayList<String>();
    Context ct;
    LayoutInflater layoutInflater;

    public customadapter(Context ctt, ArrayList<String>plc, ArrayList<String>plctp) {
        this.place = plc;
        this.placetype = plctp;
        ct = ctt;
        layoutInflater = LayoutInflater.from(ct);
    }
    @Override
    public int getCount() {
        return place.size();
    }

    @Override
    public Object getItem(int i) {
        return place.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.customrow, null);
        TextView t1, t2;
        t1 = view.findViewById(R.id.textview1);
        t2 = view.findViewById(R.id.textview2);
        t1.setText(place.get(i));
        t2.setText(placetype.get(i));
        return view;
    }

}
