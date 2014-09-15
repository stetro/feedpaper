package de.stetro.feedpaper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.stetro.feedpaper.util.FeedLoaderAsyncTask;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        setupLayoutCallbacks();
    }

    private void setupLayoutCallbacks() {
        Button updateWallpaperButton = (Button) this.findViewById(R.id.setWallpaperButton);
        updateWallpaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userAccount = readSharedPreference(FeedPaperPreference.TWITTER_ACCOUNT);
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
                input.setText(readSharedPreference(FeedPaperPreference.TWITTER_ACCOUNT));
                alert.setView(input);
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Editable value = input.getText();
                        if (value != null && value.length() > 0) {
                            saveToSharedPreferences(value.toString(), FeedPaperPreference.TWITTER_ACCOUNT);
                        }
                    }
                });
                alert.show();
            }
        });
    }

    private String readSharedPreference(FeedPaperPreference preference) {
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        return sharedPref.getString(preference.getLabel(), "Astro_Alex");
    }


    private void saveToSharedPreferences(String value, FeedPaperPreference preference) {
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(preference.getLabel(), value);
        editor.commit();
    }
}
