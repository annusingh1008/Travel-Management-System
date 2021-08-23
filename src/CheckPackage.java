import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame{
	CheckPackage( ){
		setBounds(570, 220, 600, 440);
		
		JTabbedPane pane = new JTabbedPane();
		
		String[] package1 = new String[] {"GOLD PACKAGE", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour", "Daily Buffet", 
				"Welcome Drinks on Arrival", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", 
				"SUMMER SPECIAL", "Rs 12000/-", "package1.jpg"};
		
		String[] package2 = new String[] {"SILVER PACKAGE", "5 Days and 6 Nights", "Toll Free & Entrance Free Tickets", "Meet and Greeet at Airport",
				"Welcome Drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", 
				"WINTER SPECIAL", "Rs 24000/-", "package2.jpg"};
		
		String[] package3 = new String[] {"BRONZE PACKAGE", "6 Days and 5 Nights", "Return Airfare", "Free Clubbing and Horse Riding",
				"Welcome Drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", 
				"WINTER SPECIAL", "Rs 32000/-", "package3.jpg"};
		
		JPanel p1 = createPackage(package1);
		pane.addTab("Package 1", null, p1);
		
		JPanel p2 = createPackage(package2);
		pane.addTab("Package 2", null, p2);
		
		JPanel p3 = createPackage(package3);
		pane.addTab("Package 3", null, p3);
		add(pane);
		
	}
	
	public JPanel createPackage(String[] pack) {
		JPanel p1 = new JPanel();
		p1.setBackground(Color.white);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel(pack[0]);
		l1.setBounds(50, 10, 200, 20);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		p1.add(l1);
		
		JLabel l2 = new JLabel(pack[1]);
		l2.setBounds(15, 50, 200, 20);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setForeground(Color.red);
		p1.add(l2);
		
		JLabel l3 = new JLabel(pack[2]);
		l3.setBounds(15, 90, 250, 20);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setForeground(Color.BLUE);
		p1.add(l3);
		
		JLabel l4 = new JLabel(pack[3]);
		l4.setBounds(15, 130, 250, 20);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setForeground(Color.red);
		p1.add(l4);
		
		JLabel l5 = new JLabel(pack[4]);
		l5.setBounds(15, 170, 200, 20);
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setForeground(Color.BLUE);
		p1.add(l5);
		
		JLabel l6 = new JLabel(pack[5]);
		l6.setBounds(15, 210, 200, 20);
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l6.setForeground(Color.red);
		p1.add(l6);
		
		JLabel l7 = new JLabel(pack[6]);
		l7.setBounds(15, 250, 200, 20);
		l7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l7.setForeground(Color.BLUE);
		p1.add(l7);
		
		JLabel l8 = new JLabel(pack[7]);
		l8.setBounds(15, 290, 200, 20);
		l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l8.setForeground(Color.red);
		p1.add(l8);
		
		JLabel l9 = new JLabel(pack[8]);
		l9.setBounds(15, 330, 200, 20);
		l9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l9.setForeground(Color.BLUE);
		p1.add(l9);
		
		JLabel l10 = new JLabel(pack[9]);
		l10.setBounds(220, 330, 200, 20);
		l10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l10.setForeground(Color.red);
		p1.add(l10);
		
		JLabel l11 = new JLabel(pack[10]);
		l11.setBounds(460, 330, 200, 20);
		l11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l11.setForeground(Color.red);
		p1.add(l11);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
		Image i2 = i1.getImage().getScaledInstance(280, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l12 = new JLabel(i3);
		l12.setBounds(260, 40, 280, 250);
		p1.add(l12);
		
		return p1;
	}

	public static void main(String[] args) {
		new CheckPackage().setVisible(true);

	}

}
