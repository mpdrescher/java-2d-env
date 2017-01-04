package test;

import java.util.ArrayList;

import core.Environment2D;
import core.Input;
import core.Scene;
import core.ScreenObject;

public class TestScene implements Scene
{
	ArrayList<ScreenObject> returnObjects = new ArrayList<ScreenObject>();
	
	FaceObject face = new FaceObject();
	ScreenObject object = new ScreenObject(200, 300, 500, 100, "testinstr.png");
	
	public TestScene()
	{
		returnObjects.add(face);
		returnObjects.add(object);
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

	public void onKeyEvent(Input in) 
	{

	}

	public void onMouseEvent(Input in) 
	{
		
	}

	public void objMessage(ScreenObject obj, String msg) 
	{
		
	}
}
