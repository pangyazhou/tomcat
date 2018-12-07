
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Administrator
 * @Date: 2018/12/6 11:35:47
 * @Description:
 */
public class PrimitiveServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init primitiveServlet");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter writer = res.getWriter();
        writer.println("Hello, Roses are red.");
        writer.print("Violets are blue");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy primitiveServlet");
    }
}
