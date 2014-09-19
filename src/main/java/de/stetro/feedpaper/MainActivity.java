package de.stetro.feedpaper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.stetro.feedpaper.util.FeedLoaderAsyncTask;


public class MainActivity extends Activity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        setupLayoutCallbacks();
    }

    private void setupLayoutCallbacks() {
        Button updateWallpaperButton = (Button) this.findViewById(R.id.setWallpaperButton);
        updateWallpaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userAccount = FeedpaperPreferences.readSharedPreference(context, FeedpaperPreferences.Preference.TWITTER_ACCOUNT);
                Toast.makeText(getApplicationContext(), "Updating Wallpaper from " + userAccount + " ...", Toast.LENGTH_SHORT).show();
                FeedLoaderAsyncTask task = new FeedLoaderAsyncTask(getApplicationContext());
                task.execute(userAccount);
            }
        });

        Button twitterSourceButton = (Button) this.findViewById(R.id.setTwitterSourceButton);
        twitterSourceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Twitter Account");
                alert.setMessage("This account will be polled to get the newest Tweet for your wallpaper. (e.g. Astro_Alex, HistoryInPics, Fascinatingpics ...)");
                final EditText input = new EditText(MainActivity.this);
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
        });
    }


}
