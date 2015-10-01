/**
 * Copyright 2015 Joshua Cain
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.semper.reformanda.syndication.rss;

import org.junit.Test;
import org.semper.reformanda.syndication.rss.atom.AtomLink;
import org.semper.reformanda.syndication.rss.itunes.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

public class PrintFullRssFeedTest {

    private static final Date currentDate = new Date();

    @Test
    public void demonstrateFullRssFeed() throws Exception {
        final Channel channel = new Channel();
        channel.setTitle("Test Podcast");
        channel.setLink("http://www.theTestPodcast.com");
        channel.setPubDate(currentDate);
        channel.setLastBuildDate(currentDate);
        channel.setTtl(60);
        channel.setLanguage("en");
        channel.setCopyright("All Rights Reserved");
        channel.setWebMaster("mail@theTestPodcast.com (podcast mail)");
        channel.setDescription("This is a test block of text, meant to give a more verbose description of what the podcast is about.");

        Image image = new Image()
                .setUrl("http://www.theTestPodcast.com/images/testlogo.png")
                .setTitle("The Test Podcast Logo")
                .setLink("http://www.theTestPodcast.com");
        channel.setImage(image);

        final AtomLink atomLink = new AtomLink();
        atomLink.setHref("http://www.theTestPodcast.com/rss");
        atomLink.setRel("self");
        atomLink.setType(MimeType.APPLICATION_XML_RSS);
        channel.setAtomLink(atomLink);

        final Owner owner = new Owner();
        owner.setName("Test Podcast Owner");
        owner.setEmail("mail@theTestPodcast.com");
        channel.setOwner(owner);
        channel.setAuthor("Test Podcast Author");
        channel.setExplicit("no");
        // TODO should be an attribute, rather than element text
        ItunesImage itunesImage = new ItunesImage().setHref("http://www.theTestPodcast.com/images/testlogo.png");
        channel.setItunesImage(itunesImage);

        final Category category = new Category();
        final Category subcat1 = new Category();
        subcat1.setText(ItunesCategory.Business.careers);
        category.getSubcategories().add(subcat1);
        final Category subcat2 = new Category();
        subcat2.setText(ItunesCategory.Business.managementAndMarketing);
        category.getSubcategories().add(subcat2);
        category.setText(ItunesCategory.Business.value());
        channel.setCategory(category); // TODO enumerate types

        final Item item = new Item()
                .setGuid(new URL("http://www.theTestPodcast.com/epidosdes/1"))
                .setPubDate(new Date())
                .setTitle("Episode One")
                .setDescription("The One That Made You Wish You Never Liked Start Wars in the First Place")
                .setAuthor("Test Podcast Author")
                .setSubtitle("The One That Made You Wish You Never Liked Start Wars in the First Place")
                .setSummary("We talk about Episode One, and how they should have just stopped after the sound")
                .setDuration("5:30")
                .setEnclosure(new Enclosure()
                        .setLength(1000 * 60 * 30)
                        .setType(MimeType.AUDIO_MPEG_MPG)
                        .setUrl(new URI("http://www.theTestPodcast.com/episodes/1")));
        final ItunesImage itemImage = new ItunesImage().setHref("http://www.theTestPodcast.com/images/episode1.png");
        item.setImage(itemImage);
        channel.setItems(new ArrayList<Item>(Collections.singletonList(item)));

        final Item blockedItem = new Item()
                .setGuid(new URL("http://www.theTestPodcast.com/epidosdes/2"))
                .setPubDate(new Date())
                .setTitle("Inappropriate Episode")
                .setDescription("Contains bad content, should be excluded from iTunes stream")
                .setAuthor("Test Podcast Author")
                .setSubtitle("It's a dirty one - about a white horse that falls in the mud.")
                .setSummary("Mud, lots of mud.")
                .setDuration("10:22")
                .setBlock(BlockValue.YES);
        channel.getItems().add(blockedItem);

        final Rss rss = new Rss();
        rss.setChannel(channel);
        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(rss, System.out);
    }
}