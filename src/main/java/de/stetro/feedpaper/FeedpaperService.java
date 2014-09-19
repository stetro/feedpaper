package de.stetro.feedpaper;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

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
        Log.d("feedpaper", "Updating Wallpaper ...");

        Calendar cal = Calendar.getInstance();
        Intent nextIntent = new Intent(context, FeedpaperService.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, nextIntent, 0);
        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        String minutes = FeedpaperPreferences.readSharedPreference(context, FeedpaperPreferences.Preference.REFRESH_MINUTES);
        alarm.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + Integer.parseInt(minutes) * 60 * 1000, pendingIntent);
        Log.d("feedpaper", String.format("Next Execution in %d Minutes ...", (Integer.parseInt(minutes) * 60 * 1000) / (60 * 1000)));
        return START_NOT_STICKY;
    }
}
