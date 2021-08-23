import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener {
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2, b3;
	
	ForgotPassword() {
		setBounds(430, 300, 700, 280);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
		Image i2 = i1.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l6 = new JLabel(i3);
		l6.setBounds(485, 40, 160, 160);
		add(l6);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBounds(20, 20, 430, 205);
		add(p);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(20, 10, 80, 30);
		l1.setFont(new Font("Tahoma", Font.BOLD, 12));
		p.add(l1);
		
		t1 = new JTextField();
		t1.setBorder(BorderFactory.createEmptyBorder());
		t1.setBounds(170, 15, 150, 20);
		p.add(t1);
		
		b1 = new JButton("Search");
		b1.setBackground(Color.GRAY);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(330, 15, 90, 18);
		p.add(b1);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(20, 40, 80, 30);
		l2.setFont(new Font("Tahoma", Font.BOLD, 12));
		p.add(l2);
		
		t2 = new JTextField();
		t2.setBorder(BorderFactory.createEmptyBorder());
		t2.setBounds(170, 45, 150, 20);
		p.add(t2);
		
		JLabel l3 = new JLabel("Your Security Question");
		l3.setBounds(20, 70, 140, 30);
		l3.setFont(new Font("Tahoma", Font.BOLD, 12));
		p.add(l3);
		
		t3 = new JTextField();
		t3.setBorder(BorderFactory.createEmptyBorder());
		t3.setBounds(170, 75, 200, 20);
		p.add(t3);
		
		JLabel l4 = new JLabel("Answer");
		l4.setBounds(20, 100, 80, 30);
		l4.setFont(new Font("Tahoma", Font.BOLD, 12));
		p.add(l4);
		
		t4 = new JTextField();
		t4.setBorder(BorderFactory.createEmptyBorder());
		t4.setBounds(170, 105, 150, 20);
		p.add(t4);
		
		b2 = new JButton("Retrieve");
		b2.setBackground(Color.GRAY);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(330, 105, 90, 18);
		p.add(b2);
		
		JLabel l5 = new JLabel("Password");
		l5.setBounds(20, 130, 80, 30);
		l5.setFont(new Font("Tahoma", Font.BOLD, 12));
		p.add(l5);
		
		t5 = new JTextField();
		t5.setBorder(BorderFactory.createEmptyBorder());
		t5.setBounds(170, 135, 150, 20);
		p.add(t5);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.GRAY);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		b3.setBounds(140, 170, 80, 18);
		p.add(b3);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		Conn c = new Conn();
		if(ae.getSource() == b1) {
			try {
				String sql = "select * from account where username = '"+t1.getText()+"'";
				ResultSet rs = c.s.executeQuery(sql);  // executeQuery returns the object of ResultSet class
				//rs contains the whole row
				while(rs.next()) {
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("security"));
				}
			}catch(Exception e) {
				
			}
		}else if(ae.getSource() == b2) {
			try {
				String sql = "select * from account where answer = '"+t4.getText()+"'AND username = '"+t1.getText()+"'";
				ResultSet rs = c.s.executeQuery(sql);
				while(rs.next()) {
					t5.setText(rs.getString("password"));
				}
			}catch(Exception e) {
				
			}
			
		}else if(ae.getSource() == b3) {
			this.setVisible(false);
			new Login().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new ForgotPassword().setVisible(true);

	}

}
