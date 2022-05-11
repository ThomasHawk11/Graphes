package sae;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sae2_2.Arete;

public class ReadFile {
    public static ArrayList<Arete> loadFile(String filename) {
        File file = new File(filename);
        ArrayList<Arete> aretes = new ArrayList<>();
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
                    aretes.add(new Arete(split[0],split[1],weight));


                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return aretes;
    }

}
