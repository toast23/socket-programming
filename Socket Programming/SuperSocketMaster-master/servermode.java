import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class servermode implements ActionListener {
	public static void main(String[] args) {
		new servermode();
	}

	// Properties 
	JFrame frame = new JFrame("Server");
	JPanel panel = new JPanel(); 
	JButton button = new JButton("Send lmaoooo!!!");
	JTextField textField = new JTextField("Incoming text");
	SuperSocketMaster ssm;
	
	
	// Constructor 
	public servermode() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(this);
		panel.add(button);
		panel.add(textField);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		ssm = new SuperSocketMaster(9001, this); // server constructor
		ssm.connect();
	}		
	
	// Methods 
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == button) {
			ssm.sendText("lmaoooo!!!"); // sending text over the network
		}
		else if(evt.getSource() == ssm) { // if there is incomign data, event is triggered
			String strText = ssm.readText(); // read the data
			textField.setText(strText);
		}
	}


}
