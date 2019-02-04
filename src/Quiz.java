import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Quiz {
   // private String question, answer;
    //private boolean playMode;
    String userInput;
    private Map<String, String> question_answer;
    private ArrayList<String> questions;
    private ArrayList<String> answers;



    public Quiz() {

        this.question_answer = new LinkedHashMap<>();
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
    }

    public void readXML(){

    }
    public String generateQuestion(String state){
        return "What is the captial of " + state + "?";

    }
    public String generateAnswer(String q, String a){
        return "The capital of " + q + " is " + a ;

    }

    public void checkAnswer(String answer){
        if (this.userInput.equals(answer))
            System.out.println("Correct");
        else
            System.out.println("Incorrect");

    }
    public void generateScore(){

    }
    public void returncorrectAnwers(){

    }

    public String getUserInput() {
        return this.userInput;
    }

    public Map getMap() {
        return this.question_answer;
    }

    public ArrayList<String> getQuestions() {
        return this.questions;
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }
}
