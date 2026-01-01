import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cau6_Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            HelloService stub = (HelloService) registry.lookup("HelloService");
            String response = stub.sayHello();
            System.out.println("Phan hoi: " + response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}