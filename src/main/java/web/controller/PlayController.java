package web.controller;

import utils.GetRandomPolishExpression;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PlayController extends HttpServlet {

        private int countCalcul = 0;
        private int goodResponse = 0;
        private String[] polishExpression;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
                ServletException, IOException {

            //String polishExpression = request.getParameter("polishExpression");

            //GetRandomPolishExpression polishExpression = new utils.GetRandomPolishExpression();
            //polishExpression.setPolishExpression();

            GetRandomPolishExpression myExpression = new GetRandomPolishExpression();
            polishExpression = myExpression.getExpression();

            request.setAttribute("polishExpression", String.join(" ", polishExpression));
            //Object data = "Some data, can be a String or a Javabean";
            //request.setAttribute("data", "test");

           request.getRequestDispatcher("/WEB-INF/views/play.jsp")
                    .forward(request, response);
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws
            ServletException, IOException {
            Object myValue1 = request.getParameter("inputResultat");
            String myValue = String.valueOf(myValue1);

            //Object polishExpression2 = request.getAttribute("polishExpression");
            //String polishExpression1 = String.valueOf(polishExpression2);
            //String[] polishExpression = polishExpression1.split("(?!^)");
            //int a = polishExpression1.length();
            //String[] polishExpression = polishExpression1.split("(?!^)");
            //String polishExpression1 = request.getParameter("polishExpression");
            //String[] polishExpression = polishExpression1.split("(?!^)");

            //Récupérer le même polishExpression qui est affiché pour l'utilisateur afin de le traiter


            GetRandomPolishExpression result = new GetRandomPolishExpression();
            String resultatCalcul = result.calculPolish(polishExpression);
            request.setAttribute("resultatCalcul", resultatCalcul);

            //gestion de la boucle
            countCalcul++;

            //traitement du résultat
            if(myValue.equals(resultatCalcul)){
                goodResponse++;
            }

             if(countCalcul < 10) {
                 //rappel de la page
                 doGet(request, response);
             }else{
                 request.setAttribute("goodResponse", goodResponse);

                 request.getRequestDispatcher("/WEB-INF/views/play.jsp")
                         .forward(request, response);
             }



    }
}
