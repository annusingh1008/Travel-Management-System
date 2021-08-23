import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame implements Runnable {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	JLabel[] label = new JLabel[] {l1, l2, l3, l4, l5, l6, l7, l8, l9, l10};
	
	JLabel captions;
	
	Thread t;
	public void run() {
		String[] text = new String[] {"JW Marriott Hotel", "Mandarin Oriental Hotel", "Four Seasons Hotel", "Radisson Hotel", "Classio Hotel", "The Bay Club Hotel", "Breeze Blows Hotel", "Quick Stop Hotel", "Happy Mornings Hotel", "Moss View Hotel"};
		try {
			for(int i = 0; i <= 9; i++) {
				this.label[i].setVisible(true);
				captions.setText(text[i]);
				this.label[i].add(captions);
				Thread.sleep(2800);
				this.label[i].setVisible(false);
			}
		}catch(Exception e) {}
	}
	
	CheckHotels() {
		setBounds(550, 150, 700, 500);
		
		ImageIcon  i1 = null, i2 = null, i3 = null, i4 = null, i5 = null, i6 = null, i7 = null, i8 = null, i9 = null, i10 = null;
		ImageIcon[] image  = new ImageIcon[] {i1, i2, i3, i4, i5, i6, i7, i8, i9, i10};
		
		Image j1, j2, j3, j4, j5, j6, j7, j8, j9, j10;
		Image[] jimage = new Image[] {j1 = null, j2 = null, j3 = null, j4 = null, j5 = null, j6 = null, j7 = null, j8 = null, j9 = null, j10 = null};
		
		ImageIcon  i11, i12, i13, i14, i15, i16, i17, i18, i19, i20;
		ImageIcon[] iimage  = new ImageIcon[] {i11 = null, i12 = null, i13 = null, i14 = null, i15 = null, i16 = null, i17 = null, i18 = null, i19 = null, i20 = null};
		
		captions = new JLabel();
		captions.setBounds(30, 400, 400, 50);
		captions.setForeground(Color.WHITE);
		captions.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(captions);
		
		for(int i = 0; i <= 9; i++) {
			image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/hotel"+(i+1)+".jpg"));
			jimage[i] = image[i].getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
			iimage[i] = new ImageIcon(jimage[i]);
			this.label[i] = new JLabel(iimage[i]);
			this.label[i].setBounds(0, 0, 700, 500);
			add(this.label[i]);
		}
		
		t = new Thread(this);
		t.start();
		
	}

	public static void main(String[] args) {
		new CheckHotels().setVisible(true);

	}

}
