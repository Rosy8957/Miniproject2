package atminterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Homepage extends JFrame implements ActionListener{
	JFrame f1,f2,f3,f4;                       
	JPanel p1;
	JButton b,btn,b1,b2,b3,b4,b5;
	JLabel l,l1;
	JTextField t1;
	static JTable t,tt,ttt;
	Connection con1,con2;

    int a=0;  
    String[] columnNames1= {"Accno","Acholder","Currentbalance","Date"};
	String driverName="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/bank";
	String username="root";
	String password="12345";
	String[] columnNames= {"Accno","Acholder","branch","branchaddress","nominee","occupation","date"};
	String[] columnNames2= {"Account number","TAccount","TAccounttype","Amount","TDate"};
	Homepage()
	{
		p1=new JPanel();
		l1 = new JLabel("ENTER YOUR ACNO TO SEE YOUR ACCOUNT DETAILS:");
	    t1 = new JTextField("",10);
	    l1.setFont(new Font("Serif", Font. BOLD|Font.ITALIC,15));
	    l1.setForeground(Color.RED);
		b=new JButton("FETCH DATA");
		btn=new JButton("RESET");
		ImageIcon i= new ImageIcon("D:\\hp1.jpg");
		l=new JLabel(i);
		f1=new JFrame("ACCOUNT DETAILS");
		b1=new JButton("CHECK BALANCE ");
		b2=new JButton("TRANSACTION HISTORY");
		b3=new JButton("QUIT");
		b.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 20));
	    btn.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 20));
	    b1.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 20));
	    b2.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 20));
	    b3.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 20));
		b.setForeground(Color.WHITE);
		b.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.BLACK);
		btn.setForeground(Color.WHITE);
		btn.setBackground(Color.BLACK);
	
		p1.add(l1);
		p1.add(t1);
		p1.add(b);
		p1.add(btn);
		p1.add(l);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		f1.add(p1);
		f1.setLocationRelativeTo(null); 
		f1.setResizable(false);
		f1.setVisible(true);
		f1.validate();
		f1.setBounds(70, 70, 570, 570);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == btn) {
		            t1.setText("");
		        }
			}
		});	 
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b=(JButton)e.getSource();
				System.out.println("Showing table data....");
				frame2();
		        }
			}
		);	 
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b1=(JButton)e.getSource();
				System.out.println("Showing table data....");
				frame3();
			}
		});	 
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b2=(JButton)e.getSource();
				System.out.println("Showing table data....");
				frame4();
			}
		});	
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginframe t =new Loginframe ();
				 t.setVisible(true);
			}
		});	
	}
public void frame2() {
		f2=new JFrame("DATABASE OF PERSONAL INFORMATION");
		f2.setLayout(new BorderLayout());
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(columnNames);
		t=new JTable();
		t.setModel(dtm);
		t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		t.setFillsViewportHeight(true);
		JScrollPane scroll=new JScrollPane(t);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		String textvalue=t1.getText();
		String accno="";
		String name="";
		String branch="";
		String baddress="";
		String nominee="";
		String occupation="";
		String date="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","12345");
				String sql="select * from account_detail where Acc_no="+textvalue;
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				int i=0;
				if (rs.next()) 
				{
				 accno=rs.getString("Acc_no");
				 name=rs.getString("Ac_Holder");
				 branch=rs.getString("Branch");
				 baddress=rs.getString("Branch_Address");
				 nominee=rs.getString("Nominee_Added");
				occupation=rs.getString("Occupation");
				 date=rs.getString("Dateofopen");
				 dtm.addRow(new Object[] {accno,name, branch,baddress,nominee,occupation,date});
				i++;	
				}
				 if (i<1) 
				 {
					 JOptionPane.showMessageDialog(null,"No Record Found","Error",JOptionPane.ERROR_MESSAGE);
				 }
				 if(i==1) 
				 {
				System.out.println(i+" Record Found");	 
				 }
				 else 
				 {
					 System.out.println(i+" Record Found");
				 }
				 }
					 catch(Exception ex) {
						 JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					 }
				f2.add(scroll);
				f2.setSize(900,200);
				f2.setVisible(true);
				 }
	public void frame3() {
		f3=new JFrame("DATABASE OF BALANCE INQUIRY");
		f3.setLayout(new BorderLayout());
		DefaultTableModel dtmm=new DefaultTableModel();
		dtmm.setColumnIdentifiers(columnNames1);
		tt=new JTable();
		tt.setModel(dtmm);
		tt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tt.setFillsViewportHeight(true);
		JScrollPane scroll1=new JScrollPane(tt);
		scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		String textvalue=t1.getText();
		String accno="";
		String name="";
		String currentbalance="";
		String date="";
	     try {
	            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "12345");
	            String sql="select * from balance where Acc_no="+textvalue;
				PreparedStatement ps=con1.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
	            	if (rs.next()) 
					{
	            	accno=rs.getString("Acc_no");
	   				 name=rs.getString("Ac_Holder");
	   				 currentbalance=rs.getString("Current_Balance");
	   				 date=rs.getString("Date");
	            	 dtmm.addRow(new Object[] {accno,name, currentbalance,date});
	 				a++;	
	 				}
	 				 if (a<1) 
	 				 {
	 					 JOptionPane.showMessageDialog(null,"No Record Found","Error",JOptionPane.ERROR_MESSAGE);
	 				 }
	 				 if(a==1) 
	 				 {
	 				System.out.println(a+" Record Found");	 
	 				 }
	 				 else 
	 				 {
	 					 System.out.println(a+" Record Found");
	 				 }
	 				 }catch(Exception ex) {
	 						 JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	 					 }
	     				f3.add(scroll1);
	     				f3.setSize(500,300);
	     				f3.setVisible(true);
	     }
	
	public void frame4() {
		
		f4=new JFrame(" TRANSACTION HISTORY");
		f4.setLayout(new BorderLayout());
		DefaultTableModel dtmm1=new DefaultTableModel();
		dtmm1.setColumnIdentifiers(columnNames2);
		ttt=new JTable();
		ttt.setModel(dtmm1);
		ttt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ttt.setFillsViewportHeight(true);
		JScrollPane scroll2=new JScrollPane(ttt);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		String textvalue=t1.getText();
		String accno=t1.getText();
		String taccno="";
		String acctype="";
		String amount="";
		String date="";
		
		if(textvalue.equals(accno)) {
	     try {
	            con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "12345");
	            String sql="select * from transaction";
				PreparedStatement ps=con2.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
	            	while(rs.next()) 
					{
	            	accno=rs.getString("Acc_no");
	            	taccno=rs.getString("T_Account");
	   				 acctype=rs.getString("T_Accounttype");
	   				 amount=rs.getString("Amount");
	   				 date=rs.getString("T_Date");
	            	 dtmm1.addRow(new Object[] {accno,taccno,acctype, amount,date});
	            	
	 				}}
	            	catch(Exception ex) {
						ex.printStackTrace();
					 }
		}
	            	else {
	            		JOptionPane.showMessageDialog(null,"No Record Found","Error",JOptionPane.ERROR_MESSAGE);
	            	}
	     				f4.add(scroll2);
	     				f4.setSize(500,300);
	     				f4.setVisible(true);
	     }
				 
	public static void main(String[] args) {
		new Homepage();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
} 