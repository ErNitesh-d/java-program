import java.rmi.*;
public interface Hello extends Remote {
 public int add(int a, int b) throws RemoteException;
 // public int mul(int c,int d) throws RemoteException;
 // public int sub(int e,int f) throws RemoteException;
 // public int div(int g,int g) throws RemoteException;
}
