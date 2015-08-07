package org.semper.reformanda.syndication.rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Objects;
import java.util.Optional;

@XmlRootElement
public class Rss {

    // TODO see if JAXB hates setters returning "this"

    public static Optional<Rss> fromXmlStream(final InputStream inputStream) {
        if (Objects.isNull(inputStream)) {
            return Optional.empty();
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return Optional.of((Rss) jaxbUnmarshaller.unmarshal(inputStream));
        } catch (JAXBException e) {
            // TODO not sure I want to put logging in this library - perhaps slf4j or commons if I need to...
        }

        return Optional.empty();
    }

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    @XmlElement
    public Rss setChannel(Channel channel) {
        this.channel = channel;
        return this;
    }

    @XmlAttribute
    public String getVersion() {
        return "2.0";
    }
}