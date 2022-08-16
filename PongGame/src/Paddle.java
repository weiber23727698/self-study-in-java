import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle{
	
	int id;
	int yVelocity;
	static int speed = 10;
	
	Paddle(int x, int y, int width, int height, int id){
		super(x, y, width, height);//Rectangle
		this.id = id;
	}
	


	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(-speed);
				move();
			}
			else if(e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(speed);
				move();
			}
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(-speed);
				move();
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(speed);
				move();
				break;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(0);
				move();
			}
			else if(e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(0);
				move();
			}
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(0);
				move();
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(0);
				move();
				break;
			}
		}
	}
	
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	
	public void move() {
		y += yVelocity;
	}
	
	public void draw(Graphics g) {
		if(id == 1) 
			g.setColor(Color.blue);
		else 
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
}
