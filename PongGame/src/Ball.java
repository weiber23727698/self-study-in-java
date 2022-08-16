import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle{
	
	Random random;
	int xVelocity, yVelocity;
	int speed = 3;
	
	Ball(int x, int y, int width, int height){
		super(x, y, width, height);//Rectangle
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0) {
			randomXDirection--;
		}
		setXDirection(randomXDirection);
		
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0) {
			randomYDirection--;
		}
		setYDirection(randomYDirection);
	}
	
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}
	
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}
	
	public void move() {
		x += xVelocity*speed;
		y += yVelocity*speed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, width, height);
	}
	
	
	
	
}
