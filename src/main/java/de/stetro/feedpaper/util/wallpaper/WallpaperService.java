package de.stetro.feedpaper.util.wallpaper;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
        if (isOnline()) {
            Picasso.with(context).load(url).into(new TargetAdapter() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                    try {
                        int desiredMinimumHeight = wallpaperManager.getDesiredMinimumHeight();
                        int desiredMinimumWidth = wallpaperManager.getDesiredMinimumWidth();
                        wallpaperManager.setBitmap(getReSizedBitmap(bitmap, desiredMinimumHeight, desiredMinimumWidth));
                        Toast.makeText(context, "Wallpaper updated!", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onBitmapFailed(Drawable drawable) {
                    Toast.makeText(context, "Could not load image.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(context, "No internet connection.", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public Bitmap getReSizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        if (scaleWidth > scaleHeight) {
            scaleWidth = scaleHeight;
        } else {
            scaleHeight = scaleWidth;
        }

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);

    }
}
