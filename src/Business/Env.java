package Business;

import java.util.ArrayList;

public class Env {
	
	public static ArrayList<ArrayCustom> elts;
	
	
	public Env()
	{
		elts = new ArrayList<ArrayCustom>();
	}
	
	
	public void add(ArrayCustom ac)
	{
		elts.add(ac);
	}
	
	
	public void display()
	{
		for(int i=0;i<elts.size();i++)
			elts.get(i).display();
	}
}
