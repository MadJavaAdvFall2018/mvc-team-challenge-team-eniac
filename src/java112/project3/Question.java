package java112.project3;

import java.util.*;

public class Question {
    private String questionId;
    private String question;
    private List<String> multipleChoiceAnswers;
    private List<String> answers;

    public Question(String questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    public Question(String questionId, String question, List<String> answers) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }

    public Question(String questionId, String question, String answer) {
        this(questionId, question, Arrays.asList(answer));
    }

    public Question(String questionId, String question, List<String> answers, List<String> multipleChoiceAnswers) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
        this.multipleChoiceAnswers = multipleChoiceAnswers;
    }

    public Question(String questionId, String question, String answer, List<String> multipleChoiceAnswers) {
        this(questionId, question, Arrays.asList(answer), multipleChoiceAnswers);
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getMultipleChoiceAnswers() {
        return multipleChoiceAnswers;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public boolean checkCorrectAnswer(String givenAnswer) {
        for (String answer : answers) {
            if (answer.equalsIgnoreCase(givenAnswer)) {
                return true;
            }
        }
        return false;
    }
}