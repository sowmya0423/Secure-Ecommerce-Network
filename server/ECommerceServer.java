import java.io.*;
import java.net.*;

public class ECommerceServer {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("E-Commerce Server started...");
            System.out.println("Waiting for customer connection...");

            Socket socket = serverSocket.accept();

            System.out.println("Customer connected!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            String encryptedMessage = input.readLine();

            System.out.println("Encrypted message received: "
                    + encryptedMessage);

            String decryptedMessage =
                    EncryptionUtil.decrypt(encryptedMessage);

            System.out.println("Decrypted customer message: "
                    + decryptedMessage);

            output.println("Order request received successfully.");

            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}