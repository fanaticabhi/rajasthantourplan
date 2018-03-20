package com.example.abhi.rajasthantourplan;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventsListDesign extends BaseAdapter {

    ArrayList<String>title = new ArrayList<String>();
    ArrayList<String>cat = new ArrayList<String>();
    ArrayList<String>label = new ArrayList<String>();
    ArrayList<String>duration = new ArrayList<String>();
    ArrayList<String>start = new ArrayList<String>();
    ArrayList<String>end = new ArrayList<String>();
    ArrayList<String>loc = new ArrayList<String>();
    Context ct;
    LayoutInflater lttt;
    public EventsListDesign(Context cnt, ArrayList<String>ttl, ArrayList<String>ctgry, ArrayList<String>lab, ArrayList<String>dur, ArrayList<String>stt, ArrayList<String>edd, ArrayList<String>lot){
        this.title = ttl;
        this.cat = ctgry;
        this.label = lab;
        this.duration = dur;
        this.start = stt;
        this.end = edd;
        this.loc = lot;
        ct = cnt;
        lttt = LayoutInflater.from(ct);
    }
    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int position) {
        return title.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = lttt.inflate(R.layout.activity_events_list_design, null);
        TextView t1, t2, t3, t4, t5, t6, t7;
        t1 = convertView.findViewById(R.id.title);
        t2 = convertView.findViewById(R.id.category);
        t3 = convertView.findViewById(R.id.Label);
        t4 = convertView.findViewById(R.id.duration);
        t5 = convertView.findViewById(R.id.start);
        t6 = convertView.findViewById(R.id.end);
        t7 = convertView.findViewById(R.id.location);
        t1.setText(title.get(position));
        t2.setText(cat.get(position));
        t3.setText(label.get(position));
        t4.setText(duration.get(position));
        t5.setText(start.get(position));
        t6.setText(end.get(position));
        t7.setText(loc.get(position));
        return convertView;
    }
}