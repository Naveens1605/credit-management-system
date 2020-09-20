import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/Display")
public class Main extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<!DOCTYPE html>");
        out.println("<html><Head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>View Details</title>");
        out.println("<style>");
        out.println("h1 {");
        out.println("text-align: center;");
        out.println("color:lime;");
        out.println("font-family: verdana;\n" +
                "  font-size: 300%;");
        out.println("}");
        out.println("body{");
        out.println("background-image:url('images/credit2.jpg');" +
                "background-color: #cccccc;\n" +
                "  height: 1000px;\n" +
                "  background-position: center;\n" +
                "  background-repeat: no-repeat;\n" +
                "  background-size: cover;\n" +
                "  position: relative;\n"+
                "}");
        out.println("table, th, td {\n" +
                "  border: 1px solid yellow;\n" +
                "  border-collapse: collapse;\n" +
                "  margin:0px 150px;\n" +
                "}");
        out.println("td {\n" +
                "  padding: 15px;\n" +
                "text-align : center;\n" +
                "color : black;\n" +
                        "font-family: verdana;\n" +
                        "  font-size: 115%;"+
                "}");
        out.println("th {\n" +
                "padding: 15px; +\n" +
                "text-align : center;\n" +
                "color : magenta;\n" +
                "font-family: verdana;\n" +
                "font-size: 130%;\n" +
                "}");
        out.println("input[type=submit] {\n" +
                "  width: 10%;\n" +
                "  background-color: #4CAF50;\n" +
                "  color: white;\n" +
                "  padding: 14px 0px;\n" +
                "  margin: 10px 670px;\n" +
                "  border: none;\n" +
                "  border-radius: 4px;\n" +
                "  cursor: pointer;\n" +
                "}");
        out.println("input[type=submit]:hover {\n" +
                "  background-color: #45a049;\n" +
                "}");
        out.println(".button {\n" +
                "  background-color: red;\n" +
                "  border: none;\n" +
                "  color: white;\n" +
                "  padding: 15px 32px;\n" +
                "  text-align: center;\n" +
                "  text-decoration: none;\n" +
                "  display: inline-block;\n" +
                "  font-size: 16px;\n" +
                "  margin: 0px 0px;\n" +
                "  cursor: pointer;\n" +
                "}");
        out.println(".button:hover {\n" +
                "  background-color: maroon;\n" +
                "}");
        out.println("</style>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://aa1omd1rz8mbrqt.camjcfxnroyg.ap-southeast-2.rds.amazonaws.com:3306/creditManagement", "root", "8896513483");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from user");
                out.println("<h1> Select the User from which Credit has to be send</h1></head>");
                out.println("<body><table width=80% height=5%>");
                out.println("<tr><th>S.No.</th><th>Name</th><th>Email</th><th>Credit</th><th>Transfer From</th></tr>");
                while (rs.next()) {
                    int p = rs.getInt("S.No");
                    String n = rs.getString("Name");
                    String nm = rs.getString("Email");
                    int s1 = rs.getInt("Credit");
                    out.println("<tr><td>" + p + "</td><td>" + n + "</td><td>" + nm + "</td><td>" + s1 + "</td><td><form action='Display' " +
                            "method='post'><button class='button' name='select' value=" + p + " >Select</button></form></td></tr>");
                }
                out.println("</table>");
                out.println("<form action='view' method='get'>");
                out.println("<input type='submit' value='View Transactions'></form>");
                out.println("</body></html>");
                con.close();
            } catch (Exception e) {
                out.println("Error:" + e);
            }
        }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<!DOCTYPE html>");
        out.println("<html><Head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>View Details</title>");
        out.println("<style>");
        out.println("h1 {");
        out.println("text-align: center;");
        out.println("color:orange;");
        out.println("font-family: verdana;\n" +
                "  font-size: 300%;");
        out.println("}");
        out.println("body{");
        out.println("background-image:url('images/credit2.jpg');" +
                "background-color: #cccccc;\n" +
                "  height: 900px;\n" +
                "  background-position: center;\n" +
                "  background-repeat: no-repeat;\n" +
                "  background-size: cover;\n" +
                "  position: relative;\n"+
                "}");
        out.println("table, th, td {\n" +
                "  border: 1px solid yellow;\n" +
                "  border-collapse: collapse;\n" +
                "  margin:0px 150px;\n" +
                "}");
        out.println("td {\n" +
                "  padding: 15px;\n" +
                "text-align : center;\n" +
                "color : black;\n" +
                "font-family: verdana;\n" +
                "  font-size: 115%;"+
                "}");
        out.println("th {\n" +
                "padding: 15px; +\n" +
                "text-align : center;\n" +
                "color : magenta;\n" +
                "font-family: verdana;\n" +
                "font-size: 130%;\n" +
                "}");
        out.println(".button {\n" +
                "  background-color: red;\n" +
                "  border: none;\n" +
                "  color: white;\n" +
                "  padding: 15px 32px;\n" +
                "  text-align: center;\n" +
                "  text-decoration: none;\n" +
                "  display: inline-block;\n" +
                "  font-size: 16px;\n" +
                "  margin: 0px 0px;\n" +
                "  cursor: pointer;\n" +
                "}");
        out.println(".button:hover {\n" +
                "  background-color: maroon;\n" +
                "}");
        out.println("</style>");
        int p = Integer.parseInt(req.getParameter("select"));
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://aa1omd1rz8mbrqt.camjcfxnroyg.ap-southeast-2.rds.amazonaws.com:3306/creditManagement", "root", "8896513483");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from user where not (`S.No` =" + p + ")");
                out.println("<h1>Select the User  which will receive the Credit</h1>");
                out.println("<body><table width=80% height=5%>");
                out.println("<tr><th>S.No.</th><th>Name</th><th>Email</th><th>Credit</th><th>Transfer To</th><tr>");
                while (rs.next()) {
                    int q = rs.getInt("S.No");
                    String n = rs.getString("Name");
                    String nm = rs.getString("Email");
                    int s = rs.getInt("Credit");
                    out.println("<tr><td>" + q + "</td><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td><td><form action='transfer' " +
                            "method='post'><button class='button' name='select' value=" + q + ">Select</button></form></td></tr>");
                }
                HttpSession session = req.getSession();
                ResultSet fs = stmt.executeQuery("select * from user where (`S.No` =" + p + ") ");
                while (fs.next()) {
                    String name1 = fs.getString("Name");
                    String email1 = fs.getString("Email");
                    int credit1 = fs.getInt("Credit");
                    session.setAttribute("name1", name1);
                    session.setAttribute("credit1", credit1);
                }
                session.setAttribute("p", p);
                out.println("</table>");
                out.println("</body></html>");
                con.close();
            } catch (Exception e) {
                out.println("Error:" + e);
            }

    }
}
