import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ResultPage extends JFrame implements ActionListener{
	JPanel title_panel = new JPanel();
	JLabel textField = new JLabel();
	JLabel scoreField = new JLabel();
	JButton replayButton = new JButton("Replay");
	JPanel button_panel = new JPanel();
	
	ResultPage(String s, int score1, int score2){
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0, 300, 100);
		title_panel.setFocusable(true);
		
		textField.setText("Player "+s+" wins!!!");
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(20, 200, 20));
		textField.setFont(new Font("Ink Free", Font.BOLD, 80));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setOpaque(true);
		
		scoreField.setText(String.valueOf(score1)+" : "+String.valueOf(score2));
		scoreField.setBackground(new Color(25, 25, 25));
		scoreField.setForeground(new Color(20, 200, 20));
		scoreField.setFont(new Font("Ink Free", Font.BOLD, 80));
		scoreField.setHorizontalAlignment(JLabel.CENTER);
		scoreField.setOpaque(true);
		
		title_panel.add(textField, BorderLayout.NORTH);
		title_panel.add(scoreField);
		
		button_panel.setLayout(new GridLayout());
		button_panel.setBounds(0,0, 300, 100);
		button_panel.setFocusable(true);
		
		replayButton.setFocusable(false);
		replayButton.setBackground(Color.black);
		replayButton.setForeground(Color.white);
		replayButton.setFont(new Font("Ink Free", Font.PLAIN, 45));
		replayButton.addActionListener(this);
		
		button_panel.add(replayButton);
		
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(600, 300));
		this.setLayout(new BorderLayout());
		//this.pack();
		
		this.add(title_panel, BorderLayout.NORTH);
		this.add(button_panel);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == replayButton) {
			this.dispose();
			new GameFrame();
		}
	}
}
