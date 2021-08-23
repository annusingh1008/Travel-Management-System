import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
	JButton b1, b2, b3;
	Choice c1, c2, c3;
	JTextField t1, t2;
	JLabel l12, l13, l14, l15, l16;
	
	BookHotel(String username) {
		setBounds(470, 230, 800, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("BOOK HOTEL");
		l1.setBounds(130, 10, 200, 30);
		l1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		add(l1);
		
		JLabel l2 = new JLabel("Username:");
		l2.setBounds(20, 60, 100, 20);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l2);
		
		l12 = new JLabel();
		l12.setBounds(230, 60, 100, 20);
		l12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l12);
		
		JLabel l3 = new JLabel("Select Hotel:");
		l3.setBounds(20, 90, 100, 20);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l3);
		
		c1 = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from hotel");
			while(rs.next()) {
				c1.add(rs.getString("name"));
			}
			
		}catch(Exception e) {}
		c1.setBounds(230, 90, 224, 20);
		add(c1);
		
		JLabel l4 = new JLabel("Total Persons:");
		l4.setBounds(20, 120, 100, 20);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l4);
		
		t1 = new JTextField();
		t1.setBounds(230, 120, 180, 20);
		add(t1);
		
		JLabel l5 = new JLabel("No. of Days:");
		l5.setBounds(20, 150, 100, 20);
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l5);
		
		t2 = new JTextField();
		t2.setBounds(230, 150, 180, 20);
		add(t2);
		
		JLabel l6 = new JLabel("AC/Non-AC:");
		l6.setBounds(20, 180, 100, 20);
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l6);
		
		c2 = new Choice();
		c2.add("Yes");
		c2.add("No");
		c2.setBounds(230, 180, 224, 20);
		add(c2);
		
		JLabel l7 = new JLabel("Food Included:");
		l7.setBounds(20, 210, 120, 20);
		l7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l7);
		
		c3 = new Choice();
		c3.add("Yes");
		c3.add("No");
		c3.setBounds(230, 210, 224, 20);
		add(c3);
		
		JLabel l8 = new JLabel("ID:");
		l8.setBounds(20, 240, 100, 20);
		l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l8);
		
		l13 = new JLabel();
		l13.setBounds(230, 240, 100, 20);
		l13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l13);
		
		JLabel l9 = new JLabel("Number:");
		l9.setBounds(20, 270, 100, 20);
		l9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l9);
		
		l14 = new JLabel();
		l14.setBounds(230, 270, 100, 20);
		l14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l14);
		
		JLabel l10 = new JLabel("Phone:");
		l10.setBounds(20, 300, 100, 20);
		l10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l10);
		
		l15 = new JLabel();
		l15.setBounds(230, 300, 100, 20);
		l15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l15);
		
		JLabel l11 = new JLabel("Total Price:");
		l11.setBounds(20, 330, 100, 20);
		l11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(l11);
		
		l16 = new JLabel();
		l16.setBounds(230, 330, 200, 15);
		l16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l16.setForeground(Color.RED);
		add(l16);
		
		b1 = new JButton("Check Price");
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLUE);
		b1.addActionListener(this);
		b1.setBounds(30, 370, 105, 25);
		add(b1);
		
		b2 = new JButton("Book");
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLUE);
		b2.addActionListener(this);
		b2.setBounds(155, 370, 105, 25);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.BLUE);
		b3.addActionListener(this);
		b3.setBounds(280, 370, 105, 25);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
		Image i2 = i1.getImage().getScaledInstance(337, 290, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l17 = new JLabel(i3);
		l17.setBounds(450, 70, 337, 290);
		add(l17);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
			
			while(rs.next()) {
				l12.setText(rs.getString("username"));
				l13.setText(rs.getString("id"));
				l14.setText(rs.getString("number"));
				l15.setText(rs.getString("phone"));
			}
			
		}catch(Exception e) {}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+c1.getSelectedItem()+"'");
				while(rs.next()) {
					int cost = Integer.parseInt(rs.getString("cost_per_day"));
					int food = Integer.parseInt(rs.getString("food_charges"));
					int ac = Integer.parseInt(rs.getString("ac_charges"));
					
					int persons = Integer.parseInt(t1.getText());
					int days = Integer.parseInt(t2.getText());
					
					String acprice = c2.getSelectedItem();
					String foodprice = c3.getSelectedItem();
					
					if(persons * days > 0) {
						int total = 0;
						total += acprice.equals("Yes") ? ac : 0;
						total += foodprice.equals("Yes") ? ac : 0;
						total += cost;
						total = total * persons * days;
						l16.setText(""+total);	
					}else {
						l16.setText("Please enter a valid number");
					}
				}
			}catch(Exception e) {}
		}else if(ae.getSource() == b2) {
			try {
				Conn c = new Conn();
				c.s.executeUpdate("insert into bookHotel values('"+l12.getText()+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+t2.getText()+"','"+c2.getSelectedItem()+"', '"+c3.getSelectedItem()+"', '"+l13.getText()+"', '"+l14.getText()+"', '"+l15.getText()+"', '"+l16.getText()+"')");
				JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
				this.setVisible(false);
			}catch(Exception e) {}
			
		}else if(ae.getSource() == b3) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new BookHotel("").setVisible(true);

	}

}
