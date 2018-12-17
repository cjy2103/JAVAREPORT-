package block;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Block {
	ArrayList<Shape> blocks = new ArrayList<Shape>();
	JFrame frame;
	int WIDTH=800;
	int HEIGHT=600;
	String gamename="block game";
	int speed=5;
	int yDirection =1;
	int a=200;
	int score=0;
	int b=400;
	int c=200;
	int d=0;
	int f=0;
	boolean first = false;
	int change=0;
	int headY=0;
	public Block (){
		frame= new JFrame(gamename);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.addMouseListener(new MyListener());
		
		frame.getContentPane().add(new MyPanel());
		
		frame.setSize(WIDTH, HEIGHT);
		
		
		frame.setVisible(true);
		
		for(int i=0;i<2;i++) {
			blocks.add(new Shape());
		}
	}
	
public void start() {
	
		while(true) {
			if(first==true) {
			frame.repaint();
			headY += yDirection;
			for(Shape block:blocks) {
			if(headY==400) {
				if(f==0&&c!=a) {	
				score++;
					block.update();
					}
				else if(f==1&&c==a) {
					score++;
					block.update();
				}
				else {
					break;
				}
			}
			}
			}
			try {
				Thread.sleep(speed);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
	}
	}
	
	public class MyListener implements MouseListener,Runnable  {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(first==false) {
				first=true;
			}
			if(headY<600) {
			if(a>b) {
				change=b;
				b=a;
				a=change;
			}
			else {
				change=a;
				a=b;
				b=change;
			}
			}
			}
		

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}


	}
	private class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			g.setColor(Color.YELLOW);
			g.fillOval(a,400, 70, 70);
			
		
			
			g.setColor(Color.BLUE);
			g.fillOval(b,400, 70, 70);
	
			
			g.setColor(Color.BLACK);
			g.drawString("Á¡¼ö:"+score, 600, 100);
			
			for(Shape block:blocks) {
			if(f==0) {
			g.setColor(Color.BLUE);
			g.fillRect(c, headY, 70, 100);
			if(g.getColor().equals(Color.BLUE)) {
				g.setColor(Color.YELLOW);
				g.fillRect(400, headY, 70, 100);
			}
			}
			else if(f==1) {
				g.setColor(Color.YELLOW);
				g.fillRect(c, headY, 70, 100);
				if(g.getColor().equals(Color.YELLOW)) {
					g.setColor(Color.BLUE);
					g.fillRect(400, headY, 70, 100);
				}
			}
			}
		}
	}
	public class Shape {
		public Shape() {
		}
		
		public void update() {
			Random random = new Random();
			 f = random.nextInt(2);
			 headY=0;
			 if(speed>1) {
				 speed=speed-1;
			 }
			 else {
				 speed=1;
			 }
		}
	}
	
}
