import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {	
	JButton b1;
	
	ViewPackage(String username) {
		setBounds(510, 220, 700, 355);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("VIEW PACKAGE DETAILS");
		l1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		l1.setBounds(50, 10, 250, 20);
		add(l1);
		
		JLabel l2 = new JLabel("Username:");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(30, 60, 100, 20);
		add(l2);
		
		JLabel l11 = new JLabel();
		l11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l11.setBounds(230, 60, 200, 20);
		add(l11);
		
		JLabel l3 = new JLabel("Package:");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setBounds(30, 90, 100, 20);
		add(l3);
		
		JLabel l12 = new JLabel();
		l12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l12.setBounds(230, 90, 200, 20);
		add(l12);
		
		JLabel l4 = new JLabel("Total Persons:");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setBounds(30, 120, 100, 20);
		add(l4);
		
		JLabel l13 = new JLabel();
		l13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l13.setBounds(230, 120, 200, 20);
		add(l13);
		
		JLabel l5 = new JLabel("ID:");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setBounds(30, 150, 100, 20);
		add(l5);
		
		JLabel l14 = new JLabel();
		l14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l14.setBounds(230, 150, 200, 20);
		add(l14);
		
		JLabel l6 = new JLabel("Number:");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l6.setBounds(30, 180, 100, 15);
		add(l6);
		
		JLabel l15 = new JLabel();
		l15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l15.setBounds(230, 180, 200, 20);
		add(l15);
		
		JLabel l7 = new JLabel("Phone:");
		l7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l7.setBounds(30, 210, 100, 15);
		add(l7);
		
		JLabel l16 = new JLabel();
		l16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l16.setBounds(230, 210, 200, 20);
		add(l16);
		
		JLabel l8 = new JLabel("Price:");
		l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l8.setBounds(30, 240, 100, 15);
		add(l8);
		
		JLabel l17 = new JLabel();
		l17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l17.setBounds(230, 240, 200, 20);
		add(l17);
		
		b1 = new JButton("Back");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(110, 280, 90, 20);
		b1.addActionListener(this);
		add(b1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l9 = new JLabel(i3);
		l9.setBounds(390, 20, 300, 300);
		add(l9);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from bookPackage where username = '"+username+"'");
			while(rs.next()) {
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("package"));
				l13.setText(rs.getString("persons"));
				l14.setText(rs.getString("id"));
				l15.setText(rs.getString("number"));
				l16.setText(rs.getString("phone"));
				l17.setText(rs.getString("price"));
			}
			
		}catch(Exception e) {}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new ViewPackage("").setVisible(true);

	}

}
