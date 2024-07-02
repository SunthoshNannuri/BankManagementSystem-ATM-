package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class pinchange extends JFrame implements ActionListener
{
    String pinnumber;
    JLabel text,card,pin,repin;
    JTextField cardtext;
    JButton login,clear;
    JPasswordField password,repassword;
    pinchange(String pinchange)
    {
        this.pinnumber=pinnumber;
 
     setLayout(null);
        
        text=new JLabel("PIN CHANGE");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        card=new JLabel("Card No:");
        card.setFont(new Font("Raleway",Font.BOLD,28));
        card.setBounds(100,200,200,40);
        add(card);
        cardtext=new JTextField();
        cardtext.setFont(new Font("Arial",Font.BOLD,15));
        cardtext.setBounds(250,208,250,30);
        add(cardtext);
        
        pin=new JLabel("Pin No:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(100,250,200,40);
        add(pin);
        password=new JPasswordField();
        password.setFont(new Font("Arial",Font.BOLD,15));
        password.setBounds(250,258,250,30);
        add(password);
         repin=new JLabel("new pin:");
        repin.setFont(new Font("Raleway",Font.BOLD,28));
        repin.setBounds(100,300,200,40);
        add(repin);
         repassword=new JPasswordField();
        repassword.setFont(new Font("Arial",Font.BOLD,15));
        repassword.setBounds(250,308,250,30);
        add(repassword);
        
        clear=new JButton("Clear");
        clear.setBounds(340,370,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
         login=new JButton("change");
        login.setBounds(200,370,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
          getContentPane().setBackground(Color.white);
        setTitle("ATM");
        setSize(800,480);
        setVisible(true);
        setLocation(580,270);
       
    }
         public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
           
            cardtext.setText("");
            password.setText("");
            repassword.setText("");
        }
        else if(ae.getSource()==login)
        {
      
            String pinnumber=password.getText();
             String cardnumber=cardtext.getText();
             String repinnumber=repassword.getText();
              conn c=new conn();
             String query="select * from login where pinnumber='"+pinnumber+"' and cardnumber='"+cardnumber+"'";
            try
            {
                 
                ResultSet rs=c.s.executeQuery(query); 
                if(rs.next())
                {
                    
                    String query1="update login set pinnumber='"+repinnumber+"' where cardnumber='"+cardnumber+"'";
            c.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null,"Pin Changed successfully");
                   setVisible(false);
                   new Login("").setVisible(true);
                }
                else
                {
                  
                    JOptionPane.showMessageDialog(null,"incorrect pinnumber or password");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        }
     public static void main(String args[])
    {
       new pinchange("");
    }
}

