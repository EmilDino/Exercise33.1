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

                double loanAmount = in.readDouble();
                System.out.println(loanAmount);
                double numberOfYears = in.readDouble();
                System.out.println(numberOfYears);
                double annualInterestRate = in.readDouble();
                System.out.println(annualInterestRate);
                double monthlyInterestRate = annualInterestRate / 1200;

                double monthlyPayment = loanAmount * monthlyInterestRate
                        / (1 - 1 / Math.pow(1 + monthlyInterestRate,
                        numberOfYears * 12));
                out.writeDouble(monthlyPayment);

                double totalPayment = monthlyPayment * numberOfYears * 12;
                out.writeDouble(totalPayment);
            }
        } catch (IOException e) {
            System.out.println("Severen er fucked mate");

            e.printStackTrace();
            // hurra
        }
    }
}