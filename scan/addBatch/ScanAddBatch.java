package com.arkin.scan.addBatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ScanAddBatch {
	
	String url="jdbc:oracle:thin:@172.16.1.37:1521/db11";
	String username="butchibv";
	String passwaord="butchibv_123";
	PreparedStatement pdScan=null;
	Connection conScan=null;
	void scanBatch() throws SQLException{
		conScan=DriverManager.getConnection(url, username, passwaord);
		PreparedStatement pdScan=conScan.prepareStatement("INSERT INTO BIKEDETAILS VALUES(?,?,?,?,?)");
		
		Scanner scanvalue=new Scanner(System.in);
		System.out.println("enter cc");
		int cc=scanvalue.nextInt();
		pdScan.setInt(1, cc);
		System.out.println("enter model");
		String mod=scanvalue.next();
		pdScan.setString(2, mod);
		System.out.println("enter brand");
		String brand=scanvalue.next();
		pdScan.setString(3, brand);
		System.out.println("enter speed");
		int speed=scanvalue.nextInt();
		pdScan.setInt(4, speed);
		System.out.println("enter name");
		String name=scanvalue.next();
		pdScan.setString(5, name);
		 
		pdScan.addBatch();
//		System.out.println("enter cc");
//		int cc1=scanvalue.nextInt();
//		pdScan.setInt(1, cc1);
//		System.out.println("enter model");
//		String mod1=scanvalue.next();
//		pdScan.setString(2, mod1);
//		System.out.println("enter brand");
//		String brand1=scanvalue.next();
//		pdScan.setString(3, brand1);
//		System.out.println("enter speed");
//		int speed1=scanvalue.nextInt();
//		pdScan.setInt(4, speed1);
//		System.out.println("enter name");
//		String name1=scanvalue.next();
//		pdScan.setString(5, name1);
//		
//		pdScan.addBatch();
		
		
		
		
		int[] result=pdScan.executeBatch();
		System.out.println("fine"+result);
		scanvalue.close();
		
		
	}
		void delte() throws SQLException{
			conScan=DriverManager.getConnection(url, username, passwaord);
			
			
			
			Statement strt = conScan.createStatement();
			String table = "SELECT * FROM  BIKEDETAILS";
			ResultSet rs = strt.executeQuery(table);
			while (rs.next()) {

				System.out.println(rs.getInt(1) + "	" + rs.getString(2) + "	" + rs.getString(3) + "	" + rs.getInt(4)
						+ "	" + rs.getString(5));}

			
			
			
			
		pdScan=conScan.prepareStatement("delete from BIKEDETAILS where BIKECC=? ");
		System.out.println("enter for delete bike cc");
		Scanner scant=new Scanner(System.in);
		int deleteCc=scant.nextInt();
		
		pdScan.setInt(1, deleteCc);
		pdScan.addBatch();
		
		int[] deletResult=pdScan.executeBatch();
		System.out.println(deletResult+"delete");
	
		scant.close();
	}
	
	
	
	
	public static void main(String[] args) throws SQLException {
		ScanAddBatch sab=new ScanAddBatch();
		Scanner scan= new Scanner(System.in);
		
		System.out.println("do you want insert option 1"+"\n"+"do you want delete option 2");
		int val=scan.nextInt();
		switch (val) {
		case 1:
			System.out.println("how many rows do you want to enter just give value ");
			Scanner sw=new Scanner(System.in);
			int inter=sw.nextInt();
			int i=0;
			
			do{
				sab.scanBatch();
				i++;
			}while(i<inter);
				
			break;
			
		case 2:
			System.out.println("how many rows do you want to delete just give value ");
			Scanner sw1=new Scanner(System.in);
			int inter2=sw1.nextInt();
			int i1=0;
			
			do{
				sab.delte();
				i1++;
			}while(i1<inter2);
				
			break;
			
		}
		
		
		  
scan.close();
		
		
	}

}
