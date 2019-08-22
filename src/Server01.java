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

            }
        } catch (IOException e) {
            System.out.println("Severen er fucked mate");

            e.printStackTrace();
        }
    }
}