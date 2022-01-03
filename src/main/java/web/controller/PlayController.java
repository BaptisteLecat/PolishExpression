package web.controller;

import entity.User;
import repository.Auth;
import repository.LeaderBoard;
import utils.GetRandomPolishExpression;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class PlayController extends HttpServlet {

    private int countCalcul = 0;
    private int goodResponse = 0;
    private String[] polishExpression;

    private boolean isAuthenticated(HttpServletRequest req){
        boolean isAuthenticated = false;
        int idUser = 0;
        HttpSession session = req.getSession();
        try {
            idUser = Integer.parseInt(session.getAttribute("idUser").toString());
            Auth authRepository = new Auth();
            User user = authRepository.whoAmI(idUser);
            isAuthenticated = true;
            System.out.println(authRepository.whoAmI(idUser));

        } catch (Exception e) {
            return false;
        }
        return isAuthenticated;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        if(this.isAuthenticated(request)){
            GetRandomPolishExpression myExpression = new GetRandomPolishExpression();
            polishExpression = myExpression.getExpression();

            if(countCalcul > 9){
                countCalcul = 0;
                goodResponse = 0;
            }

            request.setAttribute("polishExpression", String.join(" ", polishExpression));
            request.setAttribute("turn", countCalcul);
            request.setAttribute("goodResponse", goodResponse);
            request.getRequestDispatcher("/WEB-INF/views/play.jsp")
                    .forward(request, response);
        }else{
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        if(this.isAuthenticated(request)){
            Object myValue1 = request.getParameter("inputResultat");
            String myValue = String.valueOf(myValue1);

            //Récupérer le même polishExpression qui est affiché pour l'utilisateur afin de le traiter


            GetRandomPolishExpression result = new GetRandomPolishExpression();
            String resultatCalcul = result.calculPolish(polishExpression);
            System.out.println("#DEBUG: resultat = " + resultatCalcul);
            //request.setAttribute("resultatCalcul", resultatCalcul);
            System.out.println("#DEBUG: value = " + myValue);
            System.out.println("#DEBUG: turn = " + countCalcul);

            if(countCalcul < 9){
                GetRandomPolishExpression myExpression = new GetRandomPolishExpression();
                this.polishExpression = myExpression.getExpression();
                request.setAttribute("polishExpression", String.join(" ", this.polishExpression));

                countCalcul++;
                if (myValue.equals(resultatCalcul)) {
                    goodResponse++;
                /*System.out.println("#DEBUG: valueBoucle = " + myValue);
                System.out.println("#DEBUG: goodResponseBoucle = " + goodResponse);
                System.out.println("#DEBUG: resCalcBoucle = " + resultatCalcul);*/

                }
            }else{
                countCalcul++;
                if (myValue.equals(resultatCalcul)) {
                    goodResponse++;
                /*System.out.println("#DEBUG: valueBoucle = " + myValue);
                System.out.println("#DEBUG: goodResponseBoucle = " + goodResponse);
                System.out.println("#DEBUG: resCalcBoucle = " + resultatCalcul);*/

                }
                LeaderBoard leaderBoardRepository = new LeaderBoard();
                HttpSession session = request.getSession();
                if(session != null){
                    leaderBoardRepository.insertUserLeaderBoard(Integer.parseInt(session.getAttribute("idUser").toString()), goodResponse);
                }
            }
            request.setAttribute("turn", countCalcul);
            request.setAttribute("goodResponse", goodResponse);
            request.getRequestDispatcher("/WEB-INF/views/play.jsp")
                    .forward(request, response);
        }else{
            response.sendRedirect("login");
        }
    }
}
