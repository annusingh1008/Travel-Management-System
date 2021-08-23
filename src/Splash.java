import javax.swing.*;
import java.awt.*;
public class Splash {

	public static void main(String[] args) {
		SplashFrame frame  = new SplashFrame();
		frame.setVisible(true);
		int x = 1;
		for(int i = 0; i <= 500; i+=6, x+=7) {
			frame.setLocation(750 - (x + i)/2, 400 - i/2);
			frame.setSize(x + i, i);
			try {
				Thread.sleep(10);
			} catch(Exception e) {}
		}
		
		
		frame.setVisible(true);
	}

}

class SplashFrame extends JFrame implements Runnable{
	Thread t1;
	
	SplashFrame() {
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		add(l1);
		
//		setLocation(300, 200);
//		setSize(600, 400);
		setBounds(200, 200, 1100, 500); // location, size
		setUndecorated(true);
		
		t1 = new Thread(this);
		t1.start();
	}
	public void run() {
		try {
			Thread.sleep(7000);
			this.setVisible(false);
			
			new Login().setVisible(true);
		}catch(Exception e) {
			
		}
	}
}