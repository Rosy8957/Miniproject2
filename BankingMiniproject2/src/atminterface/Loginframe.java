package atminterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class Loginframe extends JFrame implements ActionListener {
	JFrame f1;                      
	JPanel p;
	JLabel l,l1,l2;
	JTextField t1;
	JPasswordField p1;
	JButton b1,b2;
	JCheckBox sb;
	JPanel c ;
    Loginframe() {
    	f1 = new JFrame();
        f1.setTitle("Login Form");
        c=new JPanel();
        ImageIcon i= new ImageIcon("D:/login.jpg");
       	l=new JLabel(i);
        l1 = new JLabel("USERNAME:");
        t1 = new JTextField("",10);
        l1.setFont(new Font("Serif", Font. BOLD,22));
        l2 = new JLabel("PASSWORD:");
        p1 = new JPasswordField("",10);
        l2.setFont(new Font("Serif", Font. BOLD,22));
        b1 = new JButton("LOGIN");
        b2 = new JButton("RESET");
        sb = new JCheckBox("Show Password");
        sb.setFont(new Font("Serif", Font. BOLD,22));
        t1.setForeground(Color.WHITE);
        p1.setForeground(Color.WHITE);
        p1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
    	b1.setBackground(Color.BLACK);
    	b2.setForeground(Color.WHITE);
    	b2.setBackground(Color.BLACK);
    	l1.setBounds(50, 150, 100, 30);
        t1.setBounds(150, 150, 150, 30);
        l2.setBounds(50, 220, 100, 30);
        p1.setBounds(150, 220, 150, 30);
        sb.setBounds(150, 250, 150, 30);
        b1.setBounds(50, 300, 100, 30);
        b2.setBounds(200, 300, 100, 30);
        b1.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 20));
        b2.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 20));
        c.add(l);
        c.add(l1);
        c.add(t1);
        c.add(l2);
        c.add(p1);
        c.add(sb);
        c.add(b1);
        c.add(b2);
        f1.add(c);
        f1.setBounds(70, 70, 570, 500);
		f1.setVisible(true);
		f1.setLayout(null);
		f1.setBackground(Color.white);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setLocationRelativeTo(null);  
		f1.setResizable(false);
        
    b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
	            String userText;
	            String pwdText;
	            userText = t1.getText();
	            pwdText = p1.getText(); 
	            try
	            {
	            	Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","12345");
	                PreparedStatement ps = con.prepareStatement("select name from reg where name=? and password=?");
	                ps.setString(1, userText);
	                ps.setString(2, pwdText);
	                ResultSet rs = ps.executeQuery();
	                if (rs.next())
	                {
	                	JOptionPane.showMessageDialog(c, "LOGIN SUCCESSFULLY");	                    
	                Homepage h =new Homepage();
					 h.setVisible(true);
	                } 
	                else 
	                {
	                JOptionPane.showMessageDialog(c, "Invalid Username or Password");
	                }
	            } catch (Exception ex)
	            {
	                System.out.println(ex);
	            }
			}
		}
	});	
    b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 if (e.getSource() == b2) {
		            t1.setText("");
		            p1.setText("");
		        }
		}
    });
    sb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 if (e.getSource() == sb) 
			 {
		            if (sb.isSelected()) 
		            {
		                p1.setEchoChar((char) 0);
		            } else 
		            {
		                p1.setEchoChar('*');
		            }
		        }
		}
		  });
}
    @Override
    public void actionPerformed(ActionEvent e) {     
    }
    public static void main(String[] a) {
        new Loginframe();
 
    }
} 