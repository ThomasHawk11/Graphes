import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import sae2_2.Arete;
import sae2_2.Graphe;
import sae2_2.Voisin;

public class GrapheMatrice implements Graphe{
	private HashMap<String,Integer> dictionnaireDeSommets;
	private ArrayList<ArrayList<Double>> matriceDAdjacence;
	
    public GrapheMatrice() {
        dictionnaireDeSommets = new HashMap<String, Integer>();
        matriceDAdjacence = new ArrayList<ArrayList<Double>>();
    }

	@Override
	//Ajoute une arete au graphe
	public void ajouteArete(String arg0, String arg1, double arg2) {
        int numSommet1 = dictionnaireDeSommets.get(arg0);
        int numSommet2 = dictionnaireDeSommets.get(arg1);
        matriceDAdjacence.get(numSommet1).set(numSommet2,arg2);
        matriceDAdjacence.get(numSommet2).set(numSommet1,arg2);
		
	}

	@Override
	//Ajoute un sommet au graphe
	public void ajouteSommet(String arg0) {
		dictionnaireDeSommets.put(arg0, dictionnaireDeSommets.size());
	    matriceDAdjacence.add(new ArrayList<Double>());
	    for (int i = 0; i < matriceDAdjacence.size(); i++) {
	    	matriceDAdjacence.get(i).add(0.0);
	        }
	    }

	@Override
	//Création du graphe
	public void creerGraphe(Collection<Arete> arg0) {
        for (Arete arete : arg0) {
            ajouteArete(arete.getU(), arete.getV(), arete.getPoids());
        }
		
	}
	
	//Renvoie la clé d'un Map à partir de la valeur (seulement avec les assocations un-à-un)
	public static <T,E> T getKeysByValue(Map<T,E> map, E value){
		for(Entry<T,E> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}


	@Override
	//Renvoi toutes les aretes du graphe
	public Collection<Arete> getAretes() {
        ArrayList<Arete> aretes = new ArrayList<Arete>();
   
        for (int i = 0; i < matriceDAdjacence.size(); i++) {
            for (int j = 0; j < matriceDAdjacence.size(); j++) {
                if (matriceDAdjacence.get(i).get(j) != 0) {
                    aretes.add(new Arete(getKeysByValue(dictionnaireDeSommets,i),getKeysByValue(dictionnaireDeSommets,i), matriceDAdjacence.get(i).get(j)));
                }
            }
        }
        return aretes;
	}
	

	@Override
	//Renvoi le dictionnaire des sommets du graphe
    public Collection<String> getSommets() {
        return dictionnaireDeSommets.keySet();
    }

	@Override
	//Renvoi tous les voisins d'un sommet
	public Collection<Voisin> getVoisins(String arg0) {
		ArrayList<Voisin> voisins = new ArrayList<Voisin>();
	        int nSommet = dictionnaireDeSommets.get(arg0);
	        for (int i = 0; i < matriceDAdjacence.size(); i++) {
	            if (matriceDAdjacence.get(nSommet).get(i) != 0.0) {
	                voisins.add(new Voisin(getKeysByValue(dictionnaireDeSommets,i), matriceDAdjacence.get(nSommet).get(i)));
	            }
	        }
	        return voisins;
	    }

	@Override
	//Vérifie si deux sommets sont voisins
    public boolean sontVoisins(String sommet1, String sommet2) {
        int numSommet1 = dictionnaireDeSommets.get(sommet1);
        int numSommet2 = dictionnaireDeSommets.get(sommet2);
        return matriceDAdjacence.get(numSommet1).get(numSommet2) != 0.0;
    }

}
