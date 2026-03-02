package electrical_circuit;

public class Parallel extends Circuit {
    private Circuit circuit1;
    private Circuit circuit2;
    private double potentialDifference;
    
    public Parallel(Circuit c1, Circuit c2) {
        this.circuit1 = c1;
        this.circuit2 = c2;
        this.potentialDifference = 0.0;
    }
    
    @Override
    public double getResistance() {
       
        double r1 = circuit1.getResistance();
        double r2 = circuit2.getResistance();
        
        if (r1 == 0 || r2 == 0) return 0;
        
        return 1.0 / (1.0/r1 + 1.0/r2);
    }
    
    @Override
    public double getPotentialDiff() {
        return potentialDifference;
    }
    
    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
        
        
        circuit1.applyPotentialDiff(V);
        circuit2.applyPotentialDiff(V);
    }
    
    @Override
    public String toString() {
        return "Parallel(" + circuit1 + ", " + circuit2 + ")";
    }
}