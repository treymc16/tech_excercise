import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Contact;
import util.UtilDBMcCormick;

@WebServlet("/ServletDBMcCormick")
public class ServletDBMcCormick extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public ServletDBMcCormick() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      
      // #2
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<Contact> listContacts = UtilDBMcCormick.listContacts();
      for (Contact contact : listContacts) {
          System.out.println("[DBG] " + contact.getId() + ", " //
                + contact.getName() + ", " //
                + contact.getCellNumber() + ", "
                + contact.getHomeNumber() + ", "
                + contact.getEmail() + ", "
                + contact.getAddress());

          out.println("<li>" + contact.getId() + ", " //
         		 + contact.getName() + ", " //
                  + contact.getCellNumber() + ", "
                  + contact.getHomeNumber() + ", "
                  + contact.getEmail() + ", "
                  + contact.getAddress() +  "</li>");
       }
      out.println("</ul>");
      
      out.println("<nav>");
      out.println("<a href=\"/tech_excercise_mccormick/search_mccormick.html\">Search Contacts</a> <br>");
      out.println("</nav>");
      out.println("<br />");
      
      out.println("<nav>");
      out.println("<a href=\"/tech_excercise_mccormick/insert_mccormick.html\">Add Contact</a> <br>");
      out.println("</nav>");
      out.println("<br />");
      
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
