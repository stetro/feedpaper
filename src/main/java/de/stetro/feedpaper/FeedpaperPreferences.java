package de.stetro.feedpaper;

import android.content.Context;
import android.content.SharedPreferences;

public class FeedpaperPreferences {

    public static String readSharedPreference(Context context, Preference preference) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        return sharedPref.getString(preference.getLabel(), "Astro_Alex");
    }

    public static void saveToSharedPreferences(Context context, String value, Preference preference) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(preference.getLabel(), value);
        editor.apply();
    }

    public enum Preference {
        TWITTER_ACCOUNT("twitter_account");

        private String label;

        Preference(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
