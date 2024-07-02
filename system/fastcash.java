package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class fastcash extends JFrame implements ActionListener
{
    JButton deposite;
    JButton check;
    JButton fastcash,mini,pin,wdraw,back;
    String pinnumber;
    fastcash(String pinnumber)
    {
        this.pinnumber=pinnumber;
      
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel im=new JLabel(i3);
        add(im);
        
        deposite=new JButton("Rs.100");
        deposite.setBounds(170,400,130,30);
        im.add(deposite);
        deposite.addActionListener(this);
        wdraw=new JButton("Rs.500");
        wdraw.setBounds(170,440,130,30);
        im.add(wdraw);
        wdraw.addActionListener(this);
        
        check=new JButton("Rs.1000");
        check.setBounds(330, 400, 130, 30);
        im.add(check);
        check.addActionListener(this);
        
        fastcash=new JButton("Rs.2000");
        fastcash.setBounds(170,485,130,30);
        im.add(fastcash);
        fastcash.addActionListener(this);
        
         mini=new JButton("Rs.5000");
        mini.setBounds(330,440, 130, 30);
        im.add(mini);
        mini.addActionListener(this);
        
        pin=new JButton("10000");
        pin.setBounds(330,485, 130, 30);
        im.add(pin);
        pin.addActionListener(this);
        setSize(900,900);
        setLocation(550,0);
        setVisible(true);
        
          back=new JButton("Back");
        back.setBounds(330,550,130,30);
        back.addActionListener(this);
        im.add(back);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction("");
        }
     String amount=((JButton)ae.getSource()).getText().substring(3);  
     conn c=new conn();
     try
     {
         
         ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
         
         int balance=0;
         while(rs.next())
         {
             if(rs.getString("type").equals("deposite"))
             {
                 balance+=Integer.parseInt(rs.getString("amount"));
             }
             else
             {
                  balance-=Integer.parseInt(rs.getString("amount"));
             }
         }
         if(balance<Integer.parseInt(amount))
         {
             JOptionPane.showMessageDialog(null,"Insufficient Balance");
         }
         else
         {
         String query="insert into bank values('"+pinnumber+"','"+amount+"','withdraw')";
         c.s.executeUpdate(query);
         JOptionPane.showMessageDialog(null,"Rs."+amount+" withdraw Successfully");
         setVisible(false);
         new Transaction(pinnumber).setVisible(true);
          }
     }
     catch(Exception e)
     {
         System.out.println(e);
     }
    }
public static void main(String args[])
{
    new fastcash("");
}
}
