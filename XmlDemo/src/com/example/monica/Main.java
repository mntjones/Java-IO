package com.example.monica;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException,
            ParserConfigurationException, TransformerException, SAXException {
        // write your code here

        File file = new File("src/TelemetryData.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        Node n = doc.getFirstChild();
        NodeList nl = n.getChildNodes();
        Node an, an2;

        for (int i = 0; i < nl.getLength(); i++) {

            an = nl.item(i);

            if (an.getNodeType() == Node.ELEMENT_NODE) {
                NodeList nl2 = an.getChildNodes();

                for (int i2 = 0; i2 < nl2.getLength(); i2++) {
                    an2 = nl2.item(i2);

                    System.out.println("Node type: " + an2.getNodeName() + " text content: " + an2.getTextContent());

                    if (an2.hasChildNodes()) {
                        System.out.println(an2.getFirstChild().getNodeValue() + " : " +an2.getFirstChild().getTextContent());
                    }
                }
            }
        }
    }
}
