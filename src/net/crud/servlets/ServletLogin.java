package crud.servlets;

import crud.model.User;
import crud.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class ServletLogin extends HttpServlet {
    private UserServiceImpl userServiceimp = UserServiceImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = userServiceimp.getUserLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user!=null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("list");
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}
