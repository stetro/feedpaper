package de.stetro.feedpaper.ui;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import de.stetro.feedpaper.FeedpaperPreferences;
import de.stetro.feedpaper.util.FeedLoaderAsyncTask;

public class TriggerUpdateWallpaperOnClickListener implements View.OnClickListener {
    private Context context;

    public TriggerUpdateWallpaperOnClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        String userAccount = FeedpaperPreferences.readSharedPreference(context, FeedpaperPreferences.Preference.TWITTER_ACCOUNT);
        Toast.makeText(context, "Updating Wallpaper from " + userAccount + " ...", Toast.LENGTH_SHORT).show();
        FeedLoaderAsyncTask task = new FeedLoaderAsyncTask(context);
        task.execute(userAccount);
    }

}
