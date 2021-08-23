import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
	JProgressBar p;
	Thread t;
	String username;
	
	public void run() {
		try {
			for(int i = 1; i <= 101; i++) {
				int m = p.getMaximum(); // 100
				int n = p.getValue();   // 32
				
				if(n < m) {      // 32 < 100
					p.setValue(p.getValue() + 1);  //33
				}else {
					i = 101;
					setVisible(false);
					new Dashboard(username).setVisible(true);
				}
				Thread.sleep(50);
			}
		}catch(Exception e) {
			
		}
	}
	
	Loading(String user) {
		username = user;
		t = new Thread(this);
		
		setBounds(500, 300, 500, 320);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("Travel And Tourism Application");
		l1.setBounds(60, 20, 600, 50);
		l1.setFont(new Font("Raleway", Font.BOLD, 25));
		l1.setForeground(Color.BLUE);
		add(l1);

		p = new JProgressBar();
		p.setBounds(140, 80, 200, 20);
		p.setStringPainted(true);
		add(p);
		
		JLabel l2 = new JLabel("Please Wait...");
		l2.setBounds(200, 97, 100, 30);
		l2.setFont(new Font("tahoma", Font.BOLD, 13));
		l2.setForeground(Color.RED);
		add(l2);
		
		JLabel l3 = new JLabel("Welcome "+username);
		l3.setBounds(20, 250, 150, 30);
		l3.setFont(new Font("tahoma", Font.BOLD, 13));
		l3.setForeground(Color.RED);
		add(l3);
		
		t.start();
	}

	public static void main(String[] args) {
		new Loading("").setVisible(true);

	}

}
