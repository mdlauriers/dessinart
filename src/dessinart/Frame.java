package dessinart;

import dessinart.syntax.node.Token;
import dessinart.value.Value;

import java.util.HashMap;
import java.util.Map;


public class Frame {

    private Frame parent;

    private FunctionInfo function;

    private Map<String, Value> variables = new HashMap<>();

    private Value returnValue;

    private Token callLocation;

    public Frame(Frame parent, FunctionInfo function){
        this.parent = parent;
        this.function = function;
        this.callLocation = this.callLocation;
    }

    public void assignVariable(String name, Value value){
        this.variables.put(name, value);
    }

    public Value getValue(String name){
        return this.variables.get(name);
    }

    public Frame getParent(){
        return this.parent;
    }

    public FunctionInfo getFunction(){
        return this.function;
    }

    public Value getReturnValue(){
        return this.returnValue;
    }

    public void setReturnValue(Value returnValue){
        this.returnValue =  returnValue;
    }

    public void setCallLocation(Token callLocation){
        this.callLocation = callLocation;
    }

    public Token getCallLocation(){
        return this.callLocation;
    }











}
