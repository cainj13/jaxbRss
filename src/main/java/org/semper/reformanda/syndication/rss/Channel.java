/**
 * Copyright 2015 Joshua Cain
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.semper.reformanda.syndication.rss;

import org.semper.reformanda.syndication.rss.atom.AtomLink;
import org.semper.reformanda.syndication.rss.itunes.Category;
import org.semper.reformanda.syndication.rss.itunes.Explicit;
import org.semper.reformanda.syndication.rss.itunes.ItunesImage;
import org.semper.reformanda.syndication.rss.itunes.Owner;
import org.semper.reformanda.syndication.util.BlockValueTypeAdapter;
import org.semper.reformanda.syndication.util.ExplicityTypeAdapter;
import org.semper.reformanda.syndication.util.Rfc822DateFormatAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(propOrder = {"title", "link", "atomLink", "pubDate", "lastBuildDate", "ttl", "language", "copyright", "webMaster",
    "description", "image", "owner", "author", "explicit", "itunesImage", "category", "items"})
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
    private Image image;

    // Atom Fields
    private AtomLink atomLink;

    // iTunes Fields
    private Owner owner;
    private String author;
    private Explicit explicit;
    private ItunesImage itunesImage; // TODO URI?
    private Category category; // TODO sub-cats

    private List<Item> items;

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

    @XmlJavaTypeAdapter(Rfc822DateFormatAdapter.class)
    public Date getPubDate() {
        return pubDate;
    }

    public Channel setPubDate(Date pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    @XmlJavaTypeAdapter(Rfc822DateFormatAdapter.class)
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

    public Image getImage() {
        return image;
    }

    public Channel setImage(final Image image) {
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
    @XmlJavaTypeAdapter(ExplicityTypeAdapter.class)
    public Explicit getExplicit() {
        return explicit;
    }

    public Channel setExplicit(Explicit explicit) {
        this.explicit = explicit;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd", name = "image")
    public ItunesImage getItunesImage() {
        return itunesImage;
    }

    public Channel setItunesImage(ItunesImage itunesImage) {
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

    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}