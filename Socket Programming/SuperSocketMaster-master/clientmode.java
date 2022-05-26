import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class clientmode implements ActionListener {
	public static void main(String[] args) {
		new clientmode();
	}

	// Properties 
	JFrame frame = new JFrame("Client");
	JPanel panel = new JPanel(); 
	JButton button = new JButton("Send boo!!!");
	JTextField textField = new JTextField("Incoming text");
	SuperSocketMaster ssm;
	
	
	// Constructor 
	public clientmode() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(this);
		panel.add(button);
		panel.add(textField);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		ssm = new SuperSocketMaster("127.0.0.1", 9001, this);
		ssm.connect();
	}		
	
	// Methods 
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == button) {
			ssm.sendText("BOOOOOOOO!!!");
		}
		else if(evt.getSource() == ssm) {
			String strText = ssm.readText();
			textField.setText(strText);
		}
	}


}
