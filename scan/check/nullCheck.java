package com.arkin.scan.check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class nullCheck {
	
	String url="jdbc:oracle:thin:@172.16.1.37:1521/db11";
	String username="butchibv";
	String passwaord="butchibv_123";
	PreparedStatement pdScan=null;
	
	
	@SuppressWarnings("resource")
	public int check() throws SQLException{
		Connection con=DriverManager.getConnection(url,username,passwaord);
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("enter value cc");

		int id=scan.nextInt();
		if(id>=1){
			pdScan=con.prepareStatement("INSERT INTO BIKEDETAILS VALUES(?,?,?,?,?)");
			System.out.println("enter crrct value");
				//Scanner scan2=new Scanner(System.in);
				//int cc=scan.nextInt();
				pdScan.setInt(1, id);
				
				System.out.println("enter model");
				String mod=scan.next();
				pdScan.setString(2, mod);
				System.out.println("enter brand");

				String brand=scan.next();
				pdScan.setString(3, brand);
				
				System.out.println("enter speed");

				int speed =scan.nextInt();
				pdScan.setInt(4, speed);
				
				System.out.println("enter name");

				String name=scan.next();
				pdScan.setString(5, name);
				
				scan.close();

				int result=pdScan.executeUpdate();
			System.out.println("bhy bye"+result);
		}else{
			System.out.println("enter correct value");
			
			return check();
		}
		
		
		
	return id;
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		nullCheck nck=new nullCheck();
		nck.check();
		
	}

}
