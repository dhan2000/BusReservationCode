package com.qualtechedge.BusReservationSystem.busDetails;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.qualtech.BusReservationSystem.ticketConfirmation.Ticketconfirmation;
import com.qualtechedge.BusReservationSystem.connection.Dbconnection;

public class Busdetails {
	Scanner sc = new Scanner(System.in);
	Ticketconfirmation tc = new Ticketconfirmation();
    public void busDetails(String source,String destination,int t) {
    	Connection con = null;
    	try {
    		Dbconnection db = new Dbconnection(); 
       	 con = db.connection();
    		 Statement stmt = con.createStatement();
    		 
    		int i=0;
    		
    		 String sql = "select * from busdetails where Starting_from = '"+source+"' and destination = '"+destination+"'";
       		 ResultSet rs = stmt.executeQuery(sql);
    		 while(rs.next()) {
    			 String s = rs.getString("Starting_from");
    			 
    			String d = rs.getNString("destination");
    			 String bn = rs.getNString("Bus_No");
    			 String dep = rs.getString("Departure");
    			 String dis = rs.getString("Distance");
//   			 System.out.println("Start");
                 System.out.println(++i+" "+s+" "+d+" "+bn+" "+dep+" "+dis+"km");
    		    }
    		    System.out.println("Please enter your booking schedule date and time in yyyy-mm-dd hh:mm AM/PM format: ");
    			String scd = sc.nextLine();
    			System.out.println(scd);
    			String sl = "select Starting_from,destination,Bus_No from busdetails where departure = '"+scd+"'";
    		    tc.confirmTicket(sl, t, scd);
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
}
