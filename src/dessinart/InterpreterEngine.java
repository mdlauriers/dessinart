package dessinart;

import dessinart.syntax.analysis.DepthFirstAdapter;
import dessinart.syntax.node.ADefineCanvasInstr;
import dessinart.syntax.node.AProgram;
import dessinart.syntax.node.Node;
import dessinart.value.Value;

public class InterpreterEngine extends DepthFirstAdapter {

    private Value result;

    public void visit(Node node){
        if(node != null) node.apply(this);
    }

    private Value eval(Node node){
        if(this.result != null) throw new RuntimeException("Une erreur non prévue est survenue dans l'interpréteur.");

        visit(node);

        if(this.result == null) throw new RuntimeException("Une erreur non prévue est survenue dans l'interpréteur.");

        Value result = this.result;
        this.result = null;
        return result;
    }

    @Override
    public void caseAProgram(AProgram node) {
        visit(node.getBlock());
    }

    @Override
    public void caseADefineCanvasInstr(ADefineCanvasInstr node) {

    }
}
