package web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp")
                .forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        PostChecker

        req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp")
                .forward(req, resp);
    }
}

/*

package utils;

public static class PostChecker {

    public static List<String> checkPostData(Map<String, String> postData){
        List<String> errorParam = new ArrayList();
        postData.forEach((name, value) -> {
            if(value == null || value.equals("")){
                errorParam.add(name);
            }
        });
        return errorParam;
    }
}
 */