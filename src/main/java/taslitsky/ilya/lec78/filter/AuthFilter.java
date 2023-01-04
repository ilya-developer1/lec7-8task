package taslitsky.ilya.lec78.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter {

  public void init(FilterConfig config) throws ServletException {
  }

  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    String loginURI = req.getContextPath() + "/login";
    String signUpURI = req.getContextPath() + "/signup";

    final HttpSession session = req.getSession(false);

    boolean loggedIn = session != null && session.getAttribute("user") != null;
    boolean loginRequest = req.getRequestURI().equals(loginURI);
    boolean signUpRequest = req.getRequestURI().equals(signUpURI);

    if(loggedIn || loginRequest || signUpRequest) {
      chain.doFilter(request, response);
    } else {
      res.sendRedirect(loginURI);
    }
  }
}
