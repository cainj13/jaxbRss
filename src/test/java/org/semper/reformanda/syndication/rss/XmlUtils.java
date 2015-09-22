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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class XmlUtils {
    private static final Logger log = LogManager.getLogger(XmlUtils.class);

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
        jaxbMarshaller.marshal(objectToMarshal, document);

        return document;
    }

    public static void printDocument(final Document doc) throws IOException, TransformerException {
        final Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        transformer.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(outputStream, "UTF-8")));
        log.debug(outputStream);
    }
}