package org.semper.reformanda.syndication.rss.itunes;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by jcain on 8/22/15.
 */
public class ItunesImage {

    private String href;

    @XmlAttribute
    public String getHref() {
        return href;
    }

    public ItunesImage setHref(String href) {
        this.href = href;
        return this;
    }
}