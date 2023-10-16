package ticket;
import java.util.*;
public class passengerService {
    List<passengerDetails> p=new ArrayList<>();
    ticketDataBase db=new ticketDataBase();
    public void signup(String x,String y,String z)
    {  
    	db.Signup(x,y,z);
    	
    }
    public boolean login(String x,String y)
    {  System.out.println(2);
    	return db.Login(x,y);
    }
    public void Booking(passengerDetails pd,String s)
    {
        db.booked(pd,s);
    }
   public List<passengerDetails> alldetails()
   {
       return db.getall();
   }
    public int count(String x)
    {
    	return db.counting(x);
    }
}
