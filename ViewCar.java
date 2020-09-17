package com.tilak.www;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.util.*;
import java.text.*;
import javax.servlet.http.*;
import java.io.*;
@WebServlet("/ViewCar")
public class ViewCar extends HttpServlet
{
	ResultSet rs;
	int row;
	protected void doGet(HttpServletRequest  req,HttpServletResponse res)throws ServletException,IOException,NullPointerException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			String sql;
			sql="select * from car";
			Statement st=con.createStatement();
			rs=st.executeQuery(sql);
			pw.println("<table cellspacing='0' width='900px' border='1'>");
			pw.println("<tr>");
			pw.println("<td>Company</td>");
			pw.println("<td>Model</td>");
			pw.println("<td>Color</td>");
			pw.println("<td>DOP</td>");
			pw.println("<td>Price</td>");
			pw.println("<td>Engine capacity</td>");
			pw.println("<td>Plate number</td>");
			pw.println("<td>Seating capacity</td>");
			pw.println("<td> Edit </td>");
			pw.println("<td> Delete </td>");
			pw.println("</tr>");
			while(rs.next())
			{
				pw.println("<tr>");
				pw.println("<td>" +rs.getString("COMPANY") + "</td>");
				pw.println("<td>" +rs.getString("MODEL") + "</td>");
				pw.println("<td>" +rs.getString("COLOR") + "</td>");
				pw.println("<td>" +rs.getString("DOP") + "</td>");
				pw.println("<td>" +rs.getInt("PRICE") + "</td>");
				pw.println("<td>" +rs.getString("ENGINECAPACITY") + "</td>");
				pw.println("<td>" +rs.getString("LPN") + "</td>");
				pw.println("<td>" +rs.getInt("SEATINGCAPACITY") + "</td>");
				pw.println("<td>" + "<a href='Editreturn?id=" + rs.getString("LPN") +"'> Edit </a>" + "</td>");
				pw.println("<td>" + "<a href='Delete?id=" + rs.getString("LPN") +"'> Delete </a>" + "</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
		}
		catch(Exception e)
		{
			pw.println("Exception occured" +e);
		}
	}
}





