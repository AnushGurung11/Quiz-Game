package quiz.model;

public class Question {
    private String title;
    private String options_1 ;
    private String options_2 ;
    private String options_3 ;
    private String options_4 ;
    private final String[] options = new String[4] ;

    private int correct_index;

    public Question(String title, String option_1, String option_2, String option_3, String option_4, String correct_index)
    {
        this.title = title;
        this.options_1 = option_1;
        this.options[0] = option_1;
        this.options_2 = option_2;
        this.options[1] = option_2;
        this.options_3 = option_3;
        this.options[2] = option_3;
        this.options_4 = option_4;
        this.options[3] = option_4;



        this.correct_index = Integer.parseInt(correct_index);
    }

    public Question() {

    }

    public Question(String question, String option1, String option2, String option3, String option4, int correctOption) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getCorrect_index() {
        return correct_index;
    }

    public void setCorrect_index(int correct_index) {
        this.correct_index = correct_index;
    }

    public void showOptions(){
        for(int i = 0; i < this.options.length; i++){
            System.out.println(i+1 + " . "+ options[i]);
        }
    }


    public boolean checkAnswer(int answer){
        if((answer) == this.correct_index){
            return true;
        }
        return false;
    }

    public String getOptions_1() {
        return options_1;
    }

    public String getOptions_4() {
        return options_4;
    }

    public String getOptions_3() {
        return options_3;
    }

    public String getOptions_2() {
        return options_2;
    }
}
