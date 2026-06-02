package circuits;

/**
 * A leaf gate representing a boolean input variable.
 * Must have a value assigned via setVal() before calc() is called.
 */
public class VarGate extends Gate {
    private String name;
    private boolean value;
    private boolean isSet = false;

    public VarGate(String name) {
        super(new Gate[0]);
        this.name = name;
    }

    /**
     * Returns the variable's value.
     * Throws CircuitException if setVal() was never called.
     */
    protected boolean func(boolean[] inValues) throws CircuitException {
        if (!isSet) {
            throw new CircuitException("Variable " + name + " has no value set.");
        }
        return value;
    }

    /** Assigns a boolean value to this variable. */
    public void setVal(boolean value) {
        this.value = value;
        this.isSet = true;
    }

    /** Returns "V" followed by the variable name (e.g. "V1", "Vblue"). */
    public String getName() {
        return "V" + name;
    }

    /**
     * If a value is set, returns the matching TrueGate/FalseGate singleton.
     * Otherwise returns this unchanged.
     */
    public Gate simplify() {
        if (isSet) {
            return value ? TrueGate.instance() : FalseGate.instance();
        }
        return this;
    }
}