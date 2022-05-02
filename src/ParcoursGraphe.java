import sae2_2.Graphe;

public abstract class ParcoursGraphe {
	
    public ParcoursGraphe(Graphe g) {}
    
    public abstract boolean existeChemin(String a, String b);
    
    public abstract String plusCourtChemin(String a, String b);
    
    public abstract Graphe getGraphe();

	
}
