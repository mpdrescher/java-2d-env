package core;
/*
 * Library for 2D graphics
 * 
 * Matthias Drescher, 2017
 * 
 * 
 * An Environment is created, in which screen objects can be placed
 */

public class Environment2D
{
	Window window;
	Scene scene;
	Settings settings;
	boolean refreshSettings = false;
	
	/*
	 * Use default settings
	 */
	public Environment2D(Scene scene)
	{
		this.scene = scene;
		System.setProperty("sun.java2d.opengl", "true");
		settings = new Settings();
		window = new Window(this);
		window.buildFrame();
		window.start();
		window.run();		
	}
	
	public Environment2D(Scene scene, Settings settings)
	{
		this.scene = scene;
		System.setProperty("sun.java2d.opengl", "true");
		this.settings = settings;
		window = new Window(this);
		window.buildFrame();
		window.start();
		window.run();
	}
	
	public Scene getScene()
	{
		return scene;
	}
	
	public void setScene(Scene scene)
	{
		this.scene = scene;
	}
	
	public void setSettings(Settings settings)
	{
		this.settings = settings;
		window.refreshSettings();
	}
}