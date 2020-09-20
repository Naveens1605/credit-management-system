import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/transfer")
public class Transfer extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>Transfer Credit</title>");
        HttpSession session = req.getSession();
        int q = Integer.parseInt(req.getParameter("select"));
        session.setAttribute("q", q);
        out.println("<html><head>");
        out.println("<style>");
        out.println("h1 {");
        out.println("text-align: center;");
        out.println("color:purple;");
        out.println("font-family: verdana;\n" +
                "  font-size: 300%;");
        out.println("}");
        out.println("body{");
        out.println("background-image:url('images/credit1.jpg');" +
                "background-color: #cccccc;\n" +
                "  height: 650px;\n" +
                "  background-position: center;\n" +
                "  background-repeat: no-repeat;\n" +
                "  background-size: cover;\n" +
                "  position: relative;\n" +
                "}");
        out.println("input[type=text], select {\n" +
                "  width: 35%;\n" +
                "  padding: 12px 20px;\n" +
                "  margin: 20px 470;\n" +
                "  display: inline-block;\n" +
                "  border: 1px solid #ccc;\n" +
                "  border-radius: 4px;\n" +
                "  box-sizing: border-box;\n" +
                "}");
        out.println("input[type=submit] {\n" +
                "  width: 10%;\n" +
                "  background-color: #4CAF50;\n" +
                "  color: white;\n" +
                "  padding: 14px 0px;\n" +
                "  margin: 0px 470px;\n" +
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
            ResultSet rs = stmt.executeQuery("select * from user where (`S.No` =" + q + ") ");
            while (rs.next()) {
                String name2 = rs.getString("Name");
                int s = rs.getInt("Credit");
                session.setAttribute("name2", name2);
                session.setAttribute("s", s);
            }
            out.println("<h1>Enter The Amount of Credit to be Transferred</h1></head>");
            out.println("<body><form action='transfer' method='get'><input type='text' name='credit' required=''><br>");
            out.println("<input type='submit' value='Transfer'></form>");
            out.println("</body></html>");
            con.close();
        } catch (Exception e) {
            out.println("Error:" + e);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<style>");
        out.println("h1 {");
        out.println("text-align: center;");
        out.println("color: yellow ;");
        out.println("font-family: verdana;\n" +
                "  font-size: 300%;");
        out.println("}");
        out.println("body{");
        out.println("background-image:url('images/credit.jpg');" +
                "background-color: #cccccc;\n" +
                "  height: 650px;\n" +
                "  background-position: center;\n" +
                "  background-repeat: no-repeat;\n" +
                "  background-size: cover;\n" +
                "  position: relative;\n" +
                "}");
        out.println("input[type=submit] {\n" +
                "  width: 10%;\n" +
                "  background-color: blue;\n" +
                "  color: white;\n" +
                "  padding: 14px 0px;\n" +
                "  margin: 0px 670px;\n" +
                "  border: none;\n" +
                "  border-radius: 4px;\n" +
                "  cursor: pointer;\n" +
                "}");
        out.println("input[type=submit]:hover {\n" +
                "  background-color: navy;\n" +
                "}");
        out.println("</style>");
        HttpSession session = req.getSession();
        int p = (int) session.getAttribute("p");
        int q = (int) session.getAttribute("q");
        int credit1 = (int) session.getAttribute("credit1");
        String temp = req.getParameter("credit");
        String name1 = (String) session.getAttribute("name1");
        String name2 = (String) session.getAttribute("name2");
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Pattern pattern1 = Pattern.compile("[A-Za-z]");
        Matcher match = pattern.matcher(temp);
        Matcher match1 = pattern1.matcher(temp);
        boolean val = match.find();
        boolean var = match1.find();
        if (val || var || Integer.parseInt(temp) == 0) {
            out.println("<html><head>");
            out.println("<h1>Can't Transfer " + temp + " credit!!!</h1></head>");
            out.println("<form action='Display' method='get'>");
            out.println("<body><input type='submit' value='View Details'></form>");
            out.println("<form action='view' method='get'>");
            out.println("<input type='submit' value='View Transactions'></form>");
            out.println("</body></html>");
        } else {
            int credit = Integer.parseInt(temp);
            if (credit <= credit1) {
                int s = (int) session.getAttribute("s");
                int d = credit1 - credit;
                int c = s + credit;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://aa1omd1rz8mbrqt.camjcfxnroyg.ap-southeast-2.rds.amazonaws.com:3306/creditManagement", "root", "8896513483");
                    Statement stmt = con.createStatement();
                    String query1 = "update user set Credit='" + d + "'where `S.No`='" + p + "'";
                    String query = "update user set Credit='" + c + "'where `S.No`='" + q + "'";
                    stmt.executeUpdate(query);
                    stmt.executeUpdate(query1);
                    String tran1 = "INSERT INTO `transaction`(`Transfer From`, `Transfer To`, `Credit Transferred`) VALUES ('" + name1 + "','" + name2 + "','" + credit + "')";
                    stmt.executeUpdate(tran1);
                    con.close();
                    out.println("<html><head>");
                    out.println("<h1>Transaction Successful !!!</h1></head>");
                    out.println("<form action='Display' method='get'>");
                    out.println("<body><input type='submit' value='View Details'></form>");
                    out.println("<form action='view' method='get'>");
                    out.println("<input type='submit' value='View Transactions'></form>");
                    out.println("</body></html>");
                } catch (Exception e) {
                    out.println(e);
                }
            } else {
                out.println("<html><head>");
                out.println("<h1>Insufficient Amount " + credit + " !!!</h1></head>");
                out.println("<form action='Display' method='get'>");
                out.println("<body><input type='submit' value='View Details'></form>");
                out.println("<form action='view' method='get'>");
                out.println("<input type='submit' value='View Transactions'></form>");
                out.println("</body></html>");
            }
        }
    }
}