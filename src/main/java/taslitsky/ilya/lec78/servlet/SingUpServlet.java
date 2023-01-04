package taslitsky.ilya.lec78.servlet;

import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import taslitsky.ilya.lec78.model.User;

@WebServlet(name = "SingUpServlet", value = "/signup")
public class SingUpServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/signup.jsp").forward(request,response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<User> userList = (List<User>) getServletContext().getAttribute("userList");
    String email =  request.getParameter("email");
    String password = request.getParameter("password");

    if(isUserWithSuchEmailAlreadyExist(userList, email)) {
      request.setAttribute("isError", true);
      request.setAttribute("errorMessage", "User with such email already exist");
      request.getServletContext().getRequestDispatcher("/signup.jsp").forward(request,response);
    } else {
      User user = new User(email, password);
      userList.add(user);
      request.getSession().setAttribute("user", user);
      request.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    }
  }

  private boolean isUserWithSuchEmailAlreadyExist(List<User> userList, String email) {
    for (User user : userList) {
      if(user.getEmail().equals(email)) {
        return true;
      }
    }
    return false;
  }
}
