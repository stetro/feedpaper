package de.stetro.feedpaper;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import de.stetro.feedpaper.ui.SetRefreshIntervalOnClickListener;
import de.stetro.feedpaper.ui.SetTwitterSourceOnClickListener;
import de.stetro.feedpaper.ui.TriggerUpdateWallpaperOnClickListener;


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
        updateWallpaperButton.setOnClickListener(new TriggerUpdateWallpaperOnClickListener());

        Button twitterSourceButton = (Button) this.findViewById(R.id.setTwitterSourceButton);
        twitterSourceButton.setOnClickListener(new SetTwitterSourceOnClickListener());

        Button refreshIntervalButton = (Button) this.findViewById(R.id.setIntervalButton);
        refreshIntervalButton.setOnClickListener(new SetRefreshIntervalOnClickListener());
    }
}
