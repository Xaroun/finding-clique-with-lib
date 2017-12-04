package parser;

import model.Edge;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateusz on 04.12.2017.
 */
public class GraphParser {

    private Document document;

    public GraphParser(String path) {
        this.document = getXMLDocumentFromFile(path);
    }

    private Document getXMLDocumentFromFile(String path) {
        File file = new File(path);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();

        DocumentBuilder documentBuilder = null;
        Document document = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public void getGraph() {
        List<String> nodes = fetchNodesFromDocument();
        List<Edge> edges = fetchEdgesFromDocument();

//        nodes.stream().forEach(node -> graph.addVertex(node));
//        edges.stream().forEach(edge -> {
//            DefaultWeightedEdge defaultEdge = graph.addEdge(edge.getFrom(), edge.getTo());
//            graph.setEdgeWeight(defaultEdge, edge.getWeight());
//        });

    }

    private List<String> fetchNodesFromDocument() {
        List<String> nodes = new ArrayList<>();
        for (int i = 0; i < document.getElementsByTagName("node").getLength(); i++) {
            nodes.add(document.getElementsByTagName("node").item(i).getTextContent());
        }
        return nodes;
    }

    private List<Edge> fetchEdgesFromDocument() {
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < document.getElementsByTagName("edge").getLength(); i++) {
            String edgeFrom = document.getElementsByTagName("edge").item(i).getAttributes().getNamedItem("from").getTextContent();
            String edgeTo = document.getElementsByTagName("edge").item(i).getAttributes().getNamedItem("to").getTextContent();
            int weight = Integer.parseInt(document.getElementsByTagName("edge").item(i).getFirstChild().getNextSibling().getTextContent());

            edges.add(new Edge(edgeTo, edgeFrom, weight));
        }
        return edges;
    }

}