import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Myframe extends JFrame{
	
	Calendar calender;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	String time;
	String day;
	String date;
	
	public Myframe() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Clock App");
		this.setLayout(new FlowLayout());
		this.setSize(400, 200);
		this.setResizable(false);
		
		ImageIcon image = new ImageIcon("clock.jpg");
		this.setIconImage(image.getImage());
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		timeLabel = new JLabel();
		time = timeFormat.format(Calendar.getInstance().getTime());
		timeLabel.setText(time);
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));//框框
		//timeLabel.setForeground(new Color(0x00FF00));
		//timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
		
		
		dayFormat = new SimpleDateFormat("EEE");
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 50));
		
		dateFormat = new SimpleDateFormat("MM dd, yyyy");
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
		
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		
		setTime();//update the time every one second
	}
	
	public void setTime() {
		while(true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
