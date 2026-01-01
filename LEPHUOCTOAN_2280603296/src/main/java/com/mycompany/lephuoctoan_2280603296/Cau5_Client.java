import java.net.*;

public class Cau5_Client {
    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket(8888);
            InetAddress group = InetAddress.getByName("230.0.0.0");
            socket.joinGroup(group); 
            
            System.out.println("Dang cho tin nhan multicast...");
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Nhan duoc: " + received);
            
            socket.leaveGroup(group);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}