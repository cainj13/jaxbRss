package org.semper.reformanda.syndication.rss;

import org.junit.Test;
import org.semper.reformanda.syndication.rss.atom.AtomLink;
import org.semper.reformanda.syndication.rss.itunes.Category;
import org.semper.reformanda.syndication.rss.itunes.ItunesCategory;
import org.semper.reformanda.syndication.rss.itunes.Owner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.util.Date;

public class MarshalTest {

    private static final Date currentDate = new Date();

    @Test
    public void marshalStuff() throws Exception {
        final Channel channel = new Channel();
        channel.setTitle("Test Podcast");
        channel.setLink("http://www.theTestPodcast.com");
        channel.setPubDate(currentDate);
        channel.setLastBuildDate(currentDate);
        channel.setTtl(60);
        channel.setLanguage("en");
        channel.setCopyright("All Rights Reserved");
        channel.setWebMaster("mail@theTestPodcast.com");
        channel.setDescription("This is a test block of text, meant to give a more verbose description of what the podcast is about.");

        Image image = new Image()
                .setUrl("http://www.theTestPodcast.com/images/testlogo.png")
                .setTitle("The Test Podcast Logo")
                .setLink("http://www.theTestPodcast.com");
        channel.setImage(image);

        final AtomLink atomLink = new AtomLink();
        atomLink.setHref("http://www.theTestPodcast.com/rss");
        atomLink.setRel("self");
        atomLink.setType("application/xml");
        channel.setAtomLink(atomLink);

        final Owner owner = new Owner();
        owner.setName("Test Podcast Owner");
        owner.setEmail("mail@theTestPodcast.com");
        channel.setOwner(owner);
        channel.setAuthor("Test Podcast Author");
        channel.setExplicit("no");
        // TODO should be an attribute, rather than element text
        channel.setItunesImage("http://www.theTestPodcast.com/images/testlogo.png");

        final Category category = new Category();
        final Category subcat1 = new Category();
        subcat1.setText(ItunesCategory.Business.careers);
        category.getSubcategories().add(subcat1);
        final Category subcat2 = new Category();
        subcat2.setText(ItunesCategory.Business.managementAndMarketing);
        category.getSubcategories().add(subcat2);
        category.setText(ItunesCategory.Business.value());
        channel.setCategory(category); // TODO enumerate types

        final Rss rss = new Rss();
        rss.setChannel(channel);
        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(rss, System.out);
    }
}