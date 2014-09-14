package de.stetro.feedpaper.util.settings;


public class SettingItem {
    private String name;
    private int icon;
    private String content;

    public SettingItem(String name, int icon, String content) {
        this.name = name;
        this.icon = icon;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
