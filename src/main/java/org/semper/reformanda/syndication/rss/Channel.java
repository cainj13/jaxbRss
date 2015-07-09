package org.semper.reformanda.syndication.rss;

import org.semper.reformanda.syndication.rss.atom.AtomLink;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

public class Channel {

    private String title;
    private String link;
    private Date pubDate;
    private Date lastBuildDate;
    private int ttl;
    private String language;
    private String copyright;
    private String webMaster;
    private String description;

    private AtomLink atomLink;

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    @XmlElement
    public void setLink(String link) {
        this.link = link;
    }

    public Date getPubDate() {
        return pubDate;
    }

    @XmlElement
    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Date getLastBuildDate() {
        return lastBuildDate;
    }

    @XmlElement
    public void setLastBuildDate(Date lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public int getTtl() {
        return ttl;
    }

    @XmlElement
    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getLanguage() {
        return language;
    }

    @XmlElement
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    @XmlElement
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getWebMaster() {
        return webMaster;
    }

    @XmlElement
    public void setWebMaster(String webMaster) {
        this.webMaster = webMaster;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public AtomLink getAtomLink() {
        return atomLink;
    }

    @XmlElement(namespace = "http://www.w3.org/2005/Atom")
    public void setAtomLink(AtomLink atomLink) {
        this.atomLink = atomLink;
    }
}