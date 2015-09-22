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

import org.custommonkey.xmlunit.XpathEngine;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.Date;

import static org.junit.Assert.assertTrue;

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
        assertTrue(matchingNodes.item(0).getTextContent().startsWith("Sat, 01 Jan 2000"));
    }

    @Test
    public void shouldRenderBuildDateAsRfc822Format() throws Exception {
        rss.getChannel().setLastBuildDate(new Date(DATE_MILLINIUM));

        final Document document = XmlUtils.getDocument(rss);
        final XpathEngine engine = XmlUtils.getXpathEngine();

        NodeList matchingNodes = engine.getMatchingNodes("/rss/channel/lastBuildDate", document);
        assertTrue(matchingNodes.item(0).getTextContent().startsWith("Sat, 01 Jan 2000"));
    }
}