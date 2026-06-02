package circuits;

import java.util.ArrayList;
import java.util.List;

/**
 * Logic OR gate with one or more inputs.
 * Outputs true when at least one input is true.
 */
public class OrGate extends Gate {
    public OrGate(Gate[] inGates) {
        super(inGates);
    }

    protected boolean func(boolean[] inValues) {
        for (boolean val : inValues) {
            if (val) return true;
        }
        return false;
    }

    public String getName() {
        return "OR";
    }

    /**
     * Simplification rules:
     * - Any child simplifies to true   → return TrueGate (short-circuit)
     * - False children are dropped (identity for OR)
     * - One child left  → return it directly
     * - No children left (all were false) → return FalseGate
     */
    public Gate simplify() {
        List<Gate> simplified = new ArrayList<>();
        for (Gate g : inGates) {
            Gate s = g.simplify();
            if (s instanceof TrueGate) return TrueGate.instance();
            if (!(s instanceof FalseGate)) simplified.add(s);
        }
        if (simplified.size() == 0) return FalseGate.instance();
        if (simplified.size() == 1) return simplified.get(0);
        return new OrGate(simplified.toArray(new Gate[0]));
    }
}