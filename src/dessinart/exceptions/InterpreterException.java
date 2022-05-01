package dessinart.exceptions;

import dessinart.Frame;
import dessinart.FunctionInfo;
import dessinart.syntax.node.Token;

public class InterpreterException extends RuntimeException {

    private static final String SEPARATOR = System.getProperty("line.separator");

    private Frame frame;
    private Token token;
    private String message;

    public InterpreterException(Frame frame, Token token, String message){
        this.frame = frame;
        this.token = token;
        this.message = message;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("À la ligne: " + this.token.getLine() + ", position: " + this.token.getPos());

        FunctionInfo function = this.frame.getFunction();
        if(function == null){
            sb.append(" du programme principal");
        } else if (function.returnsValue()){
            sb.append(" de la fonction " + function.getName());
        } else {
            sb.append(" du sketch " + function.getName());
        }

        sb.append(": " + this.message);

        Frame currentFrame = this.frame.getParent();
        while(currentFrame != null){
            sb.append(SEPARATOR);
            Token callLocation = currentFrame.getCallLocation();

            sb.append("\t appelé de la ligne " + callLocation.getLine() + ", position " + callLocation.getPos());

            function = currentFrame.getFunction();

            if(function == null){
                sb.append(" du programme principal " + function.getName());
            } else if (function.returnsValue()){
                sb.append(" de la fonction " + function.getName());
            } else {
                sb.append(" du sketch " + function.getName());
            }

            currentFrame = currentFrame.getParent();
        }

        return sb.toString();
    }
}
