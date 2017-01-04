package core;

public class Timer 
{
	int value;
	int size;
	Timed callback;
	
	public Timer(Timed callback, int size)
	{
		value = 0;
		this.callback = callback;
		this.size = size;
		if (size <= 0)
		{
			System.out.println("invalid timer size: " + size);
			System.exit(-1);
		}
	}
		
	public void next()
	{
		value ++;
		if (value == size)
		{
			value = 0;
			callback.onTimerZero(this);
		}
	}
	
	public void skip(int frames)
	{
		value += frames;
		if (value >= size)
		{
			value = value%size;
			callback.onTimerZero(this);
		}
	}
}