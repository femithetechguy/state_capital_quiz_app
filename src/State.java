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
    private ArrayList expressions;

    public State() {
    }

    public State(final String name, final String capital) {
        this.expressions = new ArrayList();
    }



    public ArrayList<String> getAllExpressionInstance(final String expression) throws Exception { //get any item you want from the xml file by specifying the head tag name for that item.
        expressions = new ArrayList();
        final XPath xpath = XPathFactory.newInstance().newXPath();
        final File file = new File("state_capital.xml");
        final FileInputStream stream = new FileInputStream(file);
        final InputSource source = new InputSource(stream);
        final XPathExpression expression_expr = xpath.compile(expression); // expression
        final NodeList expressionList = (NodeList) expression_expr.evaluate(source, XPathConstants.NODESET);
        for (int i = 0; i < expressionList.getLength(); i++) {
            final String retrievedExpression = expressionList.item(i).getTextContent();
            this.expressions.add(retrievedExpression);
        }
        return this.expressions;
    }
}
