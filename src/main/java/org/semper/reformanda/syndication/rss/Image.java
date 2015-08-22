package org.semper.reformanda.syndication.rss;

public class Image {

    private String url;
    private String title;
    private String link;
    private String width;
    private String height;
    private String description;

    public String getUrl() {
        return url;
    }

    public Image setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Image setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Image setLink(String link) {
        this.link = link;
        return this;
    }

    public String getWidth() {
        return width;
    }

    public Image setWidth(String width) {
        this.width = width;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public Image setHeight(String height) {
        this.height = height;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Image setDescription(String description) {
        this.description = description;
        return this;
    }
}