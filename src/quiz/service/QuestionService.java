package quiz.service;

public class QuestionService {
    public
    QuestionController questionController = new QuestionController();
    Scanner input = new Scanner(System.in);
    int answer = 0;
    ArrayList<Question> quizList = questionController.getQuestions();
        for(Question question: quizList){
        System.out.println(question.getTitle());
        question.showOptions();
        System.out.println("Choose an option: ");
        answer = Integer.parseInt(input.nextLine());
        if(question.checkAnswer(answer)){
            //TODO need to calculate score
            //TODO add the score information to the score board
            System.out.println("correct");
        }else{
            //not required just for checking purposes
            System.out.println("incorrect");
        }
    }
}
