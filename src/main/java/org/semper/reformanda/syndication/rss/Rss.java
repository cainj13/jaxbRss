package org.semper.reformanda.syndication.rss;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rss {

    // TODO see if JAXB hates setters returning "this"

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    @XmlElement
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @XmlAttribute
    public String getVersion() {
        return "2.0";
    }
}