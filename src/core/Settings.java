package core;
public class Settings 
{
	int width;
	int height;
	boolean fullscreen;
	String title;
	boolean showCursor;
	boolean resizable;
	int canvasWidth;
	int canvasHeight;
	
	public Settings()
	{
		width = 800;
		height = 600;
		fullscreen = false;
		showCursor = false;
		resizable = false;
		title = "2dg";
		canvasWidth = 800;
		canvasHeight = 600;
	}
	
	public void setWindowSize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public void setFullscreen(boolean fullscreen)
	{
		this.fullscreen = fullscreen;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setShowCursor(boolean showCursor)
	{
		this.showCursor = showCursor;
	}
	
	public void setResizable(boolean resizable)
	{
		this.resizable = resizable;
	}
	
	public void setCanvasSize(int canvasWidth, int canvasHeight)
	{
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
	}
}