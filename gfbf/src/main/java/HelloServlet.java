import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by e-snci on 9/8/2016.
 */

@WebServlet(name = "hello", urlPatterns = "/")
public class HelloServlet extends HttpServlet {

    private final Hello hello = new Hello();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String hello = this.hello.sayHello();
        resp.getWriter().write(hello);
    }
}
