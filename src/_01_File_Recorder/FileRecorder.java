package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecorder {
	public static void main(String[] args) {
		
	
	// Create a program that takes a message from the user and saves it to a file.
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter a message");
	String text = scanner.nextLine();
	try {
		FileWriter fw = new FileWriter("text.txt");
		
		fw.write(text);
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
