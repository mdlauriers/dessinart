package dessinart;

import dessinart.exceptions.SemanticException;
import dessinart.syntax.node.TIdent;

import java.util.HashMap;
import java.util.Map;

public class Scope {

    private Scope parent;

    private Map<String, Type> variables = new HashMap<>();

    public Scope(Scope parent){
        this.parent = parent;
    }

    public Scope getParent() {
        return this.parent;
    }

    private boolean hasVariable(String identifier){
        boolean ret;
        if(this.variables.containsKey(identifier)){
            ret = true;
        } else if (this.parent != null){
            ret = this.parent.hasVariable(identifier);
        } else {
            ret = false;
        }
        return ret;
    }

    public void addVariable(TIdent token, Type type){

        String name = token.getText();

        if(hasVariable(name)){
            throw new SemanticException(token, "La variable " + name + " à déjà été déclarée.");
        }

        this.variables.put(name, type);
    }

    public Type getVariableType(TIdent token){

        String name = token.getText();
        Type type = this.variables.get(name);

        if(type != null){
            return type;
        } else if (this.parent != null){
            return this.parent.getVariableType(token);
        } else {
            throw new SemanticException(token, "La variable " + name + " n'est pas encore déclarée.");
        }
    }
}
