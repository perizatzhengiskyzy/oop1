package practice5;

import java.io.*;

public class problem4 {

	public static void main(String[] args) {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("sensor.bin"))){
			for(int i = 0 ; i < 60 ; i++) {
				double j = 15+20*Math.random();
				dos.writeDouble(j);
				
			}
			
		} catch (IOException e) {
            e.printStackTrace();
        }
		try(RandomAccessFile raf = new RandomAccessFile("sensor.bin" , "rw")){
				raf.seek(29*8);
				raf.writeDouble(999.9);
				
				try (DataInputStream dis = new DataInputStream(new FileInputStream("sensor.bin"))){
					double sum = 0; 
					double max = Double.MIN_VALUE;
					for(int i = 0 ; i < 60 ; i++) {
						double d = dis.readDouble();
						sum+=d;
						if(d > max) {
							max = d;
						}
					}
					double avg = sum/60;
					System.out.println("Average: " + avg);
					System.out.println("Max: " + max);
					}
				}
				
		catch (IOException e) {
	
				e.printStackTrace();
}
		

	}

}
