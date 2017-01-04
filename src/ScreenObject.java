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
	
	public Animation getAnimation()
	{
		return anim;
	}
	
	public void update(Scene scene, long delta)
	{
		
	}
	
	public void onMouseEvent(Scene scene, Input in)
	{
		
	}
	
	public void sceneMessage(Scene sender, String message)
	{
		
	}
}