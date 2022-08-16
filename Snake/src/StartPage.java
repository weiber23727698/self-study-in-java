import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartPage extends JFrame implements ActionListener{
	
	JButton startButton = new JButton("Start");
	JLabel label = new JLabel("Snake Game");
	JPanel panel = new JPanel();
	JLabel iconLabel = new JLabel();
	
	StartPage(){
		
		ImageIcon icon = new ImageIcon("snake.png");
		
		panel.setPreferredSize(new Dimension(400, 500));
		panel.setBackground(Color.black);
		panel.setFocusable(true);
		iconLabel.setIcon(icon);
		
		startButton.setBounds(150, 400, 300, 100);
		startButton.setFocusable(false);
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(new Font("Ink Free", Font.PLAIN, 35));
		startButton.addActionListener(this);
		
		label.setForeground(Color.white);
		label.setFont(new Font("Ink Free", Font.BOLD, 60));
		
		panel.add(label);
		panel.add(startButton);
		panel.add(iconLabel);
		//this.add(label);
		//this.add(startButton);
		this.add(panel);
		//this.setLayout(null);
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		this.setResizable(false);
		//this.setSize(new Dimension(250, 200));
		this.pack();
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);// new frame will appear in the middle	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			this.dispose();
			new GameFrame();
		}
		
	}
	
}
