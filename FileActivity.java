package files;
package csci4201_HW2;

import java.io.*;
import java.util.Scanner;

public class FileActivity {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		FileWriter fileReadFrom = null;
		PrintWriter filePrintFrom = null;
		
//		System.out.print("Enter file name: ");
		String fileName = "a_christmas_carol.txt"; // sc.nextLine()
		
		int wordCount = 0;
		int lineCount = 0;
		int charCount = 0;
		
		try (Scanner readThis = new Scanner(new File(fileName))) { // reads from file input from Scanner
				
			fileReadFrom = new FileWriter(fileName,true);
			filePrintFrom = new PrintWriter(fileReadFrom);
		
			while (readThis.hasNext()) { // counts the lines as there are lines present
				
				String[] word = fileName.split("\\s*");
				for (String w : word)
					wordCount++;
				
				String line = readThis.nextLine(); 
				System.out.println(line); // prints each line of file
				lineCount++; //counts each line

				Scanner chars = new Scanner(fileName).useDelimiter(".");
				
				for (int i = 0; i < fileName.length(); i++) {
					if (chars.hasNext() ) {
						charCount++; // counts total characters including spaces
					}
				}
			}

		} catch (IOException e) {
			
			System.out.println("Error: "+ e.getMessage());
			
		} finally {
			if(filePrintFrom != null)
				filePrintFrom.close();
			sc.close();
		}
		
		System.out.println("");
		System.out.println("Word count: " + wordCount);
		System.out.println("Line count: " + lineCount);
		System.out.println("Character count: " + charCount);

	}

}
