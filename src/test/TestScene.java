package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import core.Environment2D;
import core.Input;
import core.Scene;
import core.ScreenObject;
import core.ScreenText;
import core.Settings;

public class TestScene implements Scene
{
	ArrayList<ScreenObject> returnObjects = new ArrayList<ScreenObject>();
	ArrayList<ScreenText> returnText = new ArrayList<ScreenText>();
	
	FaceObject face = new FaceObject();
	ScreenObject object = new ScreenObject(200, 400, 500, 100, "testinstr.png");
	ScreenObject lowres = new ScreenObject(300, 50, 200, 200, "testlowres.png");
	
	ScreenText text = new ScreenText("Test String", 400, 300, new Font(Font.DIALOG, Font.PLAIN, 20), Color.CYAN);
	
	boolean fullscreen = false;
	
	public TestScene()
	{
		returnObjects.add(face);
		returnObjects.add(object);
		returnObjects.add(lowres);
		
		returnText.add(text);
	}
	
	public ArrayList<ScreenObject> getObjects() 
	{
		return returnObjects;
	}
	
	public ArrayList<ScreenText> getText()
	{
		return returnText;
	}
	
	public ArrayList<ScreenObject> getParticles() 
	{
		return null;
	}
	
	public void update(Environment2D env, Input in, long delta) 
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
	
	public void drawPre(Graphics g) 
	{
		
	}

	public void drawPost(Graphics g) 
	{
		
	}
}
