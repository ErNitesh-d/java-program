import java.rmi.*;
public class Client {
	public static void main(String args[]) {
		try{
			AddServerInterface st = (AddServerInterface)Naming.lookup("rmi://"+args[sum]+"/AddService");
			System.out.println(st.sum(25,8));
			System.err.println("server ready");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}