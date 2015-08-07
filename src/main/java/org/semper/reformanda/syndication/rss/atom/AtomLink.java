package org.semper.reformanda.syndication.rss.atom;

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
    public AtomLink setHref(String href) {
        this.href = href;
        return this;
    }

    public String getRel() {
        return rel;
    }

    @XmlAttribute
    public AtomLink setRel(String rel) {
        this.rel = rel;
        return this;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute
    public AtomLink setType(String type) {
        this.type = type;
        return this;
    }
}