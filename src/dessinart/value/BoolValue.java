package dessinart.value;

public class BoolValue extends Value {

    // Déclarations statiques
    public static final BoolValue TRUE = new BoolValue(true);
    public static final BoolValue FALSE = new BoolValue(false);

    // attribut
    private boolean value;

    public BoolValue(boolean value){
        this.value = value;
    }

    public static Value get(boolean b){

        if (b) {
            return TRUE;
        } else {
            return FALSE;
        }
    }

    public boolean getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(
            Object o) {

        if (!(o instanceof BoolValue)) {
            return false;
        }

        boolean b = ((BoolValue) o).value;
        return b == this.value;
    }

    @Override
    public int hashCode() {

        return this.value ? 1 : 0;
    }
}
