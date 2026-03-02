package electrical_circuit;

public class Series extends Circuit {
    private Circuit circuit1;
    private Circuit circuit2;
    private double potentialDifference;
    
    public Series(Circuit c1, Circuit c2) {
        this.circuit1 = c1;
        this.circuit2 = c2;
        this.potentialDifference = 0.0;
    }
    
    @Override
    public double getResistance() {
        
        return circuit1.getResistance() + circuit2.getResistance();
    }
    
    @Override
    public double getPotentialDiff() {
        return potentialDifference;
    }
    
    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
        
        double current = getCurrent();
        
        
        double V1 = current * circuit1.getResistance();
        double V2 = current * circuit2.getResistance();
        
        circuit1.applyPotentialDiff(V1);
        circuit2.applyPotentialDiff(V2);
    }
    
    @Override
    public String toString() {
        return "Series(" + circuit1 + ", " + circuit2 + ")";
    }
}