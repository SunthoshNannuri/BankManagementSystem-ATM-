package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class deposite extends JFrame implements ActionListener
{
    JLabel text;
    JTextField amount;
    JButton back,deposite;
    String pinnumber,depamount;
    deposite(String pinnumber)
    {
        this.pinnumber=pinnumber;
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel im=new JLabel(i3);
        add(im);
        text=new JLabel("Please Enter The Amount");
        text.setBounds(220,270,700,35);
        text.setForeground(Color.WHITE);
        im.add(text);
        
        amount=new JTextField();
        amount.setBounds(170,350, 320,30);
        amount.setFont(new Font("System",Font.BOLD,20));
        im.add(amount);
        
         deposite=new JButton("Deposite");
        deposite.setBounds(355,450,150,30);
        im.add(deposite);
        deposite.addActionListener(this);
        
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
       
        if(ae.getSource()== deposite)
        {
            String number=amount.getText();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter amount");
            }
            else
            {
            try
            {
            depamount=amount.getText();
            conn c=new conn();
            String query="insert into bank values('"+pinnumber+"','"+number+"','deposite')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"deposited amount is:"+depamount);
            setVisible(false);
            new Transaction("");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
        }
       
        else if(ae.getSource()== back)
        {
            setVisible(false);
            new Transaction(pinnumber);
        }
    }
    public static void main(String args[])
    {
       new deposite("");
    }
}
