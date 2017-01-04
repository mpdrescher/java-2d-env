/*
 * Library for 2D graphics
 * 
 * Matthias Drescher, 2017
 * 
 * 
 * An Environment is created, in which screen objects can be placed
 */

public class Environment2D implements Runnable
{
	Window window;
	Scene scene;
	Settings settings;
	
	/*
	 * Use default settings
	 */
	public Environment2D(Scene scene)
	{
		this.scene = scene;
		System.setProperty("sun.java2d.opengl", "true");
		settings = new Settings();
		new Thread(this).start();
	}
	
	public Environment2D(Scene scene, Settings settings)
	{
		this.scene = scene;
		System.setProperty("sun.java2d.opengl", "true");
		this.settings = settings;
		new Thread(this).start();
	}
	
	public Scene getScene()
	{
		return scene;
	}
	
	public void setScene(Scene scene)
	{
		this.scene = scene;
	}
	
	/*
	 * Run a window in an external thread
	 */
	public void run() 
	{
		window = new Window(this, settings);
	}
}