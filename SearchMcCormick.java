import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Contact;
import util.InfoMcCormick;
import util.UtilDBMcCormick;

@WebServlet("/SearchMcCormick")
public class SearchMcCormick extends HttpServlet implements InfoMcCormick {
   private static final long serialVersionUID = 1L;

   public SearchMcCormick() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

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

      List<Contact> listContacts = null;
      if (keyword != null && !keyword.isEmpty()) {
         listContacts = UtilDBMcCormick.listContacts(keyword);
      } else {
         listContacts = UtilDBMcCormick.listContacts();
      }
      display(listContacts, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Contacts</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Contact> listContacts, PrintWriter out) {
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
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
