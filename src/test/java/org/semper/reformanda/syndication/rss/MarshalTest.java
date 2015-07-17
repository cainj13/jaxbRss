package org.semper.reformanda.syndication.rss;

import org.junit.Test;
import org.semper.reformanda.syndication.rss.atom.AtomLink;
import org.semper.reformanda.syndication.rss.itunes.Owner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.util.Date;

public class MarshalTest {

    @Test
    public void marshalStuff() throws Exception {
        final Channel channel = new Channel();
        channel.setTitle("My title!");
        channel.setLink("http://www.gracecommunitybaptist.org");
        channel.setPubDate(new Date());
        channel.setLastBuildDate(new Date());
        channel.setTtl(60);
        channel.setLanguage("en");
        channel.setCopyright("All Rights Reserved");
        channel.setWebMaster("mail@graceCommunityBaptist.org");
        channel.setDescription("This is a podcast!");
        channel.setImage("http://BLAHIMAGE");

        final AtomLink atomLink = new AtomLink();
        atomLink.setHref("http://www.google.com");
        atomLink.setRel("self");
        atomLink.setType("application/xml");
        channel.setAtomLink(atomLink);

        final Owner owner = new Owner();
        owner.setName("Grace Community Baptist");
        owner.setEmail("mail-owner@gcgc.org");
        channel.setOwner(owner);
        channel.setAuthor("Authoer Name");
        channel.setExplicit("no");
        channel.setItunesImage("IMAGEURL");
        channel.setCategory("Business");

        final Rss rss = new Rss();
        rss.setChannel(channel);
        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(rss, System.out);
    }
}