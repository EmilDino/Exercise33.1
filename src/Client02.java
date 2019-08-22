import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client02 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1);

            DataInputStream in = new DataInputStream
                    (socket.getInputStream());
            DataOutputStream out = new DataOutputStream
                    (socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            double tal = 0.0;


            while (true) {
                System.out.println("Skriv et tal: ");
                tal = scanner.nextDouble();


                out.writeDouble(tal);
                System.out.println("Areal der kommer tilbage fra sereveren: " + in.readDouble());

                if(tal == 0.0) { break; }
            }

        }catch (IOException e) {
            System.out.println("Clienten er fucked mate");
            e.printStackTrace();
        }
    }
}
