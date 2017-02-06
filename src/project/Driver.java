package project;


import java.util.Scanner;

public class Driver {
	private Scanner kb = new Scanner(System.in);
	private int option;

	public void select() {
		do {
			System.out.print("Enter 1 to encrypt and 2 to decrypt: ");
			option = kb.nextInt();
		} while (option != 1 && option != 2);
	}

	public void run(){
		switch (option) {
		case 1:
			Encryptor encryptor = new Encryptor();
			encryptor.readMessageAndShift();
			encryptor.encrypt();
			encryptor.output();
			break;
		case 2:
			Decryptor decryptor = new Decryptor();
			decryptor.read();
			decryptor.decrypt();
			decryptor.output();
		}
	}
}
