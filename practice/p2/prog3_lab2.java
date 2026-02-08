package oop1.practice.p2;

public class prog3_lab2 {
	private int hour;
	private int minute;
	private int second;
	
	public prog3_lab2(int h, int m, int s) {
		this.hour = h;
		this.minute = m;
		this.second = s;
	}
	
	public String toUniversal() {
		StringBuilder sb = new StringBuilder();
		
		if(hour < 10) sb.append("0" + hour + ":");
		else sb.append(hour + ":");
		
		if(minute < 10) sb.append("0" + minute + ":");
		 else sb.append(minute + ":");
		
		if(second < 10) sb.append("0" + second);
		else sb.append(second);
		
		return sb.toString();
	}
	
	public String toStandard() {
		
		boolean ok = false;
		StringBuilder sb = new StringBuilder();
		
		if(hour > 12) {
			ok = true;
			hour -= 12;
		}
		if(hour < 10) sb.append("0" + hour + ":");
		else sb.append(hour + ":");
		
		if(minute < 10) sb.append("0" + minute + ":");
		 else sb.append(minute + ":");
		
		if(second < 10) sb.append("0" + second);
		else sb.append(second);
		
		if(!ok) sb.append(" AM");
		else sb.append(" PM");
		
		return sb.toString();
	}
	
	public prog3_lab2 add(prog3_lab2 t1, prog3_lab2 t2) {
	    int newHour = t1.hour + t2.hour;
	    int newMinute = t1.minute + t2.minute;
	    int newSecond = t1.second + t2.second;

	    if (newSecond >= 60) {
	        newSecond -= 60;
	        newMinute++;
	    }

	    if (newMinute >= 60) {
	        newMinute -= 60;
	        newHour++;
	    }

	    if (newHour >= 24) {
	        newHour -= 24;
	    }

	    return new prog3_lab2(newHour, newMinute, newSecond);
	}
	
	public static void main(String[] args) {
		prog3_lab2 t = new prog3_lab2(23, 5, 6);
		System.out.println(t.toUniversal());
		System.out.println(t.toStandard());
		prog3_lab2 t2 = new prog3_lab2(4, 24, 33);
		t.add(t, t2);
		System.out.println(t.toUniversal());
	}


}
