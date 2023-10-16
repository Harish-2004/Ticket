package ticketjspfiles;
import java.awt.*;
import javax.swing.*;
import mail.Sendmsg;
import ticket.passengerDetails;
import ticket.passengerService;
import java.awt.event.*;
public class Ticket extends JFrame implements ActionListener
{      JButton next,back;
    JTextField id,name,st,dt,emailid;
    JPasswordField pt;
    passengerService ps=new passengerService();
	 Ticket()
	 {
	   setLayout(null); 
       setTitle("WELCOME TO TRAIN TICKET BOOKING");
          setSize(800,600); 
           JLabel t=new JLabel("WELCOME TO BOOKING");
          t.setFont(new Font("Osward",Font.BOLD,38));
           t.setBounds(200,120,500,40);
           add(t);
           JLabel t2=new JLabel("EMAIL ID:");
           t2.setFont(new Font("Osward",Font.BOLD,25));
            t2.setBounds(100,250,200,40);
            add(t2);
           JLabel t3=new JLabel("NAME:");
           t3.setFont(new Font("Osward",Font.BOLD,25));
           t3.setBounds(100,300,200,40);
           add(t3);
           JLabel t4=new JLabel("STARTING:");
          t4.setFont(new Font("Osward",Font.BOLD,25));
           t4.setBounds(100,350,200,40);
           add(t4);
           JLabel t5=new JLabel("DESTINATION:");
          t5.setFont(new Font("Osward",Font.BOLD,25));
           t5.setBounds(100,400,200,40);
           add(t5);
           emailid=new JTextField();
           emailid.setBounds(300,250,300,40);
           add(emailid);
            name=new JTextField();
           name.setBounds(300,300,300,40);
           add(name);
           st=new JTextField();
           st.setBounds(300,350,300,40);
           add(st);
           dt=new JTextField();
           dt.setBounds(300,400,300,40);
           add(dt);
           setVisible(true);
           next=new JButton("NEXT");
           next.setBounds(250,450,100,30);
           next.addActionListener(this);
            add(next);
            back=new JButton("BACK");
            back.setBounds(150,450,100,30);
            back.addActionListener(this);
            add(back);
            setVisible(true);
	 }
	  public void actionPerformed(ActionEvent e)
	    {
	         
                   if(e.getSource()==next)
                   {  
                	   ps.Booking(new passengerDetails(12,name.getText(),st.getText(),dt.getText()),emailid.getText());
                   }
                   else if(e.getSource()==back)
                   {   
                	   setVisible(false);
                	   new Login().setVisible(true);
                   }
	    }
	 public static void main(String args[])
	    {
		  new Ticket();
	    }
}
