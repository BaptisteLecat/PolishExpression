package web.controller;

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
 * Created by BaptisteLecat
 */
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        LeaderBoard leaderboardRepository = new LeaderBoard();
        List<entity.LeaderBoard> data = leaderboardRepository.getLeaderBoardList();
        req.setAttribute("listLeaderBoard", data);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp")
                .forward(req, resp);
    }
}
