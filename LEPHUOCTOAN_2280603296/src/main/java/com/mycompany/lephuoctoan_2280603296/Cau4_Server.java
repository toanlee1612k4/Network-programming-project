import java.io.*;
import java.net.*;

public class Cau4_Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server dang lang nghe tai cong 12345...");
            
           
            Socket socket = serverSocket.accept();
            System.out.println("Client da ket noi!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter fileWriter = new PrintWriter(new FileWriter("server_log.txt", true)); 

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Nhan tu Client: " + message);
                fileWriter.println("Log: " + message);
                fileWriter.flush(); 
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}