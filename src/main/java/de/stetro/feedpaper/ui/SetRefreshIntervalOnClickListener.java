package de.stetro.feedpaper.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import de.stetro.feedpaper.FeedpaperPreferences;


public class SetRefreshIntervalOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        final Context context = view.getContext();
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Refresh Interval");
        alert.setMessage("Required minutes to refresh your wallpaper from twitter.");
        final EditText input = new EditText(context);
        input.setText(FeedpaperPreferences.readSharedPreference(context, FeedpaperPreferences.Preference.REFRESH_MINUTES));
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Editable value = input.getText();
                if (value != null && value.length() > 0) {
                    FeedpaperPreferences.saveToSharedPreferences(context, value.toString(), FeedpaperPreferences.Preference.REFRESH_MINUTES);
                }
            }
        });
        alert.show();
    }
}
