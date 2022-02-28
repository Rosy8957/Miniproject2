package atminterface;


import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Welcomepage extends JFrame implements ActionListener{
	JFrame fr;
	JLabel l,l1;
	JButton bt,b1;
	JPanel pt;
	Welcomepage()
	{
	fr=new JFrame("WELCOME PAGE");
	pt=new JPanel();
	l1= new JLabel("WELCOME TO WESTERN SKY BANK", SwingConstants.CENTER);
	l1.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 30));
	l1.setForeground(Color.BLACK);
	l1.setBackground(Color.WHITE);
	l1.setOpaque(true);
	ImageIcon i= new ImageIcon("D:\\welcome.jpg");
	l=new JLabel(i);
	bt=new JButton("LOGIN");
	b1=new JButton("SIGN UP");
	pt.add(l1);
	pt.add(l);
	pt.add(bt);
	pt.add(b1);
	bt.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 25));
	b1.setFont(new Font("serif", Font.BOLD|Font.ITALIC, 25));
	bt.setForeground(Color.WHITE);
	bt.setBackground(Color.BLACK);
	b1.setForeground(Color.WHITE);
	b1.setBackground(Color.BLACK);
	fr.add(pt);
	fr.setBackground(Color.white);
	fr.setLocationRelativeTo(null); 
	fr.setResizable(false);
	fr.setBounds(70, 70, 750, 620);
	fr.setVisible(true);
	fr.setLayout(null);

	fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	 bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginframe lf =new Loginframe();
				 lf.setVisible(true);
			}
		});	 
	 b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Regform  r =new Regform();
				 r.setVisible(true);
			}
		});	
}
	public static void main(String[] args) {
		new Welcomepage();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
