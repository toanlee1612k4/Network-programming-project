import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Cau6_Server implements HelloService {
    
    public String sayHello() {
        System.out.println("Server da duoc goi tu xa!");
        return "Chao Client, day la phan hoi tu Server qua RMI!";
    }

    public static void main(String[] args) {
        try {
            Cau6_Server obj = new Cau6_Server();
            HelloService stub = (HelloService) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("HelloService", stub);

            System.out.println("Server RMI da san sang...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}