import javax.servlet.*;             // Tomcat 9
import javax.servlet.http.*;        // Tomcat 9
import javax.servlet.annotation.*;  // Tomcat 9
import java.io.IOException;
import java.io.PrintWriter;
 
@WebServlet("/done")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class done extends HttpServlet {

   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
 
      // Set the response MIME type of the response message
      response.setContentType("text/html");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      int id=Integer.parseInt( request.getParameter("id"));
      String fr=request.getParameter("fresher");
      String tr=request.getParameter("training");
      String ph=request.getParameter("phone");
      String doj=request.getParameter("doj");
      MyDB.update(id, fr, tr, ph, doj);
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>Form Completed</title><script src=\"script.js\"></script><link rel=\"stylesheet\" href=\"style.css\"></head>");
      out.println("<body>");
      out.println("<h1>Form Submitted!</h1>");
      out.println("</body></html>");
      out.close();
    }
}