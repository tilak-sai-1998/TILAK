package com.tilak.www;
import java.sql.*;
import javax.servlet.*;
import java.util.*;
import java.text.*;
import javax.servlet.http.*;
import java.io.*;
public class Operation1 extends HttpServlet
{
	protected void doGet(HttpServletRequest  req,HttpServletResponse res)throws ServletException,IOException,NullPointerException{
		PrintWriter pw=res.getWriter();
		Scanner sc=new Scanner(System.in);
		res.setContentType("text/html");
		String input=req.getParameter("input");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			Statement st=con.createStatement();
			String mode=null;
			String qry=null;
		     if(input.equalsIgnoreCase("all cars")){
			     mode=req.getParameter("output");
			     qry="select * from car";
				ResultSet rs=st.executeQuery(qry);
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
				
			 }
			else if(input.equalsIgnoreCase("Year of purchase")){
				   String opt=req.getParameter("opt");
				    mode=req.getParameter("output");
				      if(opt.equalsIgnoreCase("Select a car")){
						    ResultSet rs=st.executeQuery("select * from car where to_char(DOP,'yyyy')='"+mode+"'");
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
					  }
						else if(opt.equalsIgnoreCase("Delete a car")){
						  int result=st.executeUpdate("delete  from car  where to_char(DOP,'yyyy')='"+mode+"'");
						  if(result==0)
							pw.println("No records deleted");
						  else
							pw.println("Records deleted");
						}
					}
			else if(input.equalsIgnoreCase("Model")){
				   String opt=req.getParameter("opt");
				   mode=req.getParameter("output");
				      if(opt.equalsIgnoreCase("Select a car")){
						  qry="select * from car where MODEL='"+mode+"'";
						  ResultSet rs=st.executeQuery(qry);
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
					}
					else if(opt.equalsIgnoreCase("Delete a car")){
						   qry="delete from car where MODEL='"+mode+"'";
						  int result=st.executeUpdate(qry);

						  if(result==0){
							pw.println(result);
							pw.println(mode);
						  }
						  else{
							pw.println(result);
						  }

						}
			          }
			else if(input.equalsIgnoreCase("color")){
                String opt=req.getParameter("opt");
				   mode=req.getParameter("output");
				      if(opt.equalsIgnoreCase("Select a car")){
						  qry="select * from car where COLOR='"+mode+"'";
						  ResultSet rs=st.executeQuery(qry);
                        
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
					  }
						else if(opt.equalsIgnoreCase("Delete a car")){
							qry="delete from car where COLOR='"+mode+"'";
						  int result=st.executeUpdate(qry);
						  if(result==0)
							pw.println("No records deleted");
						  else
							pw.println("Records deleted");
						}
						
					}
					else if(input.equalsIgnoreCase("Price Range")){
                String opt=req.getParameter("opt");
				    mode=req.getParameter("output");
				   String[] l=mode.split("-");
				    long p1=Integer.parseInt(l[0]);
					long p2=Integer.parseInt(l[1]);
				      if(opt.equalsIgnoreCase("Select a car")){
						  ResultSet rs=st.executeQuery("select  *  from car where price between '"+p1+
						  "'and'"+p2+"'");
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
					    }
						else if(opt.equalsIgnoreCase("Delete a car")){
						  int result=st.executeUpdate("delete  from car where price between '"+p1+
						  "'and'"+p2+"'");
						  if(result==0)
							pw.println("No records deleted");
						  else
							pw.println("Records deleted");
						}
						
					}
					else if(input.equalsIgnoreCase("Licence plate number")){
						String opt=req.getParameter("opt");
				    mode=req.getParameter("output");
				      if(opt.equalsIgnoreCase("Select a car")){
						  ResultSet rs=st.executeQuery("select  *  from car");
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
							String s=rs.getString("LPN");
							if(s.contains(mode)){
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
			         }

		}
					}
		}
             
			   catch(Exception e)
		       {
				   pw.println("Exception occured" +e);
			   }
			   
			   pw.close();
	}
}



