import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{
	
	GameFrame(){
		this.add(new GamePanel(this));
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}