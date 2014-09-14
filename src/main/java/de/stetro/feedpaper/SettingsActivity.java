package de.stetro.feedpaper;


import android.app.ListActivity;
import android.os.Bundle;

import java.util.ArrayList;

import de.stetro.feedpaper.util.settings.SettingItem;
import de.stetro.feedpaper.util.settings.SettingItemAdapter;

public class SettingsActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SettingItemAdapter adapter = new SettingItemAdapter(this, generateSettingItems());
        setListAdapter(adapter);
    }

    private ArrayList<SettingItem> generateSettingItems() {
        ArrayList<SettingItem> items = new ArrayList<SettingItem>();
        items.add(new SettingItem("Twitter Account", R.drawable.twitter, "stetro"));
        items.add(new SettingItem("Refresh rate", R.drawable.refresh, "3 minutes"));
        return items;
    }
}
