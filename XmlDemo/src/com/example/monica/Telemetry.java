package com.example.monica;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;

public class Telemetry {

    public static void main(String[] args) {
        try {
            // creates a constructor of file class and parsing XML file
            File file = new File("src/TelemetryData.xml");

            // an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            // an instance of builder to parse the specified xml file
            DocumentBuilder db = null;
            try {
                db = dbf.newDocumentBuilder();
            } catch (ParserConfigurationException parserConfigurationException) {
                parserConfigurationException.printStackTrace();
            }

            Document doc = null;
            try {
                doc = db.parse(file);
            } catch (SAXException saxException) {
                saxException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("*");

            //nodelist is not iterable - use for loop to read file - print out contents
            for(int i=0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // THIS WORKS
                    System.out.println(node.getNodeName() + " : " + node.getChildNodes().item(0).getNodeValue());

                    // BAD check works
//                    if (node.getChildNodes().item(0).getNodeValue().contains("bad")) {
//                        System.out.println("!!!!!!!!!BAD FILES!!!!!!!!!!");
//                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
