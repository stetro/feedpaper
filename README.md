feedpaper
=========
![Logo](https://raw.githubusercontent.com/stetro/feedpaper/master/src/main/res/drawable-xxxhdpi/ic_launcher.png) [![Android Icon](http://developer.android.com/images/brand/en_generic_rgb_wo_45.png)](https://play.google.com/store/apps/details?id=de.stetro.feedpaper)
 [![Build Status](https://travis-ci.org/stetro/feedpaper.svg)](https://travis-ci.org/stetro/feedpaper) 
Android application to get images as wallaper from a twitter stream. 

The idea is to read a twitter feed from e.g. [@Astro_Alex](https://twitter.com/Astro_Alex) and set the current tweet as android wallpaper.

Build
-----

To build this app you need a working twitter authentication token in `src/main/java/de/stetro/feedpaper/util/FeedLoaderAsyncTask.java` in the following form:

```java
    ...
    private ConfigurationBuilder getConfigurationBuilder() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setApplicationOnlyAuthEnabled(true)
                .setOAuthConsumerKey("YOURCONSUMERKEYHERE")
                .setOAuthConsumerSecret("YOUROCONSUMERSECRETHERE");
        return cb;
    }
    ...
```

For signing you can add a keystore directory with the follwowing gradle file `keystore/keystore.gradle`:

```grails
android {
    signingConfigs {
        release {
            storeFile file('keystore/key.jks')
            storePassword "yourpassword"
            keyAlias "youralias"
            keyPassword "yourpassword"
        }
    }
}

```
