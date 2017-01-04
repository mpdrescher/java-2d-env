import java.applet.Applet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Window extends Applet implements Runnable, MouseListener, MouseMotionListener, KeyListener, ComponentListener
{
	private long lastTick = System.currentTimeMillis();
	private int systemBreakTime = 20;
	private long deltaTime = 1;
	Image dbImage;
	Graphics dbg;
	
	Environment2D env;
	Renderer renderer;
	
	Input input = new Input();

	public void paint(Graphics g)
	{
		renderer.redraw(env, input, deltaTime);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		BufferedImage img = renderer.getImage();
		double scale = this.getHeight()/ ((double) (img.getHeight()));
		int offX = (int) ((this.getWidth()-img.getWidth()*scale)/2);
		g.drawImage(img, offX, 0, (int) (img.getWidth()*scale), (int) (img.getHeight()*scale), this);
	}

	public void start()
	{
		Thread th = new Thread(this);
		th.start();
	}

	public Window(Environment2D env, Settings settings)
	{
		this.env = env;
		this.renderer = new Renderer(settings.canvasWidth, settings.canvasHeight);
		String name = settings.title;
		int width = settings.width;
		int height = settings.height;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame(name);
		frame.setBounds(d.width/2-width/2, d.height/2-height/2, width, height);
		if (settings.showCursor)
		{
			BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
			Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
			frame.setCursor(blankCursor);
		}
		addKeyListener(this);
		addMouseListener(this);
		addComponentListener(this);
		frame.getContentPane().add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		int borderX = width - getWidth();
		int borderY = height - getHeight();
		frame.setBounds(d.width/2-(width+borderX)/2, d.height/2-(height+borderY)/2, width + borderX, height + borderY);
		this.start();
		this.run();
	}

	public void update (Graphics g)
	{
		if (dbImage == null)
		{
			dbImage = createImage (this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics ();
		}
		dbg.setColor (getBackground ());
		dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);
		dbg.setColor (getForeground());
		paint (dbg);
		g.drawImage (dbImage, 0, 0, this);
	}

	public void run()
	{
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while (true)
		{
			while(System.currentTimeMillis()-lastTick<systemBreakTime)
			{
				try{
					Thread.sleep (1);
				}catch(Exception e){}
			}
			deltaTime = System.currentTimeMillis()-lastTick;
			repaint();
			lastTick = System.currentTimeMillis();
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}

	public void mouseClicked(MouseEvent e)
	{
		
	}

	public void mouseEntered(MouseEvent e)
	{

	}

	public void mouseExited(MouseEvent e)
	{

	}

	public void mousePressed(MouseEvent e)
	{
		input.setMousePos(e.getX(), e.getY());
		input.mousePressed();
		env.getScene().onMouseEvent(input);
	}

	public void mouseReleased(MouseEvent e)
	{
		input.setMousePos(e.getX(), e.getY());
		input.mouseReleased();
		env.getScene().onMouseEvent(input);
	}

	public void keyPressed(KeyEvent e)
	{
		input.keyPressed(e.getKeyCode());
		env.getScene().onKeyEvent(input);
	}

	public void keyReleased(KeyEvent e)
	{
		input.keyPressed(e.getKeyCode());
		env.getScene().onKeyEvent(input);
	}

	public void keyTyped(KeyEvent e)
	{
		
	}

	public void mouseDragged(MouseEvent e) 
	{
		input.setMousePos(e.getX(), e.getY());
		env.getScene().onMouseEvent(input);
	}

	public void mouseMoved(MouseEvent e) 
	{
		input.setMousePos(e.getX(), e.getY());
		env.getScene().onMouseEvent(input);
	}

	public void componentHidden(ComponentEvent e) {}
	public void componentMoved(ComponentEvent e) {}
	public void componentResized(ComponentEvent e) {
		dbImage = null;
	}
	public void componentShown(ComponentEvent e) {}
}