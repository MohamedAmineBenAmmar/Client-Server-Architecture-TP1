import java.net.*;
import java.io.*;


public class ServerMaj {
    public static String toUpper (String str){
       return  str.toUpperCase();
    }

    public static void main(String[] args){
        try {
            // Declaring the server socket that going to listen to the clients requests
            ServerSocket listening_socket = new ServerSocket(1800);

            // Declaring the service socket that is going to be used in conjunction with the in and out
            // buffers to exchange data
            Socket service = listening_socket.accept();

            // Declaring the in and out stream objects
            DataOutputStream out = new DataOutputStream(service.getOutputStream());
            DataInputStream in = new DataInputStream(service.getInputStream());

            while (true){
                // Receive the string from the client
                System.out.println("Data received in the server");
                String data = in.readUTF();
                System.out.println("String is: " + data);

                // Upper case the string
                System.out.println("Performing the uppercase operation...");
                String response = toUpper(data);
                System.out.println("Uppercase string: " + response);

                // Sending data to the client
                out.writeUTF(response);
                out.flush();

                if (response.equalsIgnoreCase("goodbye")) break;
            }

            // Close the connection from the server side
            service.close();
            listening_socket.close();
        } catch (Exception e){
            System.out.println("An error occurred (server side) !");
            // System.out.println(e.toString());
        }
    }
}
