package core;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public interface Scene 
{
	//For objects that have a long live span, and may be a part of the scenery
	public ArrayList<ScreenObject> getObjects();
	//basically the same, but no constant reconcat of the object list is neccessary,
	//coming from the short lifespan of the particles
	//This could also be used for bullets or anything that doesn't need to be checked
	//for mouse events/ has a short life span
	//(Particles are not checked for mouse events, but they are updated (update function)) 
	public ArrayList<ScreenObject> getParticles();
	public ArrayList<ScreenText> getText();
	
	//called every tick, delta is the time that elapsed between the two frames
	public void update(Environment2D env, Input input, long delta);
	//called on ANY key event, release is raised on keyRelease
	public void onKeyEvent(Environment2D env, Input in, KeyEvent e, boolean release);
	//called on ANY mouse event
	public void onMouseEvent(Environment2D env, Input in, MouseEvent e);
	//called when the object obj writes a message to this scene
	//used for communication between objects/scene
	//communication should be held low, because of the neccessary parsing
	public void objMessage(ScreenObject obj, String msg);
	
	//Pre -> background drawing
	//Post -> foreground drawing
	public void drawPre(Graphics g);
	public void drawPost(Graphics g);
}