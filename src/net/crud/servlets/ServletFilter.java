package crud.servlets;

import crud.model.User;
import crud.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.LogRecord;

@WebFilter(urlPatterns = {"/list", "/delete", "/insert", "/update"})
public class ServletFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");
        if (user.getRole().equals("admin")) {
            filterChain.doFilter(request, servletResponse);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("hello.jsp");
            dispatcher.forward(request, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
