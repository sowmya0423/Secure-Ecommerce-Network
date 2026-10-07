import java.io.*;
import java.net.*;

public class ECommerceClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to E-Commerce Server.");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            output.println("Customer placed an order.");

            String response = input.readLine();

            System.out.println("Server response: " + response);

            socket.close();

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}