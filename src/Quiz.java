import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Quiz {
    // private String question, answer;
    //private boolean playMode;
    String userInput;
    Map<String, String> state_and_capital;
    private Map<String, String> question_answer;
    private final ArrayList<String> questions;
    private final ArrayList<String> answers;

    public Quiz() {
        question_answer = new LinkedHashMap<>();
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        question_answer = new LinkedHashMap<>();
        state_and_capital = new LinkedHashMap<>();
    }

    public void readXML() {
    }

    public String generateQuestion(final String state) {
        return "What is the captial of " + state + "?";
    }

    public String generateAnswer(final String state, final String capital) {
        return "The capital of " + state + " is " + capital;
    }

    public void checkAnswer(final String answer) {
        if (userInput.equals(answer))
            System.out.println("Correct");
        else
            System.out.println("Incorrect");
    }

    public void generateScore() {
    }

    public void returncorrectAnwers() {
    }

    public String getUserInput() {
        return userInput;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public Map<String, String> getState_and_capital() {
        return state_and_capital;
    }

    public Map<String, String> getQuestion_answer() {
        return question_answer;
    }
}
