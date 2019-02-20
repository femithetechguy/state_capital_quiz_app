import org.junit.Before;
import org.junit.BeforeClass;

public class StateQuizTester {
    @BeforeClass
    public static void startUp(){
        System.out.println("Testing Quiz app.");
    }

    @Before
    public  void setUp(){
        State state = new State();
        Quiz quiz =  new Quiz();

    }




    //@AfterClass

    //@After
}
