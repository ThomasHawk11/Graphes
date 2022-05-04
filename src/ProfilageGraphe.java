package sae2_02;
import java.util.ArrayList;
import sae2_2.Arete;

import static sae2_02.FileUtils.loadFile;

public class ProfilageGraphe {

	public static void main(String args[]){
		 ArrayList<Arete> a = loadFile("D:\\reseau14.dot");
		 /*GrapheMatrice g1 = new GrapheMatrice();
		 g1.creerGraphe(a);
		 System.out.println(g1.getSommets().size());
		 System.out.println(g1.getAretes().size());*/
		 
		 GrapheListe g2 = new GrapheListe();
		 g2.creerGraphe(a);
		 System.out.println(g2.getSommets().size());
		 System.out.println(g2.getAretes().size());
		
		
	}


}
