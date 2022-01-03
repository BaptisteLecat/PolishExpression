package web.controller;

import utils.GetRandomPolishExpression;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PlayController extends HttpServlet {

    private int countCalcul = 1;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
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
        System.out.println("#DEBUG: resultat = " + resultatCalcul);
        request.setAttribute("resultatCalcul", resultatCalcul);
        System.out.println("#DEBUG: value = " + myValue);
        System.out.println("#DEBUG: turn = " + countCalcul);



        //gestion de la boucle
        countCalcul++;
        if (myValue.equals(resultatCalcul)) {
            goodResponse++;
            request.setAttribute("turn", countCalcul);
            System.out.println("#DEBUG: valueBoucle = " + myValue);
            System.out.println("#DEBUG: goodResponseBoucle = " + goodResponse);
            System.out.println("#DEBUG: resCalcBoucle = " + resultatCalcul);

        }
        if (!myValue.equals(resultatCalcul)) {
            //rappel de la page

            doGet(request, response);
            request.setAttribute("turn", countCalcul);
            request.getRequestDispatcher("/WEB-INF/views/play.jsp")
                    .forward(request, response);
            System.out.println("#DEBUG: countCalculBoucle = " + countCalcul);
        }
        if (countCalcul == 10) {
            //out.print("Bravo vous avez terminer l'épreuve de calcul voici votre score : " + goodResponse + "/10");
            request.setAttribute("goodResponse", goodResponse);
            System.out.println("#DEBUG: goodResponseBoucle = " + goodResponse);

            request.getRequestDispatcher("/WEB-INF/views/play.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("turn", countCalcul);
            request.getRequestDispatcher("/WEB-INF/views/play.jsp")
                    .forward(request, response);
            System.out.println("eeee");
        }

        //traitement du résultat


    }
}
