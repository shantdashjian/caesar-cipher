package project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadedDriver {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        CountDownLatch startSignal= new CountDownLatch(1);
//        CountDownLatch doneSignal = new CountDownLatch(26);
        Scanner kb = new Scanner(System.in);
        Map<Integer, String> possibleEncryptedMessages = new HashMap<>();
        String encryptedMessage = null;
        ExecutorService ex = Executors.newCachedThreadPool();
        System.out.print("Enter encrypted message: ");
        encryptedMessage = kb.nextLine();
        encryptedMessage = encryptedMessage.toLowerCase();
        for (int i = 0; i < 26; i++) {
            int shift = i + 1;

            //Future<String> result = ex.submit(new Decryptor(encryptedMessage, shift, startSignal, doneSignal));
            Future<String> result = ex.submit(new Decryptor(encryptedMessage, shift));
            possibleEncryptedMessages.put(shift, result.get());
        }
//        startSignal.countDown();
//        doneSignal.await();
        Map<Integer, String> possibleEncryptedMessagesSorted = new TreeMap<>(possibleEncryptedMessages);
        Set<Integer> shifts = possibleEncryptedMessagesSorted.keySet();

        for (Integer shift : shifts) {
            System.out.println("Shift " + shift + ": " + possibleEncryptedMessagesSorted.get(shift));
            // This goes into the keyset and prints out the keyset it then goes into the hashmap and uses the key to the the value
        }


        kb.close();
    }
}