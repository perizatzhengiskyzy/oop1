package practice5;
import java.io.*;
public class copy {
	public static void main(String[] args) {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("sensor.bin"))) {
			for(int i = 0 ; i < 60 ; i++) {
				double j = 15+20*Math.random();
				dos.writeDouble(j);
			}
			dos.close();
		} catch (IOException e) {
            e.printStackTrace();
			}
		try(RandomAccessFile raf = new RandomAccessFile("sensor.bin", "rw")){
			raf.seek(29*8);
			raf.writeDouble(999.9);
			raf.close();
			try(DataInputStream dis = new DataInputStream(new FileInputStream("sensor.bin"))) {
				double max = Double.MIN_EXPONENT;
				double sum = 0;
				for(int i = 0 ; i < 60 ; i++) {
					sum+=dis.readDouble();
					if(max<dis.readDouble()) {
						max = dis.readDouble();
					}
				}
				System.out.println("Max:" + max);
				System.out.println(sum/60);
				dis.close();
			}
			
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
		
	}
