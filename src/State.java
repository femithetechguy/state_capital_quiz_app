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
    private String capital;final File FILE = new File("state_capital.xml");
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
        XPath xpath = XPathFactory.newInstance().newXPath();

        FileInputStream stream = new FileInputStream(FILE);
        InputSource source = new InputSource(stream);
        XPathExpression state_expr = xpath.compile("//state"); // state
        NodeList stateList = (NodeList) state_expr.evaluate(source, XPathConstants.NODESET);
        for (int i = 0; i < stateList.getLength(); i++) {
            String state = stateList.item(i).getTextContent();
            states.add(state);
        }
        return states;

    }

}
