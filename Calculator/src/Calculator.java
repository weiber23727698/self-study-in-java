import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel, panel2;
	
	Font font = new Font("Arial", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator(){
		
		frame = new JFrame();
		frame.setTitle("My Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		frame.setResizable(false);
		
		textField =  new JTextField("0");
		textField.setBounds(50,  25,  300,  50);
		textField.setFont(font);
		textField.setEditable(false);
		//textField.setBackground(Color.gray);
		//textField.setForeground(Color.white);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);//內容向右邊對齊
		
		addButton = new JButton("+");
		addButton.setMnemonic(KeyEvent.VK_PLUS);
		subButton = new JButton("-");
		mulButton = new JButton("×");
		divButton = new JButton("÷");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("AC");
		negButton = new JButton("+/-");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i = 0;i < 9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(font);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBackground(Color.black);
			functionButtons[i].setForeground(Color.white);
		}
		
		for(int i = 0;i < 10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(font);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBackground(Color.white);
			numberButtons[i].setForeground(Color.black);
		}
		
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		panel = new JPanel();
		panel.setBounds(50, 175, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		for(int i = 1;i <= 3;i++)
			panel.add(numberButtons[i]);
		panel.add(addButton);
		for(int i = 4;i <= 6;i++)
			panel.add(numberButtons[i]);
		panel.add(subButton);
		for(int i = 7;i <= 9;i++)
			panel.add(numberButtons[i]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		panel2 = new JPanel();
		panel2.setBounds(50, 100, 300, 150);
		panel2.setLayout(new FlowLayout());
		panel2.add(negButton);
		panel2.add(delButton);
		panel2.add(clrButton);
		
		frame.add(textField);
		frame.add(panel);
		frame.add(panel2);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0;i <= 9;i++) {
			if(e.getSource() == numberButtons[i]) {
				if(textField.getText().equals("0"))
					textField.setText(String.valueOf(i));
				else
					textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}
		else if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		else if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		else if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		else if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		else if(e.getSource() == clrButton) {
			textField.setText("0");
		}
		else if(e.getSource() == delButton) {
			String string = textField.getText();
			textField.setText("");
			for(int i = 0;i < string.length()-1;i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
			if(string.length() == 1)
				textField.setText("0");
		}
		else if(e.getSource() == negButton) {
			double tmp = Double.parseDouble(textField.getText());
			if(Math.ceil(tmp) == Math.floor(tmp))
				textField.setText(String.valueOf((int)-tmp));
			else
				textField.setText(String.valueOf(-tmp));
		}
		else if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			}
			if(Math.ceil(result) == Math.floor(result))
				textField.setText(String.valueOf((int)result));
			else
				textField.setText(String.valueOf(result));
			num1=result;
		}
		
		
		
	}

}