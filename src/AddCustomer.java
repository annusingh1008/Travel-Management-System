import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JComboBox c1;
	JRadioButton r1, r2;
	JButton b1, b2;
	
    AddCustomer(String username) {
    	setBounds(450, 200, 700, 470);
    	getContentPane().setBackground(Color.WHITE);
    	setLayout(null);
    	
    	JLabel l1 = new JLabel("Username : ");
    	l1.setBounds(20, 15, 120, 25);
    	add(l1);
    	
    	t1 = new JTextField();
    	t1.setBounds(160, 15, 170, 25);
    	add(t1);
    	
    	JLabel l2 = new JLabel("ID : ");
    	l2.setBounds(20, 55, 130, 25);
    	add(l2);
    	
    	c1 = new JComboBox(new String[] { "Passport", "Aadhar Card", "Pan Card", "Ration Card" });
    	c1.setBounds(160, 55, 170, 25);
    	add(c1);
    	
    	JLabel l3 = new JLabel("Number : ");
    	l3.setBounds(20, 95, 120, 25);
    	add(l3);
    	
    	t2 = new JTextField();
    	t2.setBounds(160, 95, 170, 25);
    	add(t2);
    	
    	JLabel l4 = new JLabel("Name : ");
    	l4.setBounds(20, 135, 120, 25);
    	add(l4);
    	
    	t3 = new JTextField();
    	t3.setBounds(160, 135, 170, 25);
    	add(t3);
    	
    	JLabel l5 = new JLabel("Gender : ");
    	l5.setBounds(20, 175, 120, 25);
    	add(l5);
    	
    	r1 = new JRadioButton("Male");
    	r1.setBackground(Color.WHITE);
    	r1.setBounds(160, 175, 70, 25);
    	add(r1);
    	
    	r2 = new JRadioButton("Female");
    	r2.setBackground(Color.WHITE);
    	r2.setBounds(260, 175, 70, 25);
    	add(r2);
    	
    	JLabel l6 = new JLabel("Country : ");
    	l6.setBounds(20, 215, 120, 25);
    	add(l6);
    	
    	t4 = new JTextField();
    	t4.setBounds(160, 215, 170, 25);
    	add(t4);
    	
    	JLabel l7 = new JLabel("Address : ");
    	l7.setBounds(20, 255, 120, 25);
    	add(l7);
    	
    	t5 = new JTextField();
    	t5.setBounds(160, 255, 170, 25);
    	add(t5);
    	
    	JLabel l8 = new JLabel("Phone : ");
    	l8.setBounds(20, 295, 120, 25);
    	add(l8);
    	
    	t6 = new JTextField();
    	t6.setBounds(160, 295, 170, 25);
    	add(t6);
    	
    	JLabel l9 = new JLabel("Email : ");
    	l9.setBounds(20, 335, 120, 25);
    	add(l9);
    	
    	t7 = new JTextField();
    	t7.setBounds(160, 335, 170, 25);
    	add(t7);
    	
    	b1 = new JButton("Add");
    	b1.setBackground(Color.BLACK);
    	b1.setForeground(Color.WHITE);
    	b1.addActionListener(this);
    	b1.setBounds(50, 380, 100, 25);
    	add(b1);
    	
    	b2 = new JButton("Back");
    	b2.setBackground(Color.BLACK);
    	b2.setForeground(Color.WHITE);
    	b2.addActionListener(this);
    	b2.setBounds(185, 380, 100, 25);
    	add(b2);
    	
    	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
    	Image i2 = i1.getImage().getScaledInstance(350,450, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
    	JLabel l10 = new JLabel(i3);
    	l10.setBounds(340, 15, 350, 450);
    	add(l10);
    	
    	//System.out.println(username);
    	
    	try {
    		Conn c = new Conn();
    		ResultSet rs = c.s.executeQuery("Select * from account where username = '"+username+"'");
    		
    		while(rs.next()) {
    			t1.setText(rs.getString("Username"));
    			t3.setText(rs.getString("name"));
    		}
    	}catch(Exception e) {}

    }
    
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource() == b1) {
	    	String username = t1.getText();
	    	String id = (String) c1.getSelectedItem();
	    	String number = t2.getText();
	    	String name  = t3.getText();
	    	String radio = null;
	    	if(r1.isSelected()) {
	    		radio = "Male";
	    	}else if(r2.isSelected()) {
	    		radio = "Female";
	    	}
	    	String country = t4.getText();
	    	String address = t5.getText();
	    	String phone  = t6.getText();
	    	String email = t7.getText();
	    	
	    	String q = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '" +name+"', '"+radio+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
	    	try {
	    		Conn  c = new Conn();
	    		c.s.executeUpdate(q);
	    		
	    		JOptionPane.showMessageDialog(null, "Customer details added successfully");
	    		this.setVisible(false);
	    		
	    	}catch(Exception e) {}
    	}else if(ae.getSource() == b2) {
    		this.setVisible(false);
    	}
    }
	
	public static void main(String[] args) {
		new AddCustomer("").setVisible(true);
	}

}
