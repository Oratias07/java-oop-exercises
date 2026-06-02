package circuits;

/** Thrown when calc() is called but a VarGate in the circuit has no value assigned. */
public class CircuitException extends Exception {
    public CircuitException(String message) {
        super(message);
    }
}