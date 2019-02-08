import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        String user_input = quiz.getUserInput();

        String question = "";
        String answer = "";
        Random rand = new Random();
        State st = new State();

        int random;

        ArrayList<String> states = new ArrayList<>();//all the states
        ArrayList<String> capitals = new ArrayList<>(); // all the capitals


        try {
            states = st.getAllExpressionInstance("//state");//store all states
            capitals = st.getAllExpressionInstance("//capital");// store all capitals

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("New state: " + states);
        System.out.println("New capitals: " + capitals);

        ArrayList<String> questions = quiz.getQuestions(); // all the questions

        ArrayList<String> answers = quiz.getAnswers(); // all the answers

        Map<String, String> question_answer = quiz.getMap(); //map that has state and capital in a key value pair
        //check size of both array before creating a map

        int stateSize = states.size();
        int capitalSize = capitals.size();
        int questionSize = 0;
        if (stateSize == capitalSize)
            questionSize = stateSize = capitalSize; // make sure the sized are same for stae, capital and the question generated from them

        for (int i =0; i < questionSize; i++){
            question_answer.put(states.get(i), capitals.get(i));
        }
        //print the new map to see if all states and capitals have been well mapped.

        System.out.println("State and Captial map");
        for (Map.Entry entry : question_answer.entrySet())
        {
            System.out.println("State: " + entry.getKey() + "|| Capital: " + entry.getValue());
        }

    }
}
