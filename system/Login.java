package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JButton login,signup,clear;
    JTextField cardtext;
    JPasswordField password;
    JLabel text;
    JLabel card,pin;
    String pinnumber;
    Login(String pinnumber)
    {
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        text=new JLabel("Welcome To SBI");
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
        
         login=new JButton("Login");
        login.setBounds(250,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
         clear=new JButton("Clear");
        clear.setBounds(400,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("Signup");
        signup.setBounds(250,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
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
        }
        else if(ae.getSource()==login)
        {
            String cardnumber=cardtext.getText();
        String pinnumber=password.getText();
            conn c=new conn();
            String query="select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
            try
            {
                ResultSet rs=c.s.executeQuery(query); 
                if(rs.next())
                {
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }
                else
                {
                  
                    JOptionPane.showMessageDialog(null,"incorrect cardnumber and pin");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup )
        {
           setVisible(false);
           new SignupOne(pinnumber);
        }
    }
public static void main(String args[])
{
    
new Login("");
}
}