package test;

import core.Animation;
import core.AnimationBuilder;
import core.Input;
import core.Scene;
import core.ScreenObject;
import core.Timed;
import core.Timer;

public class FaceObject extends ScreenObject implements Timed
{
	int x = 100;
	int y = 100;
	double val = 0;
	
	Timer animTimer = new Timer(this, 100);
	
	public FaceObject() 
	{
		super(100, 100, 100, 100, new AnimationBuilder()
				.pushImage("test.png")
				.pushImage("test2.png")
				.build());
	}
	
	public void update(Scene scene, long delta)
	{
		animTimer.next();
		this.setPos(x, y);
	}
	
	public void onMouseEvent(Scene scene, Input in)
	{
		if (in.isMousePressed())
		{
			val += 0.2;
			y = (int) (Math.sin(val)*15+100);
		}
	}
	
	public void sceneMessage(Scene sender, String message)
	{
		if (message.equals("l"))
		{
			if (x >= 20)
			{
				x -= 10;
			}
		}
		else if (message.equals("r"))
		{
			if (x <= 580)
			{
				x += 10;
			}
		}
	}

	public void onTimerZero(Timer timer) 
	{
		this.getAnim().nextFrame();
	}
}