package bank.management.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Transaction extends JFrame implements ActionListener
{
    JButton deposite;
    JButton check;
    JButton fastcash,mini,pin,wdraw;
    String pinnumber;
    Transaction(String pinnumber)
    {
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel im=new JLabel(i3);
        add(im);
        JLabel text=new JLabel("Please Select The Transaction");
        text.setBounds(220,270,700,35);
        text.setForeground(Color.WHITE);
        im.add(text);
        
        deposite=new JButton("Deposite");
        deposite.setBounds(170,400,130,30);
        im.add(deposite);
        deposite.addActionListener(this);
        wdraw=new JButton("withdraw");
        wdraw.setBounds(170,440,130,30);
        im.add(wdraw);
        wdraw.addActionListener(this);
        
        check=new JButton("Check Balance");
        check.setBounds(330, 400, 130, 30);
        im.add(check);
        check.addActionListener(this);
        
        fastcash=new JButton("fastcash");
        fastcash.setBounds(170,485,130,30);
        im.add(fastcash);
        fastcash.addActionListener(this);
        
         pin=new JButton("Pin Change");
        pin.setBounds(330,440, 130, 30);
        im.add(pin);
        pin.addActionListener(this);
        
        mini=new JButton("Back");
        mini.setBounds(330,485, 130, 30);
        im.add(mini);
        mini.addActionListener(this);
        
        setSize(900,900);
        setLocation(550,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
      if(ae.getSource()== deposite)
      {
          setVisible(false);
          new deposite(pinnumber);
      }
       else if(ae.getSource()== wdraw)
        {
            setVisible(false);
            new withdraw(pinnumber);
        }
       else if(ae.getSource()== fastcash)
        {
         setVisible(false);
         new fastcash(pinnumber);
        }
       else if(ae.getSource()==check)
        {
         setVisible(false);
         new checkbalance(pinnumber);
        }
       else if(ae.getSource()==pin)
        {
         setVisible(false);
         new pinchange(pinnumber);
        }
       else if(ae.getSource()==mini)
        {
         setVisible(false);
         new Login(pinnumber);
        }
    }
    public static void main(String args[])
    {
        
        
        new Transaction("");
    }

    
}

