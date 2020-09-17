package com.tilak.www;
import java.sql.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.annotation.*;
import java.text.*;
import javax.servlet.http.*;
import java.io.*;
@WebServlet("/Enter")
public class Enter extends HttpServlet
{
	protected void doPost(HttpServletRequest  req,HttpServletResponse res)throws ServletException,IOException,NullPointerException,NumberFormatException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//reading input from form
		String comp=req.getParameter("company");
		String model=req.getParameter("model");
		String color=req.getParameter("color");
		String  dt=req.getParameter("date");
		//convert string date to util date
		String p=req.getParameter("price");
		String eng=req.getParameter("engineCapacity");
		String lic=req.getParameter("plateNumber");
		String s=req.getParameter("seatingCapacity");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			String qry="insert into car values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qry);
			ps.setString(1,comp);
			ps.setString(2,model);
			ps.setString(3,color);
			SimpleDateFormat  sdf=new SimpleDateFormat("dd-mmm-yyyy");
		    java.util.Date  udoj=sdf.parse(dt);
		    long ms=udoj.getTime();
		    java.sql.Date sqld=new java.sql.Date(ms);
			ps.setDate(4,sqld);
		   long c=Long.parseLong(p);
		   int price=(int)c;
			ps.setInt(5,price);
			ps.setString(6,eng);
			ps.setString(7,lic);
			int seat=Integer.parseInt(s);
			ps.setInt(8,seat);
		    int result=ps.executeUpdate();
            if(result==0)
				pw.println("<font color='red'>Records not inserted</font>");
			
			else
				pw.println("<font color='green'>Records inserted</font>");
			
		}
		catch(Exception e){
				pw.println("Sorry Exception occured" +e);
				e.printStackTrace();
			}
			
			pw.close();
		}


}