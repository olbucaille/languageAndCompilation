package Business;


import java.io.PrintStream; 
import java.util.ArrayList; 

public class ArrayCustom implements Observable{ 
	
	String name= "unknown";
	ArrayList<Double> elts; 
    private ArrayList <Observateur> observers = new ArrayList<Observateur>();

	public ArrayCustom(String s, boolean isArray)
	{ 
		System.out.println(s);
		elts = new ArrayList<Double>();
		if(isArray)
		{
			name=String.valueOf(Math.random());
			s = s.replace("[", ""); 
			s = s.replace("]", ""); 
			String res[] = s.split(" "); 
			for(int i = 0; i < res.length; i++) 
				if(!res[i].trim().isEmpty())
					elts.add(Double.parseDouble(res[i].trim())); 
		}
		else
		{
			ArrayCustom ac = Env.find(s);
			if (ac!= null)
				this.elts = ac.elts;
			name = s;
		}
	}

	
	public void display() 
	{ 
		System.out.print(name+" :");
		if(!elts.isEmpty())
		for(int i = 0; i < elts.size();	i++)
			System.out.print(elts.get(i)+" "); 
		System.out.println();
	} 
	public ArrayCustom add(ArrayCustom b) 
	{ 
		System.out.println("addition"); 
		for(int i = 0; i < elts.size(); i++) 

			elts.set(i, elts.get(i) + b.elts.get(i)); 
		
		return this;
	} 
	public ArrayCustom sub(ArrayCustom b) 
	{ 
		System.out.println("soustraction"); 
		for(int i = 0; i < elts.size(); i++) 
			elts.set(i, elts.get(i) - b.elts.get(i)); 
		
		return this;
	} 

	public void affect(ArrayCustom a)
	{
		name= a.name;
		Env.add(this);
	}

	@Override
	public void ajouterObsertvateur(Observateur o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void supprimerObservateur(Observateur o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
	}

	@Override
	public void notifierObsertavateur() {
		// TODO Auto-generated method stub
		for (Observateur observer : observers) {
            observer.actualiser(name,new ObjectToCompile());;
            
        }
	}
	
	
}
