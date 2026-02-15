package lab1.p3;

public class temperature {
	
	private double value;
	private char scale;
	
	public temperature() {
		value = 0.0;
		scale = 'C';
	}
	
	public temperature(double value) {
		this.value = value;
		this.scale = 'C';
	}
	
	public temperature(char scale) {
		this.value = 0.0;
		setScale(scale);
	}
	
	public temperature(double value, char scale) {
		this.value = value;
		setScale(scale);
	}
	
	public double getCelsius() {
		if (scale == 'C') {
			return value;
		} else {
			return 5 * (value - 32) / 9;
		}
	}
	
	public double getFahrenheit() {
		if (scale == 'F') {
			return value;
		} else {
			return (9 * value / 5) + 32;
		}
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public void setScale(char scale) {
		if (scale == 'C' || scale == 'F') {
			this.scale = scale;
		} else {
			throw new IllegalArgumentException("Scale must be 'C' or 'F'");
		}
	}
	
	public void setTemperature(double value, char scale) {
		this.value = value;
		setScale(scale);
	}
	
	public char getScale() {
		return scale;
	}


}
