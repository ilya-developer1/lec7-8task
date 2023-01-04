package taslitsky.ilya.lec78.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsersServlet", value = "/users")
public class UsersServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      getServletContext().getRequestDispatcher("/users.jsp").forward(request,response);
  }
}
