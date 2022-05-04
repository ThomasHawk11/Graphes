import static sae2_02.FileUtils.*;

import sae2_02.GrapheMatrice;

public class ProfilageGrapheMatrice {
	public static void main(String args[]){
		  GrapheMatrice g = loadFileGrapheMatrice("D:\\grapheS691D0.9CC2.dot");
		  System.out.println(g.getSommets().size());
		  System.out.println(g.getAretes().size());

	}
}
