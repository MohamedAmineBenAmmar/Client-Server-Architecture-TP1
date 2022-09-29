import java.net.*;
import java.io.*;


public class ServerMaj {
    public static String toUpper (String str){
       return  str.toUpperCase();
    }

    public static void main(String[] args){
        try {
            while (true) {
                // Declaring the server socket that going to listen to the clients requests
                ServerSocket listening_socket = new ServerSocket(1800);;
                Socket service;

                // Declaring the service socket that is going to be used in conjunction with the in and out
                // buffers to exchange data
                service = listening_socket.accept();

                // Declaring the in and out stream objects
                DataOutputStream out = new DataOutputStream(service.getOutputStream());
                DataInputStream in = new DataInputStream(service.getInputStream());

                // Calculating the factorial of the number that we got from the client
                System.out.println("Data received in the server ...");
                System.out.println("Calculating factorial ...");

                // Upper case the string
                String response = toUpper(in.readUTF());

                // Sending data to the client
                out.writeUTF(response);


                // Close the connection from the server side
                service.close();
                listening_socket.close();

                if (response.equalsIgnoreCase("goodbye")) break;
            }
        } catch (Exception e){
            System.out.println("An error occurred (server side) !");
            // System.out.println(e.toString());
        }
    }
}
