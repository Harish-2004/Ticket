
package ticketjspfiles;

import javax.swing.*;

import ticket.passengerService;

import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener {
    JButton login,clear,sup;
    JTextField ct,pt;
    JLabel t1,t2;
    passengerService ps=new passengerService();
    
    Login()
    {   
        setLayout(null);
    
        setTitle("WELCOME TO TRAIN TICKET BOOKING");
           //  ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/Untitled.jpeg"));
             //Image i1=i.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            // ImageIcon i2=new ImageIcon(i1);
             //JLabel l=new JLabel(i2);
             //l.setBounds(70,100,100,100);
             //add(l);
             //getContentPane().setBackground(Color.WHITE);
           setSize(800,600);
            
            JLabel t=new JLabel("WELCOME TO LOGIN");
            t.setFont(new Font("Osward",Font.BOLD,38));
            t.setBounds(200,120,500,40);
            add(t);
            t1=new JLabel("Email Id");
            t1.setFont(new Font("Osward",Font.BOLD,25));
            t1.setBounds(160,250,200,40);
            add(t1);
            t2=new JLabel("Password");
            t2.setFont(new Font("Osward",Font.BOLD,25));
            t2.setBounds(160,350,200,40);
            add(t2);
             ct=new JTextField();
            ct.setBounds(300,250,300,40);
            add(ct);
             pt=new JTextField();
            pt.setBounds(300,350,300,40);
            add(pt);
            login=new JButton("Sign In");
            login.setBounds(260,420,80,40);
           login.addActionListener(this);
            add(login);
            
            clear=new JButton("Clear");
            clear.setBounds(400,420,80,40);
          clear.addActionListener(this);
            add(clear);
           sup=new JButton("sign up");
            sup.setBounds(250,490,250,40);
           sup.addActionListener(this);
            add(sup);
             
             setVisible(true);
            
    }

    public void actionPerformed(ActionEvent e)
    {
         if(e.getSource()==clear)
         {
        	 ct.setText("");
             pt.setText("");
         }
         else if(e.getSource()==sup)
         {
           setVisible(false);
           new Signupone().setVisible(true);
          }
         else if(e.getSource()==login)
         { 
         
           try
           {     System.out.println(ct.getText()+" "+pt.getText());
                 if(ps.login(ct.getText(),pt.getText())&& ct.getText()!="" && pt.getText()!="")
                 { 
                     setVisible(false);
                      new Ticket().setVisible(true);
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"Incorrect credentials");
                 }
           }
           catch(Exception ex){}
         }
    }
    public static void main(String args[])
    {
        new Login();
    }


   
}
