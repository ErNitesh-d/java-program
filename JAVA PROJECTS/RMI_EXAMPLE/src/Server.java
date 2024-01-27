import java.rmi.*;
import java.rmi.registry.*;
public class Server {
 public static void main(String args[]) {
 try {
 implExample obj = new implExample();

 Naming.rebind("rmi:///Hello", obj);
 System.err.println("server ready");
 } catch (Exception e) {
 System.err.println("server exception:" + e.toString());
 System.out.println(e);
 }
 }
}
