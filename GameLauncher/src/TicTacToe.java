import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
	
	Random random = new Random();//opponent
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn = true;
	
	Set<Integer> checkEnd = new HashSet<>();
	
	TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));//becareful of frame backGroud
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(200, 20, 20));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0, 800, 10);
		
		button_panel.setLayout(new GridLayout(3, 3));//3*3 grid
		button_panel.setBackground(new Color(150, 150, 250));
		
		for(int i = 0;i < 9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setBackground(new Color(100, 180, 250));
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		
		title_panel.add(textField);
		frame.add(title_panel, BorderLayout.NORTH);// panel will stick to the upside
		frame.add(button_panel);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0;i < 9;i++) {
			if(e.getSource() == buttons[i]) {
				//buttons[i].setForeground(new Color(255,0,0));
				checkEnd.add(i);
				if(player1_turn) {
					buttons[i].setText("X");
					player1_turn = false;
					textField.setText("O turn");
					check();
				}
				else {
					buttons[i].setText("O");
					player1_turn = true;
					textField.setText("X turn");
					check();
				}
				buttons[i].setEnabled(false);
			}
		}
		
		
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(random.nextInt(2) == 0) {
			player1_turn = true;
			textField.setText("X turn");
		}
		else {
			player1_turn = false;
			textField.setText("O turn");
		}
	}
	
	public void check() {
		if(buttons[0].getText()==buttons[1].getText() && buttons[1].getText()==buttons[2].getText()) {
			if(buttons[0].getText() == "X")
				whoWins(0, 1, 2, "X");
			else if(buttons[0].getText() =="O")
				whoWins(0, 1, 2, "O");
		}
		if(buttons[3].getText()==buttons[4].getText() && buttons[4].getText()==buttons[5].getText()) {
			if(buttons[3].getText() == "X")
				whoWins(3, 4, 5, "X");
			else if(buttons[3].getText() =="O")
				whoWins(3, 4, 5, "O");
		}
		if(buttons[6].getText()==buttons[7].getText() && buttons[7].getText()==buttons[8].getText()) {
			if(buttons[6].getText() == "X")
				whoWins(6, 7, 8, "X");
			else if(buttons[6].getText() =="O")
				whoWins(6, 7, 8, "O");
		}
        if(buttons[0].getText()==buttons[3].getText() && buttons[3].getText()==buttons[6].getText()) {
			if(buttons[0].getText() == "X")
				whoWins(0, 3, 6, "X");
			else if(buttons[0].getText() =="O")
				whoWins(0, 3, 6, "O");
		}
        if(buttons[1].getText()==buttons[4].getText() && buttons[4].getText()==buttons[7].getText()) {
			if(buttons[1].getText() == "X")
				whoWins(1, 4, 7, "X");
			else if(buttons[1].getText() =="O")
				whoWins(1, 4, 7, "O");
		}
        if(buttons[2].getText()==buttons[5].getText() && buttons[5].getText()==buttons[8].getText()) {
			if(buttons[2].getText() == "X")
				whoWins(2, 5, 8, "X");
			else if(buttons[2].getText() =="O")
				whoWins(2, 5, 8, "O");
		}
        if(buttons[0].getText()==buttons[4].getText() && buttons[4].getText()==buttons[8].getText()) {
			if(buttons[0].getText() == "X")
				whoWins(0, 4, 8, "X");
			else if(buttons[0].getText() =="O")
				whoWins(0, 4, 8, "O");
		}
        if(buttons[2].getText()==buttons[4].getText() && buttons[4].getText()==buttons[6].getText()) {
			if(buttons[2].getText() == "X")
				whoWins(2, 4, 6, "X");
			else if(buttons[2].getText() =="O")
				whoWins(2, 4, 6, "O");
		}
		if(checkEnd.size() == 9) {
			textField.setText("Tie!!!");
		}
	}
	
	public void whoWins(int a, int b, int c, String winner) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int i = 0;i < 9;i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText(winner + " wins");
	}
	
	
}
