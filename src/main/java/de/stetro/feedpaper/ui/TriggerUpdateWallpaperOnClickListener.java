package de.stetro.feedpaper.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import de.stetro.feedpaper.FeedpaperService;

public class TriggerUpdateWallpaperOnClickListener implements View.OnClickListener {
    private Context context;

    public TriggerUpdateWallpaperOnClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, FeedpaperService.class);
        context.startService(intent);
    }

}
