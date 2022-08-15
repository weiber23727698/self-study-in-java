import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.*;

public class WelcomePage {
	
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	JButton backButton = new JButton("Back");

	WelcomePage(String ID, Map<String, String> loginInfo){
		
		/*
		ImageIcon imageIcon = new ImageIcon("left.jpg");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);	
		backButton.setIcon(imageIcon);
		*/
		
		backButton.setBounds(0, 0, 100, 50);
		backButton.setFont(new Font("Arial", Font.PLAIN, 20));
		backButton.setFocusable(false);
		backButton.setBackground(Color.LIGHT_GRAY);
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginPage(loginInfo);
			}
			
		});
		
		//welcomeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		welcomeLabel.setBounds(0 ,0 ,420 ,250);
		welcomeLabel.setFont(new Font(null, Font.PLAIN ,25));
		welcomeLabel.setText("Hello " + ID  + "~~~");
		welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		welcomeLabel.setAlignmentY(JFrame.CENTER_ALIGNMENT);
		
		frame.add(welcomeLabel);
		frame.add(backButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
}
