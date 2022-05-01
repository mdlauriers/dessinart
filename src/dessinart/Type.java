package dessinart;

import dessinart.syntax.analysis.DepthFirstAdapter;
import dessinart.syntax.node.ABooleanType;
import dessinart.syntax.node.AColorType;
import dessinart.syntax.node.AIntType;
import dessinart.syntax.node.PType;

import java.util.HashMap;
import java.util.Map;

public class Type {

    public static final Type INT = new Type();

    public static final Type BOOL = new Type();

    public static final Type COLOR = new Type();

    private static final Map<String, Type> classTypes = new HashMap<>();

    private FunctionInfo functionInfo;

    private Type() { }

    private Type(FunctionInfo functionInfo){
        this.functionInfo = functionInfo;
    }

    private static class TypeFinder extends DepthFirstAdapter {

        private Type type;

        @Override
        public void caseAIntType(AIntType node) {
            this.type = Type.INT;
        }

        @Override
        public void caseABooleanType(ABooleanType node) {
            this.type = Type.BOOL;
        }

        @Override
        public void caseAColorType(AColorType node) {
            this.type = Type.COLOR;
        }

        public Type getType(PType node){
            this.type = null;
            node.apply(this);
            return this.type;
        }
    }

    private static final TypeFinder typefinder = new TypeFinder();

    public static Type getType(PType node){
        return typefinder.getType(node);
    }
}
