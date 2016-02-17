package math.model;

public class RecursionTool 
{
	public double fibonacciNumber(double position)
	{
		//Bounds Check
		if(position < 0)
		{
			return Integer.MIN_VALUE;
		}
		
		//Base Case
		if(position == 0 || position == 1)
		{
			return 1;
		}
		else //Recusive case
		{
			return fibonacciNumber(position -1) + fibonacciNumber(position - 2);
		}
	}
	
	public int factorialNumber(int position)
	{
		//Bounds Check
		if(position < 0)
		{
			return Integer.MIN_VALUE;
		}
		
		
		//Base Case
		if(position == 0)
		{
			return 1;
		}
		else //Recusive case
		{
			return position * factorialNumber(position - 1);
		}
	}
}