package core;
import java.awt.Image;
import java.awt.Toolkit;

public class ScreenObject 
{
	int x;
	int y;
	int width;
	int height;
	Animation anim;
	
	public ScreenObject(int x, int y, int width, int height, Image image)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.anim = new Animation(image);
	}
	
	public ScreenObject(int x, int y, int width, int height, String imgPath)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.anim = new Animation(Toolkit.getDefaultToolkit().getImage(imgPath));
	}
	
	public ScreenObject(int x, int y, int width, int height, Animation anim)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.anim = anim;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setPos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public void setBounds(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void translate(int x, int y)
	{
		this.x += x;
		this.y += y;
	}
	
	public void transform(int w, int h)
	{
		this.width += w;
		this.height += h;
	}
	
	public Animation getAnim()
	{
		return anim;
	}
	
	/*
	 * called on update
	 */
	public void update(Scene scene, long delta)
	{
		
	}
	
	/*
	 * called on mouse event
	 */
	public void onMouseEvent(Scene scene, Input in)
	{
		
	}
	
	/*
	 * called on message from a scene
	 */
	public void sceneMessage(Scene sender, String message)
	{
		
	}
}