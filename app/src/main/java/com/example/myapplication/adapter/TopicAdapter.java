package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Topic;

import org.xmlpull.v1.XmlPullParser;

import java.util.List;

public class TopicAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Topic> list;

    public TopicAdapter(Context context, int layout, List<Topic> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        assert layoutInflater != null;
        convertView = layoutInflater.inflate(layout, null);
        TextView txtTopicName = convertView.findViewById(R.id.txtTopicName);
        ImageView imgAvt = convertView.findViewById(R.id.imgAvt);
        Topic topic = list.get(position);
        txtTopicName.setText(topic.getName());
        return convertView;

    }
}
