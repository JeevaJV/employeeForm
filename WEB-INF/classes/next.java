import javax.servlet.*;             // Tomcat 9
import javax.servlet.http.*;        // Tomcat 9
import javax.servlet.annotation.*;  // Tomcat 9
import java.io.IOException;
import java.io.PrintWriter;
 
@WebServlet("/next")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class next extends HttpServlet {

   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
 
      // Set the response MIME type of the response message
      response.setContentType("text/html");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      int id=Integer.parseInt( request.getParameter("id"));
      String nm= request.getParameter("name");
      String fm= request.getParameter("gender");
      String dob= request.getParameter("dob");
      String des= request.getParameter("designation");
      int salary= Integer.parseInt(request.getParameter("salary"));
      String dp= request.getParameter("dept");
      MyDB.store(id, nm, fm, dob, des,salary, dp);
      out.println("<html>\r\n" + //
                  "<head>\r\n" + //
                  "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n" + //
                  "<script src=\"script.js\"></script>\r\n" + //
                  "<link rel=\"stylesheet\" href=\"style.css\">\r\n" + //
                  "<title>Form-2</title>\r\n" + //
                  "</head>\r\n" + //
                  "<body>\r\n" + //
                  "<header>\r\n" + //
                  "    <div class=\"header\">\r\n" + //
                  "        FORM Part 2\r\n" + //
                  "    </div>\r\n" + //
                  "</header>\r\n" + //
                  "<form  method=\"post\" action=\"done\">\r\n" + //
                  "<ul class=\"nxt\">\r\n" + //
                  "<li>\r\n" + //
                  "Fresher: &emsp; &emsp; &emsp; &emsp; &emsp; \r\n" + //
                  "<input type=\"radio\"  name=\"fresher\" value=\"Yes\" required>\r\n" + //
                  "<label for=\"yes\">Yes</label>\r\n" + //
                  "<input type=\"radio\"  name=\"fresher\" value=\"No\" required>\r\n" + //
                  "<label for=\"no\">No</label>\r\n" + //
                  "</li>\r\n" + //
                  "<li>\r\n" + //
                  "    Need Training: &emsp; &emsp;&emsp; \r\n" + //
                  "    <input type=\"radio\"  name=\"training\" value=\"Yes\" required>\r\n" + //
                  "    <label for=\"yes\">Yes</label>\r\n" + //
                  "    <input type=\"radio\"  name=\"training\" value=\"No\" required>\r\n" + //
                  "    <label for=\"no\">No</label>\r\n" + //
                  "</li>\r\n" + //
                  "<li> \r\n" + //
                  "<label for=\"doj\">Date Of Join:</label>\r\n" + //
                  "<input type=\"date\" name=\"doj\" min=\"2023-01-01\" required  oninvalid=\"this. setCustomValidity('Select the date of joining')\">\r\n" + //
                  "</li>\r\n" + //
                  "<li> \r\n" + //
                  "<label for=\"phone\">Phone:</label>\r\n" + //
                  "<input type=\"text\" name=\"phone\"  maxlength=\"10\" minlength=\"10\" oninvalid=\"this. setCustomValidity('Enter valid phone number')\">\r\n" + //
                  "</li>\r\n" + //
                  "<li class=\"btnn\"> \r\n" + //
                  "<button type=\"submit\">Submit</button>\r\n" + //
                  "</li>\r\n" + //
                  "</ul>\r\n" + //
                  "<input type=\"number\" name=\"id\" id=\"id\" value=\""+ id +"\" hidden></form>\r\n" + //
                  "\r\n" + //
                  "</body>\r\n" + //
                  "</html>");
      out.close();
      /* Write the response message, in an HTML page
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>Hello, World</title><script src=\"script.js\"></script><link rel=\"stylesheet\" href=\"style.css\"></head>");
      out.println("<body>");
      out.println("<h1>Form Submitted!</h1>");
      out.println("</body></html>");
      out.close(); 
      // Always close the output writer
      */
   }
}