package web.controller;

import utils.GetRandomPolishExpression;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PlayController extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
                ServletException, IOException {

            //String polishExpression = request.getParameter("polishExpression");

            GetRandomPolishExpression polishExpression = new GetRandomPolishExpression();
            polishExpression.setPolishExpression();

            request.setAttribute("polishExpression", polishExpression);

           this.getServletContext().getRequestDispatcher("/WEB-INF/views/play.jsp")
                    .forward(request, response);
        }

}
