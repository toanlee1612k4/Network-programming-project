import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cau4_Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Da ket noi toi Server. Nhap tin nhan (go 'exit' de thoat):");
            
            while (true) {
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) break;
                out.println(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}