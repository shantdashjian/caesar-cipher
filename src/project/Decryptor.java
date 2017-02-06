package project;


import java.util.Scanner;

public class Decryptor {
	private String encryptedMessage;
	private int shift;
	private Scanner kb = new Scanner(System.in);
	private String decryptedMessage = "";

	public void read(){
		System.out.print("Enter encrypted message: ");
		encryptedMessage = kb.nextLine();
		encryptedMessage = encryptedMessage.toLowerCase();

		System.out.print("Enter shift: ");
		shift = kb.nextInt();
	}

	public void decrypt(){
		for(int i = 0; i < encryptedMessage.length(); i++){
			int e = encryptedMessage.charAt(i);
			int c;
			if (encryptedMessage.charAt(i) >= 'a'
				&& encryptedMessage.charAt(i) <= 'z') {
				e = e - CaesarCipherDriver.ASCII_SHIFT;
				if (e - shift < 0) {
					c = Math.abs(Math.abs(e - shift) - 26);
				} else {
					c = ((e - shift) % 26);
				}
				c = c + CaesarCipherDriver.ASCII_SHIFT;
			} else {
				c = e;
			}
			decryptedMessage = decryptedMessage + (char)c;
		}
	}

	public void output() {
		System.out.println("Original message is " + decryptedMessage);

	}
}
