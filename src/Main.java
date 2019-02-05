



import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        String user_input = quiz.getUserInput();

        String question = "";
        String answer = "";

        ArrayList<String> states = new ArrayList<>();//all the states

        ArrayList<String> capitals = new ArrayList<>(); // all the capitals

        ArrayList<String> questions = quiz.getQuestions(); // all the questions

        ArrayList<String> answers = quiz.getAnswers(); // all the answers

        Map<String, String> question_answer = quiz.getMap(); //map that has state and capital in a key value pair

        State state1 = new State("Georgia", "Atlanta "); //test states
        State state2 = new State("New york", "New jersey");

        question_answer.put(state1.getName(), state1.getCapital());
        question_answer.put(state2.getName(), state2.getCapital());


        System.out.println("Map out-puted directly");
        System.out.println(question_answer);

        /* Generate game values/ strings  according to map*/

        for ( String key : question_answer.keySet() ) {
            states.add(key);
            capitals.add(question_answer.get(key));
            questions.add(quiz.generateQuestion(key));
            answers.add(quiz.generateAnswer(key, question_answer.get(key)));
        }
        System.out.println("model.User.State out-puted directly");
        System.out.println(states);

        System.out.println("Capitals out-puted directly");
        System.out.println(capitals);

        System.out.println("Questions out-puted directly");
        System.out.println(questions);

        System.out.println("Answers out-puted directly");
        System.out.println(answers);

        System.out.println("Testing just one question");
        System.out.println(questions.get(0));
        System.out.println(answers.get(0));

        System.out.println("Testing second question");
        System.out.println(questions.get(1));
        System.out.println(answers.get(1));



    }
}
