package com.user.controller;

import java.util.Scanner;
import com.user.beans.User;
import com.user.services.Services;
import com.user.services.ServicesImpl;
import com.user.services.ServicesImplJDBC;

public class UserController {
	static Services ser;
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		User user;
		
		//option to store the Data
		System.out.println("Select a option to store data");
		System.out.println("1.Collection\n2.SQL");
		int cho=sc.nextInt();
			switch(cho){
			case 1:
				//creating object of service for collection 
				ser=new ServicesImpl();
				break;
			case 2:
				//creating object of service for SQL 
				ser=new ServicesImplJDBC();
				break;
				default:
					System.out.println("Plz enter correct option");
			}
		
		boolean c=true;
		while(c){
			//options to perform different operation  
			System.out.println("Enter a choice");
			System.out.println("1.Create user Profile");
			System.out.println("2.Get User Details");
			System.out.println("3.Update User");
			System.out.println("4.Delete User");
			System.out.println("5.exit");
			int ch=sc.nextInt();
			switch(ch){
			case 1:
				//create user profile
				user=new User();
				
				System.out.println("Enter the user id:");
				user.setId(sc.nextInt());
				System.out.println("Enter the Name");
				user.setUsername(sc.next());
				System.out.println("Enter the email");
				user.setEmail(sc.next());
				System.out.println("Enter the password");
				user.setPassword(sc.next());
				
				boolean res=ser.addUser(user);
				if(res){
					System.out.println("User Registration successfully");
				}
				else{
					System.err.println("User already exists");
				}
				break;
			case 2:
				//get user detail on passing id
				System.out.println("Enter the user id:");
				user=ser.getUser(sc.nextInt());
				if(user!=null){
					System.out.println(user);
				}
				else{
					System.err.println("No user found");
				}
				break;
			case 3:
				//update user data
				user=new User();
				
				System.out.println("Enter the user id:");
				user.setId(sc.nextInt());
				System.out.println("Enter the Name");
				user.setUsername(sc.next());
				System.out.println("Enter the email");
				user.setEmail(sc.next());
				System.out.println("Enter the password");
				user.setPassword(sc.next());
				
				boolean up=ser.updateUser(user);
				if(up){
					System.out.println("User Updated successfully");
				}
				else{
					System.err.println("User Updation Failed");
				}
				break;
			case 4:
				//delete user data
				System.out.println("Enter the user id:");
				int iddel=sc.nextInt();
				boolean del=ser.deleteUser(iddel);
				if(del){
					System.out.println("User Deleted");
				}
				else{
					System.err.println("No user found with id "+iddel);
				}
				break;
			case 5:
				//exit 
				sc.close();
				c=false;
				break;
				
				default:
					System.err.println("Plz enter correct options");
			}
			
		}		


	}

}
