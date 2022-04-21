package dessinart;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        // Check if .dsa file is passed as arg.
        if (args.length != 1) {
            System.err.println("USAGE: java dessinart.Main drawing.dsa");
            System.exit(1);
        }

        String filename = args[0];
        if (!filename.endsWith(".dsa")) {
            System.err.println("ERROR: file " + filename + " does not ends " +
                    "with the \".dsa\" suffix.");
            System.exit(1);
        }

        try{

            PushbackReader reader =
                    new PushbackReader(new FileReader(filename), 1024);

        } catch (FileNotFoundException e){
            System.err.println("ERREUR: Le fichier \"" + filename
                    + "\" n'a pas été trouvé.");
            System.exit(1);
        }
    }
}
