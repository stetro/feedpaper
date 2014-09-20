package de.stetro.feedpaper.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import de.stetro.feedpaper.FeedpaperPreferences;
import de.stetro.feedpaper.FeedpaperService;

public class TriggerUpdateWallpaperOnClickListener implements View.OnClickListener {


    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        String userAccount = FeedpaperPreferences.readSharedPreference(context, FeedpaperPreferences.Preference.TWITTER_ACCOUNT);
        String minutes = FeedpaperPreferences.readSharedPreference(context, FeedpaperPreferences.Preference.REFRESH_MINUTES);
        Toast.makeText(context, "Updating Wallpaper from " + userAccount + " every " + minutes + " Minute.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, FeedpaperService.class);
        context.startService(intent);
    }

}
