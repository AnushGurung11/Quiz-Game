package quiz.model;

public class ScoreBoard {

    private double score;
    private String playDate;

    public ScoreBoard( String playDate, double score) {

        this.playDate = playDate;
        this.score = score;
    }

    public double getScore() {
        return score;
    }


    public String getPlayDate() {
        return playDate;
    }


    public void setScore(double score) {
        this.score = score;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }
}
