package taslitsky.ilya.lec78.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import taslitsky.ilya.lec78.model.User;

@WebListener
public class ApplicationContextListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    List<User> userList = new ArrayList<>();
    sce.getServletContext().setAttribute("userList", userList);
  }
}
