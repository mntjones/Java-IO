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
            NodeList nodeList = doc.getElementsByTagName("datastream");

            //nodelist is not iterable - use for loop to read file - print out contents
            for(int i=0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nNode name: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Source: " + element.getElementsByTagName("source").item(0).getTextContent());
                    System.out.println("Id: " + element.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("Timestamp: " + element.getElementsByTagName("timestamp").item(0).getTextContent());
                    if (parseInt(element.getElementsByTagName("min").item(0).getTextContent()) < 10) {
                        System.out.println("\tMIN IS BELOW 10");
                        System.out.println("\t\tMin: " + element.getElementsByTagName("min").item(0).getTextContent());
                    }
                    else {
                        System.out.println("Min: " + element.getElementsByTagName("min").item(0).getTextContent());
                    }
                    if (parseInt(element.getElementsByTagName("max").item(0).getTextContent()) > 50) {
                        System.out.println("\tMAX IS GREATER THAN 50");
                        System.out.println("\t\tMax: " + element.getElementsByTagName("max").item(0).getTextContent());
                    }
                    else {
                        System.out.println("Max: " + element.getElementsByTagName("max").item(0).getTextContent());
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
