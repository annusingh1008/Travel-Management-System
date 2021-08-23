import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteCustomer extends JFrame implements ActionListener {
	JButton b1, b2;
	String username;
	DeleteCustomer(String user) {
		this.username = user;
		setBounds(550, 200, 700, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("DELETE CUSTOMER DETAILS");
		heading.setBounds(30, 5, 400, 25);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(heading);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(20, 50, 100, 25);
		add(l1);
		
		JLabel l11 = new JLabel();
		l11.setBounds(230, 50, 100, 25);
		add(l11);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(20, 85, 100, 25);
		add(l2);
		
		JLabel l12 = new JLabel();
		l12.setBounds(230, 85, 100, 25);
		add(l12);
		
		JLabel l3 = new JLabel("ID");
		l3.setBounds(20, 120, 100, 25);
		add(l3);
		
		JLabel l13 = new JLabel();
		l13.setBounds(230, 120, 100, 25);
		add(l13);

		JLabel l4 = new JLabel("Number");
		l4.setBounds(20, 155, 100, 25);
		add(l4);
		
		JLabel l14 = new JLabel();
		l14.setBounds(230, 155, 100, 25);
		add(l14);
		
		JLabel l5 = new JLabel("Gender");
		l5.setBounds(20, 190, 100, 25);
		add(l5);
		
		JLabel l15 = new JLabel();
		l15.setBounds(230, 190, 100, 25);
		add(l15);
		
		JLabel l6 = new JLabel("Country");
		l6.setBounds(20, 225, 100, 25);
		add(l6);
		
		JLabel l16 = new JLabel();
		l16.setBounds(230, 225, 100, 25);
		add(l16);
		
		JLabel l7 = new JLabel("Address");
		l7.setBounds(20, 260, 100, 25);
		add(l7);
		
		JLabel l17 = new JLabel();
		l17.setBounds(230, 260, 100, 25);
		add(l17);
		
		JLabel l8 = new JLabel("Phone");
		l8.setBounds(20, 295, 100, 25);
		add(l8);
		
		JLabel l18 = new JLabel();
		l18.setBounds(230, 295, 100, 25);
		add(l18);
		
		JLabel l9 = new JLabel("Email");
		l9.setBounds(20, 330, 100, 25);
		add(l9);
		
		JLabel l19= new JLabel();
		l19.setBounds(230, 330, 100, 25);
		add(l19);
		
		b1 = new JButton("Delete");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(60, 375, 90, 25);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(170, 375, 90, 25);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l10 = new JLabel(i3);
		l10.setBounds(350, 50, 300, 300);
		add(l10);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
			
			while(rs.next()) {
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("name"));
				l13.setText(rs.getString("id"));
				l14.setText(rs.getString("number"));
				l15.setText(rs.getString("gender"));
				l16.setText(rs.getString("country"));
				l17.setText(rs.getString("address"));
				l18.setText(rs.getString("phone"));
				l19.setText(rs.getString("email"));
			}
			
		}catch(Exception e) {}

	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				Conn c = new Conn();
				c.s.executeUpdate("delete from account where username = '"+username+"'");
				c.s.executeUpdate("delete from bookHotel where username = '"+username+"'");
				c.s.executeUpdate("delete from bookPackage where username = '"+username+"'");
				c.s.executeUpdate("delete from customer where username = '"+username+"'");
				JOptionPane.showMessageDialog(null, "Customer Details Deleted Successfully");
				System.exit(0);  // whole project will close
			}catch(Exception e) {}
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new DeleteCustomer("").setVisible(true);
	}

}
