package Business;

import java.util.ArrayList;

public class Env {

	public static ArrayList<ArrayCustom> elts;


	public Env()
	{
		elts = new ArrayList<ArrayCustom>();
	}


	public static ArrayCustom add(ArrayCustom ac)
	{


remove(ac.name);
		if(!elts.contains((ArrayCustom)ac))
			elts.add(ac);
/*		else
		{
			for(int i=0;i<elts.size();i++)
				if(elts.get(i).name.equals(ac.name))
					elts.get(i).elts= ac.elts;
		}*/

			return ac;

	}


	private static  void remove(String name) {
		for(int i=0;i<elts.size();i++)
			if(elts.get(i).name.equals(name))
			{
			//	System.out.println("removed");
				elts.remove(i);
			}
	}


	public static void display()
	{
		for(int i=0;i<elts.size();i++)
			elts.get(i).display();
	}
	public static ArrayCustom  find(String s)
	{
		ArrayCustom ac=null ;

		for(int i=0;i<elts.size();i++)
			if(elts.get(i).name.equals(s))
				return elts.get(i); 
		return ac;
	}
	public static ArrayCustom store(String s, boolean isArray)
	{
		ArrayCustom ac =new ArrayCustom(s,isArray);
		//System.out.print("prev");ac.display();
		ac=add(ac);
		//System.out.print("then");ac.display();
		//display();
		return ac;

	}
}
