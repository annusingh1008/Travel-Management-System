import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener {	
	JButton b1;
	
	ViewBookedHotel(String username) {
		setBounds(510, 220, 688, 440);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("VIEW BOOKED HOTEL DETAILS");
		l1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		l1.setBounds(50, 10, 350, 20);
		add(l1);
		
		JLabel l2 = new JLabel("Username:");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(30, 60, 100, 20);
		add(l2);
		
		JLabel l11 = new JLabel();
		l11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l11.setBounds(230, 60, 200, 20);
		add(l11);
		
		JLabel l3 = new JLabel("Hotel Name:");
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
		
		JLabel l5 = new JLabel("Total Days:");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setBounds(30, 150, 100, 20);
		add(l5);
		
		JLabel l14 = new JLabel();
		l14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l14.setBounds(230, 150, 200, 20);
		add(l14);
		
		JLabel l6 = new JLabel("AC Included?");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l6.setBounds(30, 180, 100, 15);
		add(l6);
		
		JLabel l15 = new JLabel();
		l15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l15.setBounds(230, 180, 200, 20);
		add(l15);
		
		JLabel l7 = new JLabel("Food Included?");
		l7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l7.setBounds(30, 210, 105, 15);
		add(l7);
		
		JLabel l16 = new JLabel();
		l16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l16.setBounds(230, 210, 200, 20);
		add(l16);
		
		JLabel l8 = new JLabel("ID:");
		l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l8.setBounds(30, 240, 100, 15);
		add(l8);
		
		JLabel l17 = new JLabel();
		l17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l17.setBounds(230, 240, 200, 20);
		add(l17);
		
		JLabel l10 = new JLabel("Number:");
		l10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l10.setBounds(30, 270, 100, 15);
		add(l10);
		
		JLabel l18 = new JLabel();
		l18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l18.setBounds(230, 270, 200, 20);
		add(l18);
		
		JLabel l22 = new JLabel("Phone:");
		l22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l22.setBounds(30, 300, 100, 15);
		add(l22);
		
		JLabel l19 = new JLabel();
		l19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l19.setBounds(230, 300, 200, 20);
		add(l19);
		
		JLabel l21 = new JLabel("Total Cost");
		l21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l21.setBounds(30, 330, 100, 15);
		add(l21);
		
		JLabel l20 = new JLabel();
		l20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l20.setBounds(230, 330, 200, 20);
		add(l20);
		
		b1 = new JButton("Back");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(110, 370, 90, 20);
		b1.addActionListener(this);
		add(b1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i2 = i1.getImage().getScaledInstance(285, 345, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l9 = new JLabel(i3);
		l9.setBounds(390, 70, 285, 345);
		add(l9);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from bookHotel where username = '"+username+"'");
			while(rs.next()) {
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("hotel"));
				l13.setText(rs.getString("persons"));
				l14.setText(rs.getString("days"));
				l15.setText(rs.getString("ac"));
				l16.setText(rs.getString("food"));
				l17.setText(rs.getString("id"));
				l18.setText(rs.getString("number"));
				l19.setText(rs.getString("phone"));
				l20.setText(rs.getString("cost"));
			}
			
		}catch(Exception e) {}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new ViewBookedHotel("").setVisible(true);

	}

}
