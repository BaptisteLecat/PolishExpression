package web.controller.auth;

import repository.Auth;
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

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp")
                .forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        Map<String, String> fields = new HashMap<String, String>();
        fields.put("inputEmail", req.getParameter("inputEmail"));
        fields.put("inputPassword", req.getParameter("inputPassword"));

        List<String> errorParams = PostChecker.checkPostData(fields);
        if(errorParams.isEmpty()){
            if(PostChecker.isValidEmailAddress(fields.get("inputEmail"))){
                Auth auth = new Auth();
                Object data = auth.login(fields.get("inputEmail"), fields.get("inputPassword"));
                if(data instanceof Integer){
                    int idUser = (int) data;
                    // Récupérer la session existante ou création d'une session
                    HttpSession session = req.getSession(true);
                    session.setAttribute("idUser", idUser);
                    req.getRequestDispatcher("/WEB-INF/views/home.jsp")
                            .forward(req, resp);
                }else{
                    req.setAttribute("errorMessage", "Identifiants incorrects.");
                    req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp")
                            .forward(req, resp);
                }
            }else{
                req.setAttribute("errorMessage", "Le format de l'email est incorrect");
                req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp")
                        .forward(req, resp);
            }
        }else{
            req.setAttribute("errorMessage", PostChecker.setErrorMessage(errorParams));
            req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp")
                    .forward(req, resp);
        }
    }
}