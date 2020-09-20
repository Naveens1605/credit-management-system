import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/view")
public class view extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<html><head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>View Transaction</title>");
        out.println("<style>");
        out.println("h1 {");
        out.println("text-align: center;");
        out.println("color: green;");
        out.println("font-family: verdana;\n" +
                "  font-size: 300%;");
        out.println("}");
        out.println("body{");
        out.println("background-color: cyan;\n" +
                "  height: 900px;\n" +
                "  background-position: center;\n" +
                "  background-repeat: no-repeat;\n" +
                "  background-size: cover;\n" +
                "  position: relative;\n"+
                "}");
        out.println("table, th, td {\n" +
                "  border: 1px solid brown;\n" +
                "  border-collapse: collapse;\n" +
                "  margin:0px 150px;\n" +
                "}");
        out.println("td {\n" +
                "  padding: 15px;\n" +
                "text-align : center;\n" +
                "color : blue;\n" +
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
                "  margin: 10px 680px;\n" +
                "  border: none;\n" +
                "  border-radius: 4px;\n" +
                "  cursor: pointer;\n" +
                "}");
        out.println("input[type=submit]:hover {\n" +
                "  background-color: #45a049;\n" +
                "}");
        out.println("</style>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://aa1omd1rz8mbrqt.camjcfxnroyg.ap-southeast-2.rds.amazonaws.com:3306/creditManagement", "root", "8896513483");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from transaction ");
                out.println("<h1>Transaction History</h1></head>");
                out.println("<body><table width=80% height=5%>");
                out.println("<tr><th>S.No.</th><th>Transfer From</th><th>Transfer To</th><th>Credit Transferred</th></tr>");
                while (rs.next()) {
                    int p = rs.getInt("S.No");
                    String n = rs.getString("Transfer From");
                    String nm = rs.getString("Transfer To");
                    int s1 = rs.getInt("Credit Transferred");
                    out.println("<tr><td>" + p + "</td><td>" + n + "</td><td>" + nm + "</td><td>" + s1 + "</td></tr>");
                }
                out.println("</table>");
                out.println("<form action='Display' method='get'>");
                out.println("<input type='submit' value='View Details'></form>");
                out.println("</body></html>");
                con.close();
            } catch (Exception e) {
                out.println("Error:" + e);
            }
    }
}


