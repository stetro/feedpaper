package de.stetro.feedpaper.util;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class WallpaperService {
    private Context context;

    public WallpaperService(Context context) {
        this.context = context;
    }

    public void setWallpaperBy(String url) {
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
        Picasso.with(context).load(url).into(new TargetAdapter() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                try {
                    wallpaperManager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onBitmapFailed(Drawable drawable) {
                Toast.makeText(context, "Could not load image.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
