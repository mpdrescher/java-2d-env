package test;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import core.Environment2D;
import core.Input;
import core.Scene;
import core.ScreenObject;
import core.Settings;

public class TestScene implements Scene
{
	ArrayList<ScreenObject> returnObjects = new ArrayList<ScreenObject>();
	
	FaceObject face = new FaceObject();
	ScreenObject object = new ScreenObject(200, 300, 500, 100, "testinstr.png");
	ScreenObject lowres = new ScreenObject(300, 50, 200, 200, "testlowres.png");
	
	boolean fullscreen = false;
	
	public TestScene()
	{
		returnObjects.add(face);
		returnObjects.add(object);
		returnObjects.add(lowres);
	}
	
	public ArrayList<ScreenObject> getObjects() 
	{
		return returnObjects;
	}
	
	public void update(Environment2D env, Input in) 
	{
		if(in.isPressed(68))
		{
			face.sceneMessage(this, "r");
		}
		if(in.isPressed(65))
		{
			face.sceneMessage(this, "l");
		}
	}

	public void onKeyEvent(Environment2D env, Input in, KeyEvent e, boolean released) 
	{
		if(in.isPressed(70) && !released)
		{
			fullscreen = !fullscreen;
			Settings settings = new Settings();
			settings.setFullscreen(fullscreen);
			env.setSettings(settings);
		}
	}

	public void onMouseEvent(Environment2D env, Input in, MouseEvent e) 
	{
		
	}

	public void objMessage(ScreenObject obj, String msg) 
	{
		
	}
}
