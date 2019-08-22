import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client01 {
    public static void main(String[] args)   {
        try {

            // Opretter en ny socket og tilslutter til serveren på localhost på port 1
            Socket socket = new Socket("localhost", 1);

            DataInputStream in = new DataInputStream
                    (socket.getInputStream());
            DataOutputStream out = new DataOutputStream
                    (socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            double annualInterestRate = 0.0;
            double numberOfYears = 0;
            double loanAmount = 0;
            double sum = 0;

            while (true) {
                System.out.println("Enter annual interest rate: ");
                annualInterestRate = scanner.nextDouble();

                System.out.println("Enter number of years: ");
                numberOfYears = scanner.nextDouble();

                System.out.println("Enter loan amount: ");
                loanAmount = scanner.nextDouble();

                // Send tallene til serveren
                out.writeDouble(annualInterestRate);
                out.writeDouble(numberOfYears);
                out.writeDouble(loanAmount);
                sum = in.readDouble();



                System.out.println("Monthly payment: " + sum);

                if(sum == 0.0) { break; }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
