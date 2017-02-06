package project;

import java.util.Scanner;

public class CaesarCipherDriver {
	public static final int ASCII_SHIFT = 97;
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Driver driver = new Driver();
		String again;
		do {
			driver.select();
			driver.run();
			System.out.print("Encrypt/Decrypt again (y/n)? ");
			again = kb.next();
		} while (again.equals("y") || again.equals("Y"));

		kb.close();
	}
}
