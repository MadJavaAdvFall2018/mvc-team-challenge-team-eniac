package java112.project3;

/**
 *  This is a JavaBean to use with the Quiz application
 *
 * @author tltwining
 */
public class QuizBean {
    private String questionHtml;

    private String name;

    private Integer questionsCorrect;
    private Integer totalQuestions;
    private Double percentCorrect;

    private String gradingHtml;

    public QuizBean() {
        
    }

    public String getQuestionHtml() {
        return questionHtml;
    }

    public void setQuestionHtml(String questionHtml) {
        this.questionHtml = questionHtml;
    }

    public Integer getQuestionsCorrect() {
        return questionsCorrect;
    }

    public void setQuestionsCorrect(Integer questionsCorrect) {
        this.questionsCorrect = questionsCorrect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Double getPercentCorrect() {
        return percentCorrect;
    }

    public void setPercentCorrect(Double percentCorrect) {
        this.percentCorrect = percentCorrect;
    }

    public String getGradingHtml() {
        return gradingHtml;
    }

    public void setGradingHtml(String gradingHtml) {
        this.gradingHtml = gradingHtml;
    }
}
