import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class AnimationBuilder 
{
	ArrayList<Image> images;
	
	public void pushImage(String imgPath)
	{
		images.add(Toolkit.getDefaultToolkit().getImage(imgPath));
	}
	
	public void pushImage(Image image)
	{
		images.add(image);
	}
	
	public Animation build()
	{
		return (new Animation((Image[]) (images.toArray())));
	}
}