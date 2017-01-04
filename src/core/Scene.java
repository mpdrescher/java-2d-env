package core;
import java.util.ArrayList;

public interface Scene 
{
	public ArrayList<ScreenObject> getObjects();
	public void update(Environment2D env, Input input);
	public void onKeyEvent(Input in);
	public void onMouseEvent(Input in);
	public void objMessage(ScreenObject obj, String msg);
}