package mail;
import ticket.assignvalues;
import ticket.passengerDetails;
public class Sendmsg {
	String nearst;
	
	static passengerDetails x=new passengerDetails();
	public Sendmsg()
	{
		
	}
  public Sendmsg(String a,passengerDetails pd)
  { 
	nearst=a;  
	x=pd;
  }
  public String  sendtext()
  {   
	  return "ID:"+x.getId()+"\nNAME:"+x.getName()+"\nSTARTING:"+x.getStarting()+"\nALTERNATIVE:"+nearst+"\nDESTINATION:"+x.getDestination()+"\n TicketConfirmed with an Alternative route";
  }
}
