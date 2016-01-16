package Business;

import java.util.ArrayList;

public class Env {

	public static ArrayList<VectorCustom> elts;


	public Env()
	{
		elts = new ArrayList<VectorCustom>();
	}


	public static VectorCustom add(VectorCustom vc)
	{


		remove(vc.name);
		if(!elts.contains((VectorCustom)vc))
			elts.add(vc);
		/*		else
		{
			for(int i=0;i<elts.size();i++)
				if(elts.get(i).name.equals(ac.name))
					elts.get(i).elts= ac.elts;
		}*/

		return vc;

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

	public static VectorCustom find(String s)
	{
		VectorCustom vc=null ;

		for(int i=0;i<elts.size();i++)
			if(elts.get(i).name.equals(s))
				return elts.get(i); 
		return vc;
	}

	public static VectorCustom store(String s, boolean isArray)
	{
		VectorCustom vc=null;
		
			vc =new VectorCustom(s,isArray);
		
	
		if(find(vc.name)!=null)
			return find(vc.name);
		else
		{
			vc=add(vc);
			return vc;
		}
	}
}
