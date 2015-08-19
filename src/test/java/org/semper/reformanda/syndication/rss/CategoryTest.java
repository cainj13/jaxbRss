package org.semper.reformanda.syndication.rss;

import org.custommonkey.xmlunit.NamespaceContext;
import org.custommonkey.xmlunit.SimpleNamespaceContext;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.XpathEngine;
import org.junit.Before;
import org.junit.Test;
import org.semper.reformanda.syndication.rss.itunes.Category;
import org.semper.reformanda.syndication.rss.itunes.ItunesCategory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    private Rss rss;

    @Before
    public void setUp() {
        rss = new Rss();

        final Channel channel = new Channel();
        rss.setChannel(channel);
    }

    @Test
    public void shouldIncludeCategoryTextAsXmlAttribute() throws Exception {
        final String categoryName = ItunesCategory.Business.value();
        final Category category = new Category();
        category.setText(categoryName);
        rss.getChannel().setCategory(category);

        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        jaxbMarshaller.marshal(rss, document);

        NamespaceContext context = new SimpleNamespaceContext(Collections.singletonMap("itunes", "http://www.itunes.com/dtds/podcast-1.0.dtd"));
        XpathEngine engine = XMLUnit.newXpathEngine();
        engine.setNamespaceContext(context);

        NodeList matchingNodes = engine.getMatchingNodes(String.format("/rss/channel/itunes:category[@text='%s']", categoryName), document);
        assertEquals("Could not find itunes category attribute", 1, matchingNodes.getLength());
    }

    @Test
    public void shouldNextSubcategoriesAsElementsUnderParentCategory() {
        // TODO
    }
}