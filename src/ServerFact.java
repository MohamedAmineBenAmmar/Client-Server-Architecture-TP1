import java.net.*;
import java.io.*;

public class ServerFact {
    public static int fact(int x){
        if (x == 0){
            return 1;
        } else {
            return x *fact(x-1);
        }
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

            // Calculating the factorial of the number that we got from the client
            System.out.println("Data received in the server ...");
            System.out.println("Calculating factorial ...");
            int f = fact(in.read());

            // Sending data to the client
            out.write(f);

            // Close the connection from the server side
            service.close();
            listening_socket.close();


        } catch (Exception e){
            System.out.println("An error occurred (server side) !");
        }
    }
}
