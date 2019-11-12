package java112.project3;

import java.util.*;
import java.io.*;
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
            String inputName = request.getParameter("yourName");
            String teamName = request.getParameter("teamName");
            String jerseyNumber = request.getParameter("jerseyNumber");
        } else {
            url = "/quiz.jsp";
        }

        request.setAttribute("quizBean", quizBean);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }

}
