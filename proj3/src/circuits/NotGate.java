package circuits;

/**
 * Logic NOT gate with exactly one input.
 * Outputs the boolean negation of its input.
 */
public class NotGate extends Gate {
    public NotGate(Gate in) {
        super(new Gate[] { in });
    }

    protected boolean func(boolean[] inValues) {
        return !inValues[0];
    }

    public String getName() {
        return "NOT";
    }

    /**
     * Simplification rules:
     * - NOT(true)  → FalseGate
     * - NOT(false) → TrueGate
     * - NOT(NOT(x)) → x  (double negation elimination)
     * - Otherwise wrap simplified child in a new NotGate
     */
    public Gate simplify() {
        Gate simplifiedInput = inGates[0].simplify();

        if (simplifiedInput instanceof TrueGate)  return FalseGate.instance();
        if (simplifiedInput instanceof FalseGate) return TrueGate.instance();

        // Double negation: NOT(NOT(x)) → x (already simplified)
        if (simplifiedInput instanceof NotGate) {
            return ((NotGate) simplifiedInput).inGates[0];
        }

        return new NotGate(simplifiedInput);
    }
}