package Business;
import java.io.PrintStream; 
import java.util.ArrayList; 
public class ArrayCustom { 
	ArrayList<Double> elts; 

	public ArrayCustom(String s)
	{ 
		elts = new ArrayList<Double>();
		s = s.replace("[", ""); 
		s = s.replace("]", ""); 
		String res[] = s.split(" "); 
		for(int i = 0; i < res.length; i++) 
			if(!res[i].trim().isEmpty())
			elts.add(Double.parseDouble(res[i].trim())); 
	}
	public void display() 
	{ 
		for(int i = 0; i < elts.size();	i++)
			System.out.println(elts.get(i)); 
	} 
	public ArrayCustom add(ArrayCustom b) 
	{ 
		System.out.println("addition"); 
		for(int i = 0; i < elts.size(); i++) 
			
			elts.set(i, elts.get(i) + b.elts.get(i)); 
		display();  
		return this;
	} 
	public ArrayCustom sub(ArrayCustom b) 
	{ 
		System.out.println("soustraction"); 
		for(int i = 0; i < elts.size(); i++) 
			elts.set(i, elts.get(i) - b.elts.get(i)); 
		display();  
		return this;
	} 
}
