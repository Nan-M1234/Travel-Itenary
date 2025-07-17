import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.sql.*;

import java.util.*
;
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/<html>");
		PrintWriter out = response.getWriter();
//		out.println("starting point");
//		out.println("<html>");
//		out.println("<body>");
		String UserName = request.getParameter("username");
		String Password = request.getParameter("pass");
		String Aadhar = request.getParameter("aadhar");
//		out.println("hello1");
		String Email= request.getParameter("email");
//		out.println("hello1");
		
		String Phone= request.getParameter("phone");
//		out.println("phone:"+Phone);
		
		String Address= request.getParameter("address");
//		out.println("hello2");
		String TripName = request.getParameter("tripName");
//		out.print("doub t");
		String TripStartDate= request.getParameter("tripSTA");
		String TripEndDate= request.getParameter("tripEnD");
//		out.println("doubt2");
		
//		out.println("bye");
		String Vehicle= request.getParameter("travelType");
		String HotelCheckIn= request.getParameter("hotChIn");
		String HotelCheckOut= request.getParameter("hotChOu");
		String HotelType= request.getParameter("hotelType");
//		out.println("starting point");
		
		
		
		
		try {
//			out.println("mysql1");
			Class.forName("com.mysql.cj.jdbc.Driver");
//		    out.println("mysql2");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","Vinayinsta@");
//			out.println("mysql4");
			PreparedStatement pst= con.prepareStatement("update user_table set  user_name=?, Password=?,Aadhar_Number=?,user_Email=?,Phone_number=?,user_Address=? where  user_id=?");
			PreparedStatement pst2 = con.prepareStatement("update trip_table set trip_name=?,trip_Startdate=?,Trip_Enddate=? where trip_id=?");
 			PreparedStatement pst3 = con.prepareStatement("update transportation_table set Trans_type=? where Trans_id=?");
			PreparedStatement pst4 = con.prepareStatement("update hotel_table set hotel_checkindate=?,hotel_checkoutdate=?, hotel_roomtype=? where hotel_id=? ");
//			out.println("mysql3");
			pst.setString(1,UserName);
			pst.setString(2,Password);
			pst.setString(3, Aadhar);
			pst.setString(4,Email);
			pst.setString(5,Phone);
		    pst.setString(6,Address);
			//Scanner obj = new Scanner(System.in);
			//System.out.println("enter your user id: ");
			//int user_id = obj.nextInt();
			pst.setInt(7, 1);
			
			
			pst2.setString(1,TripName);
            pst2.setString(2,TripStartDate);
            pst2.setString(3,TripEndDate);
            
            //Scanner sc = new Scanner(System.in);
            //System.out.println("enter your trip id: ");
            //int id=sc.nextInt();
            pst2.setInt(4, 100);
            
            // Transid is 400
            pst3.setString(1,Vehicle);
           // Scanner tid = new Scanner(System.in);
            //System.out.println("enter your Trans-id: ");
            //int  TransId=tid.nextInt();
            pst3.setInt(2,400);
            
            
            // hotel_id start from 600
           pst4.setString(1,HotelCheckIn);
           pst4.setString(2, HotelCheckOut);
           pst4.setString(3,HotelType);
           //Scanner nx =new Scanner(System.in);
           //System.out.println("enter your hotel-id: ");
           //int hotelId = nx.nextInt();
           pst4.setInt(4,600);
            
			
			
//			out.println("hello");
			int x = pst.executeUpdate();
			int y = pst2.executeUpdate();
			int z = pst3.executeUpdate();
			int v = pst4.executeUpdate();
			if(x>0) {
				out.println("Recorded successfully");
			}
			if(y>0) {
				out.println("Recorded successfully");
			}
			if(z>0) {
				out.println("Recorded successfully");
			}
			if(v>0) {
				out.println("Recorded successfully");
			}
			else {
				out.println("not inserted");
			}
			
//			PreparedStatement pst1 = con.prepareStatement("SELECT *FROM trip_table");
//			out.println("vina");
//			ResultSet rs = pst1.executeQuery();
//			out.println("<h1>");
//			
//			while(rs.next()) {
//				out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getInt(7));
//			
//			}
			con.close();
//			out.println("</h1>");
			
			
		}
		catch(Exception e) {
				
		}
//		out.println("</body></html>");		
		
		
	}

}

