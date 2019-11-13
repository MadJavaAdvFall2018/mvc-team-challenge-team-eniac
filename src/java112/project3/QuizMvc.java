package java112.project3;

import java.util.*;
import java.io.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;



@WebServlet(
    name = "quiz",
    urlPatterns = { "/quiz" }
)
public class QuizMvc extends HttpServlet {

    private List<Question> questions;

    public QuizMvc() {
        questions = new ArrayList<Question>();
        
        questions.add(new Question("yourName", "What is your name?"));

        questions.add(new Question("question1",
                "What is Steph Curry's jersey number?", "30", Arrays.asList("21", "30", "44", "10")));

        questions.add(new Question("question2",
                "What team did Michael Jordan initially play for?",
                Arrays.asList("bulls", "chicago bulls")));
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.jsp";

        QuizBean quizBean = new QuizBean();

        if (request.getParameter("quiz-submitted") != null
                && request.getParameter("quiz-submitted").equals("true")) {
            url = "/index.jsp";

            String name = request.getParameter("yourName");

            StringBuilder gradingHtml = new StringBuilder();

            int totalQuestions = 0;
            int totalQuestionsCorrect = 0;

            for (Question question : questions) {
                gradingHtml.append("<div class=\"question\">");

                String givenAnswer = request.getParameter(question.getQuestionId());


                if (question.getMultipleChoiceAnswers() == null) {
                    gradingHtml.append("<label for=\"" + question.getQuestionId()
                            + "\">" + question.getQuestion());

                    if (question.getAnswers() != null) {
                        if (question.checkCorrectAnswer(givenAnswer)) {
                            gradingHtml.append("<div class=\"correct\"><i class=\"fal fa-check\"></i></div>");
                        } else {
                            gradingHtml.append("<div class=\"incorrect\"><i class=\"fal fa-times\"></i></div>");
                        }
                    } else {
                        gradingHtml.append("<div class=\"ungraded\"><i class=\"fal fa-minus\"></i></div>");
                    }

                    gradingHtml.append("</label>");

                    gradingHtml.append("<input type=\"text\" name=\""
                            + question.getQuestionId() + "\" value=\""
                            + givenAnswer + "\" disabled=\"disabled\"/>");
                } else {
                    gradingHtml.append("<p>" + question.getQuestion() + "</p>");

                    int answerNumber = 1;
                    for (String answer : question.getMultipleChoiceAnswers()) {
                        gradingHtml.append("<div class=\"answer\"><input type=\"radio\" name=\""
                                + question.getQuestionId() + "\" id=\""
                                + question.getQuestionId() + "ans"
                                + answerNumber + "\" value=\""
                                + answer + "\" disabled=\"disabled\" "
                                + (givenAnswer.equals(answer)
                                ? "checked=\"checked\""
                                : "") + "/>");

                        gradingHtml.append("<label for=\""
                                + question.getQuestionId() + "ans"
                                + answerNumber + "\">" + answer);

                        if (givenAnswer.equals(answer))
                            gradingHtml.append("<i class=\"fal fa-bullseye-arrow chosen-arrow\"></i>");

                        if (question.getAnswers().contains(answer)) {
                            if (question.checkCorrectAnswer(givenAnswer)) {
                                gradingHtml.append("<div class=\"correct\"><i class=\"fal fa-check\"></i></div>");
                            } else {
                                gradingHtml.append("<div class=\"incorrect\"><i class=\"fal fa-times\"></i></div>");
                            }
                        }

                        gradingHtml.append("</label></div>");

                        answerNumber++;
                    }
                }


                if (question.getAnswers() != null) {
                    if (question.checkCorrectAnswer(givenAnswer)) {
                        totalQuestionsCorrect++;
                    }
                    totalQuestions++;
                }

                gradingHtml.append("</div>");
            }

            quizBean.setName(name);

            quizBean.setGradingHtml(gradingHtml.toString());

            quizBean.setTotalQuestions(totalQuestions);
            quizBean.setQuestionsCorrect(totalQuestionsCorrect);
            quizBean.setPercentCorrect(
                    Math.round(((double) totalQuestionsCorrect / totalQuestions)
                    * 10000.0) / 100.0);
        } else {
            url = "/quiz.jsp";

            StringBuilder questionHtml = new StringBuilder();

            for (Question question : questions) {
                questionHtml.append("<div class=\"question\">");

                if (question.getMultipleChoiceAnswers() == null) {
                    questionHtml.append("<label for=\"" + question.getQuestionId()
                            + "\">" + question.getQuestion() + "</label>");

                    questionHtml.append("<input type=\"text\" name=\""
                            + question.getQuestionId() + "\" />");
                } else {
                    questionHtml.append("<p>" + question.getQuestion() + "</p>");

                    int answerNumber = 1;
                    for (String answer : question.getMultipleChoiceAnswers()) {
                        questionHtml.append("<div class=\"answer\"><input type=\"radio\" name=\""
                                + question.getQuestionId() + "\" id=\""
                                + question.getQuestionId() + "ans"
                                + answerNumber + "\" value=\""
                                + answer + "\" />");

                        questionHtml.append("<label for=\""
                                + question.getQuestionId() + "ans"
                                + answerNumber + "\">" + answer + "</label></div>");

                        answerNumber++;
                    }
                }

                questionHtml.append("</div>");
            }

            quizBean.setQuestionHtml(questionHtml.toString());
        }

        request.setAttribute("quizBean", quizBean);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }

}
