import java.awt.event.*;
import javax.swing.*;



import java.awt.*;
import java.util.*;

public class LoginPage implements ActionListener{
	
	JFrame frame = new JFrame("Login Page");
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton signUpButton = new JButton("Sign up");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();// won't display our input
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	
	Map<String, String> loginInfo = new HashMap<>();
	
	LoginPage(Map<String, String> loginInfoOriginal){	
		this.loginInfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50, 100,  75, 25);
		userPasswordLabel.setBounds(50, 150,  75, 25);
		messageLabel.setBounds(50, 250, 350, 35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		messageLabel.setHorizontalAlignment(JLabel.CENTER);
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		loginButton.setBackground(Color.LIGHT_GRAY);
		
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setBackground(Color.lightGray);
		
		signUpButton.setBounds(175, 50, 100, 25);
		signUpButton.setFocusable(false);
		signUpButton.addActionListener(this);
		signUpButton.setBackground(Color.lightGray);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(signUpButton);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton) {
			String ID = userIDField.getText();
			String pwd = String.valueOf(userPasswordField.getPassword());
			
			if(loginInfo.containsKey(ID)) {
				if(loginInfo.get(ID).equals(pwd)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					frame.dispose();//close the current frame
					new WelcomePage(ID, loginInfo);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password!!!");
					userPasswordField.setText("");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("You haven't signed up for it!!!");
				reset();
			}	
		}
		else if(e.getSource() == resetButton) {
			reset();
		}
		else if(e.getSource() == signUpButton) {
			String ID = userIDField.getText();
			String pwd = String.valueOf(userPasswordField.getPassword());
			if(loginInfo.containsKey(ID)) {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Account exists!!!");
				reset();
			}
			else {
				if(userPasswordField.getPassword().length == 0) {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Password is too short!!!");
					userPasswordField.setText("");
				}
				else if(userIDField.getText().length() == 0) {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Invalid ID!!!");
					userPasswordField.setText("");
				}
				else {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Sign up successful!!!");
					loginInfo.put(ID, pwd);
					reset();
				}
				
			}
		}
	}
		
	private void reset() {
		userIDField.setText("");
		userPasswordField.setText("");
	}


}
