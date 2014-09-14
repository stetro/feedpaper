package de.stetro.feedpaper.util.settings;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.stetro.feedpaper.R;

public class SettingItemAdapter extends ArrayAdapter<SettingItem> {

    private final Context context;
    private final ArrayList<SettingItem> modelsArrayList;

    public SettingItemAdapter(Context context, ArrayList<SettingItem> modelsArrayList) {

        super(context, R.layout.setting_item, modelsArrayList);

        this.context = context;
        this.modelsArrayList = modelsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = null;

        rowView = inflater.inflate(R.layout.setting_item, parent, false);

        ImageView imgView = (ImageView) rowView.findViewById(R.id.item_icon);
        TextView titleView = (TextView) rowView.findViewById(R.id.item_title);
        TextView counterView = (TextView) rowView.findViewById(R.id.item_counter);

        imgView.setImageResource(modelsArrayList.get(position).getIcon());
        titleView.setText(modelsArrayList.get(position).getName());
        counterView.setText(modelsArrayList.get(position).getContent());

        return rowView;
    }
}
