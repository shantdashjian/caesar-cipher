package project;

import java.util.Scanner;

public class Encryptor {
	private String message;
	private String encryptedMessage = "";
	private int shift;
	Scanner kb = new Scanner(System.in);

	public void readMessageAndShift(){
		System.out.print("Enter message: "); message = kb.nextLine();
		message = message.toLowerCase();
		System.out.print("Enter shift: "); shift = kb.nextInt();
	}

	public void encrypt(){
		for(int i = 0; i < message.length(); i++){
			int c = message.charAt(i);
			int e;
			// If a letter
			if (message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {
				c = c - CaesarCipherDriver.ASCII_SHIFT;
				e = ((c + shift) % 26) ;
				e = e + CaesarCipherDriver.ASCII_SHIFT;
			}
			// If not a letter
			else {
				e = c;
			}
			encryptedMessage = encryptedMessage + (char)e;
		}
	}

	public void output() {
		System.out.println("Encrypted Message is " + encryptedMessage);

	}


}
