import java.rmi.*;
import java.rmi.server.*;
public class implExample extends UnicastRemoteObject
implements Hello {
 private static final long serialVersionUID = 1L;
 implExample() throws RemoteException {
 super();
 }
 public int add(int a, int b)
 throws RemoteException {
 return a + b;
 }
}