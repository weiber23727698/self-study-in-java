import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
	
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.6666));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;// player1
	Paddle paddle2;// player2
	Ball ball;
	Score score;
	
	GameFrame frame;
	//JLabel res = new JLabel();
		
	GamePanel(GameFrame frame){
		
		this.frame = frame;
		
		newPaddles();
		newBall();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		this.setLayout(new BorderLayout());
		
		gameThread = new Thread(this);// Runnable
		gameThread.start();
				
	}
	
	public void newBall() {
		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	
	public void newPaddles() {//generate 2 paddle
		paddle1 = new Paddle(0, (GAME_HEIGHT/2 - PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2 - PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		this.graphics = image.getGraphics();
		draw(this.graphics);
		g.drawImage(image, 0, 0, this);//GamePanel itself
	}
	
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
		g.setColor(Color.white);
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);// 中線
		Toolkit.getDefaultToolkit().sync(); // it helps with the animation
	}
	
	public void move() {// allow paddles and ball to move more smoothly
		paddle1.move();
		paddle2.move();
		ball.move();
	}

	public void checkCollision() {
		// stop paddles at window edges
		if(paddle1.y <= 0)
			paddle1.y = 0;
		else if(paddle1.y >= GAME_HEIGHT-PADDLE_HEIGHT)
			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		if(paddle2.y <= 0)
			paddle2.y = 0;
		else if(paddle2.y >= GAME_HEIGHT-PADDLE_HEIGHT)
			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
		// bounce ball off top & bottom window edges
		if(ball.y <= 0)
			ball.setYDirection(-ball.yVelocity);
		else if(ball.y >= GAME_HEIGHT-BALL_DIAMETER)
			ball.setYDirection(-ball.yVelocity);
		// bounce ball of paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++;// speed up when collision
			if(ball.yVelocity > 0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		else if(ball.intersects(paddle2)) {
			ball.xVelocity = (ball.xVelocity+1)*(-1);
			if(ball.yVelocity > 0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		// give a player 1 point and creates new paddles & ball(over a turn)
		if(ball.x <= 0) {
			score.player2++;
			checkResult();
			newPaddles();
			newBall();
		}
		else if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.player1++;
			checkResult();
			newPaddles();
			newBall();
		}
	}
	
	public void checkResult() {
		if(score.player1 == 10) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.dispose();
			new ResultPage("1", 10, score.player2);
			try {
				gameThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(score.player2 == 10) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.dispose();
			new ResultPage("2", score.player1, 10);
			try {
				gameThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double timeGap = 0;
		
		while(true) {
			long now = System.nanoTime();
			timeGap += (now-lastTime) / ns;
			lastTime = now;
			if(timeGap >= 1) {
				move();
				checkCollision();
				repaint();
				timeGap--;
			}
		}
	}
	
	public class AL extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
	
	
	
	
	
	
	
	
	

}
