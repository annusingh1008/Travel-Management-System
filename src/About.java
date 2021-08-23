import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
	JButton b1;
	String s;
	About() {
		setBounds(550, 200, 450, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("Travel and Tourism Management System");
		l1.setForeground(Color.RED);
		l1.setBounds(55, 20, 400, 25);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		s = "About Projects          \n  "
                + "\nThe objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\n•Simplifies the manual work"
                + "\n•It minimizes the documentation related work"
                + "\n•Provides up to date information"
                + "\n•Friendly Environment by providing warning messages."
                + "\n•Travelers details can be provided"
                + "\n•Booking confirmation notification"
                ;
		
		TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
		t1.setEditable(false);
		t1.setBounds(45, 65, 350, 280);
		add(t1);
		
		add(l1);
		
		b1 = new JButton("Back");
		b1.setBounds(180, 365, 70, 25);
		b1.addActionListener(this);
		add(b1);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new About().setVisible(true);

	}

}
