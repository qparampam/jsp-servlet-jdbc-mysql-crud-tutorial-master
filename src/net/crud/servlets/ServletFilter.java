package crud.servlets;

import crud.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Мне нужно проверять, чтобы на страницу user мог попасть только user
// Но он уходит в цикл


@WebFilter(urlPatterns = {"/admin", "/delete", "/insert", "/update", "/user"})
public class ServletFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");
         if(user != null && user.getRole().equals("admin")) {
            filterChain.doFilter(request, servletResponse);
        } else if(user != null && user.getRole().equals("user")){
             if (request.getRequestURL().toString().contains("user")){
                 filterChain.doFilter(request, servletResponse);
             } else {
                 HttpServletResponse response = (HttpServletResponse) servletResponse;
                 response.sendRedirect("user");
             }
        } else {
                 HttpServletResponse response = (HttpServletResponse) servletResponse;
                 response.sendRedirect("/");
         }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
