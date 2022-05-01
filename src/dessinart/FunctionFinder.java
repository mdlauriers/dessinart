package dessinart;

import dessinart.exceptions.SemanticException;
import dessinart.syntax.analysis.DepthFirstAdapter;
import dessinart.syntax.node.*;
import dessinart.Type;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionFinder extends DepthFirstAdapter {

    private Map<String, FunctionInfo> functions = new HashMap<>();

    private Map<Node, Scope> scopes = new HashMap<>();

    private List<ParamInfo> paramList;

    public void visit(Node node){

        if(node != null){
            node.apply(this);
        }
    }

    private void addFunction(Token location, FunctionInfo functionInfo){
        if(this.functions.containsKey(functionInfo.getName())) {
            throw new SemanticException(location, "La fonction " + functionInfo.getName() + " existe déjà.");
        }
        this.functions.put(functionInfo.getName(), functionInfo);
    }

    ///////////////////////////////////////////////////////////////
    // fonctions et sketch
    //-------------------------------------------------------------
    @Override
    public void caseAFunctionFctdecl(AFunctionFctdecl node) {
        this.paramList = new LinkedList<>();
        visit(node.getParams());
        FunctionInfo function = new FunctionInfo(node, this.paramList);
        this.paramList = null;

        addFunction(node.getName(), function);
    }

    @Override
    public void caseASketchFctdecl(ASketchFctdecl node) {
        this.paramList = new LinkedList<>();
        visit(node.getParams());
        FunctionInfo sketch = new FunctionInfo(node, this.paramList);
        this.paramList = null;

        addFunction(node.getName(), sketch);
    }

    @Override
    public void caseAParam(AParam node) {
        this.paramList.add(new ParamInfo(node.getName(), Type.getType(node.getType())));
    }
    ///////////////////////////////////////////////////////////////////

    public FunctionInfo getFunctionInfo(String name){
        return this.functions.get(name);
    }

    public void addScope(Node key, Scope scope){
        this.scopes.put(key, scope);
    }

    public Scope getScope(Node key){
        return this.scopes.get(key);
    }















}
