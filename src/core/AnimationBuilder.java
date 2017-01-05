package core;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class AnimationBuilder 
{
	ArrayList<Image> images = new ArrayList<Image>();
	
	public AnimationBuilder pushImage(String imgPath)
	{
		Image image = Toolkit.getDefaultToolkit().getImage(imgPath);
		images.add(image);
		return this;
	}
	
	public AnimationBuilder pushImage(Image image)
	{
		images.add(image);
		return this;
	}
	
	public Animation build()
	{
		Image[] result = new Image[images.size()];
		for (int i = 0; i < images.size(); i++)
		{
			result[i] = images.get(i);
		}
		return (new Animation(result));
	}
}