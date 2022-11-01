import java.net.*;
import java.io.*;
import java.util.Scanner;

// Test class

public class ClientFact {
    public static void main(String[] args){
        try{
            // Initializing the client socket
            Socket client_socket = new Socket("localhost", 1800);

            // Declaring the in and out stream objects
            DataOutputStream out = new DataOutputStream(client_socket.getOutputStream());
            DataInputStream in = new DataInputStream(client_socket.getInputStream());

            // Declaring the scanner object that is going to be used to read data from the user + a variable that
            // acts as a placeholder
            Scanner scanner = new Scanner(System.in);
            int data;

            // Getting data from the user
            System.out.println("Please enter an integer: ");
            data = scanner.nextInt();

            // Sending the data that we read from the user to the server
            out.write(data);

            // Displaying the result coming from the server
            System.out.println("The factorial result: " + in.read());

            // Close the connection from the client side
            client_socket.close();
        } catch(Exception e){
            System.out.println("An error occurred (client side) !");
        }
    }
}
