import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        State st = new State();
        Player player = new Player();
        int seed = 0;
        int maxQuestions;
        String question = "";
        ArrayList<String> states = new ArrayList<>();//all the states
        ArrayList<String> capitals = new ArrayList<>(); // all the capitals
        ArrayList<String> questions = new ArrayList<>();//all the questions
        ArrayList<String> answerCapitals = new ArrayList<>();
        int [] choice = generateRandom(50);
        ; // all the answers
        ArrayList<Character> answerCharacters = new ArrayList<>(); // all thecharacters that matched the right anser;
        Map<String, String> question_and_answer;
        try {
            states = st.getAllExpressionInstance("//state");//store all states
            capitals = st.getAllExpressionInstance("//capital");// store all capitals
            if (states.size() == capitals.size()) //ensure that you have same number of item in state and capital
                seed = states.size();
            else {
                seed = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(seed);
        //System.out.println("STATE" + "           ==        " +  "CAPITAL");
        for (int i = 0; i < seed; i++) {
            //System.out.println("State:" +  states.get(i) + ", Capital:" +  capitals.get(i));
        }
        answerCharacters = quiz.getCorrectAnswerChar(); //get all the correct answer
        for (int i = 0; i < seed; i++) {
            question = quiz.generateQuestion(states, capitals, i);
            questions.add(question);
            String correctCapital = quiz.getCorrectCapital();
            answerCapitals.add(correctCapital);
        }

        
        Scanner scanner = new Scanner(System.in);
        maxQuestions = 10;
        String userInput = "";
        int questionIndex = 0;
        boolean isCorrect;
        System.out.println("----WELCOME------");
        for (int i = 0; i < choice.length; i++)
        {
            //System.out.println(generateRandom(50));
           // System.out.println(choice[i]);
        }
        do {
            System.out.println("Question " + (questionIndex + 1));
            System.out.println(questions.get(choice[questionIndex]));

            userInput = scanner.next();
           // System.out.println(answerCharacters.get(choice[questionIndex]));
            questionIndex++;
               
        }
        while(questionIndex < 10);
        if(userInput.equalsIgnoreCase("y")){
            
        }
        
      
    }
    public static int[] generateRandom(int peak){
        int [] choice = new int[peak];
        Random random = new Random();
        //obtain from 0 - peak
         ;
         for (int i =0; i < peak; i++){
             int number = random.nextInt(peak);
             choice[i] = number;
         }

         return choice;
    }
}
