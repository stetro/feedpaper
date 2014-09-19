package de.stetro.feedpaper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import de.stetro.feedpaper.ui.SetTwitterSourceOnClickListener;
import de.stetro.feedpaper.ui.TriggerUpdateWallpaperOnClickListener;
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
        updateWallpaperButton.setOnClickListener(new TriggerUpdateWallpaperOnClickListener(context));

        Button twitterSourceButton = (Button) this.findViewById(R.id.setTwitterSourceButton);
        twitterSourceButton.setOnClickListener(new SetTwitterSourceOnClickListener(context));
    }


}
