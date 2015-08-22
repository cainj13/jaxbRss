package org.semper.reformanda.syndication.rss.itunes;

import org.custommonkey.xmlunit.XpathEngine;
import org.junit.Before;
import org.junit.Test;
import org.semper.reformanda.syndication.rss.Channel;
import org.semper.reformanda.syndication.rss.Rss;
import org.semper.reformanda.syndication.rss.XmlUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import static org.junit.Assert.assertEquals;

public class ItunesImageTest {

    private Rss rss;

    @Before
    public void setUp() {
        rss = new Rss();

        final Channel channel = new Channel();
        rss.setChannel(channel);
    }

    @Test
    public void shouldRenderItunesImageHrefAsAttribute() throws Exception {
        final String imageUrl = "http://www.example.com/images/logo.png";
        final ItunesImage itunesImage = new ItunesImage().setHref(imageUrl);
        rss.getChannel().setItunesImage(itunesImage);

        final Document document = XmlUtils.getDocument(rss);
        final XpathEngine engine = XmlUtils.getXpathEngine();

        final String subcategoryXpath = String.format("/rss/channel/itunes:image[@href='%s']", imageUrl);
        NodeList matchingNodes = engine.getMatchingNodes(subcategoryXpath, document);
        assertEquals("Could not find itunes image href attribute", 1, matchingNodes.getLength());
    }
}