package DessinART.value;

public class IntValue extends Value {

    private int value;

    public IntValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof IntValue)) return false;

        int i = ((IntValue) obj).getValue();
        return i == this.value;
    }

    @Override
    public int hashCode() {
        return this.value;
    }
}
