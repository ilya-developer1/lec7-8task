package taslitsky.ilya.lec78.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getSession().removeAttribute("user");
    getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
  }
}
