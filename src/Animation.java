import java.awt.Image;

public class Animation 
{
	Image[] frames;
	int frame = 0;
	
	public Animation(Image image)
	{
		frames = new Image[1];
		frames[0] = image;
	}
	
	public Animation(Image[] frames)
	{
		this.frames = frames;
	}
	
	public void nextFrame()
	{
		frame ++;
		if (frame >= frames.length)
		{
			frame = 0;
		}
	}
	
	public void toFrame(int frame)
	{
		this.frame = frame;
		if (frame >= frames.length || frame < 0)
		{
			frame = 0;
		}
	}
	
	public int length()
	{
		return frames.length;
	}
	
	public Image getCurrent()
	{
		return frames[frame];
	}
}