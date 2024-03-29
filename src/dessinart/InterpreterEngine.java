package dessinart;

import dessinart.exceptions.InterpreterException;
import dessinart.exceptions.ReturnException;
import dessinart.syntax.analysis.*;
import dessinart.syntax.lexer.*;
import dessinart.syntax.node.*;
import dessinart.syntax.parser.*;

import dessinart.value.*;
import dessinart.gui.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class InterpreterEngine extends DepthFirstAdapter {

    private FunctionFinder functionFinder;

    private Frame currentFrame;

    private Value result;

    private List<Value> argumentValues;
    private Dessin monDessin;

    public InterpreterEngine(FunctionFinder functionFinder) {
        this.functionFinder = functionFinder;

    }

    public void visit(Node node){
        if(node != null) node.apply(this);
    }

    private Value eval(
            Node node) {

        if (this.result != null) {
            throw new RuntimeException("Erreur inattendue dans l'intérpéteur.");
        }

        visit(node);

        if (this.result == null) {
            throw new RuntimeException("Erreur inattendue dans l'intérpéteur.");
        }

        Value result = this.result;
        this.result = null;
        return result;
    }

    private int getNumberLeft(
            Value value,
            Token token) {

        if (!(value instanceof IntValue)) {
            throw new InterpreterException(this.currentFrame, token,
                    "L'expression de gauche n'est pas un nombre entier.");
        }

        return ((IntValue) value).getValue();
    }

    private int getNumberRight(
            Value value,
            Token token) {

        if (!(value instanceof IntValue)) {
            throw new InterpreterException(this.currentFrame, token,
                    "L'expression de droite n'est pas un nombre entier.");
        }

        return ((IntValue) value).getValue();
    }

    private boolean evalBoolean(
            Node node,
            Token token) {

        Value value = eval(node);
        if (!(value instanceof BoolValue)) {
            throw new InterpreterException(this.currentFrame, token,
                    "L'expression n'est pas un booléen.");
        }

        return ((BoolValue) value).getValue();
    }

    public void montrerDessin() { //affichage du dessin
        this.monDessin.montrer();
    }

    @Override
    public void caseAProgram(AProgram node) {
        // visit(node.getBlock());

        this.currentFrame = new Frame(this.currentFrame, null);
        visit(node.getDefs());
        //visit(node.getDecls());
        visit(node.getMain());
        this.currentFrame = null;
        //montrerDessin();
        //this.monDessin.repaint();
        monDessin.attendre(100);
        this.montrerNoReplace();
    }

    private void montrerNoReplace() {
        this.monDessin.montrerNoReplace();
    }

    @Override
    public void caseADefs(ADefs node) { // Define et création du canvas
        ADefcan defineCanvas = (ADefcan) node.getDefcan();
        TNumber tokenWidth = defineCanvas.getWidth();;
        int width = Integer.parseInt(tokenWidth.getText());

        TNumber tokenHeight = defineCanvas.getHeight();
        int height = Integer.parseInt(tokenHeight.getText());

        ADefpen definePen = (ADefpen) node.getDefpen();
        TNumber tokenPenWitdh = definePen.getWidth();
        int penWidth = Integer.parseInt(tokenPenWitdh.getText());

        TNumber tokenPosX = definePen.getPosx();
        int posX = Integer.parseInt(tokenPosX.getText());

        TNumber tokenPosY = definePen.getPosy();
        int posY = Integer.parseInt(tokenPosY.getText());

        // construction du canvas
        this.monDessin = new Dessin(width, height, posX, posY, penWidth);
        this.monDessin.montrer();
    }

    // -------------------------------------------------------------------------
    // Déclarations
    // -------------------------------------------------------------------------
    /*@Override
    public void caseAVardecl(AVardecl node) {

    }*/

    // -------------------------------------------------------------------------
    // Instructions
    // -------------------------------------------------------------------------
    @Override
    public void caseADeclInstr(ADeclInstr node) {
        Value value = eval(node.getExp());
        this.currentFrame.assignVariable(node.getIdent().getText(), value);
    }

    @Override
    public void caseAAssignInstr(AAssignInstr node) {
        Value value = eval(node.getExp());
        this.currentFrame.assignVariable(node.getIdent().getText(), value);
    }

    @Override
    public void caseAPenfctInstr(APenfctInstr node) {
        visit(node.getPenfct());
    }

    @Override
    public void caseAIfInstr(AIfInstr node) {
        if(evalBoolean(node.getExp(), node.getIf())){
            visit(node.getBlock());
        }
    }

    @Override
    public void caseAWhileInstr(AWhileInstr node) {
        while(evalBoolean(node.getExp(), node.getWhile())){
            visit(node.getBlock());
        }
    }

    @Override
    public void caseAReturnInstr(AReturnInstr node) {
        if (node.getExp() != null){
            Value value = eval(node.getExp());
            this.currentFrame.setReturnValue(value);
        }

        throw new ReturnException();
    }

    @Override
    public void caseACallInstr(ACallInstr node) {

        List<Value> previousArgumentValues = this.argumentValues;

        this.argumentValues = new LinkedList<>();
        visit(node.getArgs());

        this.currentFrame.setCallLocation(node.getIdent());

        FunctionInfo function = this.functionFinder.getFunctionInfo(node.getIdent().getText());
        this.currentFrame = new Frame(this.currentFrame, function);

        Iterator<Value> argumentValuesIterator = this.argumentValues.iterator();
        List<ParamInfo> params = function.getParams();

        for(ParamInfo param : params){
            Value value = argumentValuesIterator.next();
            this.currentFrame.assignVariable(param.getName().getText(), value);
        }

        try{
            visit(function.getBody());
        } catch (ReturnException e){}


        this.argumentValues = previousArgumentValues;
        this.currentFrame = this.currentFrame.getParent();
        this.currentFrame.setCallLocation(null);
    }
    // -----------------------------------------------------------------------------------------------


    /////////////////////////////////////////////////////////////////////////////////
    // fonctions sur le crayon et wait
    /////////////////////////////////////////////////////////////////////////////////
    @Override
    public void caseAReplacePenfct(AReplacePenfct node) { // déplacement absolue
        Value valX = eval(node.getPosX());
        Value valY = eval(node.getPosY());

        int x = ((IntValue) valX).getValue();
        int y = ((IntValue) valY).getValue();

        //System.out.println("Pos du crayon: x :" + x + " y: " + y);

        this.monDessin.bougerCrayonAbs(x, y);
    }

    @Override
    public void caseAMovePenfct(AMovePenfct node) { // déplacement relatif
        Value valX = eval(node.getDistX());
        Value valY = eval(node.getDistY());

        int x = ((IntValue) valX).getValue();
        int y = ((IntValue) valY).getValue();

        this.monDessin.bougerCrayonRel(x, y);
    }

    @Override
    public void caseADrawabsPenfct(ADrawabsPenfct node) { // dessin jusqu'à une position absolue et déplace crayon avec
        Value valX = eval(node.getPosX());
        Value valY = eval(node.getPosY());

        int x = ((IntValue) valX).getValue();
        int y = ((IntValue) valY).getValue();

        this.monDessin.drawAbs(x, y);
    }

    @Override
    public void caseADrawPenfct(ADrawPenfct node) { // dessin jusqu'à une position relative et déplace crayon avec
        Value valX = eval(node.getDistX());
        Value valY = eval(node.getDistY());

        int x = ((IntValue) valX).getValue();
        int y = ((IntValue) valY).getValue();

        this.monDessin.drawRel(x, y);
    }

    @Override
    public void caseASetcolorPenfct(ASetcolorPenfct node) { // set la couleur du crayon
        Value valCouleur = eval(node.getColor());
        ColorValue cColor = (ColorValue) valCouleur;

        Color couleur = ((ColorValue) valCouleur).getValue();

        if((cColor.getRed() < 0 && cColor.getRed() > 255) && (cColor.getGreen() < 0 && cColor.getGreen() > 255) && (cColor.getBlue() < 0 && cColor.getBlue()  > 255)){
            throw new InterpreterException(this.currentFrame, node.getLPar(), "Les valeurs de la couleur doivent être comprises entre 0 et 255");
        }

        this.monDessin.setPenColor(couleur);
    }

    @Override
    public void caseASetwidthPenfct(ASetwidthPenfct node) { // set la largeur / taille du crayon
        Value valPenW = eval(node.getWidth());

        int largeur = ((IntValue) valPenW).getValue();

        this.monDessin.setPenWidth(largeur);
    }

    @Override
    public void caseAWaitPenfct(AWaitPenfct node) { // attendre un certain nombre de millisecondes avant de continuer
        Value valWait = eval(node.getDelay ());
        int delay = ((IntValue) valWait).getValue ();

        this.monDessin.attendre (delay);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////////
    // fonctions math
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public void caseAPowerMathfcts(APowerMathfcts node) { // fonction puissance
        Value vBase = eval(node.getBase());
        Value vExposant = eval(node.getExpos());

        int base = ((IntValue) vBase).getValue();
        int exposant = ((IntValue) vExposant).getValue();

        int monResultat = (int) Math.round(Math.pow((double) base, (double) exposant));

        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseARound5Mathfcts(ARound5Mathfcts node) { // arrondir par morceaux de 5
        Value valR = eval(node.getValeur());
        int valRo = ((IntValue) valR).getValue();
        int monResultat;
        int moduloR = valRo % 5;
        if (moduloR == 0) {
            monResultat = valRo;
        } else if (moduloR >= 3) {
            monResultat = valRo - moduloR + 5;
        } else {
            monResultat = valRo - moduloR;
        }

        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseARound10Mathfcts(ARound10Mathfcts node) { // arrondir par morceaux de 10
        Value valR = eval(node.getValeur());
        int valRo = ((IntValue) valR).getValue();
        int monResultat;
        int moduloR = valRo % 10;
        if (moduloR == 0) {
            monResultat = valRo;
        } else if (moduloR >= 5) {
            monResultat = valRo - moduloR + 10;
        } else {
            monResultat = valRo - moduloR;
        }

        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseARound100Mathfcts(ARound100Mathfcts node) { // arrondir par morceaux de 100
        Value valR = eval(node.getValeur());
        int valRo = ((IntValue) valR).getValue();
        int monResultat;
        int moduloR = valRo % 100;
        if (moduloR == 0) {
            monResultat = valRo;
        } else if (moduloR >= 50) {
            monResultat = valRo - moduloR + 100;
        } else {
            monResultat = valRo - moduloR;
        }

        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseALogMathfcts(ALogMathfcts node) {
        Value valBase = eval(node.getBase());
        Value valLogde = eval(node.getLogde());
        int base = ((IntValue) valBase).getValue();
        int logde = ((IntValue) valLogde).getValue();

        int monResultat = (int) Math.round((Math.log((double) logde))/(Math.log((double) base)));

        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseASinMathfcts(ASinMathfcts node) {
        Value valAngle = eval(node.getAngle());
        Value valMul = eval(node.getMul());

        int angle = ((IntValue) valAngle).getValue();
        int mul = ((IntValue) valMul).getValue();

        int monResultat = (int) (Math.sin((double) angle)*mul);

        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseACosMathfcts(ACosMathfcts node) {
        Value valAngle = eval(node.getAngle());
        Value valMul = eval(node.getMul());

        int angle = ((IntValue) valAngle).getValue();
        int mul = ((IntValue) valMul).getValue();

        int monResultat = (int) (Math.cos((double) angle)*mul);

        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseATanMathfcts(ATanMathfcts node) {
        Value valAngle = eval(node.getAngle());
        Value valMul = eval(node.getMul());

        int angle = ((IntValue) valAngle).getValue();
        int mul = ((IntValue) valMul).getValue();


        int monResultat = (int) (Math.tan((double) angle) * mul);
        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseARandomdeuxcinqcinqMathfcts(ARandomdeuxcinqcinqMathfcts node) { // retourne un chiffre aléatoire entre 0 et 255
        int monResultat = (int) Math.round(Math.random() * 255);
        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseARandomhundMathfcts(ARandomhundMathfcts node) { // retourne un chiffre aléatoire entre 0 et 100
        int monResultat = (int) Math.round(Math.random() * 100);
        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseARandomtenMathfcts(ARandomtenMathfcts node) { // retourne un chiffre aléatoire entre 0 et 10
        int monResultat = (int) Math.round(Math.random() * 10);
        this.result = new IntValue(monResultat);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////////////
    // Term
    //////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void caseANumberTerm(ANumberTerm node) {
        try{
            this.result = new IntValue(Integer.parseInt(node.getNumber().getText()));
        } catch (NumberFormatException e){
            throw new InterpreterException(this.currentFrame, node.getNumber(), "Le nombre entré est trop grand!");
        }
    }

    @Override
    public void caseANegativeTerm(ANegativeTerm node) {
        try{
            int value = Integer.parseInt(node.getNumber().getText());
            int result = 0 - value;
            this.result = new IntValue(result);
        } catch (NumberFormatException e){
            throw new InterpreterException(this.currentFrame, node.getNumber(), "Le nombre entré est trop grand!");
        }
    }

    @Override
    public void caseAVarTerm(AVarTerm node) {
        String identifier = node.getIdent().getText();
        Value value = this.currentFrame.getValue(identifier);
        if (value == null) {
            throw new InterpreterException(this.currentFrame, node.getIdent(),
                    "La variable " + identifier + " n'a pas de valeur.");
        }
        this.result = value;
    }

    @Override
    public void caseABoolTerm(ABoolTerm node) {
        this.result = eval (node.getBoole ());
    }

    @Override
    public void caseAParTerm(AParTerm node) {
        this.result = eval (node.getExp ());
    }

    @Override
    public void caseAColorTerm(AColorTerm node) {
        Value red = eval(node.getRed());
        Value green = eval(node.getGreen());
        Value blue = eval(node.getBlue());

        int vRed = ((IntValue) red).getValue();
        int vGreen = ((IntValue) green).getValue();
        int vBlue = ((IntValue) blue).getValue();

        if((vRed < 0 && vRed > 255) && (vGreen < 0 && vGreen > 255) && (vBlue < 0 && vBlue > 255)){
            throw new InterpreterException(this.currentFrame, node.getLPar(), "Les valeurs de la couleur doivent être comprises entre 0 et 255");
        }

        this.result = new ColorValue(vRed, vGreen, vBlue);
    }

    @Override
    public void caseAMathfctsTerm(AMathfctsTerm node) {
        this.result = eval (node.getMathfcts ());
    }

    @Override
    public void caseACallTerm(ACallTerm node) {
        List<Value> previousArgumentsValues = this.argumentValues;
        this.argumentValues = new LinkedList<>();
        visit(node.getArgs());

        this.currentFrame.setCallLocation(node.getIdent());

        FunctionInfo function = this.functionFinder.getFunctionInfo(node.getIdent().getText());
        this.currentFrame = new Frame(this.currentFrame, function);

        Iterator<Value> argumentValuesIterator = this.argumentValues.iterator();
        List<ParamInfo> params = function.getParams();
        for( ParamInfo param : params) {
            Value value = argumentValuesIterator.next();
            this.currentFrame.assignVariable(param.getName().getText(), value);
        }

        try {
            visit(function.getBody());
            throw new InterpreterException(this.currentFrame.getParent(),
                    node.getIdent(), "La fonction " + node.getIdent().getText()
                    + " n'a pas retourné de valeur.");
        }
        catch (ReturnException e) {
            // attrappe l'exception de retour
        }

        this.result = this.currentFrame.getReturnValue();
        this.argumentValues = previousArgumentsValues;
        this.currentFrame = this.currentFrame.getParent();
        this.currentFrame.setCallLocation(null);
     }

    @Override
    public void caseAArg(AArg node) {
        this.argumentValues.add(eval(node.getExp()));
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////////
    // Main
    //////////////////////////////////////////////////////////////////////////
    @Override
    public void caseAMain(AMain node) {
        visit(node.getBlock());
    }
    ////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // Exp
    // -----------------------------------------------------------------------
    @Override
    public void caseAEqExp(
            AEqExp node) {

        Value left = eval(node.getLeft());
        Value right = eval(node.getRight());
        this.result = BoolValue.get(left.equals(right));
    }

    @Override
    public void caseALtExp(
            ALtExp node) {

        int left = getNumberLeft(eval(node.getLeft()), node.getLt());
        int right = getNumberRight(eval(node.getRight()), node.getLt());
        this.result = BoolValue.get(left < right);
    }

    @Override
    public void caseAGtExp(
            AGtExp node) {

        int left = getNumberLeft(eval(node.getLeft()), node.getGt());
        int right = getNumberRight(eval(node.getLeft()), node.getGt());
        this.result = BoolValue.get(left > right);
    }

    @Override
    public void caseASimpleExp(ASimpleExp node) {
        this.result = eval (node.getSum ());
    }
    //////////////////////////////////////////////////////////////////////////////////


    //////////////////////////////////////////////////////////////////////////////////
    // Sum
    // -------------------------------------------------------------------------------
    @Override
    public void caseAAddSum(
            AAddSum node) {

        Value left = eval(node.getLeft());
        Value right = eval(node.getRight());

        if (left instanceof IntValue) {
            this.result = new IntValue(getNumberLeft(left, node.getPlus())
                    + getNumberRight(right, node.getPlus()));

            return;
        }

        throw new InterpreterException(this.currentFrame, node.getPlus(),
                "L'expression de gauche n'est ni une chaîne de caractères ni un nombre.");
    }

    @Override
    public void caseASubSum(ASubSum node) {
        Value left = eval(node.getLeft());
        Value right = eval(node.getRight());

        if (left instanceof IntValue) {
            this.result = new IntValue(getNumberLeft(left, node.getMinus ())
                    - getNumberRight(right, node.getMinus ()));

            return;
        }

        throw new InterpreterException(this.currentFrame, node.getMinus (),
                "L'expression de gauche n'est ni une chaîne de caractères ni un nombre.");
    }

    @Override
    public void caseADivSum(ADivSum node) {
        Value left = eval(node.getLeft());
        Value right = eval(node.getRight());

        if (left instanceof IntValue) {

            int divise = getNumberLeft (left, node.getDivide ());
            int diviseur = getNumberRight (right, node.getDivide ( ));

            int resultat = Math.round (divise/diviseur);

            this.result = new IntValue(resultat);

            return;
        }

        throw new InterpreterException(this.currentFrame, node.getDivide (),
                "L'expression de gauche n'est ni une chaîne de caractères ni un nombre.");
    }

    @Override
    public void caseAMulSum(AMulSum node) {
        Value left = eval(node.getLeft());
        Value right = eval(node.getRight());

        if (left instanceof IntValue) {

            int divise = getNumberLeft (left, node.getStar ());
            int diviseur = getNumberRight (right, node.getStar ());

            int resultat = divise * diviseur;
            this.result = new IntValue(resultat);

            return;
        }

        throw new InterpreterException(this.currentFrame, node.getStar (),
                "L'expression de gauche n'est ni une chaîne de caractères ni un nombre.");
    }

    @Override
    public void caseAModSum(AModSum node) {
        Value left = eval(node.getLeft());
        Value right = eval(node.getRight());

        if (left instanceof IntValue) {

            int divise = getNumberLeft (left, node.getMod());
            int diviseur = getNumberRight (right, node.getMod( ));

            int resultat = Math.round (divise % diviseur);

            this.result = new IntValue(resultat);

            return;
        }

        throw new InterpreterException(this.currentFrame, node.getMod (),
                "L'expression de gauche n'est ni une chaîne de caractères ni un nombre.");
    }

    @Override
    public void caseASimpleSum(ASimpleSum node) {
        this.result = eval (node.getNeg ());
    }
    ////////////////////////////////////////////////////////////////////////////////


    @Override
    public void caseANotNeg(ANotNeg node) {
        this.result = BoolValue.get(!evalBoolean(node.getExp(), node.getNot()));
    }
    /*@Override
    public void caseATermNeg)(ATermNeg node){}*/

    /////////////////////////////////////////////////////////////////////////////
    // Boole (boolean)
    @Override
    public void caseATrueBoole(ATrueBoole node) {
        boolean vrai = true;
        this.result = new BoolValue(vrai);
    }

    @Override
    public void caseAFalseBoole(AFalseBoole node) {
        boolean faux = false;
        this.result = new BoolValue(faux);
    }
    ///////////////////////////////////////////////////////////////////////////
}
