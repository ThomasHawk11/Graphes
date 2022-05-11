package sae;

import sae2_2.Graphe;

public abstract class ParcoursGraphe {
    private Graphe graphe;

    public ParcoursGraphe(Graphe g) {
        this.graphe = g;
    }

    public static boolean existeChemin(String a, String b) {
        return false;
    }

    public abstract String plusCourtChemin(String a, String b);

    public abstract Graphe getGraphe();
}


