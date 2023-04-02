package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */

public static void decrypt() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter a message to decrypt");
	String text = scanner.nextLine();
	char[] file = text.toCharArray();
	for(int i = 0; i < file.length; i++) {
		file[i] = (char)(file[i]-4);
	}
	String after = "";
	for(int j = 0; j < file.length; j++) {
		after = after+file[j];
	}
	String FileEncryptor = new String(file);
	try {
		FileWriter fw = new FileWriter("FileEncryptor.txt");
		
		fw.write(after);
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	

}
public static void main(String[] args) {
decrypt();
}
}
