package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class checkbalance extends JFrame implements ActionListener
{
    JButton back;
    JLabel text;
    String pinnumber;
    
    checkbalance(String pinnumber)
    {
         this.pinnumber=pinnumber;
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel im=new JLabel(i3);
        add(im);
        
        back=new JButton("Back");
        back.setBounds(330,485, 130, 30);
        back.addActionListener(this);
        im.add(back);
        
        
    conn c=new conn();
      int balance=0; 
        try
        {
         ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
       
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
         String que="insert into check_bal values('"+balance+")";
    c.s.executeUpdate(que);
     }
    
     catch(Exception e)
     {
         System.out.println(e);
     }
    
    text=new JLabel("Balnce Amount is Amount:"+balance);
        text.setBounds(220,270,700,35);
        text.setForeground(Color.WHITE);
        im.add(text);
    setSize(900,900);
        setLocation(550,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
    }
public static void main(String args[])
{
    new checkbalance("");
}
}