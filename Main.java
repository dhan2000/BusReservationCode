package com.qualtechedge.BusReservationSystem.registration;
import com.qualtechedge.BusReservationSystem.dboperation.Dboperation;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Main {
	static ResourceBundle rb = ResourceBundle.getBundle("com.qualtechedge.BusReservationSystem.resource.application",Locale.US);
 static final Logger mainlogger= Logger.getLogger(Main.class.getName());
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String log4j = rb.getString("com.qualtechedge.BusReservationSystem.resource.log4j");
				PropertyConfigurator.configure(log4j);
				mainlogger.info("Successful");
				mainlogger.info("welcome");;
		//System.out.println("You are new user user..yes or no");
		mainlogger.info("You are new user user..yes or no");
		
		Dboperation del = new Dboperation();
		Dboperation ud = new Dboperation();
		if(sc.next().equalsIgnoreCase("no")) {
			Login  lg = new Login();
			lg.logIn();
			
//			System.out.println("You want to update profile ??");
//	           String n = sc.next();
//	           if(n.equalsIgnoreCase("yes")) {
//	        	   ud.updateOperation();
//	           }
//			System.out.println("Are you wnat to delete your account ??");
//			String dele = sc.next();
//			if(dele.equalsIgnoreCase("yes")) {
//				del.deleteOperation();
//			}
			
		}else {
		Registration a = new Registration();
		a.register();
//		System.out.println("You can log in now...");
		Login  lg = new Login();
		lg.logIn();
		
		}
	}

}
