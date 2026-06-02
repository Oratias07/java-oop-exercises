package circuits;

/**
 * Singleton gate that always outputs false.
 * Use FalseGate.instance() — never construct directly.
 */
public class FalseGate extends Gate {
    private static final FalseGate INSTANCE = new FalseGate();

    private FalseGate() {
        super(new Gate[0]);
    }

    /** Returns the single shared FalseGate instance. */
    public static Gate instance() {
        return INSTANCE;
    }

    protected boolean func(boolean[] inValues) {
        return false;
    }

    public String getName() {
        return "F";
    }

    public Gate simplify() {
        return this;
    }
}
