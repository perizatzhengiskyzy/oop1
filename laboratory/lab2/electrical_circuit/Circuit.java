package electrical_circuit;

import static java.lang.Math.pow;

public abstract class Circuit {
    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double V);
    
    public double getPower() {
        return pow(getPotentialDiff(), 2) / getResistance();
    }
    
    public double getCurrent() {
        return getPotentialDiff() / getResistance();
    }
}