package practice5;

import java.io.*;
import java.util.*;

public class problem5 {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("math"));
	             BufferedWriter results = new BufferedWriter(new FileWriter("results.txt"));
	             BufferedWriter log = new BufferedWriter(new FileWriter("log.txt"))){
			String line;
			while((line = br.readLine())!=null) {
				try {
					StringTokenizer str = new StringTokenizer(line , "+-/*", true);
					double a = Double.parseDouble(str.nextToken());
					String op = str.nextToken();
					double b = Double.parseDouble(str.nextToken());
					
					double res ;
					switch(op) {
					case "+": 
				        res = a + b; 
				        break;
				    case "-": 
				        res = a - b; 
				        break;
				    case "*": 
				        res = a * b; 
				        break;
				    case "/": 
				    	if (b == 0) {
				            throw new ArithmeticException("Division by zero");
				        }
				        res = a / b;
				        break;
				    default: 
				        throw new UnsupportedOperationException();
					}
					
					results.write(line + " = " + res);
                    results.newLine();
					
				}catch (NoSuchElementException e) {
                    log.write("Error in expression: " + line + " (missing operand)");
                    log.newLine();
                } catch (NumberFormatException e) {
                    log.write("Error in expression: " + line + " (invalid number)");
                    log.newLine();
                } catch (UnsupportedOperationException e) {
                    log.write("Error in expression: " + line + " (unsupported operator)");
                    log.newLine();
                }
				catch (ArithmeticException e) {  
				    log.write("Error in expression: " + line + " (division by zero)");
				    log.newLine();
				}
				
			}
		}catch (IOException e) {
            e.printStackTrace();
        }
		

		
	}
}
