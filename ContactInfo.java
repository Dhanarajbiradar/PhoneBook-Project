package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ContactInfo {
	
	private int srno;
	private String name,mob;
	

	public ContactInfo() {
		super();
	}


	public ContactInfo(int srno, String name, String mob) {
		super();
		this.srno = srno;
		this.name = name;
		this.mob = mob;
	}


	public int getSrno() {
		return srno;
	}


	public void setSrno(int srno) {
		this.srno = srno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMob() {
		return mob;
	}


	public void setMob(String mob) {
		this.mob = mob;
	}


	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			Statement s=con.createStatement();		
	        Scanner s1=new Scanner(System.in);
	        int rep=0;
	        while(rep==0)
	        {
			System.out.println("1)Insert Contacts");
			System.out.println("2)Update Contact");
			System.out.println("3)Delete Contact");
			System.out.println("4)display Contact");
			System.out.println("5)Search Contact\n");
			System.out.println("select option you want to exicute");
			int ch=s1.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Insert Data:");
				System.out.println("Enter Srno :");
				int srno=s1.nextInt();	
				System.out.println("Enter Name :");
				String name=s1.next();	
				System.out.println("Enter Mobile NO :");
				String mobileno=s1.next();	
				ContactInfo ct=new ContactInfo(srno, name, mobileno);
				
				int n1=s.executeUpdate("insert into ContactInfo values("+ct.getSrno()+",\""+ct.getName()+"\",\""+ct.getMob()+"\")");
				if(n1>0)
				{
					System.out.println("Data inserted successefully");
				}
				else {
					System.out.println("Data not inserted");
				}
			   break;
			   
			case 2:
				System.out.println("Update Data:");
				System.out.println("1)Update Name.");
				System.out.println("2)Update MobileNO.");
				System.out.println("3)update MobileNo and Name.");
				System.out.println("select option you want to update");
				int ch1=s1.nextInt();
				switch(ch1)
				{
				case 1:
					System.out.println("update Name");
					System.out.println("Enter Srno you want to upadate");
					int srnou=s1.nextInt();	
					System.out.println("Enter Name:");
					String nameu=s1.next();
					
					int n2=s.executeUpdate("update ContactInfo set name='"+nameu+"' where srno="+srnou+"");
					if(n2>0)
					{
						System.out.println("Data Update successefully");
						
						System.out.println("if you see your updated contact then press 1 Esle 0.");
						int  c;
						c=s1.nextInt();
						if(c==1) {
							ResultSet rs=s.executeQuery("select*from ContactInfo where srno="+srnou+"");
							while(rs.next())
								{
									System.out.println("SRNO :"+rs.getInt(1)+"  Name :"+rs.getString(2)+"  MobileNO :"+rs.getString(3));
								}
						}else {
							
						}
					}
					else {
						System.out.println("Data not update!");
					}
					break;
					
					
				case 2:
					System.out.println("update MobileNO");
					System.out.println("Enter Srno you want to upadate:");
					int srnoum=s1.nextInt();	
					System.out.println("Enter MobileNO:");
					String mobileu=s1.next();
					
					int n3=s.executeUpdate("update ContactInfo set mob='"+mobileu+"' where srno="+srnoum+"");
					if(n3>0)
					{
						System.out.println("Data Update successefully");
						System.out.println("if you see your updated contact then press 1) Esle 0)");
						int  c;
						c=s1.nextInt();
						if(c==1) {
							ResultSet rs=s.executeQuery("select*from ContactInfo where srno="+srnoum+"");
							while(rs.next())
								{
									System.out.println("SRNO :"+rs.getInt(1)+"  Name :"+rs.getString(2)+"  MobileNO :"+rs.getString(3));
								}
						}else {
							
						}
						
					}
					else {
						System.out.println("Data not update!");
					}
					break;
					
				case 3:
					System.out.println("Update Mobileno and Name:");
					System.out.println("Enter Srno you want to upadate:");
					int srnoub=s1.nextInt();
					
					System.out.println("Enter Name:");
					String nameub=s1.next();
					
					System.out.println("Enter MobileNO:");
					String mobileub=s1.next();
					int n4=s.executeUpdate("update ContactInfo set name='"+nameub+"',mob='"+mobileub+"' where srno="+srnoub+"");
					
					if(n4>0)
					{
						System.out.println("Data Update successefully");
						System.out.println("if you see your updated contact then press 1) Esle 0)");
						int  c;
						c=s1.nextInt();
						if(c==1) {
							ResultSet rs=s.executeQuery("select*from ContactInfo where srno="+srnoub+"");
							while(rs.next())
								{
									System.out.println("SRNO :"+rs.getInt(1)+"  Name :"+rs.getString(2)+"  MobileNO :"+rs.getString(3));
								}
						}else {
							
						}
						
					}
					else {
						System.out.println("Data not update!");
					}
					
					break;
					
					default:
						System.out.println("Enter valid Option:");
						
					
				}
				
				 break; 
			case 3:
				System.out.println("Delete query:");
				System.out.println("Enter srno for delete record:");
				int srnod=s1.nextInt();
			    int n4=s.executeUpdate("delete from ContactInfo where srno="+srnod+"");
				  if(n4>0)
					{
						System.out.println("Data deleted successefully");
					}
					else {
						System.out.println("Data not deleted!");
					}
					break;
				 
			case 4:
				int countr=0;
				System.out.println("Select query");
				ResultSet rs=s.executeQuery("select*from ContactInfo");
				
				System.out.println("------------------------------------------------------");
				System.out.println("   SrNo    |     Names     |      Mobile NO");
				while(rs.next())
				{
					countr++;
					System.out.println("   "+rs.getInt(1)+"             "+rs.getString(2)+"            "+rs.getString(3));
				}
				System.out.println("------------------------------------------------------");
				System.out.println("                                  Total:"+countr+" Contact(s)");
				break;
				
			case 5:
				
				System.out.println("+-------------------------------+");
				System.out.println("1)Search from frist name");
					int countf=0;
	
					System.out.print("Enter Frist name");
					
					String fsrc=s1.next();
					ResultSet rs1=s.executeQuery(" select * from ContactInfo where name like '%"+fsrc+"%'");
					System.out.println("------------------------------------------------------");
					System.out.println("   SrNo    |     Names     |      Mobile NO");
					while(rs1.next())
					{
						countf++;
						System.out.println("   "+rs1.getInt(1)+"             "+rs1.getString(2)+"            "+rs1.getString(3));
					}
					System.out.println("------------------------------------------------------");
					if(countf>1)
					{
					System.out.println("\n*There are "+countf+" records are avaibles.");
					}else {
						System.out.println("\n*There is only "+countf+" record is avaible.");
					}
				
				break;
				 
			 }
			  System.out.println("\nEnter your choice 1 for Exit and 0 for main seting:");
			  rep=s1.nextInt();
	        }
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
