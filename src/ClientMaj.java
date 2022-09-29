import java.net.*;
import java.io.*;
import java.util.Scanner;
public class ClientMaj {
    public static void main(String[] args){
        try{
            // Declaring the scanner object that is going to be used to read data from the user + a variable that
            // acts as a placeholder
            Scanner scanner = new Scanner(System.in);
            String data;

            while(true){
                // Initializing the client socket
                Socket client_socket = new Socket("localhost", 1800);

                // Declaring the in and out stream objects
                DataOutputStream out = new DataOutputStream(client_socket.getOutputStream());
                DataInputStream in = new DataInputStream(client_socket.getInputStream());


                // Getting data from the user
                System.out.println("Please enter a message to the server (the string goodbye will close the connection): ");
                data = scanner.nextLine();

                // Sending the data that we read from the user to the server
                out.writeUTF(data);

                // Saving the result coming from the server in a local variable
                String response = in.readUTF();

                // Displaying the result coming from the server
                System.out.println("The upper cased string is: " + response);

                // Close the connection from the client side
                client_socket.close();

                if(response.equalsIgnoreCase("goodbye")) break;
            }


        } catch(Exception e){
            System.out.println("An error occurred (client side) !");
        }
    }
}
