import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1);

            System.out.println("Serveren kører fint");

            Socket socket = server.accept();

            System.out.println("serveren har modtaget en forbindelse fra: " + socket.getRemoteSocketAddress().toString());

            while(true) {
                DataInputStream in = new DataInputStream
                        (socket.getInputStream());
                DataOutputStream out = new DataOutputStream
                        (socket.getOutputStream());

                double rate = in.readDouble();
                System.out.println(rate);
                double years = in.readDouble();
                System.out.println(years);
                double amount = in.readDouble();
                System.out.println(amount);


            }
        } catch (IOException e) {
            System.out.println("Severen er fucked mate");

            e.printStackTrace();
        }
    }
}