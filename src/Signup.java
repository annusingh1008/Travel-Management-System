import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
	JButton b1, b2;
	JTextField t1, t2, t3, t4;
	Choice c1;
	
	Signup() {
		setBounds(420,300,650,260);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(133, 193, 233));
		p1.setBounds(0, 0, 370, 280);
		p1.setLayout(null);
		add(p1);
		
		JLabel l1 = new JLabel("Username");
		l1.setFont(new Font("Tahoma", Font.BOLD, 12));
		l1.setBounds(30, 10, 110, 30);
		p1.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(150, 15, 180, 20);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t1);
		
		JLabel l2 = new JLabel("Name");
		l2.setFont(new Font("Tahoma", Font.BOLD, 12));
		l2.setBounds(30, 40, 110, 30);
		p1.add(l2);
		
		t2 = new JTextField();
		t2.setBounds(150, 45, 180, 20);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t2);
		
		JLabel l3 = new JLabel("Password");
		l3.setFont(new Font("Tahoma", Font.BOLD, 12));
		l3.setBounds(30, 70, 110, 30);
		p1.add(l3);
		
		t3 = new JTextField();
		t3.setBounds(150, 75, 180, 20);
		t3.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t3);
		
		JLabel l4 = new JLabel("Security Question");
		l4.setFont(new Font("Tahoma", Font.BOLD, 12));
		l4.setBounds(30, 100, 110, 30);
		p1.add(l4);
		
		c1 = new Choice();
		c1.add("Your Nickname");
		c1.add("Your Favourite Sport");
		c1.add("In which city you're born");
		c1.add("Your Lucky Number");
		c1.setBounds(150, 105, 225, 20);
		p1.add(c1);
		
		JLabel l5 = new JLabel("Answer");
		l5.setFont(new Font("Tahoma", Font.BOLD, 12));
		l5.setBounds(30, 130, 110, 30);
		p1.add(l5);
		
		t4 = new JTextField();
		t4.setBounds(150, 135, 180, 20);
		t4.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t4);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
		Image i2 = i1.getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l6 = new JLabel(i3);
		l6.setBounds(410, 20, 190, 190);
		add(l6);
		
		b1 = new JButton("Create");
		b1.setBounds(50, 170, 100, 25);
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.setBackground(Color.WHITE);
		b1.setForeground(new Color(133, 193, 233));
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(190, 170, 100, 25);
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.setBackground(Color.WHITE);
		b2.setForeground(new Color(133, 193, 233));
		b2.addActionListener(this);
		p1.add(b2);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String username = t1.getText();
			String name = t2.getText();
			String password = t3.getText();
			String security = c1.getSelectedItem();
			String answer = t4.getText();
			
			String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+security+"', '"+answer+"')";
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				this.setVisible(false);
				new Login().setVisible(true);
			}catch(Exception e) {
				
			}
			
			
		}else if(ae.getSource() == b2) {
			new Login().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Signup().setVisible(true);
		

	}

}
