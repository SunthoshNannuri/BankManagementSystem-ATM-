package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class withdraw extends JFrame implements ActionListener
{
    JLabel text;
    JTextField amount;
    JButton back,withdraw;
    String pinnumber;
    String withdrawamount;
    withdraw(String pinnumber)
    {
        this.pinnumber=pinnumber;
                ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel im=new JLabel(i3);
        add(im);
        text=new JLabel("Please Enter the amount");
        text.setBounds(220,270,700,35);
        text.setForeground(Color.WHITE);
        im.add(text);
        
        amount=new JTextField();
        amount.setBounds(170,350, 320,30);
        amount.setFont(new Font("System",Font.BOLD,20));
        im.add(amount);
        
         withdraw=new JButton("withdraw");
        withdraw.setBounds(355,450,150,30);
        im.add(withdraw);
        withdraw.addActionListener(this);
        
        back=new JButton("back");
        back.setBounds(355,485,150,30);
        im.add(back);
        back.addActionListener(this);
    setSize(900,900);
    setLocation(550,0);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
      String wnumber=amount.getText();
     conn c=new conn();
     try
     {
          if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction("");
        }
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
         if(balance<Integer.parseInt(wnumber))
         {
             JOptionPane.showMessageDialog(null,"Insufficient Balance");
             setVisible(false);
             new Transaction("");
         }
         else
         {
         String query="insert into bank values('"+pinnumber+"','"+wnumber+"','withdraw')";
         c.s.executeUpdate(query);
         JOptionPane.showMessageDialog(null,"Rs."+wnumber+" withdraw Successfully");
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
        new withdraw("");
    }
}
