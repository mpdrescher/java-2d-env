package test;

import core.Environment2D;
import core.Scene;

public class Test 
{
	public static void main(String[] args)
	{
		Scene scene = new TestScene();
		new Environment2D(scene);
	}
}