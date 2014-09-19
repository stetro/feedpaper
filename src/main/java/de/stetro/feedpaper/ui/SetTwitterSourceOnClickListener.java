package de.stetro.feedpaper.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import de.stetro.feedpaper.FeedpaperPreferences;


public class SetTwitterSourceOnClickListener implements View.OnClickListener {
    private Context context;

    public SetTwitterSourceOnClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Twitter Account");
        alert.setMessage("This account will be polled to get the newest Tweet for your wallpaper. (e.g. Astro_Alex, astro_reid, Fascinatingpics ...)");
        final EditText input = new EditText(context);
        input.setText(FeedpaperPreferences.readSharedPreference(context, FeedpaperPreferences.Preference.TWITTER_ACCOUNT));
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Editable value = input.getText();
                if (value != null && value.length() > 0) {
                    FeedpaperPreferences.saveToSharedPreferences(context, value.toString(), FeedpaperPreferences.Preference.TWITTER_ACCOUNT);
                }
            }
        });
        alert.show();
    }
}
