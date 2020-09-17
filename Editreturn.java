package com.tilak.www;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.util.*;
import java.text.*;
import javax.servlet.http.*;
import java.io.*;
@WebServlet("/Editreturn")
public class Editreturn extends HttpServlet
{
	ResultSet rs;
	 int row;
	protected void doGet(HttpServletRequest  req,HttpServletResponse res)throws ServletException,IOException,NullPointerException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String eid=req.getParameter("id");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			PreparedStatement ps=con.prepareStatement("select * from car where LPN=?");
			ps.setString(1,eid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				pw.println("<form action='Editservlet' method='POST'");
				pw.println("<table>");
				pw.println("<tr><td>Company</td> <td><input type='text' name='company' id='company' value='"+rs.getString("company") +"'/></td></tr>");
				pw.println("<tr><td>Model</td> <td><input type='text' name='model' id='model' value='"+rs.getString("model") +"'/></td></tr>");
				pw.println("<tr><td>Color</td> <td><input type='text' name='color' id='color' value='"+rs.getString("color") +"'/></td></tr>");
				pw.println("<tr><td>Date of purchase</td> <td><input type='text' name='date' id='date' value='"+rs.getString("DOP") +"'/></td></tr>");
				pw.println("<tr><td>Price</td> <td><input type='text' name='price' id='price' value='"+rs.getInt("price") +"'/></td></tr>");
				pw.println("<tr><td>Engine capacity</td> <td><input type='text' name='engineCapacity' id='engineCapacity' value='"+rs.getString("ENGINECAPACITY") +"'/></td></tr>");
				pw.println("<tr><td>Licence plate number</td> <td><input type='text' name='plateNumber' id='plateNumber' value='"+rs.getString("LPN") +"'/></td></tr>");
				pw.println("<tr><td>Seating capacity</td> <td><input type='text' name='seatingCapacity' id='seatingCapacity' value='"+rs.getInt("SEATINGCAPACITY") +"'/></td></tr>");
				pw.println("<tr> <td colspan='2'><input type='submit' value='Update'/></td></tr>");
				pw.println("</table>");
				pw.println("</form>");
			}
		}
		catch(Exception e)
		{
			pw.println("Exception occured" +e);
		}
	}
}