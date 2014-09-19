package de.stetro.feedpaper;

import android.content.Context;
import android.content.SharedPreferences;

public class FeedpaperPreferences {

    public static String readSharedPreference(Context context, Preference preference) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        return sharedPref.getString(preference.getLabel(), preference.getDefaultValue());
    }

    public static void saveToSharedPreferences(Context context, String value, Preference preference) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(preference.getLabel(), value);
        editor.apply();
    }

    public enum Preference {
        TWITTER_ACCOUNT("twitter_account", "Astro_Alex"),
        REFRESH_MINUTES("refresh_minutes", "60");

        private String label;
        private String defaultValue;

        Preference(String label, String defaultValue) {
            this.label = label;
            this.defaultValue = defaultValue;
        }

        public String getLabel() {
            return label;
        }

        public String getDefaultValue() {
            return defaultValue;
        }
    }
}
