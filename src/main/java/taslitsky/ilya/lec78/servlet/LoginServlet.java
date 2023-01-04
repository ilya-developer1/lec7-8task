package taslitsky.ilya.lec78.servlet;

import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import taslitsky.ilya.lec78.model.User;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<User> userList = (List<User>) getServletContext().getAttribute("userList");
    String email =  request.getParameter("email");
    String password = request.getParameter("password");
    User user = new User(email, password);

    if(userList.contains(user)) {
      request.getSession().setAttribute("user", user);
      request.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    } else {
      request.setAttribute("isError", true);
      request.setAttribute("errorMessage", "Wrong password or email. Or user does not exist");
      request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
  }

}
