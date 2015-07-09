package org.semper.reformanda.syndication.rss.atom;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace="http://www.w3.org/2005/Atom")
public class AtomLink {

    // TODO this is Stringly-typed.  Should go back and make links URLs, enumerate types, etc.
    private String href;
    private String rel;
    private String type;

    public String getHref() {
        return href;
    }

    @XmlAttribute
    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    @XmlAttribute
    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }
}