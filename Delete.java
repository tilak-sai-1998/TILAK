package com.tilak.www;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.util.*;
import java.text.*;
import javax.servlet.http.*;
import java.io.*;
@WebServlet("/Delete")
public class Delete extends HttpServlet
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
			PreparedStatement ps=con.prepareStatement("delete from car where LPN=?");
			ps.setString(1,eid);
			row=ps.executeUpdate();
			if(row==0)
				pw.println("<font color='red'>Records not Deleted</font>");
			
			else
				pw.println("<font color='green'>Records Deleted</font>");
			
		}
		catch(Exception e){
				pw.println("Sorry Exception occured" +e);
				e.printStackTrace();
			}
			
			pw.close();
		}


}
