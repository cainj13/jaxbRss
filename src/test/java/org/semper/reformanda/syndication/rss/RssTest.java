package org.semper.reformanda.syndication.rss;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

public class RssTest {

    @Test
    public void shouldUnmarshalSampleRssFeedFields() throws Exception {
        final Optional<Rss> rss = Rss.fromXmlStream(new FileInputStream("src/test/resources/sampleFeed.xml"));
        assertNotNull(rss);
    }
}