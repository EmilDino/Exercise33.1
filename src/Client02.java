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
            double weightInKilograms = 0.0;
            double heightInMeters = 0.0;
            double bmi = 0.0;

            while (true) {
                System.out.println("indtast vægt i kilo");
                weightInKilograms = scanner.nextDouble();

                System.out.println("Intast højde i meter");
                heightInMeters = scanner.nextDouble();

                out.writeDouble(weightInKilograms);
                out.writeDouble(heightInMeters);
                bmi = in.readDouble();

                System.out.println("Din BMI er: " + in.readDouble());

                if(bmi == 0.0) { break; }
            }

        }catch (IOException e) {
            System.out.println("Clienten er fucked mate");
            e.printStackTrace();
        }
    }
}
