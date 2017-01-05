package core;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer 
{
	BufferedImage canvas;
	
	public Renderer(int width, int height)
	{
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
	}
	
	public void drawObject(Graphics g, ScreenObject obj)
	{
		g.drawImage(obj.anim.getCurrent(), obj.x, obj.y, obj.width, obj.height, null);
	}
	
	public void redraw(Environment2D env, Input input, long delta)
	{
		Graphics g = canvas.getGraphics();
		ArrayList<ScreenObject> objects = env.scene.getObjects();
		ArrayList<ScreenObject> particles = env.scene.getObjects();
		ArrayList<ScreenText> text = env.scene.getText();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		env.getScene().drawPre(g);
		
		if (objects != null)
		{
			for (int i = 0; i < objects.size(); i++)//objects
			{
				drawObject(g, objects.get(i));
				objects.get(i).update(env.getScene(), delta);
				if (input.mouseX >= objects.get(i).x && input.mouseX <= objects.get(i).x + objects.get(i).width)
				{
					if (input.mouseY >= objects.get(i).y && input.mouseY <= objects.get(i).y + objects.get(i).height)
					{
						objects.get(i).onMouseEvent(env.getScene(), input);
					}
				}
			}
		}
		
		if (particles != null)
		{
			for (int i = 0; i < particles.size(); i++)//particles
			{
				drawObject(g, objects.get(i));
				objects.get(i).update(env.getScene(), delta);
			}
		}
		
		if (text != null)//text
		{
			for (int i = 0; i < text.size(); i++)
			{
				ScreenText st = text.get(i);
				g.setFont(st.font);
				g.setColor(st.color);
				g.drawString(st.content, st.x, st.y);
			}
		}
		
		env.getScene().drawPost(g);
	}
	
	public BufferedImage getImage()
	{
		return canvas;
	}
}