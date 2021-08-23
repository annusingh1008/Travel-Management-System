import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {
	JButton b1, b2, b3;
	Choice c1;
	JTextField t1;
	JLabel l11, l12, l13, l14, l15;
	
	BookPackage(String username) {
		
		setBounds(500, 220, 780, 410);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("BOOK PACKAGE");
		l1.setFont(new Font("YU Mincho", Font.PLAIN, 20));
		l1.setBounds(110, 10, 200, 20);
		add(l1);
		
		JLabel l2 = new JLabel("Username");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(30, 60, 100, 20);
		add(l2);
		
		l11 = new JLabel();
		l11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l11.setBounds(230, 60, 100, 20);
		add(l11);
		
		JLabel l3 = new JLabel("Select Package");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setBounds(30, 95, 100, 20);
		add(l3);
		
		c1 = new Choice();
		c1.add("Gold Package");
		c1.add("Silver Package");
		c1.add("Bronze Package");
		c1.setBounds(230, 95, 220, 20);
		add(c1);
		
		JLabel l4 = new JLabel("Total Persons");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setBounds(30, 130, 100, 20);
		add(l4);
		
		t1 = new JTextField("1");
		t1.setBounds(230, 130, 177, 20);
		add(t1);
		
		JLabel l5 = new JLabel("ID");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setBounds(30, 165, 100, 20);
		add(l5);
		
		l12 = new JLabel();
		l12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l12.setBounds(230, 165, 100, 20);
		add(l12);
		
		JLabel l6 = new JLabel("Number");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l6.setBounds(30, 200, 100, 20);
		add(l6);
		
		l13 = new JLabel();
		l13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l13.setBounds(230, 200, 100, 20);
		add(l13);
		
		JLabel l7 = new JLabel("Phone");
		l7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l7.setBounds(30, 235, 100, 20);
		add(l7);
		
		l14 = new JLabel();
		l14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l14.setBounds(230, 235, 100, 20);
		add(l14);
		
		JLabel l8 = new JLabel("Total Price");
		l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l8.setBounds(30, 270, 100, 20);
		add(l8);
		
		l15 = new JLabel();
		l15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l15.setBounds(230, 270, 100, 20);
		l15.setForeground(Color.RED);
		add(l15);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
			
			while(rs.next()) {
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("id"));
				l13.setText(rs.getString("Number"));
				l14.setText(rs.getString("phone"));
			}
			
		}catch(Exception e){}
		
		b1 = new JButton("Check Price");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(40, 320, 115, 25);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Book Package");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(170, 320, 115, 25);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		b3.setBounds(300, 320, 115, 25);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(290, 290, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l9 = new JLabel(i3);
		l9.setBounds(450, 50, 290, 290);
		add(l9);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String p = c1.getSelectedItem();
			int cost = 0;
			if(p.equals("Gold Package")) {
				cost = 12000;
			}else if(p.equals("Silver Package")) {
				cost = 24000;
			}else if(p.equals("Bronze Package")) {
				cost = 32000;
			}
			
			int persons =  Integer.parseInt(t1.getText());
			cost *= persons;
			
			l15.setText("Rs "+cost);
			
		}else if(ae.getSource() == b2) {
			try {
				Conn c = new Conn();
				c.s.executeUpdate("insert into bookPackage values('"+l11.getText()+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+l12.getText()+"', '"+l13.getText()+"', '"+l14.getText()+"', '"+l15.getText()+"')");
				JOptionPane.showMessageDialog(null, "Package Booked Successfully");
				this.setVisible(false);
			}catch(Exception e) {}
		
		}else if(ae.getSource() == b3) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new BookPackage("").setVisible(true);

	}

}
