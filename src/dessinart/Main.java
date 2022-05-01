package dessinart;

import dessinart.FunctionFinder;
import dessinart.VariableAndReturnChecker;
import dessinart.exceptions.*;
import dessinart.syntax.lexer.Lexer;
import dessinart.syntax.lexer.LexerException;
import dessinart.syntax.node.Node;
import dessinart.syntax.parser.Parser;
import dessinart.syntax.parser.ParserException;

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

        try {
            PushbackReader reader
                    = new PushbackReader(new FileReader(filename), 1024);
            Parser parser = new Parser(new Lexer(reader));
            Node tree = parser.parse();

            // trouve les fonctions et procédures
            FunctionFinder functionFinder = new FunctionFinder();
            functionFinder.visit(tree);

            VariableAndReturnChecker varchecks
                    = new VariableAndReturnChecker(functionFinder);
            varchecks.visit(tree);

            //Interprétation
            InterpreterEngine interp = new InterpreterEngine(functionFinder);
            interp.visit(tree);
        }
        catch (FileNotFoundException e) {
            System.err.println("ERREUR: Le fichier \"" + filename
                    + "\" n'a pas été trouvé.");
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("ERREUR D'ENTRÉE/SORTIE: " + e.getMessage());
            System.exit(1);
        }
        catch (LexerException e) {
            System.err.println("ERREUR LEXICALE: " + e.getMessage());
            System.exit(1);
        }
        catch (ParserException e) {
            System.err.println("ERREUR DE SYNTAXE: " + e.getMessage());
            System.exit(1);
        }
        catch (SemanticException e) {
            System.err.println("ERREUR SÉMANTIQUE: " + e.getMessage());
            System.exit(1);
        }
        catch (InterpreterException e) {
            System.err.println("ERREUR D'EXECUTION: " + e.getMessage());
            System.exit(1);
        }
    }
}
