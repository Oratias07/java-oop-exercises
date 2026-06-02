package circuits;

/**
 * Abstract base class for all logic gates.
 * Each gate holds references to its input gates and delegates computation
 * to the subclass via func().
 */
public abstract class Gate {
    /** Input gates feeding into this gate. */
    protected Gate[] inGates;

    /** Computes the gate's output given already-evaluated boolean inputs. */
    protected abstract boolean func(boolean[] inValues) throws CircuitException;

    /** Returns the display name of this gate (e.g. "AND", "NOT", "V1"). */
    public abstract String getName();

    /** Returns a logically equivalent, simplified gate. Does not modify this gate. */
    public abstract Gate simplify();

    public Gate(Gate[] inGates) {
        this.inGates = inGates;
    }

    /**
     * Recursively evaluates the circuit rooted at this gate.
     * Throws CircuitException if any VarGate in the tree has no value set.
     */
    public boolean calc() throws CircuitException {
        boolean[] inValues = new boolean[inGates.length];
        for (int i = 0; i < inGates.length; i++) {
            inValues[i] = inGates[i].calc();
        }
        return func(inValues);
    }

    /**
     * Returns "NAME" for leaf gates, or "NAME[child1, child2, ...]" for gates with inputs.
     */
    public String toString() {
        if (inGates.length == 0) {
            return getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append("[");
        for (int i = 0; i < inGates.length; i++) {
            sb.append(inGates[i].toString());
            if (i < inGates.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
