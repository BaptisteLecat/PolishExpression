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
        if(countCalcul > 10){
            countCalcul = 0;
            goodResponse = 0;

        }
        GetRandomPolishExpression myExpression = new GetRandomPolishExpression();
        polishExpression = myExpression.getExpression();

        request.setAttribute("polishExpression", String.join(" ", polishExpression));
        //Object data = "Some data, can be a String or a Javabean";
        //request.setAttribute("data", "test");
        request.setAttribute("turn", countCalcul);
        request.setAttribute("goodResponse", goodResponse);
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
        //request.setAttribute("resultatCalcul", resultatCalcul);
        System.out.println("#DEBUG: value = " + myValue);
        System.out.println("#DEBUG: turn = " + countCalcul);

        if(countCalcul < 10){
            GetRandomPolishExpression myExpression = new GetRandomPolishExpression();
            this.polishExpression = myExpression.getExpression();
            request.setAttribute("polishExpression", String.join(" ", this.polishExpression));
            countCalcul++;
            if (myValue.equals(resultatCalcul)) {
                goodResponse++;
                System.out.println("#DEBUG: valueBoucle = " + myValue);
                System.out.println("#DEBUG: goodResponseBoucle = " + goodResponse);
                System.out.println("#DEBUG: resCalcBoucle = " + resultatCalcul);

            }
        }
        else{
            //réanistialisation valeur
            countCalcul = 0;
            goodResponse = 0;
        }

        
        request.setAttribute("turn", countCalcul);
        request.setAttribute("goodResponse", goodResponse);
        request.getRequestDispatcher("/WEB-INF/views/play.jsp")
                    .forward(request, response);
    }
}
