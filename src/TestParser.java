import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class TestParser {
    public static void main(String[] args) throws Exception {
        ArrayList<String> states = new ArrayList();
            ArrayList<String> capitals = new ArrayList();
            XPath xpath = XPathFactory.newInstance().newXPath();
            File file = new File("state_capital.xml");
            FileInputStream stream = new FileInputStream(file);
            InputSource source = new InputSource(stream);
            // grab all states from XML FILE, we are using XPath expressions  //state for state tags
            // https://blog.scrapinghub.com/2016/10/27/an-introduction-to-xpath-with-examples
            XPathExpression state_expr = xpath.compile("//state"); // state
            XPathExpression capital_expr = xpath.compile("//capital"); // capital
            NodeList stateList = (NodeList) state_expr.evaluate(source, XPathConstants.NODESET);
            //NodeList capitalList = (NodeList) capital_expr.evaluate(source, XPathConstants.NODESET);
            // print out name of each state
            for (int i = 0; i < stateList.getLength(); i++) {
                String state = stateList.item(i).getTextContent();
                states.add(state);
             //Node node = stateList.item(i);
           // states.add(stateList.item(i).toString());
            //states = (ArrayList<String>) node;
            //System.out.println(node.getTextContent());

        }
        System.out.println(states + "\n");

    }
}
