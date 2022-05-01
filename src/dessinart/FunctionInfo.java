package dessinart;

import dessinart.syntax.node.AFunctionFctdecl;
import dessinart.syntax.node.ASketchFctdecl;
import dessinart.syntax.node.PBlock;

import java.util.Collections;
import java.util.List;

// DONE

public class FunctionInfo {

    private String name;

    private List<ParamInfo> params;

    private Type returnType;

    private PBlock body;

    public FunctionInfo(AFunctionFctdecl node, List<ParamInfo> paramList) {
        this.name = node.getName().getText();
        this.params = Collections.unmodifiableList(paramList);
        this.returnType = Type.getType(node.getReturnType());
        this.body = node.getBlock();
    }

    public FunctionInfo(ASketchFctdecl node, List<ParamInfo> paramList){
        this.name = node.getName().getText();
        this.params = Collections.unmodifiableList(paramList);
        this.returnType = null;
        this.body = node.getBlock();
    }

    public boolean returnsValue() {
        return this.returnType != null;
    }

    public Type getReturnType() {

        if(this.returnType == null){
            throw new RuntimeException("Problème interne: getReturnType ne doit pas être appelé sur un Sketch.");
        }

        return this.returnType;
    }

    public List<ParamInfo> getParams() {
        return this.params;
    }

    public String getName(){
        return this.name;
    }

    public PBlock getBody(){
        return this.body;
    }

}















