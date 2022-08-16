import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartPage extends JFrame implements ActionListener{
	
	JButton snakeButton = new JButton("Snake Game");
	JButton TicButton = new JButton("TicTacToe Game");
	JLabel textField = new JLabel("Choose a game~");
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	
	StartPage(){
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0, 800, 100);
		title_panel.setFocusable(true);
		
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(20, 200, 20));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setOpaque(true);
		title_panel.add(textField);
		
		button_panel.setLayout(new GridLayout());
		button_panel.setBounds(0,0, 800, 100);
		button_panel.setFocusable(true);
		
		
		//snakeButton.setBounds(150, 400, 100, 100);
		snakeButton.setFocusable(false);
		snakeButton.setBackground(Color.black);
		snakeButton.setForeground(Color.white);
		snakeButton.setFont(new Font("Ink Free", Font.PLAIN, 35));
		snakeButton.addActionListener(this);

		TicButton.setFocusable(false);
		TicButton.setBackground(Color.black);
		TicButton.setForeground(Color.white);
		TicButton.setFont(new Font("Ink Free", Font.PLAIN, 35));
		TicButton.addActionListener(this);
		
		button_panel.add(snakeButton);
		button_panel.add(TicButton);
		
		
		this.setTitle("Starting Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		this.setResizable(false);
		this.setSize(new Dimension(800, 400));
		this.setLayout(new BorderLayout());
		
		
		this.add(title_panel, BorderLayout.NORTH);// panel will stick to the upside
		this.add(button_panel);
		this.setVisible(true);
		this.setLocationRelativeTo(null);// new frame will appear in the middle	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == snakeButton) {
			this.dispose();
			new GameFrame();
		}
		if(e.getSource() == TicButton) {
			this.dispose();
			new TicTacToe();
		}
		
	}
	
}
