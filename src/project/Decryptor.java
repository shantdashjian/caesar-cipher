package project;


import java.util.Scanner;
import java.util.concurrent.Callable;

public class Decryptor implements Callable<String> {
    private String encryptedMessage;
    private int shift;
    private Scanner kb = new Scanner(System.in);
    private String decryptedMessage = "";
//    private final CountDownLatch startSignal;
//    private final CountDownLatch doneSignal;
    public void read(){
        System.out.print("Enter encrypted message: ");
        encryptedMessage = kb.nextLine();
        encryptedMessage = encryptedMessage.toLowerCase();

        System.out.print("Enter shift: ");
        shift = kb.nextInt();
    }

    public void decrypt(){
//        System.out.println(encryptedMessage);
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
    //public Decryptor(String encryptedMessage, int shift,CountDownLatch startSignal, CountDownLatch doneSignal){
    	public Decryptor(String encryptedMessage, int shift){
        this.encryptedMessage = encryptedMessage.toLowerCase();
        this.shift= shift;
//        this.startSignal = startSignal;
//        this.doneSignal = doneSignal;

    }
    public String decrypt(String newMessage, int newShift){
        encryptedMessage = newMessage;
        shift = newShift;

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
        return decryptedMessage;
    }
    public void output() {
        System.out.println("Original message is " + decryptedMessage + "\n the shift is "+ shift);

    }

//    @Override
//    public void run() {
//        decrypt();
//        output();
//    }
//    public Decryptor(CountDownLatch startSignal, CountDownLatch doneSignal){
//        this.startSignal = startSignal;
//        this.doneSignal = doneSignal;
//    }
    public Decryptor() {
		// TODO Auto-generated constructor stub
	}
    @Override
    public String call() throws Exception {

//        try {
//            startSignal.await();
            decrypt();
//            doneSignal.countDown();

//        } catch(InterruptedException ex){}

        return decryptedMessage;
    }
}