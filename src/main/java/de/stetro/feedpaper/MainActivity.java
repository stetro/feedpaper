package de.stetro.feedpaper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

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
        Button button = (Button) this.findViewById(R.id.setWallpaperButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FeedLoaderAsyncTask task = new FeedLoaderAsyncTask(getApplicationContext());
                task.execute("BestEarthPix");
            }
        });
    }
}
