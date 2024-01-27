import java.rmi.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.rmi.registry.*;
public class Client {
 public static void main(String args[]) {
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter First Number: ");
 int a = sc.nextInt();
 System.out.println("Enter Second Number: ");
 int b = sc.nextInt();
 try {
 String host="localhost";
 // Hello 
Hello remoteobj=(Hello)Naming.lookup("rmi://"+host+"/hello");

implExample obj = new implExample();

 Naming.rebind("rmi://localhost" +
 "/Hello", obj);
 System.out.println(obj.add(a, b));
 } catch (Exception e) {
 System.err.println("client exception:" + e.toString());
 System.out.println(e);
 }
 }
}
