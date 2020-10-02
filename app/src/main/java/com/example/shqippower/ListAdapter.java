package com.example.shqippower;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListActivity> {
    private Context mContext;
    private int mResource;

    private static class ViewHolder {
        TextView title;
        TextView type;
        TextView time;
    }

    public ListAdapter(Context context, int resource, ArrayList<ListActivity> objects){
        super(context, resource, objects);
        mContext=context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String title = getItem(position).getTitle();
        String type = getItem(position).getType();
        String time = getItem(position).getTime();
        final View result;
        ViewHolder holder;
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.title=convertView.findViewById(R.id.title);
            holder.type=convertView.findViewById(R.id.type);
            holder.time=convertView.findViewById(R.id.time);
            result=convertView;
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
            result=convertView;
        }

        holder.title.setText(title);
        holder.type.setText(type);
        holder.time.setText(time);

        return result;
    }
}
