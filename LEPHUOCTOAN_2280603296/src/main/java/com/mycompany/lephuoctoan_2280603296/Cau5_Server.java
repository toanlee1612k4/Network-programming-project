import java.net.*;

public class Cau5_Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress group = InetAddress.getByName("230.0.0.0");  
            String message = "Xin chao ";
            
            byte[] buf = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 8888);
            
            socket.send(packet);
            System.out.println("Da gui thong diep multicast.");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}