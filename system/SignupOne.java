package bank.management.system;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class SignupOne extends JFrame implements ActionListener
{
     JTextField nametext,addtext,cardtext,pintext;
    JButton submit;
    String pinnumber;
    SignupOne(String pinnumber)
    {
        setLayout(null);
        setTitle("Signup");
       
       JLabel form=new JLabel("Additional Details");
       form.setFont(new Font("Arial",Font.BOLD,30));
       form.setBounds(280, 100, 400, 40);
       add(form);
       JLabel name=new JLabel("Name:");
       name.setFont(new Font("Arial",Font.BOLD,20));
       name.setBounds(210, 208,250, 30);
       add(name);
       nametext=new JTextField();
       nametext.setFont(new Font("Arial",Font.BOLD,20));
       nametext.setBounds(280,208,250,30);
       add(nametext);
        
        JLabel  address=new JLabel("Address:");
        address.setFont(new Font("Arial",Font.BOLD,20));
        address.setBounds(190, 250, 250, 30);
        add(address);
        
       addtext=new JTextField();
       addtext.setFont(new Font("Arial",Font.BOLD,20));
       addtext.setBounds(280,250,250,30);
       add(addtext);
       
        JLabel dob=new JLabel("DOB:");
        dob.setFont(new Font("Arial",Font.BOLD,20));
        dob.setBounds(190, 300, 250, 30);
        add(dob);
        JDateChooser date=new JDateChooser();
        date.setBounds(280, 300, 250, 30);
        add(date);
       submit=new JButton("Submit");
       submit.setFont(new Font("Arial",Font.BOLD,20));
       submit.setBounds(320, 350,100, 30);
       submit.addActionListener(this);
       

        
     
       
       
       
       add(submit);
          setSize(850,800);
        setVisible(true);
        setLocation(550,150);
        getContentPane().setBackground(new Color(135, 206, 235));
    }
    public void actionPerformed(ActionEvent ae)
    {
        String name=nametext.getText();
        String address=addtext.getText();
        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if(address.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Address Is Required");
            }
            else
            {
                Random ran=new Random();
                String cardnumber=""+Math.abs((ran.nextLong()%9000L)+1000L);
                String pinnumber=""+Math.abs((ran.nextLong()%9000L)+1000L);
                conn c=new conn();
                String query1="insert into signup values('"+name+"','"+address+"')";
                String query="insert into login values('"+cardnumber+"','"+pinnumber+"')";
                JOptionPane.showMessageDialog(null,"cardnumber:"+cardnumber+"\n  Pin:"+pinnumber);        
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                setVisible(false);
                new Login(pinnumber);            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        new SignupOne("");
    }
}
