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

import org.semper.reformanda.syndication.rss.itunes.BlockValue;
import org.semper.reformanda.syndication.rss.itunes.ItunesImage;
import org.semper.reformanda.syndication.util.BlockValueTypeAdapter;
import org.semper.reformanda.syndication.util.Rfc822DateFormatAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.net.URL;
import java.util.Date;

public class Item {

    private URL guid;
    private String title;
    private String description;
    private Date pubDate;
    private Enclosure enclosure;

    // iTunes
    private String author;
    private String subtitle;
    private String summary;
    private ItunesImage image;
    // TODO use something like a Duration object for this...
    private String duration;
    private BlockValue block;

    public URL getGuid() {
        return guid;
    }

    public Item setGuid(URL guid) {
        this.guid = guid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Item setTitle(final String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(final String description) {
        this.description = description;
        return this;
    }

    @XmlJavaTypeAdapter(Rfc822DateFormatAdapter.class)
    public Date getPubDate() {
        return pubDate;
    }

    public Item setPubDate(final Date pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public Item  setEnclosure(final Enclosure enclosure) {
        this.enclosure = enclosure;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public String getAuthor() {
        return author;
    }

    public Item setAuthor(String author) {
        this.author = author;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public String getSubtitle() {
        return subtitle;
    }

    public Item setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public String getSummary() {
        return summary;
    }

    public Item setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public ItunesImage getImage() {
        return image;
    }

    public Item setImage(ItunesImage image) {
        this.image = image;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    public String getDuration() {
        return duration;
    }

    public Item setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    @XmlElement(namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    @XmlJavaTypeAdapter(BlockValueTypeAdapter.class)
    public BlockValue getBlock() {
        return block;
    }

    public Item setBlock(final BlockValue block) {
        this.block = block;
        return this;
    }
}