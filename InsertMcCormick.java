import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.InfoMcCormick;
import util.UtilDBMcCormick;

@WebServlet("/InsertMcCormick")
public class InsertMcCormick extends HttpServlet implements InfoMcCormick {
   private static final long serialVersionUID = 1L;

   public InsertMcCormick() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name").trim();
      String cellNum = request.getParameter("cellNumber").trim();
      String homeNum = request.getParameter("homeNumber").trim();
      String email = request.getParameter("email").trim();
      String address = request.getParameter("address").trim();
      UtilDBMcCormick.createContacts(name, cellNum, homeNum, email, address);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      out.println("<li> Name: " + name);
      out.println("<li> Cell Number: " + cellNum);
      out.println("<li> Home Number: " + homeNum);
      out.println("<li> Email: " + email);
      out.println("<li> Address: " + address);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
