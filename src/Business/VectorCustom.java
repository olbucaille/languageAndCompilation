package Business;

import java.util.ArrayList;

public class VectorCustom {

	public String name;
	public ArrayList<ArrayCustom> elts;
	
	public VectorCustom(String s, boolean isVect)
	{ 
		elts = new ArrayList<ArrayCustom>();
		
		if(isVect)
		{
		name=String.valueOf(Math.random());
		String[] res =s.split("\\[");
		for(int i=0;i<res.length;i++)
			if(res[i]!=null && !res[i].isEmpty())
			elts.add(new ArrayCustom(res[i]));
		
	//	this.display();
		}
		else
		{
			this.name= s;
		}
	}
	
	public VectorCustom add(VectorCustom b) 
	{ 
		System.out.println("addition"); 
		//System.out.println(b.elts.size());
		//this.display();
		for(int i = 0; i < elts.size(); i++) 
		{
		//	System.out.println("first");
		//	elts.get(i).display();
		//	System.out.println("second");
		//	b.elts.get(i).display();
		//	elts.get(i).add(b.elts.get(i));
		//	System.out.println("afterope");
	//	elts.get(i).display();
			elts.set(i, elts.get(i).add(b.elts.get(i))); 
		}
		return this;
	} 
	public VectorCustom sub(VectorCustom b) 
	{ 
		System.out.println("soustraction"); 
		for(int i = 0; i < elts.size(); i++) 
			elts.set(i, elts.get(i).sub(b.elts.get(i))); 

		return this;
	} 
	
	public VectorCustom mul(VectorCustom b) 
	{ 
		System.out.println("multiplication"); 
		for(int i = 0; i < elts.size(); i++) 
			elts.set(i, elts.get(i).mul(b.elts.get(i))); 

		return this;
	} 
	public VectorCustom div(VectorCustom b) 
	{ 
		System.out.println("division"); 
		for(int i = 0; i < elts.size(); i++) 
			elts.set(i, elts.get(i).div(b.elts.get(i))); 

		return this;
	} 

	
	public void display()
	{
		System.out.print(name+" [");
		for(int i=0;i<elts.size();i++)
			elts.get(i).display();
		System.out.print("]");
		System.out.println("");
	}
	
	public void affect(VectorCustom a)
	{
		name= a.name;
		Env.add(this);
	}
}
