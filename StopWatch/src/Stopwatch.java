import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int passTime = 0;// initiated state (in milliseconds)
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			passTime += 1000;
			hours = passTime / 3600000;
			minutes = (passTime/60000) % 60;
			seconds = (passTime/1000) % 60;
			
			setTime();
		}
		
		
	});
	
	Stopwatch(){
		
		setTime();
		timeLabel.setBounds(75, 100, 250, 100);
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 45));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));//框框
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		timeLabel.setBackground(Color.black);
		timeLabel.setForeground(Color.white);
		
		startButton.setBounds(75, 200, 125, 50);
		startButton.setBackground(Color.lightGray);
		startButton.setFont(new Font("Verdana", Font.BOLD, 20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(200, 200, 125, 50);
		resetButton.setBackground(Color.lightGray);
		resetButton.setFont(new Font("Verdana", Font.BOLD, 20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Clock\\clock.jpg");
		frame.setIconImage(icon.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My StopWatch APP");
		frame.setLayout(null);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.add(timeLabel);
		frame.add(startButton);
		frame.add(resetButton);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			start();
			if(started == false) {
				started = true;
				startButton.setText("STOP");
				start();
			}
			else {
				started = false;
				startButton.setText("START");
				stop();
			}
		}
		else if(e.getSource() == resetButton) {
			started = false;
			startButton.setText("START");
			reset();
		}
		
	}
	
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
	
	void reset() {
		timer.stop();
		passTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		setTime();
	}
	
	void setTime() {
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	}
}
