//unfinished

package sae;

import sae2_2.Graphe;
import sae2_2.Voisin;
import sae2_2.Arete;
import sae.GrapheMatrice;
import sae.ParcoursGraphe;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class ParcoursGrapheLargeur extends ParcoursGraphe {
    private Graphe graphe;

    public ParcoursGrapheLargeur(Graphe g) {
        this.graphe=g;
    }

    public static boolean existeChemin(String a, String b) {
        if(a==b) return true;
        Queue<String> queue = new LinkedList<String>();
        queue.add(a);
        ArrayList<String> visite = new ArrayList<String>();
        String temp;
        while(!queue.isEmpty()){
            temp = queue.remove();
            visite.add(temp);
            for(Voisin v : _______.getVoisins(temp)){
                if(!visite.contains(v.getEtiquette())){
                    if(v.getEtiquette().equals(b))return true;
                    else{
                        visite.add(v.getEtiquette());
                        queue.add(v.getEtiquette());
                    }
                }
            }
        }
 return false;
}

    @Override
    public String plusCourtChemin(String a, String b) {
        return null;
    }

    @Override
    public Graphe getGraphe() {
        return ;
    }
}

