package com.vicentcode.converte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LongitudAdapter extends ArrayAdapter<Longitud_Item> {

    public LongitudAdapter(Context context, ArrayList<Longitud_Item> Longitud_Item) {
        super(context, 0, Longitud_Item);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.longitud_spinner_row, parent, false
            );
        }
        ImageView imageViewFlag = convertView.findViewById(R.id.image_logo);
        TextView textViewName = convertView.findViewById(R.id.text_view_name);
        Longitud_Item currentItem = getItem(position);
        if (currentItem != null) {
            imageViewFlag.setImageResource(currentItem.getImage());
            textViewName.setText(currentItem.getLongiName());
        }
        return convertView;
    }
}


