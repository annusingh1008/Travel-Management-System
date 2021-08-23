import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JButton b1, b2, b3;
	JTextField t1;
	JPasswordField t2;
	
	Login() {
//		setSize(400, 400);
//		setLocation(400,200);
		setLayout(null); // BorderLayout(bydefault), flowLayout, gridLayout
		setBounds(450, 300, 650, 300);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 300, 300);
		p1.setBackground(new Color(131, 193, 233));
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(70, 80, 150, 150);
		p1.add(l1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(300, 15, 320, 230);
		add(p2);
		
		JLabel l2 = new JLabel("Username");
		l2.setBounds(50, 20, 100, 25);
		l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		p2.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(50, 50, 200, 25);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p2.add(t1);
		
		JLabel l3 = new JLabel("Password");
		l3.setBounds(50, 80, 100, 25);
		l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		p2.add(l3);
		
		t2 = new JPasswordField();
		t2.setBounds(50, 110, 200, 25);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p2.add(t2);
		
		b1 = new JButton("Login");
		b1.setBounds(50, 150, 90, 25);
		b1.setBackground(new Color(131, 193, 233));
		b1.setForeground(Color.WHITE);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		p2.add(b1);
		
		b2 = new JButton("Signup");
		b2.setBounds(160, 150, 90, 25);
		b2.setForeground(new Color(131, 193, 233));
		b2.setBackground(Color.WHITE);
		b2.setBorder(new LineBorder(new Color(131, 193, 233)));
		b2.addActionListener(this);
		p2.add(b2);
		
		b3 = new JButton("Forgot Password");
		b3.setBounds(90, 190, 120, 25);
		b3.setBackground(Color.WHITE);
		b3.setForeground(new Color(131, 193, 233));
		b3.setBorder(new LineBorder(new Color(131, 193, 233)));
		b3.addActionListener(this);
		p2.add(b3);
		
		JLabel l4 = new JLabel("Trouble in Login...");
		l4.setBounds(215, 190, 110, 25);
		l4.setForeground(Color.RED);
		p2.add(l4);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				Conn c = new Conn();
				String username = t1.getText();
				String password = t2.getText();
				String sql = "select * from account where username = '"+username+"'AND password = '"+password+"'";
				
				ResultSet cs = c.s.executeQuery(sql);
				
				if(cs.next()) {
					this.setVisible(false);
					new Loading(username).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Login");
				}
			}catch(Exception e) {
				
			}
			
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
			new Signup().setVisible(true);

			
		}else if(ae.getSource() == b3) {
			this.setVisible(false);
			new ForgotPassword().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Login();

	}

}
