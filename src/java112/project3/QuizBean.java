package java112.project3;

/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 *@author    eknapp
 */
public class QuizBean {
    private String questionHtml;

    /**
     *  Constructor for the BeanOne object
     */
    public QuizBean() {
        
    }

    public String getQuestionHtml() {
        return questionHtml;
    }

    public void setQuestionHtml(String questionHtml) {
        this.questionHtml = questionHtml;
    }
}
