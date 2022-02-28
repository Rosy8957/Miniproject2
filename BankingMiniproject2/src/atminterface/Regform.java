package atminterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Regform extends JFrame implements ActionListener {

	 	JFrame f;
	    String[] gender={"select","Male","Female"};
	    JLabel l1,l2,l3,l4,l5,l6,l7;
	    JTextField t1,t2,t3,t4,t5;
	    JComboBox c1;
	    JPasswordField p1,p2;
	    JButton b1, b2;
	   Regform()
	    {  
	    	f=new JFrame("SIGN UP PAGE");
		     l1=new JLabel("NAME:");
		     l2=new JLabel("GENDER:");
		     l3=new JLabel("FATHER NAME:");
		     l4=new JLabel("PASSWORD:");
		     l5=new JLabel("CONFIRM PASSWORD:");
		     l6=new JLabel("BRANCH NAME:");
		     l7=new JLabel("EMAIL:");
		 	l1.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 12));
			l2.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 13));
			l3.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 13));
			l4.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 13));
			l5.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 13));
			l6.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 13)); 
			l7.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 13));
			t1=new JTextField("",10);
		     c1=new JComboBox(gender);
		     t2=new JTextField();
		     p1=new JPasswordField("",10);
		     p2=new JPasswordField("",10);
		     t3=new JTextField("",10);
		     t4=new JTextField("",10);
		     t5=new JTextField("",10);
		     b1=new JButton("REGISTER");
		     b2=new JButton("RESET");
		 	b1.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 18));
			b2.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 18)); 
		 	l1.setBounds(20,20,40,70);
		     	l2.setBounds(20,70,80,70);
		     	l3.setBounds(20,120,100,70);
		      	l4.setBounds(20,170,100,70);
		        l5.setBounds(20,220,140,70);
		        l6.setBounds(20,270,100,70);
		        l7.setBounds(20,320,100,70);
		        t1.setBounds(180,43,165,23);
		        c1.setBounds(180,93,165,23);
		        t2.setBounds(180,143,165,23);
		        p1.setBounds(180,193,165,23);
		        p2.setBounds(180,243,165,23);
		        t3.setBounds(180,293,165,23);
		        t4.setBounds(180,343,165,23);
		        t5.setBounds(180,343,165,23);
		        b1.setBounds(70,400,130,35);
		        b2.setBounds(220,400,100,35);
		    	b1.setForeground(Color.WHITE);
		    	b1.setBackground(Color.BLACK);
		    	b2.setForeground(Color.WHITE);
		    	b2.setBackground(Color.BLACK);
		    	  t1.setForeground(Color.WHITE);
		          t1.setBackground(Color.black);
		          c1.setForeground(Color.WHITE);
		          c1.setBackground(Color.black);
		          t2.setForeground(Color.WHITE);
		          t2.setBackground(Color.black);
		          p1.setForeground(Color.WHITE);
		          p1.setBackground(Color.black);
		          p2.setForeground(Color.WHITE);
		          p2.setBackground(Color.black);
		          t3.setForeground(Color.WHITE);
		          t3.setBackground(Color.black);
		          t4.setForeground(Color.WHITE);
		          t4.setBackground(Color.black);
		     f.add(l1);
		     f.add(t1);
		     f.add(l2);
		     f.add(c1);
		     f.add(l3);
		     f.add(t2);
		     f.add(l4);
		     f.add(p1);
		     f.add(l5);
		     f.add(p2);
		     f.add(l6);
		     f.add(t3);
		     f.add(l7);
		     f.add(t4);
		     f.add(b1);
		     f.add(b2);
		     f.setBounds(40,40,380,600);
		     f.getContentPane().setBackground(Color.pink);
		     f.getContentPane().setLayout(null);
		     f.setVisible(true);   
		     f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		     f.setLocationRelativeTo(null);  //
				f.setResizable(false);
		     b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	        if(e.getSource()==b1)
	        {
	            try {
	            	Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","12345");
	                PreparedStatement Pstatement=connection.prepareStatement("insert into reg values(?,?,?,?,?,?,?)");
	                Pstatement.setString(1,t1.getText());
	                Pstatement.setString(2,c1.getSelectedItem().toString());
	                Pstatement.setString(3,t2.getText());
	                Pstatement.setString(4,p1.getText());
	                Pstatement.setString(5,p2.getText());
	                Pstatement.setString(6,t3.getText());
	                Pstatement.setString(7,t4.getText());
	          
	                if(p1.getText().equalsIgnoreCase(p2.getText()))
	                {
	                
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null,"password did not match");
	                }
	 
	            } catch (SQLException | ClassNotFoundException e1) {
	                e1.printStackTrace();
	            }
	        }
				}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        if(e.getSource()==b2)
	        {
	            t1.setText("");
	            c1.setSelectedItem("select");
	            t2.setText("");
	            p1.setText("");
	            p2.setText("");
	            t3.setText("");
	            t4.setText("");
	        }
	 
	    }
		});
	    }
	    public static void main(String[] args)
	    {
	        new Regform();
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	    }
