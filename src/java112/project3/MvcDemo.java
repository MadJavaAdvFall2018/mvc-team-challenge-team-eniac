package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;



@WebServlet(
    name = "mvcDemo",
    urlPatterns = { "/mvc-demo" }
)
public class MvcDemo extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String inputName = request.getParameter("yourName");
        String teamName = request.getParameter("teamName");
        String jerseyNumber = request.getParameter("jerseyNumber");

        Integer q1answer = 30;

        BeanOne myBean = new BeanOne();

        myBean.setMySpecialData("Your name: " + inputName);
        request.setAttribute("myCoolBean", myBean);

        myBean.setMySpecialData("Your answer: " + jerseyNumber);
        request.setAttribute("myCoolBean", myBean);
        
        myBean.setMySpecialData("Your answer: " + teamName);
        request.setAttribute("myCoolBean", myBean);




        String url = "/index.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }

}
