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
            states = st.getAllStates();
            capitals = st.getAllCapitals();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("New state: " + states.toString());
        System.out.println("New capitals: " + capitals.toString());

        ArrayList<String> questions = quiz.getQuestions(); // all the questions

        ArrayList<String> answers = quiz.getAnswers(); // all the answers

        Map<String, String> question_answer = quiz.getMap(); //map that has state and capital in a key value pair




    }
}
