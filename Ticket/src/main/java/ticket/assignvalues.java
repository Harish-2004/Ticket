package ticket;
import java.util.ArrayList;
import mail.*;
import java.util.List;
import java.lang.Math;

public class assignvalues {
	int st;
	String stname;
	int dt;
	String dtname;
	ticketDataBase db=new ticketDataBase();
	assignvalues()
	{
		
	}
	assignvalues(int x,int y,String a,String b)
	{
		st=x;
		dt=y;
		stname=a;
		dtname=b;
	}
	public void setst(int x,String a)
	{
		st=x;
		stname=a;
		
	}
	public void setdt(int y,String b)
	{
		dt=y;
		dtname=b;
	}
	public void check(passengerDetails pd,List <assignvalues> a,String s)
	{  System.out.println(a);
	   System.out.println(st);
		int n=a.size();
	      int  min=1000;
	       int x=0;
		for(int i=0;i<n;i++)
		{
			if(Math.abs(st-a.get(i).dt)<min )
			{
				min=Math.abs(st-a.get(i).dt);
				x=i;
			}
		}
		System.out.println("near="+x+" "+a.get(x).dt+" "+a.get(x).dtname);
		
       Sendmsg S=new Sendmsg(a.get(x).dtname,pd);
       System.out.println(S.sendtext());
      new sendemail(S.sendtext(),s);
	}
	
	@Override
	public String toString()
	{
		return st+" "+dt+"\n";
	}
}
