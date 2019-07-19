import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;



public class AuthenticationFilter implements Filter {
    private ServletContext context;

    public void destroy() {
    }
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");// check

    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        if(session == null){ //checking if the session
           this.context.log("Unauthorized access request");

            req.getRequestDispatcher("denied.jsp").forward(req,res);
            res.sendRedirect("denied.jsp");


        }
        else {
            //pass the request a long the filter chain
            chain.doFilter(request, response);
        }

    }



}
