package core;
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
		for(int i = 0; i < keysPressed.size(); i++)
		{
			if (key == keysPressed.get(i))
			{
				keysPressed.remove(i);
				return;
			}
		}
	}
	
	public boolean isPressed(int key)
	{
		return keysPressed.contains(key);
	}
	
	public ArrayList<Integer> getPressedKeys()
	{
		return keysPressed;
	}
	
	public int getNumberOfKeysPressed()
	{
		return keysPressed.size();
	}
	
	public int getMouseX()
	{
		return mouseX;
	}
	
	public int getMouseY()
	{
		return mouseY;
	}
	
	public boolean isMousePressed()
	{
		return mouseClicked;
	}
}
