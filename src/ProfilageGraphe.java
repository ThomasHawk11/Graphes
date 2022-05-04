package sae2_02;
import java.util.ArrayList;
import sae2_2.Arete;

import static sae2_02.FileUtils.loadFile;

public class ProfilageGraphe {

	public static void main(String args[]){
		 ArrayList<Arete> a = loadFile("D:\\reseauFrance.dot");
		 
		 System.out.println("Début Graphe Matrice");
		 long time = System.currentTimeMillis();
		 GrapheMatrice g1 = new GrapheMatrice();
		 g1.creerGraphe(a);
		 System.out.println((System.currentTimeMillis()-time)/1000.+"secondes");
		 System.out.println();
		 
		 System.out.println("Début Graphe Liste");
		 long time2 = System.currentTimeMillis();
		 GrapheListe g2 = new GrapheListe();
		 g2.creerGraphe(a);
		 System.out.println((System.currentTimeMillis()-time2)/1000.+"secondes");
		
	}


}