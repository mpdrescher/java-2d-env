import java.util.ArrayList;

public class Input 
{
	int mouseX = -1;
	int mouseY = -1;
	boolean mouseClicked = false;
	
	ArrayList<Integer> keysPressed = new ArrayList<Integer>();
	
	public void setMousePos(int x, int y)
	{
		mouseX = x;
		mouseY = y;
	}
	
	public void mousePressed()
	{
		mouseClicked = true;
	}
	
	public void mouseReleased()
	{
		mouseClicked = false;
	}
	
	public void keyPressed(int key)
	{
		keysPressed.add(key);
	}
	
	public void keyReleased(int key)
	{
		keysPressed.remove(key);
	}
	
	public boolean isPressed(int key)
	{
		return keysPressed.contains(key);
	}
}
