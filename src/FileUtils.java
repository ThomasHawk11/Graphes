package sae2_02;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {
    public static GrapheMatrice loadFileGrapheMatrice(String filename) {
        File file = new File(filename);;
        GrapheMatrice graphe = new GrapheMatrice();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replace("\" -- \"", "\"");
                line = line.replace(";", "");
                line = line.replace("\t\"", "").trim();

                String[] split = line.split("\"");
                
                if (split.length == 3) {
                    double weight = Double.parseDouble(split[2].split(",")[0].split("=")[1]);
                    graphe.ajouteSommet(split[0]);
                    graphe.ajouteSommet(split[1]);
                    graphe.ajouteArete(split[0],split[1],weight);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        
        return graphe;
    }
    
    public static GrapheListe loadFileGrapheListe(String filename) {
        File file = new File(filename);;
        GrapheListe graphe = new GrapheListe();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replace("\" -- \"", "\"");
                line = line.replace(";", "");
                line = line.replace("\t\"", "").trim();

                String[] split = line.split("\"");
                
                if (split.length == 3) {
                    double weight = Double.parseDouble(split[2].split(",")[0].split("=")[1]);
                    graphe.ajouteSommet(split[0]);
                    graphe.ajouteSommet(split[1]);
                    graphe.ajouteArete(split[0],split[1],weight);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return graphe;
    }
}
