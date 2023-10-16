
package ticketjspfiles;
import javax.swing.*;

import ticket.passengerService;

import java.awt.*;
import java.awt.event.*;
public class Signupone extends JFrame implements ActionListener{
    JTextField nt,dt,et;
    JRadioButton yes,no;
    long  ra;
     JButton next,back;
    Signupone()
    {
          setLayout(null);
          setSize(800,800);
        JLabel p=new JLabel("Personal details");
        p.setFont(new Font("Raleway",Font.BOLD,30));
        p.setBounds(240,80,600,30);
        add(p);
        
         JLabel n=new JLabel("Name :");
        n.setFont(new Font("Raleway",Font.BOLD,22));
        n.setBounds(130,170,300,20);
        add(n);
        
        nt=new JTextField();
        nt.setBounds(350,170,300,25);
        add(nt);
        JLabel dob=new JLabel("Email:");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(130,220,300,20);
        add(dob);
        dt=new JTextField();
        dt.setBounds(350,220,300,25);
        add(dt);
        JLabel g=new JLabel("password :");
        g.setFont(new Font("Raleway",Font.BOLD,22));
        g.setBounds(130,270,600,20);
        add(g);
        et=new JTextField();
        et.setBounds(350,270,300,25);
        add(et);
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
        
        try
        {   if (e.getSource()==back)
        	{
        	setVisible(false);
            new Login().setVisible(true);
        	}
            else  if(nt.getText().equals(""))
            { JOptionPane.showMessageDialog(null,"Name is required");}
            if(e.getSource()==next)
            {  
               passengerService p=new passengerService();
               p.signup(nt.getText(),dt.getText(),et.getText());
               setVisible(false);
               new Login().setVisible(true);
               }
        }
        catch(Exception e1){}
    }
    public static void main(String arg[])
    {
        new Signupone();
    }
    
}
