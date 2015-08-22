package org.semper.reformanda.syndication.rss;

import org.custommonkey.xmlunit.NamespaceContext;
import org.custommonkey.xmlunit.SimpleNamespaceContext;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.XpathEngine;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Collections;

public class XmlUtils {

    public static XpathEngine getXpathEngine() {
        final NamespaceContext context = new SimpleNamespaceContext(Collections.singletonMap("itunes", "http://www.itunes.com/dtds/podcast-1.0.dtd"));
        final XpathEngine engine = XMLUnit.newXpathEngine();
        engine.setNamespaceContext(context);
        return engine;
    }

    public static Document getDocument(final Object objectToMarshal) throws JAXBException, ParserConfigurationException {
        final JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        // TODO add logging here - would be nice to see what's happening...
        jaxbMarshaller.marshal(objectToMarshal, document);
        return document;
    }
}