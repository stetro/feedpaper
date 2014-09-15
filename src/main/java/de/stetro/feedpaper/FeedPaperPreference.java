package de.stetro.feedpaper;


public enum FeedPaperPreference {

    TWITTER_ACCOUNT("twitter_account");

    private String label;

    FeedPaperPreference(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
