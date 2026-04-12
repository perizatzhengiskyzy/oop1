package practice5;
import java.io.*;
import java.util.*;


public class WordFrequencyAnalyzer {
	public static void main(String[] args) {
	
		
		 try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("input.txt"), "UTF-8")
            );
            PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream("report.txt"), "UTF-8")
            )) {
				Map<String , Integer> frequency = new HashMap<>();
				String line ; 
				while((line = reader.readLine()) != null) {
					String[] words = line.toLowerCase().split("[^\\p{L}]+");
					for(String str : words) {
						if(!str.isEmpty()) {
							frequency.put(str, frequency.getOrDefault(str, 0)+1);
						}
					}
				
			}
			List<Map.Entry<String, Integer>> sorted =new ArrayList<>(frequency.entrySet());
			sorted.sort((a,b) -> b.getValue().compareTo(a.getValue()));
			for(Map.Entry<String , Integer> s : sorted) {
				writer.println(s.getKey() + ":" + s.getValue());
			}
			System.out.println("Готово! Результат в файле report.txt");

		} catch (FileNotFoundException e) {
			System.out.print("Error occurs: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("Error occurs: " + e.getMessage());
			e.printStackTrace();
		}
             
	}
}
