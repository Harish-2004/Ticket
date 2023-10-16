package ticket;

public class stationassign {
	ticketDataBase db=new ticketDataBase();
	String station;
	int value;
	stationassign()
	{
		
	}
	stationassign(String y,int a)
	{
		station=y;
		value=a;
	}
	void assignstation(String y)
	{
		station=y;
	}
	void givevalue(int x)
	{
		value=x;
	}
	@Override
	public String toString()
	{
		return station+" "+String.valueOf(value);
	}

}
