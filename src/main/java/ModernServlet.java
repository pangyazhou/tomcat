import com.ligoo.connector.http.HttpRequest;
import com.ligoo.connector.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.WriteAbortedException;
import java.util.Enumeration;

/**
 * @Author: Administrator
 * @Date: 2018/12/10 15:47:45
 * @Description:
 */
public class ModernServlet extends HttpServlet {
    public ModernServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Modern Servlet</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h2>Headers</h2");
        Enumeration enumeration = request.getHeaderNames();

        while(enumeration.hasMoreElements()) {
            String element = (String)enumeration.nextElement();
            writer.println("<br>" + element + " : " + request.getHeader(element));
        }

        writer.println("<br><h2>Method</h2");
        writer.println("<br>" + request.getMethod());
        writer.println("<br><h2>Parameters</h2");
        Enumeration parameterNames = request.getParameterNames();

        while(parameterNames.hasMoreElements()) {
            String paramterName = (String)parameterNames.nextElement();
            writer.println("<br>" + paramterName + " : " + request.getParameter(paramterName));
        }

        writer.println("<br><h2>Query String</h2");
        writer.println("<br>" + request.getQueryString());
        writer.println("<br><h2>Request URI</h2");
        writer.println("<br>" + request.getRequestURI());
        writer.println("</body>");
        writer.println("</html>");
       /* response.setContentType("text/html");
        System.out.println("service ...");
        PrintWriter writer = response.getWriter();
        writer.println("i love rose.");
        writer.print("It is a very good book.");*/
    }

    @Override
    public void init() throws ServletException {
        System.out.println("ModernServlet-init");        
    }
}
