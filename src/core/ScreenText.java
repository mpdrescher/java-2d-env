package core;

import java.awt.Color;
import java.awt.Font;

public class ScreenText 
{
	String content;
	int x;
	int y;
	Font font;
	Color color;
	
	public ScreenText(String content, int x, int y, Font font)
	{
		color = Color.BLACK;
		this.content = content;
		this.x = x;
		this.y = y;
		this.font = font;
	}
	public ScreenText(String content, int x, int y, Font font, Color color)
	{
		this.color = color;
		this.content = content;
		this.x = x;
		this.y = y;
		this.font = font;
	}
	
	public void setText(String content)
	{
		this.content = content;
	}
	
	public String getText()
	{
		return content;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setPos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setFont(Font font)
	{
		this.font = font;
	}
}
