package circuits;
import java.util.ArrayList;
import java.util.List;

/**
 * Logic AND gate with one or more inputs.
 * Outputs true only when all inputs are true.
 */
public class AndGate extends Gate {
    public AndGate(Gate[] inGates) {
        super(inGates);
    }

    protected boolean func(boolean[] inValues) {
        for (boolean val : inValues) {
            if (!val) return false;
        }
        return true;
    }

    public String getName() {
        return "AND";
    }

    /**
     * Simplification rules:
     * - Any child simplifies to false  → return FalseGate (short-circuit)
     * - True children are dropped (identity for AND)
     * - One child left  → return it directly
     * - No children left (all were true) → return TrueGate
     */
    public Gate simplify() {
        List<Gate> simplified = new ArrayList<>();
        for (Gate g : inGates) {
            Gate s = g.simplify();
            if (s instanceof FalseGate) return FalseGate.instance();
            if (!(s instanceof TrueGate)) simplified.add(s);
        }
        if (simplified.size() == 0) return TrueGate.instance();
        if (simplified.size() == 1) return simplified.get(0);
        return new AndGate(simplified.toArray(new Gate[0]));
    }
}
