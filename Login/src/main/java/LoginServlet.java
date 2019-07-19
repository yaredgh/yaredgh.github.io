import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class LoginServlet extends HttpServlet {
    HttpSession session = null;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));
        String remember = req.getParameter("remember");

        DataStore Ds = new DataStore();
        HashMap<String, String> myDb = Ds.getMyDb();
        boolean isValid = false;
        Iterator itrerator = myDb.entrySet().iterator();
        while (itrerator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) itrerator.next();
            if (user.getUserName().equalsIgnoreCase(entry.getKey())
                    && user.getPassword().equalsIgnoreCase((String) entry.getValue())) {
                isValid = true;
                break;
            }
        }
        if (isValid){
            this.session = req.getSession();
            this.session.setAttribute("userName", user.getUserName());
            if (req.getParameter("remember") != null) {
                Cookie cUserName = new Cookie("cookuser", user.getUserName());
                Cookie cPassword = new Cookie("cookpass", user.getPassword());
                Cookie cRemember = new Cookie("cookrem", remember.trim());
                cUserName.setMaxAge(2592000);
                cPassword.setMaxAge(2592000);
                cRemember.setMaxAge(2592000);
                resp.addCookie(cUserName);
                resp.addCookie(cPassword);
                resp.addCookie(cRemember);
            }
            resp.sendRedirect("HomePage.jsp");
        }
        else
            {
            req.setAttribute("errorMessage","Invalid user Password");// check this
            RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
            dispatcher.forward(req,resp);
        }




    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
         doPost(req,resp);


    }
}