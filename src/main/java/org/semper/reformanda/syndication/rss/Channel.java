package org.semper.reformanda.syndication.rss;

import org.semper.reformanda.syndication.rss.atom.AtomLink;
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
    private String category; // TODO sub-cats

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Date getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(Date lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getWebMaster() {
        return webMaster;
    }

    public void setWebMaster(String webMaster) {
        this.webMaster = webMaster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlElement(namespace = "http://www.w3.org/2005/Atom", name = "link")
    public AtomLink getAtomLink() {
        return atomLink;
    }

    public void setAtomLink(AtomLink atomLink) {
        this.atomLink = atomLink;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public String getExplicit() {
        return explicit;
    }

    public void setExplicit(String explicit) {
        this.explicit = explicit;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd", name = "image")
    public String getItunesImage() {
        return itunesImage;
    }

    public void setItunesImage(String itunesImage) {
        this.itunesImage = itunesImage;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}