package circuits;

public class Main {
    public static void main(String[] args) throws Exception {
        VarGate v1 = new VarGate("1");
        VarGate v2 = new VarGate("2");

        Gate g1 = new Or2Gate(FalseGate.instance(), TrueGate.instance());
        Gate g2 = new Or2Gate(v1, new NotGate(v2));
        Gate out = new AndGate(new Gate[] { g1, g2, TrueGate.instance() });

        v1.setVal(false);
        v2.setVal(true);
        System.out.println(out + " = " + out.calc());

        VarGate v3 = new VarGate("1");
        VarGate v4 = new VarGate("2");

        Gate g3 = new Or2Gate(FalseGate.instance(), TrueGate.instance());
        Gate g4 = new Or2Gate(v3, new NotGate(v4));
        Gate out2 = new AndGate(new Gate[] { g3, g4, TrueGate.instance() });

        System.out.println(out2 + " = " + out2.simplify());
    }
}