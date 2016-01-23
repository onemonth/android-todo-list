package com.onemonth.todolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfredhanssen on 1/23/16.
 */
public class StringAdapter extends ArrayAdapter<String>
{
    private int mResource;
    private LayoutInflater mLayoutInflater;
    private List<String> mItems = new ArrayList<>();

    public StringAdapter(Context context, int resource)
    {
        super(context, resource);

        mResource = resource;
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(@NonNull String item)
    {
        mItems.add(item);
        notifyDataSetChanged();
    }

    public void removeItem(@NonNull int position)
    {
        mItems.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        return mItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;

        if (convertView == null)
        {
            convertView = mLayoutInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.itemTextView = (TextView) convertView.findViewById(mResource);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        final String item = mItems.get(position);
        holder.itemTextView.setText(item);

        return convertView;
    }

    static class ViewHolder
    {
        TextView itemTextView;
    }
}
