package de.stetro.feedpaper.util;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import de.stetro.feedpaper.util.wallpaper.WallpaperService;
import twitter4j.MediaEntity;
import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class FeedLoaderAsyncTask extends AsyncTask<String, Void, String> {
    private Context context;

    public FeedLoaderAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String url = "";
        ConfigurationBuilder cb = getConfigurationBuilder();

        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        try {
            twitter.getOAuth2Token();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        Paging paging = new Paging(1, 10);
        try {
            List<twitter4j.Status> tweets = twitter.getUserTimeline(strings[0], paging);
            for (twitter4j.Status tweet : tweets) {
                MediaEntity[] mediaEntities = tweet.getMediaEntities();
                if (mediaEntities.length == 0) {
                    continue;
                }
                MediaEntity mediaEntity = mediaEntities[mediaEntities.length - 1];
                url = mediaEntity.getMediaURL().concat(":large");
                break;
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return url;
    }

    @Override
    protected void onPostExecute(String s) {
        WallpaperService wallpaperService = new WallpaperService(context);
        wallpaperService.setWallpaperBy(s);
    }

    private ConfigurationBuilder getConfigurationBuilder() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("***")
                .setOAuthConsumerSecret("***")
                .setOAuthAccessToken("*****")
                .setOAuthAccessTokenSecret("***");
        return cb;
    }
}
