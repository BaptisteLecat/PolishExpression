package web.controller;

import entity.User;
import repository.Auth;
import repository.LeaderBoard;
import utils.PostChecker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BaptisteLecat & FxPelet
 */
public class ProfilController extends HttpServlet {

    private boolean isAuthenticated(HttpServletRequest req){
        boolean isAuthenticated = false;
        int idUser = 0;
        HttpSession session = req.getSession();
        try {
            idUser = Integer.parseInt(session.getAttribute("idUser").toString());
            Auth authRepository = new Auth();
            User user = authRepository.whoAmI(idUser);
            isAuthenticated = true;
        } catch (Exception e) {
            return false;
        }
        return isAuthenticated;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        if(this.isAuthenticated(req)){
            try{
                int userId = Integer.parseInt(req.getParameter("userId"));
                Auth authRepository = new Auth();
                LeaderBoard leaderBoardRepository = new LeaderBoard();

                //Get user profile
                User user = authRepository.whoAmI(userId);

                //Get last play
                entity.LeaderBoard lastLeaderBoard = leaderBoardRepository.getLastLeaderBoardForUser(user);

                //Get list of leaderBoard for user
                List<entity.LeaderBoard> listLeaderBoardUser = leaderBoardRepository.getLeaderBoardListForUser(user);

                req.setAttribute("user", user);
                req.setAttribute("lastLeaderBoard", lastLeaderBoard);
                req.setAttribute("listLeaderBoardUser", listLeaderBoardUser);
                req.getRequestDispatcher("/WEB-INF/views/profil.jsp")
                        .forward(req, resp);
            }catch (NumberFormatException e){
                req.setAttribute("errorMessage", "Ce user est inconnu.");
                req.getRequestDispatcher("/WEB-INF/views/profil.jsp")
                        .forward(req, resp);
            }
        }else{
            resp.sendRedirect("login");
        }
    }
}
