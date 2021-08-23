import javax.swing.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {
	JButton b1;
	Paytm() {
		JEditorPane j = new JEditorPane();
		j.setEditable(false);
		
		try {
			j.setPage("https://paytm.com/credit-card-bill-payment");
		}catch(Exception e) {
			j.setContentType("text/html");
			j.setText("<html>Could not load, Error 404</html>");
		}

        JScrollPane js = new JScrollPane(j);
        getContentPane().add(js);
		
        setBounds(600, 175, 600, 500);
		
		b1 = new JButton("Back");
		b1.setBounds(450, 30, 70, 30);
		b1.addActionListener(this);
		j.add(b1);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			this.setVisible(false);
			new Payment().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Paytm().setVisible(true);

	}

}
