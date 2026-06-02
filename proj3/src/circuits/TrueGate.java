package circuits;

/**
 * Singleton gate that always outputs true.
 * Use TrueGate.instance() — never construct directly.
 */
public class TrueGate extends Gate {
    private static final TrueGate INSTANCE = new TrueGate();

    private TrueGate() {
        super(new Gate[0]);
    }

    /** Returns the single shared TrueGate instance. */
    public static Gate instance() {
        return INSTANCE;
    }

    protected boolean func(boolean[] inValues) {
        return true;
    }

    public String getName() {
        return "T";
    }

    public Gate simplify() {
        return this;
    }
}
