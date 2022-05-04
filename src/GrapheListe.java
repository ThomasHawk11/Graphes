package sae2_02;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;

import sae2_2.Arete;
import sae2_2.Graphe;
import sae2_2.Voisin;

public class GrapheListe implements Graphe{
	private HashMap<String,Collection<Arete>> listeDAdjacence;

    public GrapheListe(){
        listeDAdjacence = new HashMap<String,Collection<Arete>>();
    }
    
    //Ajoute un sommet au graphe
    public void ajouteSommet(String s){
        listeDAdjacence.put(s, new ArrayList<Arete>());
    }
    
    //Ajoute une arete au graphe
    public void ajouteArete(String arg0, String arg1, double arg2){
        Arete a = new Arete(arg0, arg1, arg2);
        listeDAdjacence.get(arg0).add(a);
        listeDAdjacence.get(arg1).add(a);
    }
    
    //renvoi les sommets du graphe
    public Collection<String> getSommets(){
        return listeDAdjacence.keySet();
    }
    
    //renvoi les aretes du graphe
    public Collection<Arete> getAretes(){
        ArrayList<Arete> aretes = new ArrayList<Arete>();        
        for (String s : listeDAdjacence.keySet()) {
        	for(Arete a : listeDAdjacence.get(s)) {
        			if (!aretes.contains(a)) aretes.add(a);
        	}
        }
        return aretes;
	}
    //Cr�ation du graphe
    public void creerGraphe(Collection<Arete> aretes){
        for(Arete a : aretes){
        	if(!listeDAdjacence.keySet().contains(a.getU())) 
        		this.ajouteSommet(a.getU());
        	if(!listeDAdjacence.keySet().contains(a.getV())) 
        		this.ajouteSommet(a.getV());
        	
        	this.ajouteArete(a.getU(), a.getV(), a.getPoids());
        }
    }
    
    //Renvoi tous les voisins d'un sommet
    public Collection<Voisin> getVoisins(String s){
        Collection<Voisin> voisins = new ArrayList<Voisin>();
        for(Arete a : listeDAdjacence.get(s)){
            voisins.add(new Voisin(a.getV(), a.getPoids()));
        }
        return voisins;
    }
    
    //V�rifie si deux sommets sont voisins
    public boolean sontVoisins(String arg0, String arg1){
        return listeDAdjacence.get(arg0).contains(new Arete(arg0, arg1, 0));
    }

    
}
