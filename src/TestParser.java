import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;

public class TestParser {
    public static void main(String[] args) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        File file = new File("state_capital.xml");
        FileInputStream stream = new FileInputStream(file);
        InputSource source = new InputSource(stream);
        // grab all states from XML file, we are using XPath expressions  //state for state tags
        // https://blog.scrapinghub.com/2016/10/27/an-introduction-to-xpath-with-examples
        XPathExpression expr = xpath.compile("//capital");
        NodeList list = (NodeList) expr.evaluate(source, XPathConstants.NODESET);
        // print out name of each state
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.println(node.getTextContent());
        }
    }
}
