package dessinart;

import dessinart.exceptions.SemanticException;
import dessinart.syntax.analysis.DepthFirstAdapter;
import dessinart.syntax.node.*;
import dessinart.value.Value;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VariableAndReturnChecker extends DepthFirstAdapter {

    private FunctionFinder functionFinder;

    private FunctionInfo currentFunction;

    private Scope currentScope;

    private Type resultType;

    private List<Type> argumentTypes;

    public VariableAndReturnChecker(FunctionFinder functionFinder){
        this.functionFinder = functionFinder;
    }

    public void visit(Node node) {

        if (node != null) {
            node.apply(this);
        }
    }

    private Type evalType(Node node){
        if(this.resultType != null){
            throw new RuntimeException("Erreur innattendue dans le vérificateur sémantique");
        }

        visit(node);

        if(this.resultType == null){
            throw new RuntimeException("Erreur innattendue dans le vérification sémantique");
        }

        Type resultType = this.resultType;
        this.resultType = null;
        return resultType;
    }

    private void evalTypeBoolean(Node node, Token token){
        Type type = evalType(node);
        if( type != Type.BOOL){
            throw new SemanticException(token, "L'expression n'est pas un booléen!");
        }
    }

    private void checkNumberLeft(Type type,  Token token){
        if(type != Type.INT){
            throw new SemanticException(token, "L'expression de gauche n'est pas un nombre entier.");
        }
    }

    private void checkNumberRight(Type type,  Token token){
        if(type != Type.INT){
            throw new SemanticException(token, "L'expression de droite n'est pas un nombre entier.");
        }
    }

    private void checkNumber(Type type, Token token){
        if(type != Type.INT){
            throw new SemanticException(token, "L'expression doit être un nombre entier.");
        }
    }

    private void checkColor(Type type, Token token){
        if(type != Type.COLOR){
            throw new SemanticException(token, "L'expression doit être de type COLOR.");
        }
    }

    @Override
    public void caseAFunctionFctdecl(AFunctionFctdecl node) {
        this.currentFunction = this.functionFinder.getFunctionInfo(node.getName().getText());
        this.currentScope = new Scope(null);
        this.functionFinder.addScope(node, this.currentScope);

        List<ParamInfo> params = this.currentFunction.getParams();
        for (ParamInfo param : params){
            this.currentScope.addVariable(param.getName(), param.getType());
        }
        visit(node.getBlock());

        this.currentScope = null;
        this.currentFunction = null;
    }

    @Override
    public void caseASketchFctdecl(ASketchFctdecl node) {
        this.currentFunction = this.functionFinder.getFunctionInfo(node.getName().getText());
        this.currentScope = new Scope(null);
        this.functionFinder.addScope(node, this.currentScope);

        List<ParamInfo> params = this.currentFunction.getParams();
        for (ParamInfo param : params){
            this.currentScope.addVariable(param.getName(), param.getType());
        }
        visit(node.getBlock());

        this.currentScope = null;
        this.currentFunction = null;
    }

    @Override
    public void inABlock(ABlock node) {
        this.currentScope = new Scope(this.currentScope);
        this.functionFinder.addScope(node, this.currentScope);
    }

    @Override
    public void outABlock(ABlock node) {
        this.currentScope = this.currentScope.getParent();
    }


    @Override
    public void caseADeclInstr(ADeclInstr node) {

        Type type = evalType(node.getExp());
        this.currentScope.addVariable(node.getIdent(), type);
    }

    @Override
    public void caseAAssignInstr(AAssignInstr node) {
        Type type = evalType(node.getExp());
        if(type != this.currentScope.getVariableType(node.getIdent())){
            throw new SemanticException(node.getAssign(),
                    "L'expression n'est pas du type approprié pour la variable voulue " + node.getIdent().getText() + ".");
        }
    }

    @Override
    public void caseAPenfctInstr(APenfctInstr node) {
        visit(node.getPenfct());
    }

    @Override
    public void caseAIfInstr(AIfInstr node) {
        evalTypeBoolean(node.getExp(), node.getIf());
        visit(node.getBlock());
    }

    @Override
    public void caseAWhileInstr(AWhileInstr node) {
        evalTypeBoolean(node.getExp(), node.getWhile());
        visit(node.getBlock());
    }

    @Override
    public void caseAReturnInstr(AReturnInstr node) {

        if(this.currentFunction == null){
            throw new SemanticException(node.getReturn(), "Return n'est pas valide dans le programme principal.");
        }

        if(this.currentFunction.returnsValue()){
            if(node.getExp() == null){
                throw new SemanticException(node.getReturn(), "Return nécessite une valeur de retour");
            }

            // Vérifie que l'expression est du même type que la fonction
            Type type = evalType(node.getExp());
            if(type != this.currentFunction.getReturnType()){
                throw new SemanticException(node.getReturn(), "L'expression n'est pas du type approprié pour le résultat de la fonction " + this.currentFunction.getName() + ".");
            }
        } else {
            if(node.getExp() != null){
                throw new SemanticException(node.getReturn(), "Return n'accepte pas de valeur de retour dans un sketch " + this.currentFunction.getName() + ".");

            }
        }
    }


    @Override
    public void caseACallInstr(ACallInstr node) {
        FunctionInfo functionInfo = this.functionFinder.getFunctionInfo(node.getIdent().getText());

        if(functionInfo == null){
            throw new SemanticException(node.getIdent(), "La procédure " + node.getIdent().getText() + " n'existe pas.");
        }

        if(functionInfo.returnsValue()) {
            throw new SemanticException(node.getIdent(), "La fonction " + node.getIdent().getText() + " ne peut être appelée ici");
        }

        List<Type> previousArgumentTypes = this.argumentTypes;

        this.argumentTypes = new LinkedList<>();
        visit(node.getArgs());

        List<ParamInfo> params = functionInfo.getParams();

        if(this.argumentTypes.size() != params.size()){
            throw new SemanticException(node.getLPar(), "Il faut " + params.size() + " arguments pour l'exécution");
        }

        Iterator<Type> argTypesIterator = this.argumentTypes.iterator();
        int count = 1;
        for(ParamInfo param : params){
            Type argType = argTypesIterator.next();

            if(argType != param.getType()){
                throw new SemanticException(node.getLPar(), "L'argument numéro " + count + " n'est pas du type approprié");
            }

            count++;
        }

        this.argumentTypes = previousArgumentTypes;
    }

    @Override
    public void caseAEqExp(AEqExp node) {
        Type left = evalType(node.getLeft());
        Type right = evalType(node.getRight());
        if (left != right) {
            throw new SemanticException(node.getEq(),
                    "La comparaison de valeurs de types disctincts est interdite.");
        }

        // sauvegarde le type des valeurs comparées pour le générateur de code
        this.functionFinder.addType(node, left);

        this.resultType = Type.BOOL;
    }

    @Override
    public void caseALtExp(ALtExp node) {
        Type left = evalType(node.getLeft());
        Type right = evalType(node.getRight());
        checkNumberLeft(left, node.getLt());
        checkNumberRight(right, node.getLt());
        this.resultType = Type.BOOL;
    }

    @Override
    public void caseAGtExp(AGtExp node) {
        Type left = evalType(node.getLeft());
        Type right = evalType(node.getRight());
        checkNumberLeft(left, node.getGt());
        checkNumberRight(right, node.getGt());
        this.resultType = Type.BOOL;
    }

    @Override
    public void caseAAddSum(AAddSum node) {
        Type left = evalType(node.getLeft());
        Type right = evalType(node.getRight());

        // Addition
        checkNumberLeft(left, node.getPlus());
        checkNumberRight(right, node.getPlus());
        this.resultType = Type.INT;
    }

    @Override
    public void caseASubSum(ASubSum node) {
        Type left = evalType(node.getLeft());
        Type right = evalType(node.getRight());
        checkNumberLeft(left, node.getMinus());
        checkNumberRight(right, node.getMinus());
        this.resultType = Type.INT;
    }

    @Override
    public void caseANotNeg(ANotNeg node) {
        evalTypeBoolean(node.getExp(), node.getNot());
        this.resultType = Type.BOOL;
    }

    @Override
    public void caseANumberTerm(ANumberTerm node) {
        try {
            Integer.parseInt(node.getNumber().getText());
            this.resultType = Type.INT;
        }
        catch (NumberFormatException e) {
            throw new SemanticException(node.getNumber(),
                    "Le nombre indiqué est trop grand.");
        }
    }

    @Override
    public void caseAVarTerm(AVarTerm node) {
        this.resultType = this.currentScope.getVariableType(node.getIdent());
    }

    @Override
    public void caseABoolTerm(ABoolTerm node) {
        visit(node.getBoole());
    }

    @Override
    public void caseATrueBoole(ATrueBoole node) {
        this.resultType = Type.BOOL;
    }

    @Override
    public void caseAFalseBoole(AFalseBoole node) {
        this.resultType = Type.BOOL;
    }

    @Override
    public void caseAColorTerm(AColorTerm node) {
        Type red = evalType(node.getRed());
        Type blue = evalType(node.getBlue());
        Type green = evalType(node.getGreen());

        checkNumber(red, node.getLPar());
        checkNumber(blue, node.getComma1());
        checkNumber(green, node.getComma2());

        this.resultType = Type.COLOR;
    }

    @Override
    public void caseAMathfctsTerm(AMathfctsTerm node) {
        visit(node.getMathfcts());
    }

    @Override
    public void caseACallTerm(ACallTerm node) {
        FunctionInfo function = this.functionFinder.getFunctionInfo(node.getIdent().getText());

        if(function == null){
            throw new SemanticException(node.getIdent(), "La fonction " + node.getIdent().getText() + " n'existe pas.");
        }

        if(!function.returnsValue()) {
            throw new SemanticException(node.getIdent(), "La procédure " + node.getIdent().getText() + " ne peut pas être appelée ici");
        }

        List<Type> previousArgumentTypes = this.argumentTypes;

        this.argumentTypes = new LinkedList<>();
        visit(node.getArgs());

        List<ParamInfo> params = function.getParams();

        if(this.argumentTypes.size() != params.size()){
            throw new SemanticException(node.getLPar(), "Il faut " + params.size() + " argument(s).");
        }

        Iterator<Type> argTypesIterator = this.argumentTypes.iterator();
        int count = 1;
        for(ParamInfo param : params){
            Type argType = argTypesIterator.next();

            if(argType != param.getType()){
                throw new SemanticException(node.getLPar(), "L'argument numéro " + count + "n'est pas du type approprié.");
            }

            count++;
        }

        this.argumentTypes = previousArgumentTypes;
        this.resultType = function.getReturnType();
    }

    @Override
    public void caseAArg(AArg node) {
        this.argumentTypes.add(evalType(node.getExp()));
    }

    @Override
    public void caseAPowerMathfcts(APowerMathfcts node) {
        Type base = evalType(node.getBase());
        Type power = evalType(node.getExpos());

        checkNumber(base, node.getLPar());
        checkNumber(power, node.getComma());
    }

    @Override
    public void caseARound5Mathfcts(ARound5Mathfcts node) {
        Type exp = evalType(node.getValeur());
        checkNumber(exp, node.getLPar());
    }

    @Override
    public void caseARound10Mathfcts(ARound10Mathfcts node) {
        Type exp = evalType(node.getValeur());
        checkNumber(exp, node.getLPar());
    }

    @Override
    public void caseARound100Mathfcts(ARound100Mathfcts node) {
        Type exp = evalType(node.getValeur());
        checkNumber(exp, node.getLPar());
    }

    @Override
    public void caseALogMathfcts(ALogMathfcts node) {
        Type exp = evalType(node.getBase());
        Type lodge = evalType(node.getLogde());

        checkNumber(exp, node.getLPar());
        checkNumber(lodge, node.getComma());
    }

    @Override
    public void caseASinMathfcts(ASinMathfcts node) {
        Type angle = evalType(node.getAngle());
        checkNumber(angle, node.getLPar());
    }

    @Override
    public void caseACosMathfcts(ACosMathfcts node) {
        Type angle = evalType(node.getAngle());
        checkNumber(angle, node.getLPar());
    }

    @Override
    public void caseATanMathfcts(ATanMathfcts node) {
        Type angle = evalType(node.getAngle());
        checkNumber(angle, node.getLPar());
    }


    @Override
    public void caseAReplacePenfct(AReplacePenfct node) {
        Type posx = evalType(node.getPosX());
        Type posy = evalType(node.getPosY());

        checkNumber(posx, node.getLPar());
        checkNumber(posy, node.getComma());
    }

    @Override
    public void caseAMovePenfct(AMovePenfct node) {
        Type distx = evalType(node.getDistX());
        Type disty = evalType(node.getDistY());

        checkNumber(distx, node.getLPar());
        checkNumber(disty, node.getComma());
    }

    @Override
    public void caseADrawabsPenfct(ADrawabsPenfct node) {
        Type distx = evalType(node.getPosX());
        Type disty = evalType(node.getPosY());

        checkNumber(distx, node.getLPar());
        checkNumber(disty, node.getComma());
    }

    @Override
    public void caseADrawPenfct(ADrawPenfct node) {
        Type distx = evalType(node.getDistX());
        Type disty = evalType(node.getDistY());

        checkNumber(distx, node.getLPar());
        checkNumber(disty, node.getComma());
    }

    @Override
    public void caseASetcolorPenfct(ASetcolorPenfct node) {
        Type color = evalType(node.getColor());
        checkColor(color, node.getLPar());
    }

    @Override
    public void caseASetwidthPenfct(ASetwidthPenfct node) {
        Type exp = evalType(node.getWidth());
        checkNumber(exp, node.getLPar());
    }
}
