import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ses1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(request.getParameter("dummy").equals("n")){
		HttpSession session = request.getSession(true);

        // print session info

        Date created = new Date(session.getCreationTime());
        Date accessed = new Date(session.getLastAccessedTime());
        out.println("ID " + session.getId());
        out.println("Created: " + created);
        out.println("Last Accessed: " + accessed);

        // set session info if needed
		String[] p = request.getParameterValues("product");
		//out.println(request.getParameter("product"));
        //if (p != null && p.length() > 0) {
           // String dataValue = request.getParameter("dataValue");
            session.setAttribute("product", p);
        }
		

        // print session contents

		else if(request.getParameter("dummy").equals("s")){
			HttpSession session = request.getSession(false);
			if(session!=null)
			{
        String[] e = (String[])session.getAttribute("product");
		for(int i=0;i<e.length;i++)
			{
        	out.println("u have selected");
            String name = (String)e[i];
            //String value = session.getAttribute(name).toString();
            out.println("product= " + name+"    ");
        }
    }
		}
}
	}
