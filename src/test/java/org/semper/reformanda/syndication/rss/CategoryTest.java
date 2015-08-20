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
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

        final Document document = getDocument();
        final XpathEngine engine = getXpathEngine();

        NodeList matchingNodes = engine.getMatchingNodes(String.format("/rss/channel/itunes:category[@text='%s']", categoryName), document);
        assertEquals("Could not find itunes category attribute", 1, matchingNodes.getLength());
    }

    @Test
    public void shouldNextSubcategoriesAsElementsUnderParentCategory() throws Exception {
        final Category category = new Category();
        category.setText(ItunesCategory.Business.value());
        final Category subCategory = new Category();
        subCategory.setText(ItunesCategory.Business.careers);
        category.getSubcategories().add(subCategory);
        rss.getChannel().setCategory(category);

        final Document document = getDocument();
        final XpathEngine engine = getXpathEngine();

        final String subcategoryXpath = String.format("/rss/channel/itunes:category[@text='%s']/itunes:category[@text='%s']", ItunesCategory.Business.value(), ItunesCategory.Business.careers);
        NodeList matchingNodes = engine.getMatchingNodes(subcategoryXpath, document);
        assertEquals("Could not find itunes subcategory attribute", 1, matchingNodes.getLength());
    }

    private XpathEngine getXpathEngine() {
        final NamespaceContext context = new SimpleNamespaceContext(Collections.singletonMap("itunes", "http://www.itunes.com/dtds/podcast-1.0.dtd"));
        final XpathEngine engine = XMLUnit.newXpathEngine();
        engine.setNamespaceContext(context);
        return engine;
    }

    private Document getDocument() throws JAXBException, ParserConfigurationException {
        final JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        jaxbMarshaller.marshal(rss, document);
        return document;
    }
}