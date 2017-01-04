package core;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public interface Scene 
{
	public ArrayList<ScreenObject> getObjects();
	public void update(Environment2D env, Input input);
	public void onKeyEvent(Environment2D env, Input in, KeyEvent e, boolean release);
	public void onMouseEvent(Environment2D env, Input in, MouseEvent e);
	public void objMessage(ScreenObject obj, String msg);
}