import java.util.*;
public class Quiz {
    // private String question, answer;
    //private boolean playMode;
    private String userInput;
    Map<String, String> state_and_capital;
    private Map<String, String> question_answer;
    private  ArrayList<String> questions;
    private final ArrayList<String> answers;
    private String correctAnswer;
    private String state;
    public Quiz() {
        question_answer = new LinkedHashMap<>();
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        question_answer = new LinkedHashMap<>();
        state_and_capital = new LinkedHashMap<>();
        state = "";
        correctAnswer = "";
    }
    public void readXML() {
    }
    public String generateQuestion(ArrayList<String> states, ArrayList<String> capitals, int index) {
        String questionString = "";
        try {
            int index1 = index;
            int index2 = (index + 10) % states.size();
            int index3 = (index + 20) % states.size();
            int index4 = (index + 30) % states.size();
            int index5 = (index + 40) % states.size();
            state = states.get(index1); //the current state about which the question is being asked
            //get index of current state and find the capital that matches it.
            correctAnswer = capitals.get(states.indexOf(state)); //the correct answer out of all the opotions that are made available.
            String wrongAnswer1 = capitals.get(index2);
            String wrongAnswer2 = capitals.get(index3);
            String wrongAnswer3 = capitals.get(index4);
            String wrongAnswer4 = capitals.get(index5);
            if (index > -1 && index < 10)
                questionString = formQuestionSentence(state, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, wrongAnswer4);
            if (index > 10 && index < 20)
                questionString = formQuestionSentence(state, wrongAnswer1, correctAnswer, wrongAnswer2, wrongAnswer3, wrongAnswer4);
            if (index > 20 && index < 30)
                questionString = formQuestionSentence(state, wrongAnswer1, wrongAnswer2, correctAnswer, wrongAnswer3, wrongAnswer4);
            if (index > 30 && index < 40)
                questionString = formQuestionSentence(state, wrongAnswer1, wrongAnswer2, wrongAnswer3, correctAnswer, wrongAnswer4);
            if (index > 40 && index < 50)
                questionString = formQuestionSentence(state, wrongAnswer1, wrongAnswer2, wrongAnswer3, wrongAnswer4, correctAnswer);
            // questionString =    formQuestionSentence( state, wrongAnswer1, wrongAnswer2,  wrongAnswer3,wrongAnswer4, correctAnswer);
            return questionString;
        } catch (Exception ex) {
            return "Error: CHeck Index: Ensure you have all lists needed for this program to run.";
        }
    }
    public String formQuestionSentence(String state, String a, String b, String c, String d, String e) {
        String questionString = "What is the capital of " + state + "?" + "\n" + "a) " + a + "\n" + "b)" +
                " " + b + "\n" + "c) " + c + "\n" + "d) " + d + "\n" + "e) " + e;
        return questionString;
    }
    public String generateAnswer() {
        String answer = "";
        try {
            answer = "The capital of " + state + " is " + correctAnswer;
        } catch (Exception ex) {
            System.out.println("Error: Check you index please!");
        }
        return answer;
    }
    public void checkAnswer(final String userInput) {
        if (userInput.equals(correctAnswer))
            System.out.println("Correct");
        else
            System.out.println("Incorrect");
    }
    public int generateScore(String userInput , String correctAnswer) {
        int score = 0;
        if (isCorrect(userInput, correctAnswer))
            score += 1;

        return score;
    }
        public boolean isCorrect(String userInput, String correctAnswer){
            return userInput.equals(correctAnswer);
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
    public ArrayList<ArrayList<String>> getContentOfMap(Map<String, String> mapName) { //read xml file and extract the necessary data
        mapName = new LinkedHashMap<>();
        ArrayList<ArrayList<String>> keys_and_values = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        List<String> keyList = new ArrayList<>(mapName.keySet());
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);
            String value = mapName.get(key);
            keys.add(key);
            values.add(value);
            keys_and_values.add(keys);
            keys_and_values.add(values);
        }
        return keys_and_values;
    }
}
