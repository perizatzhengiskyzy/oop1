package electrical_circuit;

public class Main {
    public static void main(String[] args) {
       
        
        
        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);
        
        Circuit f = new Series(a, b);
        Circuit g = new Parallel(c, d);
        Circuit h = new Series(g, e);
        Circuit circuit = new Parallel(h, f);
        
        
        circuit.applyPotentialDiff(12.0);
        
        double R = circuit.getResistance();
        double I = circuit.getCurrent();
        double P = circuit.getPower();
        
        System.out.println("Circuit Analysis");
        System.out.println("Total circuit: " + circuit);
        System.out.printf("Equivalent resistance: %.4f Ω\n", R);
        System.out.printf("Total current: %.4f A\n", I);
        System.out.printf("Total power: %.4f W\n", P);
        
        System.out.println("\n=== Detailed Analysis ===");
        printCircuitDetails(circuit, 0);
    }
    
    private static void printCircuitDetails(Circuit circuit, int level) {
        String indent = "  ".repeat(level);
        
        if (circuit instanceof Resistor) {
            Resistor r = (Resistor) circuit;
            System.out.printf("%s%s: R=%.2f Ω, V=%.2f V, I=%.4f A, P=%.4f W\n",
                indent, r, r.getResistance(), 
                r.getPotentialDiff(), r.getCurrent(), r.getPower());
        } else if (circuit instanceof Series) {
            Series s = (Series) circuit;
            System.out.printf("%sSeries: R_total=%.4f Ω, V=%.2f V, I=%.4f A\n",
                indent, s.getResistance(), 
                s.getPotentialDiff(), s.getCurrent());
            
         
        } else if (circuit instanceof Parallel) {
            Parallel p = (Parallel) circuit;
            System.out.printf("%sParallel: R_total=%.4f Ω, V=%.2f V, I=%.4f A\n",
                indent, p.getResistance(), 
                p.getPotentialDiff(), p.getCurrent());
        }
    }
}