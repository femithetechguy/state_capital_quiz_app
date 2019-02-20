import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        State st = new State();
       // String user_input = quiz.getUserInput();
        String question = "";
        String answer = "";
        Random rand = new Random();
        int random;
        ArrayList<String> states = new ArrayList<>();//all the states
        ArrayList<String> capitals = new ArrayList<>(); // all the capitals
        ArrayList<String> questions;//all the questions
        ArrayList<String> answers; // all the answers
        Map<String, String> state_and_capital;
        Map<String, String> question_and_answer;
        try {
            states = st.getAllExpressionInstance("//state");//store all states
            capitals = st.getAllExpressionInstance("//capital");// store all capitals
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("New state: " + states);
        System.out.println("New capitals: " + capitals);
        questions = quiz.getQuestions(); // all the questions
        answers = quiz.getAnswers(); // all the answers
        state_and_capital = quiz.getState_and_capital(); //map that has state and capital in a key value pair
        question_and_answer = quiz.getQuestion_answer(); //map that has state and capital in a key value pair
        //check size of both array before creating a map
        int stateSize = states.size();
        int capitalSize = capitals.size();
        int questionSize = 0;
        if (stateSize == capitalSize)
            questionSize = stateSize = capitalSize; // make sure the sized are same for stae, capital and the question generated from them
        else
            questionSize = 0;
        for (int i = 0; i < questionSize; i++) {
            state_and_capital.put(states.get(i), capitals.get(i));
        }
        for (int i = 0; i < questionSize; i++) {
            state_and_capital.put(states.get(i), capitals.get(i));
        }
        //print the new map to see if all states and capitals have been well mapped.
        System.out.println("State and Captial map");
        for (Map.Entry entry : state_and_capital.entrySet()) {
            //  System.out.println("State: " + entry.getKey() + "|| Capital: " + entry.getValue());
        }
        System.out.println("State size: " + states.size());
        System.out.println("Capital size: " + capitals.size());
        //add all states and capitals into question
        for (int i = 0; i < questionSize; i++) {
            question = quiz.generateQuestion(states, capitals, i);
            //System.out.println(question);
            // answer = quiz.generateAnswer();
            question_and_answer.put(question, answer);
        }
        System.out.println("Questions and Answers");
        for (Map.Entry entry : question_and_answer.entrySet()) {
            //   System.out.println("Question: " + entry.getKey() + "\nAnswer: " + entry.getValue());
        }
        System.out.println("Question size: " + states.size());
        System.out.println("Answer size: " + capitals.size());
        ArrayList<ArrayList<String>> qa = new ArrayList<>();
        // answers = quiz.getContentOfMap(question_and_answer).get(1);
        for (int i = 0; i < 50; i++) {
            int count = i++;
            questions.add(quiz.generateQuestion(states, capitals, count));
            System.out.println("Question No. " + count);

            //System.out.println(quiz.generateQuestion(states, capitals, i));
            System.out.println(questions.get(i));
            System.out.println("Answer for question No. " + count);
            System.out.println(quiz.generateAnswer());
        }
        //  System.out.println(answer);
        //System.out.println(quiz.getState());
        // System.out.println(quiz.getState());
    }
}
