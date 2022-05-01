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
import java.time.temporal.ValueRange;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class InterpreterEngine extends DepthFirstAdapter {

    private FunctionFinder functionFinder;

    private Frame currentFrame;


    private Value result;

    private List<Value> argumentValues;

    ////////////////////////////////////////////////////////
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
        visit(node.getDecls());
        visit(node.getMain());
        this.currentFrame = null;
        montrerDessin();
    }

    @Override
    public void caseADefs(ADefs node) { // Define et création du canvas
        System.out.println("passe ici!");
        ADefcan defineCanvas = (ADefcan) node.getDefcan();

        TNumber tokenWidth = defineCanvas.getWidth();;

        //Value valWidth = eval(tokenWidth);

        int width = Integer.parseInt(tokenWidth.getText());

        TNumber tokenHeight = defineCanvas.getHeight();
        //Value valHeight = eval(tokenHeight);
        int height = Integer.parseInt(tokenHeight.getText());

        ADefpen definePen = (ADefpen) node.getDefpen();

        TNumber tokenPenWitdh = definePen.getWidth();
        //Value valPenWidth = eval(tokenPenWitdh);
        int penWidth = Integer.parseInt(tokenPenWitdh.getText());

        TNumber tokenPosX = definePen.getPosx();
        //Value valPosX = eval(tokenPosX);
        int posX = Integer.parseInt(tokenPosX.getText());

        TNumber tokenPosY = definePen.getPosy();
        //Value valPosY = eval(tokenPosY);
        int posY = Integer.parseInt(tokenPosY.getText());

        //this.result = new IntValue(2);

        // construction du canvas
        this.monDessin = new Dessin(width, height, posX, posY, penWidth);
        this.monDessin.montrer();
    }

    /*@Override
    public void caseADefcan(ADefcan node) {
        System.out.println("passe icitte");
        Value valWidth = eval(node.getWidth());
        Value valHeight = eval(node.getHeight());

        int width = ((IntValue) valWidth).getValue();
        int height = ((IntValue) valHeight).getValue();

        this.monDessin.setDimensions(width, height);
    }*/

    /*@Override
    public void caseADefpen(ADefpen node) {
        Value valPenWidth = eval(node.getWidth());
        int penWidth = ((IntValue) valPenWidth).getValue();

        Value valPosX = eval(node.getPosx());
        int posX = ((IntValue) valPosX).getValue();

        Value valPosY = eval(node.getPosy());
        int posY = ((IntValue) valPosY).getValue();

        this.monDessin.setPenWidth(penWidth);
        this.monDessin.bougerCrayonAbs(posX, posY);
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
    // fonctions sur le crayon
    /////////////////////////////////////////////////////////////////////////////////
    @Override
    public void caseAReplacePenfct(AReplacePenfct node) { // déplacement absolue
        Value valX = eval(node.getPosX());
        Value valY = eval(node.getPosY());

        int x = ((IntValue) valX).getValue();
        int y = ((IntValue) valY).getValue();

        System.out.println("Pos du crayon: x :" + x + " y: " + y);

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

    ////////////////////////////////////////////////////////////////////////////////////////////

    /*@Override
                                public void caseACallTerm(ACallTerm) {
                                    // TODO
                                }*/
    @Override
    public void caseAArg(AArg node) {
        this.argumentValues.add(eval(node.getExp()));
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
        int angle = ((IntValue) valAngle).getValue();

        int monResultat = (int) Math.sin((double) angle);

        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseACosMathfcts(ACosMathfcts node) {
        Value valAngle = eval(node.getAngle());
        int angle = ((IntValue) valAngle).getValue();

        int monResultat = (int) Math.cos((double) angle);

        this.result = new IntValue(monResultat);
    }

    @Override
    public void caseATanMathfcts(ATanMathfcts node) {
        Value valAngle = eval(node.getAngle());
        int angle = ((IntValue) valAngle).getValue();

        int monResultat = (int) Math.tan((double) angle);

        this.result = new IntValue(monResultat);
    }


    @Override
    public void caseANumberTerm(ANumberTerm node) {
        try{
            this.result = new IntValue(Integer.parseInt(node.getNumber().getText()));
        } catch (NumberFormatException e){
            throw new InterpreterException(this.currentFrame, node.getNumber(), "Le nombre entré est trop grand!");
        }
    }

    @Override
    public void caseAMain(AMain node) {
        visit(node.getBlock());
    }

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
}
