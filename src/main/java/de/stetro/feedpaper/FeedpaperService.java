package de.stetro.feedpaper;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import de.stetro.feedpaper.util.FeedLoaderAsyncTask;


public class FeedpaperService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Context context = getApplicationContext();
        String userAccount = FeedpaperPreferences.readSharedPreference(context, FeedpaperPreferences.Preference.TWITTER_ACCOUNT);
        Toast.makeText(context, "Updating Wallpaper from " + userAccount + " ...", Toast.LENGTH_SHORT).show();
        FeedLoaderAsyncTask task = new FeedLoaderAsyncTask(context);
        task.execute(userAccount);
        return START_NOT_STICKY;
    }
}
