

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {



    public static void main(String [] args) {
       Quiz quiz = new Quiz();
        State st = new State();
        Player player = new Player();
        int seed = 0 ;
        int maxQuestions;

        String question = "";

        ArrayList<String> states = new ArrayList<>();//all the states
        ArrayList<String> capitals = new ArrayList<>(); // all the capitals


        ArrayList<String> questions = new ArrayList<>();//all the questions
        ArrayList<String> answerCapitals = new ArrayList<>();; // all the answers
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
        for(int i = 0; i < seed; i++) {
            //System.out.println("State:" +  states.get(i) + ", Capital:" +  capitals.get(i));
        }
        answerCharacters = quiz.getCorrectAnswerChar(); //get all the correct answer
        for (int i = 0; i < seed; i++) {
            question = quiz.generateQuestion(states, capitals, i);
            questions.add(question);
            String correctCapital = quiz.getCorrectCapital();
            answerCapitals.add(correctCapital);




            //Collections.shuffle(questions);

            // answer = quiz.generateAnswer();
            // question_and_answer.put(question, answer);

        }
        //System.out.println(questions.get(0) );
        // System.out.println(answers.get(2));


        Scanner scanner = new Scanner(System.in);


        //System.out.println(questions.get(0) );
        //for (int i = 0; i < 50; i++) {
        //System.out.println("Question : " + (i+1));
        //System.out.println(questions.get(i));
        //  System.out.println(answerCapitals.get(i));

        // 	System.out.println(answerCharacters.get(i));
        //}
        //System.out.println(answerCharacters.size());
        //System.out.println(answerCharacters);
        //System.out.println(answerCharacters.indexOf('a'));
        //System.out.println(answerCharacters.lastIndexOf('a'));
        //System.out.println(answerCharacters.indexOf('b'));
        // System.out.println(answerCharacters.lastIndexOf('b'));

        maxQuestions = 10;
        String userInput = "";
        int questionIndex = 0;
        System.out.print("***********Welcome to our game***********\n");
        do {

            System.out.println("---Question " + ( questionIndex + 1)+"---");

            System.out.println(questions.get(questionIndex ));
            System.out.println(answerCapitals.get(questionIndex ));
            System.out.println(answerCharacters.get(questionIndex ));


            // Displaying a message on the screen
            // System.out.println(questions.get(0));

            userInput = scanner.next();
            System.out.println("You enetered: " + userInput);
            questionIndex++;
            userInput = "";
        } while( questionIndex < maxQuestions ) ;

        System.out.println(questionIndex  + " Questions have been asked");
        System.out.println(questionIndex  + " Would you like to continue? ");
        userInput = scanner.next();
        if (userInput.equals("y"))
            questionIndex = 0;


    }




}


