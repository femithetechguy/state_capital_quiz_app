import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class State {
    private String name;
    private String capital;

   private ArrayList<String> states;
   private ArrayList<String> capitals;

   public State(){

   }

    public State(String name, String capital) {
        this.name = name;
        this.capital = capital;
        states = new ArrayList();
        capitals = new ArrayList();


    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(final String capital) {
        this.capital = capital;
    }

    public ArrayList<String> getAllStates() throws Exception {
        states = new ArrayList();

        XPath xpath = XPathFactory.newInstance().newXPath();
        final File file = new File("state_capital.xml");
        FileInputStream stream = new FileInputStream(file);
        InputSource source = new InputSource(stream);
        // grab all states from XML FILE, we are using XPath expressions  //state for state tags
        // https://blog.scrapinghub.com/2016/10/27/an-introduction-to-xpath-with-examples
        XPathExpression state_expr = xpath.compile("//state"); // state

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
        return states;

    }

    public ArrayList<String> getAllCapitals() throws Exception {
        capitals = new ArrayList();

        XPath xpath = XPathFactory.newInstance().newXPath();
        final File file = new File("state_capital.xml");
        FileInputStream stream = new FileInputStream(file);
        InputSource source = new InputSource(stream);
        // grab all capitals from XML FILE, we are using XPath expressions  //capital for capital tags
        // https://blog.scrapinghub.com/2016/10/27/an-introduction-to-xpath-with-examples
        XPathExpression capital_expr = xpath.compile("//capital"); // capital

        NodeList capitalList = (NodeList) capital_expr.evaluate(source, XPathConstants.NODESET);
        //NodeList capitalList = (NodeList) capital_expr.evaluate(source, XPathConstants.NODESET);
        // print out name of each capital
        for (int i = 0; i < capitalList.getLength(); i++) {
            String capital = capitalList.item(i).getTextContent();
            capitals.add(capital);
            //Node node = capitalList.item(i);
            // capitals.add(capitalList.item(i).toString());
            //capitals = (ArrayList<String>) node;
            //System.out.println(node.getTextContent());
        }
        return capitals;

    }

}
