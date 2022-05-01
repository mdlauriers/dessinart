package dessinart.exceptions;

import dessinart.syntax.node.Token;

public class SemanticException extends RuntimeException {

    private Token token;
    private String message;

    public SemanticException(Token token, String message){
        this.token = token;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "À la ligne " + this.token.getLine() + ", position " + this.token.getPos() + ": " + this.message;
    }
}
