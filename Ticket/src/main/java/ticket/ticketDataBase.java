package ticket;
import java.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import mail.Sendmsg;

public class ticketDataBase {
    Connection conn=null;
    int abx=5;
    public ticketDataBase() throws RuntimeException {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "1111");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void add(passengerDetails pd)
    {   
        String query="insert into passengerbooking (name,starting,destination) values (?,?,?)";
        try {
            PreparedStatement st;
            st = conn.prepareStatement(query);
            st.setString(1,pd.getName());
            st.setString(2,pd.getStarting());
            st.setString(3,pd.getDestination());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<passengerDetails>  getall()
    {      String query="select id,name,starting,destination from passengerbooking ";
        List<passengerDetails> p=new ArrayList<>();
        try {
            PreparedStatement st;
            st = conn.prepareStatement(query);
            ResultSet rs= st.executeQuery();

            while(rs.next())
            {   passengerDetails pd=new passengerDetails();
                pd.setId(Integer.parseInt(rs.getString(1)));
                pd.setName(rs.getString(2));
                pd.setStarting(rs.getString(3));
                pd.setDestination(rs.getString(4));
                p.add(pd);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       return p;
    }
    public void Signup(String x,String y,String z)
    {     System.out.println(x+" "+y+" "+z);
    	  String query="insert into login (name,emailid,password) values (?,?,?)";
          try {
              PreparedStatement st;
              st = conn.prepareStatement(query);
              st.setString(1,x);
              st.setString(2,y);
              st.setString(3,z);
              st.execute();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
    }
    public boolean Login(String x,String y)
    {
    	 System.out.println(x+" "+y);
    	 int z=1;
    	String query="select emailid,password from login ";
    	System.out.println(query);
        try {
        	PreparedStatement st;
       	 st = conn.prepareStatement(query);
       	 ResultSet rs= st.executeQuery();
            while(rs.next()) {
               
                if(x.equals(rs.getString(1)) && y.equals(rs.getString(2)))
               		 {   
               	          return z==1;
               		 }
            }
          return z!=1;  
        } 
		catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     public int counting(String x)
     { int count=0;
     try {
     String query = "select count(*) from "+x;
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery(query);
     rs.next();
      count = rs.getInt(1);
     System.out.println("Number of records in the  passengerbooking table: "+count);
     }catch(Exception e) {}
         
    	 return count;
     }
     public List<stationassign> data()
     {   String query="select stations,value from train";
    	 List<stationassign>s=new ArrayList<>();
    	 try {
             PreparedStatement st;
             st = conn.prepareStatement(query);
             ResultSet rs= st.executeQuery();

             while(rs.next())
             {   stationassign k=new stationassign(rs.getString(1),Integer.parseInt(rs.getString(2)));
                 s.add(k);

             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
    	 return s;
     }
     public void booked(passengerDetails pd,String email)
     {  int b=0;
       
       b=counting("passengerbooking");
      System.out.println(b);
       System.out.println(abx);
       if(b<abx)
       { System.out.println("add");
    	add(pd);
       }
       else
       {   System.out.println("subtract");
    	   List<assignvalues> k=new ArrayList<>();
          List<stationassign> statassign=new ArrayList<>();
          statassign=data();
          List<passengerDetails>pd1=new ArrayList<>();
          pd1=getall();
    	  assignvalues agv=new assignvalues();
    	   for(int i=0;i<b;i++)
    	   {  assignvalues imp=new assignvalues();
    		  for(int j=0;j<7;j++)
    		  {  
    			  if(pd1.get(i).getStarting().equals(statassign.get(j).station))
    			  {

    				   imp.setst(statassign.get(j).value,statassign.get(j).station);
    			  }
    			  if(pd1.get(i).getDestination().equals(statassign.get(j).station))
    			  {
    				  imp.setdt(statassign.get(j).value,statassign.get(j).station);  
    			  }
    			  if(pd.getStarting().equals(statassign.get(j).station))
    					  {
    				          agv.setst(statassign.get(j).value,statassign.get(j).station);
    					  }
    			  if(pd.getDestination().equals(statassign.get(j).station))
    					  {
    				          agv.setdt(statassign.get(j).value,statassign.get(j).station);
    					  }
    			  
    		  }
    		  k.add(imp);
    	   }
    	   agv.check(pd,k,email);
    
     }
     }
     }
