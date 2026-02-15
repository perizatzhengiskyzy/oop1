package lab1.p5;

import java.util.Vector;

public class DragonLaunch {
	private Vector<Person> line;
	
	DragonLaunch(){
		line = new Vector<>();
	}
	
	public void kidnap(Person p) {
		line.add(p);
	}
	
	 public boolean willDragonEatOrNot() {
	        if (line.isEmpty()) return false;

	        int writeIndex = 0; 
	        for(int readIndex = 0 ; readIndex < line.size(); readIndex++) {
	        	Person current = line.get(readIndex);
	        	if(writeIndex>0 && line.get(writeIndex-1).getGender()==Gender.BOY && current.getGender()==Gender.GIRL) {
	        		writeIndex--;
	        	}
	        	else {
	        		 if (writeIndex < line.size()) {
	                     line.set(writeIndex, current);
	                 } else {
	                     line.add(current);
	                 }
	                 writeIndex++;
	        	}
	        	
	    }
	        while(line.size()>writeIndex) {
	        	line.remove(line.size()-1);
	        }
	        return !line.isEmpty();
	    
	 }
	    public void printLine() {
	        for (Person p : line) {
	            System.out.print(p + " ");
	        }
	        System.out.println();
	    }
}
