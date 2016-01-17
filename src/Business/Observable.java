package Business;


public interface Observable {

	abstract void ajouterObsertvateur (Observateur o);
	abstract void supprimerObservateur(Observateur o);
	abstract void notifierObsertavateur();
	
}
