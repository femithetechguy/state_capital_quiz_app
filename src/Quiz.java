import java.util.*;
public class Quiz {
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private Map<String, String> question_answer;
    private String quizState; //current state where the question is generated from
    private String correctCapital; //correct answer for current question
    private char correctAnswerChar; //correct answer for current question
    private ArrayList<Character> answerCharacters;// all thecharacters that matched the right anser;
    private ArrayList<Integer> numberList;
    Integer[] choice;
    public Quiz() {
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        question_answer = new LinkedHashMap<>();
        answerCharacters = new ArrayList<>(); // all thecharacters that matched the right anser;
        numberList = new ArrayList<>();
        choice = new Integer[49];
    }
    public String formQuestionSentence(String state, String a, String b, String c, String d, String e) {
        String questionString = "What is the capital of " + state + "?" + "\n" + "a) " + a + "\n" + "b)" +
                " " + b + "\n" + "c) " + c + "\n" + "d) " + d + "\n" + "e) " + e + "\n";
        return questionString;
    }
    public String generateQuestion(ArrayList<String> states, ArrayList<String> capitals, int index) {
        String questionString = "";
        try {
            int index1 = index;
            int index2 = (index + 10) % states.size();
            int index3 = (index + 20) % states.size();
            int index4 = (index + 30) % states.size();
            int index5 = (index + 40) % states.size();
            quizState = states.get(index1); //the current state about which the question is being asked
            //get index of current state and find the capital that matches it.
            correctCapital = capitals.get(states.indexOf(quizState)); //the correct answer out of all the opotions that are made available.
            String wrongAnswer1 = capitals.get(index2);
            String wrongAnswer2 = capitals.get(index3);
            String wrongAnswer3 = capitals.get(index4);
            String wrongAnswer4 = capitals.get(index5);
            if (index > -1 && index < 10)
                questionString = formQuestionSentence(quizState, correctCapital, wrongAnswer1, wrongAnswer2, wrongAnswer3, wrongAnswer4);
            if (index >= 10 && index < 20)
                questionString = formQuestionSentence(quizState, wrongAnswer1, correctCapital, wrongAnswer2, wrongAnswer3, wrongAnswer4);
            if (index >= 20 && index < 30)
                questionString = formQuestionSentence(quizState, wrongAnswer1, wrongAnswer2, correctCapital, wrongAnswer3, wrongAnswer4);
            correctAnswerChar = 'c';
            if (index >= 30 && index < 40)
                questionString = formQuestionSentence(quizState, wrongAnswer1, wrongAnswer2, wrongAnswer3, correctCapital, wrongAnswer4);
            if (index >= 40 && index < 50)
                questionString = formQuestionSentence(quizState, wrongAnswer1, wrongAnswer2, wrongAnswer3, wrongAnswer4, correctCapital);
            // questionString =    formQuestionSentence( state, wrongAnswer1, wrongAnswer2,  wrongAnswer3,wrongAnswer4, correctAnswer);
            return questionString;
        } catch (Exception ex) {
            return "Error: CHeck Index: Ensure you have all lists needed for this program to run.";
        }
    }
    public String getCorrectCapital() {
        String answer = "";
        try {
            answer = "The capital of " + quizState + " is " + correctCapital;
        } catch (Exception ex) {
            System.out.println("Error: Check you index please!");
        }
        return answer;
    }
    public void printLastMsg(ArrayList<Integer> wrongAnswers, int score, ArrayList<String> answerCapitals) {
        System.out.println("=================================================================");
        System.out.println("You Scored: " + score + " points.");
        System.out.println("Answers to the questions you got wrong.");

        //System.out.println(wrongAnswers); // used to track the index of the question the playyer missed
        for (int i = 0; i < wrongAnswers.size(); i++) System.out.println(answerCapitals.get(wrongAnswers.get(i)));
    }
    public boolean isCorrectAnswer(String userInput, Character correctAnswer) {
        return userInput.equals(String.valueOf(correctAnswer));
    }
    public ArrayList<Character> getCorrectAnswerChar() {
        for (int i = 0; i < 10; i++)
            answerCharacters.add(i, 'a');
        for (int i = 10; i < 20; i++)
            answerCharacters.add(i, 'b');
        for (int i = 20; i < 30; i++)
            answerCharacters.add(i, 'c');
        for (int i = 30; i < 40; i++)
            answerCharacters.add(i, 'd');
        for (int i = 40; i < 50; i++)
            answerCharacters.add(i, 'e');
        return answerCharacters;
    }
    public void askQuizQuestions(Quiz quiz, int score, String userInput, int questionIndex, ArrayList<String> questions, Scanner scanner, boolean isCorrect, ArrayList<Character> answerCharacters, ArrayList<Integer> wrongAnswers, ArrayList<String> answerCapitals) {
        do {
            choice = getChoices(49);
            System.out.println("Question " + (questionIndex + 1));
            // System.out.println(" Index No:" + choice[questionIndex]);//used to track the current index being used
            System.out.println(questions.get(choice[questionIndex]));
            userInput = scanner.next();
            //isCorrect = quiz.isCorrectAnswer(userInput, answerCharacters.get(choice[questionIndex]));
            isCorrect = quiz.isCorrectAnswer(userInput, answerCharacters.get(choice[questionIndex]));
            //System.out.println(isCorrect);
            if (isCorrect) {
                System.out.print("\'"+userInput+"\'" + " is correct\n");
                score++;
            } else {
                System.out.print("\'"+userInput+"\'" +" is wrong\n");
                wrongAnswers.add(choice[questionIndex]);
            }
            questionIndex++;
            //ArrayList<Integer> ongAnswers = new ArrayList<>();
        }
        while (questionIndex < 10);
        //System.out.println(questionIndex);//used to track question index
        if (questionIndex % 10 == 0  ) {
            this.printLastMsg(wrongAnswers, score, answerCapitals);
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.println("You have been asked " + questionIndex + " questions. Would you ike to continue? Please Type y for yes or n for no.");
            userInput = scanner.next();
            wrongAnswers.clear();
            if(userInput.equalsIgnoreCase("y")) {
                questionIndex = 0; //reset question back to no 0
                askQuizQuestions(quiz, score, userInput, questionIndex, questions, scanner, isCorrect, answerCharacters, wrongAnswers, answerCapitals);
                //userInput = scnner.next();a
            }
            else if (userInput.equalsIgnoreCase("n")){

                System.out.println("Thank you for playing our game....");}


            else{
            System.out.println("\'"+userInput+"\'" + " is not a valid response");
            System.out.println("Thank you for playing our game....");}

        }
        //askQuizQuestions(quiz, score, userInput, questionIndex, questions, scanner, isCorrect, answerCharacters, wrongAnswers, answerCapitals);

        //userInput = " ";

      ;


    }
    public Integer[] getChoices(int size) { //generate number that are random to shuffle questions and answers accorrdingly
        Integer[] choice = new Integer[size];
        for (int i = 0; i <= size; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        choice = numberList.toArray(new Integer[numberList.size()]);
        return choice;
    }
}
