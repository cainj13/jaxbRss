package org.semper.reformanda.syndication.rss;

import org.semper.reformanda.syndication.rss.atom.AtomLink;
import org.semper.reformanda.syndication.rss.itunes.Category;
import org.semper.reformanda.syndication.rss.itunes.Owner;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class Channel {

    // Generic RSS fields
    private String title;
    private String link;
    private Date pubDate;
    private Date lastBuildDate;
    private int ttl;
    private String language;
    private String copyright;
    private String webMaster;
    private String description;
    private String image;

    // Atom Fields
    private AtomLink atomLink;

    // iTunes Fields
    private Owner owner;
    private String author;
    private String explicit; // TODO boolean/enum
    private String itunesImage; // TODO URI?
    private Category category; // TODO sub-cats

    public String getTitle() {
        return title;
    }

    public Channel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Channel setLink(String link) {
        this.link = link;
        return this;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public Channel setPubDate(Date pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    public Date getLastBuildDate() {
        return lastBuildDate;
    }

    public Channel setLastBuildDate(Date lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
        return this;
    }

    public int getTtl() {
        return ttl;
    }

    public Channel setTtl(int ttl) {
        this.ttl = ttl;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Channel setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getCopyright() {
        return copyright;
    }

    public Channel setCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    public String getWebMaster() {
        return webMaster;
    }

    public Channel setWebMaster(String webMaster) {
        this.webMaster = webMaster;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Channel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Channel setImage(String image) {
        this.image = image;
        return this;
    }

    @XmlElement(namespace = "http://www.w3.org/2005/Atom", name = "link")
    public AtomLink getAtomLink() {
        return atomLink;
    }

    public Channel setAtomLink(AtomLink atomLink) {
        this.atomLink = atomLink;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public Owner getOwner() {
        return owner;
    }

    public Channel setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public String getAuthor() {
        return author;
    }

    public Channel setAuthor(String author) {
        this.author = author;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public String getExplicit() {
        return explicit;
    }

    public Channel setExplicit(String explicit) {
        this.explicit = explicit;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd", name = "image")
    public String getItunesImage() {
        return itunesImage;
    }

    public Channel setItunesImage(String itunesImage) {
        this.itunesImage = itunesImage;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public Category getCategory() {
        return category;
    }

    public Channel setCategory(Category category) {
        this.category = category;
        return this;
    }
}