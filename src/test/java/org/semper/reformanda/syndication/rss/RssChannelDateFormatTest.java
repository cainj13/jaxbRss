package org.semper.reformanda.syndication.rss;

import org.custommonkey.xmlunit.XpathEngine;
import org.junit.Before;
import org.junit.Test;
import org.semper.reformanda.syndication.util.Rfc822DateFormatAdapter;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class RssChannelDateFormatTest {

    private Rss rss;
    public final Long DATE_MILLINIUM = 946702800000L;

    @Before
    public void setUp() {
        rss = new Rss();

        final Channel channel = new Channel();
        rss.setChannel(channel);
    }

    @Test
    public void shouldRenderPubDateAsRfc822Format() throws Exception {
        rss.getChannel().setPubDate(new Date(DATE_MILLINIUM));

        final Document document = XmlUtils.getDocument(rss);
        final XpathEngine engine = XmlUtils.getXpathEngine();

        NodeList matchingNodes = engine.getMatchingNodes("/rss/channel/pubDate", document);
        assertEquals(matchingNodes.item(0).getTextContent(), "Sat, 01 Jan 2000 00:00:00 -0500");
    }

    @Test
    public void shouldRenderBuildDateAsRfc822Format() throws Exception {
        rss.getChannel().setLastBuildDate(new Date(DATE_MILLINIUM));

        final Document document = XmlUtils.getDocument(rss);
        final XpathEngine engine = XmlUtils.getXpathEngine();

        NodeList matchingNodes = engine.getMatchingNodes("/rss/channel/lastBuildDate", document);
        assertEquals(matchingNodes.item(0).getTextContent(), "Sat, 01 Jan 2000 00:00:00 -0500");
    }
}